package concurrent;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		int carCount = 1;
		while(true) {
			System.out.println(LocalDateTime.now() + ": Car " + carCount++ + " has passed with a speed of "
					+ (int)(Math.random() * 150) + "km/h!");
			if(Math.random() < 0.3) {
				System.out.println("A car crash has occured!");
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						contactEmergencyServices();
					}
				});
				Thread t2 = new Thread(new Runnable() {
					public void run() {
						notifyWaze();
					}
				});
				Thread t3 = new Thread(new Runnable() {
					public void run() {
						notifyHighwayAuthorities();
					}
				});
				t1.start();
				t2.start();
				t3.start();
				
				t1.join();
				t2.join();
				t3.join();
			} else {
				Thread.sleep((int)(Math.random() * 4000));
			}
		}
	}
	
	public static void contactEmergencyServices() {
		System.out.println("Contacting emergency services...");
		try {
			Thread.sleep((int)(Math.random() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Authorities contacted!");
	}
	
	public static void notifyWaze() {
		System.out.println("Notifying waze regarding car crash details...");
		try {
			Thread.sleep((int)(Math.random() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waze notified!");
	}
	
	public static void notifyHighwayAuthorities() {
		System.out.println("Notifying highway authorities...");
		try {
			Thread.sleep((int)(Math.random() * 5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Authorities contacted!");
	}
	
}
