package uppgift4_komp1;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.ObservableList;

public class DeletePerson {
	static void del(String id) {
		String xmlFile = "Person1.xml";
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			org.w3c.dom.Document document = documentBuilder.parse(xmlFile);
			NodeList products = document.getElementsByTagName("product");
			for (int i = 0; i < products.getLength(); i++) {
				Element product = (Element) products.item(i);
				Element idTag = (Element) product.getElementsByTagName("id").item(0);
				if (idTag.getTextContent().equalsIgnoreCase(id)) {
					idTag.getParentNode().getParentNode().removeChild(products.item(i));
					break;
				}
			}
			saveXMLContent(document, xmlFile);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	private static void saveXMLContent(org.w3c.dom.Document document, String xmlFile) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource((Node) document);
			StreamResult streamResult = new StreamResult(xmlFile);
			transformer.transform(domSource, streamResult);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
