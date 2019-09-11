package sequential;

public class VehicleClassifier {
	
	public void run(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is a " + v.type );
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
