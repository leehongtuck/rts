package sequential;

public class GpsNotifier {
	public void run(Vehicle v) {
		System.out.println("Notifying to Google Maps and Waze about vehicle " + v.id + " breakdown!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Google Maps and Waze notified about the breakdown!");
	}
}
