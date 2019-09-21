package concurrent;

import java.util.Date;

public class Main {
	public static long difference;
	static volatile Vehicle vehicle;
	
	public static void main(String[] args) throws InterruptedException {
		int vehicleCount = 1;
		
		VehicleBreakdown vbd = new VehicleBreakdown();
		Thread thrVbd = new Thread(vbd);
		thrVbd.start();
		Thread t1, t2, t3;
		
		while(true) {
			difference = new Date().getTime();
			Vehicle v = new Vehicle(vehicleCount++);
			vbd.setVehicle(v);
			t1 = new Thread(new VehicleClassifier());
			t2 = new Thread(new NumberPlateReader());
			t3 = new Thread(new SpeedDetector());
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();
		}
	}
}

