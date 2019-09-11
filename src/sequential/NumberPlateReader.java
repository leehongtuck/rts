package sequential;

public class NumberPlateReader {
	public void run(Vehicle v) {
		System.out.println("Vehicle " + v.id + " number plate is " + v.numPlate);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
