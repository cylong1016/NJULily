package log.ui.login;

import java.awt.BorderLayout;

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
		LoginPanel panel = new LoginPanel();
		this.add(panel, BorderLayout.CENTER);
		this.setTitle("用户登录");
		this.setSize(LogUIConfig.WIDTH / 2, LogUIConfig.HEIGHT / 2);
		this.setLocationRelativeTo(null); // 居中
		hy.start(); // 透明度渐变启动界面
	}

}
