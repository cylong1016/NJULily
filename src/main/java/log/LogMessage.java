package log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.userbl.UserInfo;

/**
 * 记录用户操作的日志信息
 * @author cylong
 * @version 2014年12月26日 下午7:03:51
 */
public class LogMessage implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 5419259025758261604L;

	/** 操作时间 */
	public String time;
	/** 操作员 */
	public String username;
	/** 操作信息 */
	public String message;

	/**
	 * @param message
	 * @author cylong
	 * @version 2014年12月26日 下午7:15:05
	 */
	public LogMessage(String message) {
		this(UserInfo.getInstance().getUsername(), message);
	}

	public LogMessage(String username, String message) {
		this.username = username;
		this.message = message;
		/* 自动生成时间 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time = sdf.format(new Date());
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.time + "] [" + this.username + "] " + this.message;
	}

}
