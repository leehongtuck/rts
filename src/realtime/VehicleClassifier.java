package realtime;

import javax.realtime.RealtimeThread;

public class VehicleClassifier extends RealtimeThread{
	Vehicle prev;
	
	public void classify(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is a " + v.type );
		prev = v;
	}
	
	@Override
	public void run() {
		while(true) {
			if(prev != Main.vehicle)
				classify(Main.vehicle);
			try {
				waitForNextRelease();
			} catch (IllegalThreadStateException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
