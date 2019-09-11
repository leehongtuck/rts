package sequential;

public class VehicleClassifier {
	
	public void classify(Vehicle v) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Vehicle " + v.id + " is a " + v.type );
		
	}
}
