package assignments;
import java.io.IOException;

public class CharStackNew {
	
  private char[] m_data;           // See Note #1 below
  private int m_ptr;
  
  public CharStackNew(int size) {
      m_ptr = 0;                   // Note #2
      m_data = new char[(size > 1 ? size : 10)]; 
  }
  
  public void push(char c) {
	  
      if (m_ptr >= m_data.length) { // Note #3
    	  
         // Grow the array automatically
         char[] tmp = 
            new char[m_data.length * 2];
      
         System.arraycopy(m_data, 0, 
                          tmp, 0, 
                          m_data.length);
         m_data = tmp;
      }
      m_data[m_ptr++] = c;
  }
     
  // Add explicit error reporting
  public char pop() throws Exception {  // Note #4
  
	  // if the stack is empty
	  if(m_ptr == 0) {
		  // Throw underflow exception
		  throw new Exception("Stack Underflow");
	  }
      return m_data[--m_ptr];
  }
  
  public boolean hasMoreElements() {
      return (m_ptr != 0);
  }
  
  // Note #5
  public static void main(String[] argv) throws IOException {
	  try {
	      CharStackNew s = new CharStackNew(10);
	      int i;
	      
	      while ( (i = System.in.read()) != -1 ) {
	         s.push((char) i);
	      }
	      
	      while (s.hasMoreElements()) {
	         System.out.write(s.pop());
	      }      
	      
	      System.out.println();
	  }
	  // catch StackOverflowError
	  catch(StackOverflowError e1) {
		  System.out.println("Stack Overflow Error");
		  e1.printStackTrace();
	  }
	  // catch Exception
	  catch(Exception e2) {
		  System.out.println("Exception");
		  e2.printStackTrace();
	  }
   }
}



