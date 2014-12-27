package log.config;

import java.awt.Color;
import java.awt.Font;

/**
 * LogUI的配置
 * @author cylong
 * @version 2014年12月26日 下午8:39:03
 */
public class LogUIConfig {

	/** 界面的宽 */
	public static int WIDTH = 900;
	/** 界面的高 */
	public static int HEIGHT = 600;
	/** 主界面的背景色 */
	public static Color MAIN_COLOR = Color.WHITE;
	
	/*----------------------------标题配置--------------------------------*/
	/** 标题字体 */
	public static Font TITLE_FONT = new Font("黑体", Font.PLAIN, 25);
	/** 标题字体颜色 */
	public static Color TITLE_FORE_COLOR = Color.BLACK;
	/** 标题背景颜色 */
	public static Color TITLE_BACK_COLOR = new Color(0x2D2D30);
	/** 标题按钮背景颜色 */
	public static Color TITLE_BUTTON_BACK_COLOR = Color.LIGHT_GRAY;
	/*----------------------------标题配置--------------------------------*/
	
	/*----------------------------登录界面配置--------------------------------*/
	/** 字体 */
	public static Font LOGIN_FONT = new Font("黑体", Font.PLAIN, 25);
	public static int COLUMNS = 13;
	/*----------------------------登录界面配置--------------------------------*/

	/*----------------------------通用按钮配置--------------------------------*/
	/** button字体 */
	public static Font BTN_FONT = new Font("黑体", Font.PLAIN, 16);
	/** button字体颜色 */
	public static Color BTN_FORE_COLOR = Color.BLACK;
	/** button背景颜色 */
	public static Color BTN_BACK_COLOR = Color.LIGHT_GRAY;
	/** 移动到button上的背景颜色 */
	public static Color ENTERED_BTN_BACK_COLOR = Color.GRAY;
	/*----------------------------通用按钮配置--------------------------------*/

	/*----------------------------输入日期Panel配置--------------------------------*/
	/** 标签和输入框字体 */
	public static Font INPUT_FONT = new Font("黑体", Font.PLAIN, 16);
	/*----------------------------输入日期Panel配置--------------------------------*/

	/*----------------------------文本配置--------------------------------*/
	/** 文本字体 */
	public static Font TEXT_FONT = new Font("黑体", Font.PLAIN, 14);
	/** 文本字体颜色 */
	public static Color TEXT_FORE_COLOR = new Color(0x000000);
	/** 文本背景颜色 */
	public static Color TEXT_BACK_COLOR = new Color(0xEEEEEE);
	/*----------------------------文本配置--------------------------------*/

}
