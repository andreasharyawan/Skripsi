import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Testparser {

    public static void main(String argv[]) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(Testparser.class.getResourceAsStream("/map.osm"));
        NodeList nodeList = document.getElementsByTagName("node");
		NodeList tagList = document.getElementsByTagName("tag");

        for (int i = 0; i < nodeList.getLength(); i++){
            Node nNode = nodeList.item(i);
			
			System.out.print("Latitude :");
            System.out.println(nNode.getAttributes().getNamedItem("lat").getNodeValue());
			System.out.print("Longitude :");
            System.out.println(nNode.getAttributes().getNamedItem("lon").getNodeValue());
			System.out.println("");
        }
		
		System.out.println("Amenity :");
		for (int i = 0; i < tagList.getLength(); i++){
			Node tList = tagList.item(i);
			
			if(tList.getAttributes().getNamedItem("k").getNodeValue().equals("amenity")){
				System.out.println(tList.getAttributes().getNamedItem("v").getNodeValue());
			}
			
		}	
    }


}