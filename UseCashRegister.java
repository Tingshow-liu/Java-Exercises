package assignments;
//import assignments.CashRegister;

public class UseCashRegister{
	public static void main(String[] args) {
		// register 1
		CashRegister register1 = new CashRegister();
		register1.AddAmount(20.95);
		register1.AddAmount(100);
		
		int total_transactions = register1.TransactionCount();
		double total_amount = register1.Total();
		System.out.println("Total transactions in register1:" + total_transactions);
		System.out.println("Total amount in register1:" + total_amount);
		
		register1.ResetTransactions();
		int reset_total_transactions = register1.TransactionCount();
		double reset_total_amount = register1.Total();
		System.out.println("Total transactions in register1 after resetting:" + reset_total_transactions);
		System.out.println("Total amount in register1 after resetting:" + reset_total_amount);
		
		// register 2
		CashRegister register2 = new CashRegister();
		register2.AddAmount(30.75);
		
		//Count of registers
		int register_count = CashRegister.RegisterCount();
		System.out.println("Count of registers:" + register_count);
	}
}
