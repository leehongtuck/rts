package sequential;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vehicle {
	int id;
	String numPlate = "";
	VehicleType type;
	int speed;
	boolean towed;
	
	public Vehicle(int id) {
		this.id = id; 
		Random r = new Random();
		List<VehicleType> types = Arrays.asList(VehicleType.MOTORBIKE, VehicleType.CAR, VehicleType.LORRY, VehicleType.VAN);
		type = types.get(r.nextInt(types.size()));
		speed = r.nextInt(150);
		
		for(int i = 0; i < 3; i++) {
			int high = 90;
			int low = 65;	
			numPlate += (char)(r.nextInt(high - low) + low);
		}
		
		for(int i = 0; i < 3; i++) {
			int high = 57;
			int low = 48;
			numPlate += (char)(r.nextInt(high - low) + low);
		}
	}
}


