package config;

/**
 * @author cylong
 * @version 2014年11月28日 下午12:38:53
 */
public class RMI {

	public static String URL = null;

	static {
		ParseXML parse = new ParseXML("config/RMI.xml", "RMI");
		URL = parse.getValue("url");
	}
}
