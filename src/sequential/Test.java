package sequential;

public class Test {
	private static int vehicleCount = 1;
	
	public static void main(String[] args) throws InterruptedException {
	
		SpeedDetector sd = new SpeedDetector();
		VehicleClassifier vc = new VehicleClassifier();
		NumberPlateReader npr = new NumberPlateReader();
		
		VehicleBrokeDown vbd = new VehicleBrokeDown();
		Thread thrVbd = new Thread(vbd);
		thrVbd.start();
		
		while(true) {
			Vehicle v = new Vehicle(vehicleCount++);
			vbd.setVehicle(v);
			vc.classify(v);
			npr.run(v);
			sd.detect(v);
			vbd.removeVehicle();
		}
	}	
}

class VehicleBrokeDown implements Runnable {
	Vehicle v;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(v != null) {
				if(Math.random() < 0.1) {
					v.speed = 0;
					System.out.println("Vehicle " + v.id + " set to broke down");
					v = null;
					
				} 
			}
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setVehicle(Vehicle v) {
		this.v = v;
	}
	
	public void removeVehicle() {
		v = null;
	}
	
	
	
	
	
}
