package server.common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 对XML文件进行解析
 * @author cylong
 * @version 2014年11月26日 下午3:32:05
 */
public class ParseXML {

	private Element element;

	public ParseXML(String node) {
		try {
			// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// step 2:获得具体的dom解析器  
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			// step3: 解析一个xml文档，获得Document对象（根结点）  
			Document doc = docBuilder.parse(new File("config/DataService.xml"));
			NodeList list = doc.getElementsByTagName(node);
			element = (Element)list.item(0);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据Key获得value
	 * @param key
	 * @return value
	 * @author cylong
	 * @version 2014年11月30日 下午11:03:03
	 */
	public String getValue(String key) {
		String value = element.getElementsByTagName(key).item(0).getFirstChild().getNodeValue();
		return value;
	}

}
