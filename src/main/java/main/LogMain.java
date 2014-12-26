package main;

import log.ui.frame.LogFrame;

/**
 * 查看日志界面
 * @author cylong
 * @version 2014年12月26日 下午9:00:18
 */
public class LogMain {

	public static void main(String[] args) {
		System.setProperty("awt.useSystemAAFontSettings", "on");
		System.setProperty("swing.aatext", "true");
		new LogFrame();
	}
}
