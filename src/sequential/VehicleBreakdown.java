package sequential;

public class VehicleBreakdown implements Runnable {
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
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				synchronized(this) {
					try {
						System.out.println("waiting");
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
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
	
	public void removeVehicle() {
		v = null;
	}

}

