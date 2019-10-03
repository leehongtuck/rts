package realtime;

public class VehicleBreakdown implements Runnable {
	Vehicle v; 

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(v != null) {
				if(Math.random() < 0.2) {
					v.speed = 0;
					System.out.println("Vehicle " + v.id + " is set to breakdown!");
				} 
				v = null;
			}
			synchronized(this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
	
	public void setVehicle(Vehicle v) {
		Vehicle temp = this.v;
		this.v = v;
		if(temp == null) {
			synchronized(this) {
				notify();
			}
		}
	}
}

