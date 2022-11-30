package assignments;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DomParser{
	public static void main(String[] args) {
		try {
			// xml_file attached, too
			File xml_file = new File("/Users/tingshow_liu/eclipse-workspace/Introduction to Java/src/assignments/xml_input.txt");
			// construct DOM parser factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// get DOM parser object
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xml_file);
			
			// get root element "DVD"
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			// getElementsByTagName:
			// Returns a NodeList of all descendant Elements with a given tag name (summary)
			NodeList node_list = doc.getElementsByTagName("summary");
			System.out.println("--------------------------------");
			
			for(int i = 0; i < node_list.getLength(); i++) {  // i == 1
				Node node = node_list.item(i);
				// element: summary
				System.out.println("Current element: " + node.getNodeName());
				
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					// element: count
					NodeList node_list1 = element.getElementsByTagName("count");
					for(int j = 0; j < node_list1.getLength(); j++) {
						Node node1 = node_list1.item(j);
						// NamedNodeMap: represents an unordered list of nodes
						// attributes of element decade
						NamedNodeMap attributes = node1.getAttributes();
						// read the attributes in node1
						Node attribute = attributes.getNamedItem("decade");
						if(attribute != null) {
							String year = attribute.getTextContent();
							String cnt = node1.getTextContent();
							System.out.println("Number of movies released in " + year + " is: " + cnt);
						}
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}




