package assignments;
import java.io.*;

public class SortStrings{
	public static void main(String[] argv) throws IOException{
		System.out.println("Please enter 8 strings");
		String[] MyArray = new String[8];
		for(int i=0; i<8; i++) {
			System.out.println("Please enter a string:");
			BufferedReader stdin = 
					new BufferedReader(new InputStreamReader(System.in), 1);
			String str = stdin.readLine();
			MyArray[i] = str.toLowerCase();
		}
		// bubble sorting
		String temp;
		System.out.println("Strings after being sorted:");
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<8; j++) {
				if(MyArray[j].compareTo(MyArray[i])<0) {  
					// swap MyArray[i] and MyArray[j]
					temp = MyArray[i];
					MyArray[i] = MyArray[j];
					MyArray[j] = temp;
				}
			}
			System.out.println(MyArray[i]);
		}
	}
}
