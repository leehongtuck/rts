package concurrent;


public class VehicleGenerator implements Runnable{
	int count = 1;
	VehicleBreakdown vb;
	
	public VehicleGenerator() {
		vb = new VehicleBreakdown();
		new Thread(vb).start();
	}
	@Override
	public void run() {
		while(true) {
			Main.vehicle = new Vehicle(count++);
			vb.setVehicle(Main.vehicle);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
