// Threads
package assignments;

public class NumberPrinter implements Runnable{
	private DataHolder dataholder;
	
	public NumberPrinter(DataHolder dataholder) {
		this.dataholder = dataholder;
	}
	
	public void run() {
		System.out.println("Start printing integer");
		
		// Print integer 1~10
		for(int i = 1; i <= 10; i++) {
			try { 
				// Stop and wait for a while
				Thread.sleep(1000);  
            } 
            catch(InterruptedException e) { 
                e.printStackTrace(); 
            }
			// Print the integer
			this.dataholder.printNumber();
		}	
	}
}


