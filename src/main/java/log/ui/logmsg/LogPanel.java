package log.ui.logmsg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import log.LogMessage;
import log.LogMsgController;
import log.config.LogUIConfig;
import log.ui.Button;
import log.ui.TextField;

/**
 * 显示日志信息
 * @author cylong
 * @version 2014年12月26日 下午9:11:28
 */
public class LogPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 8770200041944584165L;

	/** 背景图片 */
	private static final Image IMG_BACK = new ImageIcon("ui/image/log/logmain/back.png").getImage();

	/** 年月日标签 */
	private DateLabel[] dateLabel;
	/** 三个输入框 */
	private InputField[] input;
	/** 查询和显示全部日志按钮 */
	private Button search, showAll;
	/** 输入panel的位置 */
	private Point inPanelPoint = new Point(0, 25);
	/** 输入panel的大小 */
	private Dimension inPanelDimen = new Dimension(IMG_BACK.getWidth(null), 82);

	/** 按钮大小 */
	private Dimension btnDim = new Dimension(80, 23);
	/** 标签、输入框、按钮之间的间隙 */
	private int interval = 20;

	/** 显示日志 */
	private LogTextArea logText;
	/** 显示日志的TextArea与界面的内边距 */
	private int padding = 72;
	private Point logTextPoint = new Point(padding, inPanelPoint.y + inPanelDimen.height);
	private Dimension logTextSize = new Dimension(LogUIConfig.WIDTH - padding * 2, 480);

	public LogPanel() {
		this.setOpaque(false);
		this.setLayout(null);
		this.setBackground(LogUIConfig.MAIN_COLOR);
		this.addInputPanel();
		this.addLogText();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(IMG_BACK, 0, 0, this);
		super.paintComponent(g);
	}

	private void addInputPanel() {
		InputPanel inPanel = new InputPanel();
		inPanel.setLocation(inPanelPoint);
		inPanel.setSize(inPanelDimen);
		this.add(inPanel, BorderLayout.NORTH);
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
		this.add(logText, BorderLayout.CENTER);
	}

	private class InputPanel extends JPanel {

		/** serialVersionUID */
		private static final long serialVersionUID = -1836768806430466838L;

		public InputPanel() {
			this.setOpaque(false);
			this.setLayout(new FlowLayout(FlowLayout.CENTER, interval, interval));
			this.addInput();
			this.addButton();
		}

		/**
		 * 添加输入日期的输入框
		 * @author cylong
		 * @version 2014年12月27日 上午4:22:13
		 */
		private void addInput() {
			dateLabel = new DateLabel[3];
			input = new InputField[3];
			SimpleDateFormat[] sdf = new SimpleDateFormat[3];
			String[] date_s = {"年", "月", "日"};
			String[] dateFormat = {"yyyy", "MM", "dd"};
			Date curDate = new Date();
			// 初始化输入框，设置标签和输入框的位置，并且添加标签和输入框
			for(int i = 0; i < dateLabel.length; i++) {
				dateLabel[i] = new DateLabel(date_s[i]);
				sdf[i] = new SimpleDateFormat(dateFormat[i]);
				input[i] = new InputField();
				input[i].setText(sdf[i].format(curDate));
				input[i].setFont(LogUIConfig.INPUT_FONT);
				input[i].setHorizontalAlignment(JTextField.CENTER);
				this.add(input[i]);
				this.add(dateLabel[i]);
			}
		}

		/**
		 * 添加查询和显示全部按钮
		 * @author cylong
		 * @version 2014年12月27日 上午4:20:44
		 */
		private void addButton() {
			btnListener listener = new btnListener();
			search = new Button("查询");
			search.setPreferredSize(btnDim);
			search.addMouseListener(listener);
			this.add(search);
			showAll = new Button("显示全部");
			showAll.setPreferredSize(btnDim);
			showAll.addMouseListener(listener);
			this.add(showAll);
		}

	}

	private class btnListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == search) {
				Date current = new Date();
				String year = LogPanel.this.input[0].getText();
				SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
				year = (isDigit(year)) ? year : sdfYear.format(current);	// 默认为当年
				String month = LogPanel.this.input[1].getText();
				month = (isDigit(month)) ? ("-" + month) : "";
				String day = LogPanel.this.input[2].getText();
				day = (isDigit(day) && month.length() != 0) ? ("-" + day) : "";
				String date = year + month + day;
				ArrayList<LogMessage> logs = LogMsgController.getLogs(date);
				logText.setText("");
				logText.append(logs);
				logText.setTitle(date);
			} else if (e.getSource() == showAll) {
				logText.setTitle("全部日志");
				logText.setText("");
				for(int i = LogMsgController.logFilesName.length - 1; i >= 0; i--) {
					ArrayList<LogMessage> logs = LogMsgController.getLogs(LogMsgController.logFilesName[i]);
					logText.append(logs);
				}
			}
		}

		/**
		 * 判断一个字符串是否为数字
		 * @param num
		 * @return
		 * @author cylong
		 * @version 2014年12月27日 下午3:18:35
		 */
		private boolean isDigit(String num) {
			if (num.length() == 0) {
				return false;
			}
			for(int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					return false;
				}
			}
			return true;
		}
	}

}

class DateLabel extends JLabel {

	/** serialVersionUID */
	private static final long serialVersionUID = 11733136455717335L;

	public DateLabel(String Text) {
		super(Text, JLabel.LEFT);
		this.setFont(LogUIConfig.INPUT_FONT);
	}
}

class InputField extends TextField {

	/** serialVersionUID */
	private static final long serialVersionUID = -7461764475544506463L;

	/** 输入框背景图片 */
	private static final Image IMG_TEXT_BOX = new ImageIcon("ui/image/log/text_box.png").getImage();

	public InputField() {
		this.removeMouseListener(listener);
		// 和背景一样大
		this.setPreferredSize(new Dimension(IMG_TEXT_BOX.getWidth(null), IMG_TEXT_BOX.getHeight(null)));
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(IMG_TEXT_BOX, 0, 0, this);
		super.paintComponent(g);
	}

}
