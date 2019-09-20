package realtime;

import javax.realtime.AsynchronouslyInterruptedException;

public class VehicleBreakdown implements Runnable {
	Vehicle v; 
	AsynchronouslyInterruptedException aie;
	
	public VehicleBreakdown(AsynchronouslyInterruptedException aie) {
		this.aie = aie;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(v != null) {
				if(Math.random() < 0.4) {
					v.speed = 0;
					System.out.println("fire away!");
					aie.fire();
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

