package assignments;
import java.util.Scanner;

interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }

interface Vehicle {
	int getWeightInPounds();
}

interface Automobile extends Vehicle { }
interface LargeAutomobile extends Vehicle { }
interface Sedan extends Automobile { }   
interface Van extends LargeAutomobile { }  
interface Truck extends LargeAutomobile { }  
interface Compact extends Automobile { }  
interface SportsUtilityVehicle extends Truck, Van { } 


//small cars
class SaturnSL1 implements SpringHill, Sedan { 
	public int getWeightInPounds() {
		return 1000;
	}
}

class HondaCivic implements Japanese, Compact {
	public int getWeightInPounds() {
		return 1000;
	}
}

class MercedesC230 implements German, Sedan { 
	public int getWeightInPounds() {
		return 1000;
	}
}

//large cars
class ChevyS10 implements Detroit, Truck {
	public int getWeightInPounds() {
		return 2500;
	}
}

class SubaruOutback implements Japanese, SportsUtilityVehicle { 
	public int getWeightInPounds() {
		return 2500;
	}
}


//class: ParkingGarage
public class ParkingGarage{
	
	static int vehicle_num;
	static int total_weight;
	static int flag;
	
	public ParkingGarage() {
		vehicle_num = 0;
		total_weight = 0;
		flag = 0;
	}
	
	public void parkVehicle(int w) {
		if(vehicle_num < 20) {
			if(total_weight + w <= 25000) {
				total_weight += w;
				vehicle_num ++;
				flag = 0;
				System.out.println("Current # of vehicle: " + vehicle_num);
				System.out.println("Current total weight of vehicle: " + total_weight);
			} else {
				System.out.println("Weight limit exceeded. Cannot park the car.");
				flag = 1;
			}
		} else {
			System.out.println("Vehicle num limit exceeded. Cannot park the car.");
			flag = 1;
		}
	}
	
	public static void main(String[] args){
		ParkingGarage parkingGarage = new ParkingGarage();
		
		while(flag == 0) {
			Scanner vehicle = new Scanner(System.in);
			System.out.println("Enter the vehicle you want to park");
			System.out.println("1. SaturnSL1\n2. HondaCivic\n3. MercedesC230\n4. ChevyS10\n5. SubaruOutback");
			int car_type = vehicle.nextInt();
			int weight = 0;
			
			switch(car_type) {
			case 1:
				weight = (new SaturnSL1()).getWeightInPounds();
				parkingGarage.parkVehicle(weight);
				break;
			case 2:
				weight = (new HondaCivic()).getWeightInPounds();
				parkingGarage.parkVehicle(weight);
				break;
			case 3:
				weight = (new MercedesC230()).getWeightInPounds();
				parkingGarage.parkVehicle(weight);
				break;
			case 4:
				weight = (new ChevyS10()).getWeightInPounds();
				parkingGarage.parkVehicle(weight);
				break;
			case 5:
				weight = (new SubaruOutback()).getWeightInPounds();
				parkingGarage.parkVehicle(weight);
				break;
			default:
				System.out.println("Wrong input! Please enter again.");
			}
		}
	}
}






