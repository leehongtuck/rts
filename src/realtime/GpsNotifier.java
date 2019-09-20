package realtime;

public class GpsNotifier implements Runnable{
	Vehicle v;
	
	public GpsNotifier(Vehicle v) {
		this.v = v;
	}
	
	public void run(Vehicle v) {
		System.out.println("Notifying to Google Maps and Waze about vehicle " + v.id + " breakdown!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Google Maps and Waze notified about the breakdown!");
	}
	
	@Override
	public void run() {
		run(v);
	}
}
