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
public class LogController {

	/** 所有日志文件名 */
	public static String[] logFilesName;

	static {
		new Thread() {
			@Override
			public void run() {
				File dir = new File("data/log");
				logFilesName = dir.list();
			}
		}.start();
	}

	public static DefineList<LogMessage> logs;

	static {
		/* 自动生成日期 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		// 每一天的日志放到同一个文件里
		logs = new DefineList<LogMessage>("data/log/" + date + ".log");
	}

	/**
	 * 添加一条日志记录
	 * @author cylong
	 * @version 2014年12月26日 下午7:35:23
	 */
	public static void addLog(String message) {
		logs.add(new LogMessage(message));
	}

	public static ArrayList<LogMessage> getLogs(String date) {
		for(int i = 0; i < logFilesName.length; i++) {
			if(logFilesName[i].contains(date)) {
				return new DefineList<LogMessage>("data/log/" + logFilesName[i]).getInList();
			}
		}
		return null;
	}

}
