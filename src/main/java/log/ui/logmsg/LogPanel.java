package log.ui.logmsg;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import log.LogController;
import log.LogMessage;
import log.ui.Button;
import config.LogUIConfig;

/**
 * 显示日志信息
 * @author cylong
 * @version 2014年12月26日 下午9:11:28
 */
public class LogPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 8770200041944584165L;

	/** 年月日标签 */
	private DateLabel[] date;
	/** 三个输入框 */
	private InputText[] input;
	/** 查询和显示全部日志按钮 */
	public Button search, showAll;

	/** 标签的大小和输入框的大小 */
	private Dimension labelDim = new Dimension(40, 20);
	/** 按钮大小 */
	private Dimension btnDim = new Dimension(80, 20);
	/** 标签、输入框、按钮之间的间隙 */
	private int interval = 10;
	/** 第一个标签（年）的x坐标 （居中） */
	private int labelX = (LogUIConfig.WIDTH - 7 * interval - 6 * labelDim.width - 2 * btnDim.width) / 2;
	/** 第一个标签（年）的y坐标 */
	private int labelY = 20;

	/** 显示日志 */
	private LogTextArea logText;
	private Point logTextPoint = new Point(0, 60);
	private Dimension logTextSize = new Dimension(LogUIConfig.WIDTH, 450);

	public LogPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		this.setLocation(0, LogUIConfig.TITLE_HEIGHT);	// 向下偏移TITLE_HEIGHT，防止和TitlePanel重合
		this.setSize(LogUIConfig.WIDTH, LogUIConfig.HEIGHT - LogUIConfig.TITLE_HEIGHT);
		this.setBackground(LogUIConfig.MAIN_COLOR);
		this.addLogText();
		this.addInput();
		this.addButton();
	}

	/**
	 * 添加输入日期的输入框
	 * @author cylong
	 * @version 2014年12月27日 上午4:22:13
	 */
	private void addInput() {
		date = new DateLabel[3];
		input = new InputText[3];
		date[0] = new DateLabel("年");
		date[1] = new DateLabel("月");
		date[2] = new DateLabel("日");
		// 初始化输入框，设置标签和输入框的位置，并且添加标签和输入框
		for(int i = 0; i < date.length; i++) {
			input[i] = new InputText();
			input[i].setLocation(labelX, labelY);
			input[i].setSize(labelDim);
			this.add(input[i]);
			date[i].setSize(labelDim);
			date[i].setLocation(labelX + interval + labelDim.width, labelY);
			this.add(date[i]);
			labelX = labelX + 2 * (interval + labelDim.width);
		}
	}

	/**
	 * 添加日志信息
	 * @author cylong
	 * @version 2014年12月27日 上午4:19:53
	 */
	private void addLogText() {
		logText = new LogTextArea();
		logText.setLocation(logTextPoint);
		logText.setSize(logTextSize);
		this.add(logText);
	}

	/**
	 * 添加查询和显示全部按钮
	 * @author cylong
	 * @version 2014年12月27日 上午4:20:44
	 */
	private void addButton() {
		btnListener listener = new btnListener();
		search = new Button("查询");
		search.setSize(btnDim);
		search.setLocation(labelX, labelY);
		search.addMouseListener(listener);
		this.add(search);
		showAll = new Button("显示全部");
		showAll.setSize(btnDim);
		showAll.setLocation(labelX + interval + btnDim.width, labelY);
		showAll.addMouseListener(listener);
		this.add(showAll);
	}

	private class btnListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == search) {
				String date =
								LogPanel.this.input[0].getText() + "-" + LogPanel.this.input[1].getText() + "-"
										+ LogPanel.this.input[2].getText();
				ArrayList<LogMessage> logs = LogController.getLogs(date);
				logText.setText("");
				logText.append(logs);
				String title =
								LogPanel.this.input[0].getText() + "年" + LogPanel.this.input[1].getText() + "月"
										+ LogPanel.this.input[2].getText() + "日";
				logText.setTitle(title);
			} else if (e.getSource() == showAll) {
				String title = "全部日志";
				logText.setTitle(title);
				logText.setText("");
				for(String fileName : LogController.logFilesName) {
					ArrayList<LogMessage> logs = LogController.getLogs(fileName);
					logText.append(logs);
				}
			}
		}
	}

}

class DateLabel extends JLabel {

	/** serialVersionUID */
	private static final long serialVersionUID = 11733136455717335L;

	public DateLabel(String Text) {
		super(Text);
		this.setFont(LogUIConfig.INPUT_FONT);
		this.setHorizontalAlignment(JLabel.LEFT);
	}
}

class InputText extends JTextField {

	/** serialVersionUID */
	private static final long serialVersionUID = -6857760594273517171L;

	public InputText() {
		this.setFont(LogUIConfig.INPUT_FONT);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
}
