package config;

/**
 * @author cylong
 * @version 2014年11月28日 下午12:38:53
 */
public class RMIConfig {

	public static String HOST = null;
	public static String PORT = null;
	public static String PREFIX = null;

	static {
		ParseXML parse = new ParseXML("config/RMI.xml", "RMI");
		HOST = parse.getValue("host");
		PORT = parse.getValue("port");
		PREFIX = "rmi://" + HOST + ":" + PORT + "/";
	}
}
