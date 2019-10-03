package realtime;

import javax.realtime.*;

public class Main {
	static volatile Vehicle vehicle;
	
	public static void main(String[] args) {
		ReleaseParameters rel = new PeriodicParameters(new RelativeTime(1000, 0));
		ReleaseParameters vgRel = new PeriodicParameters(new RelativeTime(1200, 0));
		
		RealtimeThread npr = new NumberPlateReader();
		RealtimeThread sd = new SpeedDetector();
		RealtimeThread vc = new VehicleClassifier();
		
		npr.setReleaseParameters(rel);
		sd.setReleaseParameters(rel);
		vc.setReleaseParameters(rel);
		
		AccidentResponse handler = new AccidentResponse();
		AsyncEvent breakdown = new AsyncEvent();
		breakdown.addHandler(handler);
		
		RealtimeThread vg = new VehicleGenerator(breakdown, handler);
		vg.setReleaseParameters(vgRel);
		
		npr.start();
		sd.start();
		vc.start();
		
		vg.start();	
	}
}


class AccidentResponse extends AsyncEventHandler{
	Vehicle v;

	public void setVehicle(Vehicle v) {
		this.v = v;
	}
	
	@Override
	public void handleAsyncEvent() {
		System.out.println("Vehicle " + v.id + " , a " + v.type + " has broken down!");
		new Thread(new AuthoritiesNotifier(v)).start();;
		new Thread(new GpsNotifier(v)).start();
		v.speed = 0;
		v = null;
	}	
}

