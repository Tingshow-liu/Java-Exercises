// Threads
package assignments;

public class DataHolder{
	// -1: No number created now
	private int number = -1;
	
	// Called by "NumberCreater"
	public synchronized void setNumber(int number) {
		while(this.number != -1) {
			try {
				// DataHolder already holds a string, wait
				wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.number = number;
		System.out.println("Integer created!");
		
		// awaken a waiting NumberPrinter to work
		notify();
	}
	
	// Called by "NumberPrinter"
	public synchronized int printNumber() {
		while(this.number == -1) {
			try {
				// No number to print now, wait
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		// NumberPrinter get the number away from DataHolder
		int temp = this.number;
		System.out.println("Print integer: " + this.number);
		System.out.println("--------------------------------");
		this.number = -1;
		
		// awaken a NumberCreater to work
		notify();
		
		return temp;
	}
	
	
	// Test the Threads
	public static void main(String[] args) {
		DataHolder dataholder = new DataHolder();
		
		Thread creater = new Thread(new NumberCreater(dataholder));
		Thread printer = new Thread(new NumberPrinter(dataholder));
		creater.start();
		printer.start();
	}
}




