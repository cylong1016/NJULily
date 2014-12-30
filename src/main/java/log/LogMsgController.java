package log;

import io.DefineList;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 负责对日志的添加查找操作
 * @author cylong
 * @version 2014年12月27日 上午5:00:20
 */
public class LogMsgController {

	/** 所有日志文件名 */
	public static String[] logFilesName;

	/** 当天日志 */
	private static DefineList<LogMessage> curLogs;

	static {
		// 加载全部日志文件名和
		new Thread() {

			@Override
			public void run() {
				File dir = new File("data/log");
				logFilesName = dir.list();
			}
		}.start();
		// 加载当前日志文件
		refreshCurLogs();
	}

	public static DefineList<LogMessage> getCurLogs() {
		return curLogs;
	}

	/**
	 * 刷新当前日志，防止多客户端之间日志的覆盖
	 * @author cylong
	 * @version 2014年12月31日 上午4:08:12
	 */
	private static void refreshCurLogs() {
		/* 自动生成日期 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		// 每一天的日志放到同一个文件里
		curLogs = new DefineList<LogMessage>("data/log/" + date + ".log");
	}

	/**
	 * 添加一条日志记录
	 * @param message 操作信息
	 * @author cylong
	 * @version 2014年12月26日 下午7:35:23
	 */
	public static void addLog(String message) {
		refreshCurLogs();
		curLogs.add(new LogMessage(message));
	}

	/**
	 * 添加一条日志记录
	 * @param username 操作员
	 * @param message 操作信息
	 * @author cylong
	 * @version 2014年12月29日 上午2:45:34
	 */
	public static void addLog(String username, String message) {
		refreshCurLogs();
		curLogs.add(new LogMessage(username, message));
	}

	public static ArrayList<LogMessage> getLogsByDate(String date) {
		ArrayList<LogMessage> logs = new ArrayList<LogMessage>();
		for(int i = logFilesName.length - 1; i >= 0; i--) {
			if (logFilesName[i].contains(date)) {
				logs.addAll(new DefineList<LogMessage>("data/log/" + logFilesName[i]).getInList());
			}
		}
		return logs;
	}

}
