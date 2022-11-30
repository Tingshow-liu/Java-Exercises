package assignments;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class FileReader{
	public static void main(String[] args) {
		// BufferedReader: Simplifies reading text from a character input stream
		BufferedReader buffered_reader = null;
		String lines;
		int total_lines = -1;
	
		try {
			// Will read the course syllabus text file (also attached)
			System.out.println("Will read the course syllabus txt file");
			// read file (path)
			File txt = new File("/Users/tingshow_liu/eclipse-workspace/Introduction to Java/src/assignments/ELENGX436.2_Syllabus.txt");
			String absolute = txt.getAbsolutePath();
			Scanner file = new Scanner(absolute);
			lines = file.nextLine();  // something like an URL
			
			// FileInputStream: read data in binary format
			// InputStreamReader: convert data bytes to characters
			// LineNumberReader: keeps track of line numbers of the read characters
			LineNumberReader reader1 = new LineNumberReader(new InputStreamReader(new FileInputStream(lines), "UTF-8"));
			LineNumberReader reader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(lines), "UTF-8"));
			
			// Count total # of lines: used in the scenario of displaying last n lines
			while (reader2.readLine() != null) total_lines++;
			// System.out.println("total lines:" + total_lines);
			
			Scanner line_num = new Scanner(System.in);
			System.out.println("Enter the number of lines to display:");
			int i = line_num.nextInt();
			
			System.out.println("----------File content----------");
			
			// Positive line number
			if(i > 0) {
				while(((lines = reader1.readLine())!=null) && reader1.getLineNumber()<=i){
					System.out.println(lines);
				}
			}
			// line number = 0
			else if(i == 0) {
				while(((lines = reader1.readLine())!=null)) {
					System.out.println(lines);
				}
			}
			// negative line number
			else if(i < 0) {
				// Use arrays to handle printing the last n lines
				ArrayList<String> list = new ArrayList<String>();
				while ((lines = reader1.readLine()) != null) {
			        list.add(lines);
			      }
				// Slice it based on the row # to display
				List<String> list1 = list.subList(total_lines+i, total_lines);
				// System.out.println(list1);
				for (Iterator iter = list1.iterator(); iter.hasNext();) {
					System.out.println((String) iter.next());
			      }
			}
			reader1.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("File not found");
		}
		catch (IOException e) {
			System.err.println("Unable to read the file.");
		}
	}
}












