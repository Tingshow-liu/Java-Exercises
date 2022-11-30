package assignments;

import java.util.Scanner;

public class Balloon{
	int max_pressure;
	int current_pressure;
	static int flag;
	
	public Balloon(int max_pressure, int current_pressure) {
		this.max_pressure = max_pressure;
		this.current_pressure = current_pressure;
		flag = 0;
	}
	
	public void inflate(int p) {
		if(p + this.current_pressure > this.max_pressure) {
			System.out.println("Pressure exceeds dangerous level: " + this.max_pressure);
			System.out.println("Cannot increase pressure!!");
			flag = 1;
		}else {
			this.current_pressure += p;
			System.out.println("Current pressure level:" + this.current_pressure);
			flag = 0;
		}
	}
	
	public static void main(String args[]) {
		// Set maximum pressure = 100, current pressure = 0
		Balloon balloon = new Balloon(100, 0);
		
		while(flag == 0) {
			Scanner pressure = new Scanner(System.in);
			System.out.println("Enter the pressure you want to inflate");
			int p = pressure.nextInt();
			balloon.inflate(p);
		}
	}
}








