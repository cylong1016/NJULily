package log.ui.login;

import log.config.LogUIConfig;
import log.ui.frame.Frame;

/**
 * @author cylong
 * @version 2014年12月27日 下午9:31:11
 */
public class LoginFrame extends Frame {

	/** serialVersionUID */
	private static final long serialVersionUID = -4910301259193694804L;

	public LoginFrame() {
		this.setTitle("登录");
		this.setSize(LogUIConfig.WIDTH, LogUIConfig.HEIGHT);
		this.setLocationRelativeTo(null); // 居中
		hy.start(); // 透明度渐变启动界面
	}

}
