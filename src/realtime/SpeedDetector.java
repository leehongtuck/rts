package realtime;

import javax.realtime.AsyncEvent;
import javax.realtime.AsyncEventHandler;
import javax.realtime.RealtimeThread;

public class SpeedDetector extends RealtimeThread{
	Vehicle prev, v;
	AsyncEvent breakdown = new AsyncEvent();
	AccidentResponse handler = new AccidentResponse();
	
	public SpeedDetector() {		
		breakdown.addHandler(handler);
	}
	
	public void detect(Vehicle v) {
		this.v = v;
		if(v.speed == 0) {
			breakdown.fire();
		} else {
			System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
		}
		prev = v;
	}
	
	
	@Override
	public void run() {
		while(true) {
			if(prev != Main.vehicle) {
				detect(Main.vehicle);
			}	
			try {
				waitForNextRelease();
			} catch (IllegalThreadStateException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	class AccidentResponse extends AsyncEventHandler{
		@Override
		public void handleAsyncEvent() {
			System.out.println("Vehicle " + v.id + " has broken down!");
			new Thread(new AuthoritiesNotifier(v)).start();;
			new Thread(new GpsNotifier(v)).start();
			v = null;
		}	
	}
}

