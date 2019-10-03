package realtime;

import javax.realtime.AsyncEvent;
import javax.realtime.RealtimeThread;

public class VehicleGenerator extends RealtimeThread{
	int count = 1;
	VehicleBreakdown vb;
	
	public VehicleGenerator(AsyncEvent event, AccidentResponse handler) {
		vb = new VehicleBreakdown(event, handler);
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
