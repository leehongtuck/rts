package realtime;

import javax.realtime.AsyncEvent;

public class VehicleBreakdown implements Runnable {
	Vehicle v; 
	AsyncEvent event;
	AccidentResponse handler;
	
	public VehicleBreakdown(AsyncEvent event, AccidentResponse handler) {
		this.event = event;
		this.handler = handler;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(v != null) {
				if(Math.random() < 0.01) {
					v.speed = 0;
					System.out.println("fire away!");
					handler.setVehicle(v);
					event.fire();
					v = null;	
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
}

