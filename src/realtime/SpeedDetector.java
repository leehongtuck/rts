package realtime;

import javax.realtime.RealtimeThread;

public class SpeedDetector extends RealtimeThread{
	Vehicle prev;
	
	public void detect(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
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
}


