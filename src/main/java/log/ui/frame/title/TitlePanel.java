package log.ui.frame.title;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import log.ui.frame.Frame;

/**
 * frame上的标题栏
 * @author cylong
 * @version 2014年12月10日 上午10:41:49
 */
public class TitlePanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -5595756092214353675L;

	/** 标题背景图片 */
	private static final Image IMG_TITLE = new ImageIcon("ui/image/log/title.png").getImage();

	/** 关闭按钮 */
	private TitleButton exit;
	/** 最小化按钮 */
	private TitleButton min;
	/** 按钮与按钮之间、按钮与边框的间距 */
	private int interval = 15;
	/** 主frame，主要为了最小化使用其对象 */
	private Frame frame;

	public TitlePanel(Frame frame) {
		this.frame = frame;
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, interval, interval));
		// 和图片一样大
		this.setPreferredSize(new Dimension(IMG_TITLE.getWidth(null), IMG_TITLE.getHeight(null)));
		addTitleButton(); // 添加最大化最小化按钮
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(IMG_TITLE, 0, 0, this);
	}


	private void addTitleButton() {
		// 按钮监听
		TitleButtonListener listener = new TitleButtonListener();
		// 最小化按钮
		min = new TitleButton();
		min.addMouseListener(listener);
		this.add(min);
		// 关闭按钮
		exit = new TitleButton();
		exit.addMouseListener(listener);
		this.add(exit);
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
