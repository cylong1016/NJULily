package server.common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 对XML文件进行解析
 * @author cylong
 * @version 2014年11月26日 下午3:32:05
 */
/**
 * @author cylong
 * @version 2014年12月2日 上午1:05:24
 */
public class ParseXML {

	public static void main(String[] args) {
		ParseXML p = new ParseXML("ClientData");
		System.out.println(p.getValue("name"));
		p.setValue("name", "cylong");
		System.out.println(p.getValue("name"));
	}

	private Element theData;
	private Element root;

	public ParseXML(String name) {
		try {
			// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			// step 2:获得具体的dom解析器  
			DocumentBuilder docBuilder = dbfactory.newDocumentBuilder();
			// step3: 解析一个xml文档，获得Document对象（根结点）  
			Document xmldoc = docBuilder.parse(new File("config/DataService.xml"));
			root = xmldoc.getDocumentElement();
			theData = (Element)selectSingleNode("/DataService/Data[name='" + name + "']", root);
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
	 * @param tag
	 * @return value
	 * @author cylong
	 * @version 2014年11月30日 下午11:03:03
	 */
	public String getValue(String tag) {
		String value = theData.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue();
		return value;
	}

	public void setValue(String tag, String value) {
		theData.getElementsByTagName(tag).item(0).setTextContent(value);
	}

	/**
	 * 查找节点，并返回第一个符合条件节点
	 * @author cylong
	 * @version 2014年12月2日 上午1:05:34
	 */
	public Node selectSingleNode(String express, Object source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node)xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return result;
	}
}
