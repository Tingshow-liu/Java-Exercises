// Threads
package assignments;

public class NumberCreater implements Runnable{
	private DataHolder dataholder;
	
	public NumberCreater(DataHolder dataholder) {
		this.dataholder = dataholder;
	}
	
	public void run() {
		System.out.println("Start creating integer");
		
		// Create integer 1~10
		for(int num = 1; num <= 10; num++) {
			// Throws an InterruptedException; lets the program continue
			try {
				// Stop and wait for a while
				Thread.sleep(1000);  
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			// Give the created integer to "DataHolder"
			this.dataholder.setNumber(num);
		}
	}
}
