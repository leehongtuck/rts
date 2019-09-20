package realtime;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.RealtimeThread;

public class VehicleGenerator extends RealtimeThread{
	int count = 1;
	VehicleBreakdown vb;
	
	public VehicleGenerator(AsynchronouslyInterruptedException aie) {
		vb = new VehicleBreakdown(aie);
		new Thread(vb).start();
	}
	@Override
	public void run() {
		while(true) {
			Main.vehicle = new Vehicle(count++);
			vb.setVehicle(Main.vehicle);
			try {
				waitForNextRelease();
			} catch (IllegalThreadStateException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
