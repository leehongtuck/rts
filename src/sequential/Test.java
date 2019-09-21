package sequential;

import java.util.Date;

public class Test {

	
	public static void main(String[] args) throws InterruptedException {
		int vehicleCount = 1;
		
		SpeedDetector sd = new SpeedDetector();
		VehicleClassifier vc = new VehicleClassifier();
		NumberPlateReader npr = new NumberPlateReader();
		
		VehicleBreakdown vbd = new VehicleBreakdown();
		Thread thrVbd = new Thread(vbd);
		thrVbd.start();
		
		while(true) {
			concurrent.Main.difference = new Date().getTime();
			Vehicle v = new Vehicle(vehicleCount++);
			vbd.setVehicle(v);
			vc.classify(v);
			npr.read(v);
			sd.detect(v);
			vbd.removeVehicle();
		}
	}	
}
