package realtime;

import javax.realtime.*;

public class Main {
	static volatile Vehicle vehicle;
	
	public static void main(String[] args) {
		ReleaseParameters rel = new PeriodicParameters(new RelativeTime(1000, 0));
		ReleaseParameters vgRel = new PeriodicParameters(new RelativeTime(2500, 0));
		
		RealtimeThread npr = new NumberPlateReader();
		RealtimeThread sd = new SpeedDetector();
		RealtimeThread vc = new VehicleClassifier();
		
		npr.setReleaseParameters(rel);
		sd.setReleaseParameters(rel);
		vc.setReleaseParameters(rel);
		
		RealtimeThread vg = new VehicleGenerator();
		vg.setReleaseParameters(vgRel);
		
		npr.start();
		sd.start();
		vc.start();
		
		vg.start();	
	}
}

