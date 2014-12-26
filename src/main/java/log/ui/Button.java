package log.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import config.LogUIConfig;

/**
 * 所有button的父类
 * @author cylong
 * @version 2014年12月12日 上午4:00:21
 */
public class Button extends JLabel {

	/** serialVersionUID */
	private static final long serialVersionUID = -5073422084920844212L;

	public Button(String text) {
		super(text, JLabel.CENTER);
		this.setFont(LogUIConfig.BTN_FONT);	// 文本字体
		this.setForeground(LogUIConfig.BTN_FORE_COLOR);	// 文本颜色
		this.setOpaque(true);
		this.addMouseListener(new ButtonListener());
		this.setBackground(LogUIConfig.BTN_BACK_COLOR);	// 按钮背景色
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.setBackground(LogUIConfig.BTN_BACK_COLOR);
		super.setEnabled(enabled);
	}
	
	private class ButtonListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			if(Button.this.isEnabled()) {
				Button.this.setBackground(LogUIConfig.ENTERED_BTN_BACK_COLOR);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(Button.this.isEnabled()) {
				Button.this.setBackground(LogUIConfig.BTN_BACK_COLOR);
			}
		}

		public void mousePressed(MouseEvent e) {
			if(Button.this.isEnabled()) {
				Button.this.setBackground(LogUIConfig.BTN_BACK_COLOR);
			}
		}

		public void mouseReleased(MouseEvent e) {
			if(Button.this.isEnabled()) {
				Button.this.setBackground(LogUIConfig.ENTERED_BTN_BACK_COLOR);
			}
		}

	}
}
