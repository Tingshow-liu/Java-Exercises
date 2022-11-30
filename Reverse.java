package assignments;
import java.util.Scanner;

public class Reverse{
	public static void main(String[] argv){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a string");
		String str = scanner.nextLine();
		scanner.close();
		String reversed = reverse(str);
		System.out.println("The reversed string is: " + reversed);
	}
	// recursive function: reverse
	public static String reverse(String str){
		if ((str == null) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
}

//reverse(Thanks)
//reverse(hanks) + T
//(reverse(anks) + h) + T
//((reverse(nks) + a) + h) + T
//(((reverse(ks) + n) + a) + h) + T
//((((reverse(s) + k) + n) + a) + h) + T
//sknahT





