package realtime;

import java.util.ArrayList;

import javax.realtime.RealtimeThread;

public class NumberPlateReader extends RealtimeThread {
	Vehicle prev;
	
	public void read(Vehicle v) {
		System.out.println("Vehicle " + v.id + " number plate is " + v.numPlate);
		prev = v;
	}
	
	
	@Override
	public void run() {
		while(true) {
			if(prev != Main.vehicle)
				read(Main.vehicle);
			try {
				waitForNextRelease();
			} catch (IllegalThreadStateException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
