package log.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import log.config.LogUIConfig;

/**
 * 所有button的父类
 * @author cylong
 * @version 2014年12月12日 上午4:00:21
 */
public class Button extends JLabel {

	/** serialVersionUID */
	private static final long serialVersionUID = -5073422084920844212L;

	/** 未移动到按钮时候的图片 */
	private Image fore;
	/** 移动到按钮上的图片 */
	private Image back;

	/** 是否移动到按钮上 */
	private boolean isEntered = false;

	public Button(String text) {
		super(text, JLabel.CENTER);
		this.setFont(LogUIConfig.BTN_FONT);	// 文本字体
		this.setForeground(LogUIConfig.BTN_FORE_COLOR);	// 文本颜色
		this.setOpaque(true);
		this.addMouseListener(new ButtonListener());
		this.setBackground(LogUIConfig.BTN_BACK_COLOR);	// 按钮背景色
	}

	public Button(Image fore, Image back) {
		this.fore = fore;
		this.back = back;
		// 和图片一样大
		this.setSize(fore.getWidth(null), fore.getHeight(null));
		this.addMouseListener(new ButtonImageListener());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isEntered) {
			g.drawImage(back, 0, 0, this);
		} else {
			g.drawImage(fore, 0, 0, this);
		}
	}

	private class ButtonListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			Button.this.setBackground(LogUIConfig.ENTERED_BTN_BACK_COLOR);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Button.this.setBackground(LogUIConfig.BTN_BACK_COLOR);
		}

		public void mousePressed(MouseEvent e) {
			Button.this.setBackground(LogUIConfig.BTN_BACK_COLOR);
		}

		public void mouseReleased(MouseEvent e) {
			Button.this.setBackground(LogUIConfig.ENTERED_BTN_BACK_COLOR);
		}

	}

	private class ButtonImageListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			isEntered = true;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isEntered = false;
			repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			isEntered = false;
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			isEntered = true;
			repaint();
		}

	}
}
