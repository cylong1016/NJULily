package log.ui.logmsg;

import log.config.LogUIConfig;
import log.ui.frame.Frame;

/**
 * @author cylong
 * @version 2014年12月27日 下午9:15:35
 */
public class LogFrame extends Frame {

	/** serialVersionUID */
	private static final long serialVersionUID = -8558818784226467183L;

	public LogFrame() {
		// 显示日志信息的panel
		LogPanel panel = new LogPanel();
		this.add(panel);
		this.setTitle("操作日志");
		this.setSize(LogUIConfig.WIDTH, LogUIConfig.HEIGHT);
		this.setLocationRelativeTo(null); // 居中
		hy.start(); // 透明度渐变启动界面
	}

}
