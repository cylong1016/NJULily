package log.ui.frame.title;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import log.ui.frame.LogFrame;
import config.LogUIConfig;

/**
 * frame上的标题栏
 * @author cylong
 * @version 2014年12月10日 上午10:41:49
 */
public class TitlePanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -5595756092214353675L;

	/** 按钮之间还有和边框的间隙 */
	private int interval = (LogUIConfig.TITLE_HEIGHT - LogUIConfig.TITLE_BTN_H) / 2;
	/** 关闭按钮x坐标 */
	private int exitX = LogUIConfig.WIDTH - LogUIConfig.TITLE_BTN_W - interval;
	/** 最小化按钮x坐标 */
	private int minX = exitX - interval - LogUIConfig.TITLE_BTN_W;
	/** 关闭按钮 */
	private TitleButton exit;
	/** 最小化按钮 */
	private TitleButton min;
	/** 主frame，主要为了最小化使用其对象 */
	private LogFrame frame;

	public TitlePanel(LogFrame frame) {
		this.frame = frame;
		this.setLayout(null);
		this.setOpaque(true);
		this.setSize(LogUIConfig.WIDTH, LogUIConfig.TITLE_HEIGHT);
		this.setBackground(LogUIConfig.TITLE_BACK_COLOR);
		addTitleButton(); // 添加最大化最小化按钮
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g2d);
		g2d.setFont(LogUIConfig.TITLE_FONT);
		g2d.setColor(LogUIConfig.TITLE_FORE_COLOR);
	}

	private void addTitleButton() {
		// 按钮监听
		TitleButtonListener listener = new TitleButtonListener();
		// 关闭按钮
		exit = new TitleButton();
		exit.setLocation(exitX, interval);
		exit.addMouseListener(listener);
		this.add(exit);
		// 最小化按钮
		min = new TitleButton();
		min.setLocation(minX, interval);
		min.addMouseListener(listener);
		this.add(min);
	}

	private class TitleButtonListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == min) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		}

	}

}
