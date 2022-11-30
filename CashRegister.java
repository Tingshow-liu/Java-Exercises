package assignments;

public class CashRegister{
	public static void main(String[] args){}
	
	public static int total_registers = 0;
	public int total_transactions = 0;
	public double total_amount = 0.00;
	
	public CashRegister() {
		total_registers += 1;
	} // end of constructor
	
	public void AddAmount(double amount) {
		total_amount += amount;
		total_transactions += 1;
	}
	
	public int TransactionCount() {
		return total_transactions;
	}
	
	public double Total() {
		return total_amount;
	}
	
	public void ResetTransactions() {
		total_amount = 0;
		total_transactions = 0;
	}
	
	public static int RegisterCount() {
		return total_registers;
	}
}
