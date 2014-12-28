package log.ui.warning;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDialog;

/**
 * 提示框
 * @author cylong
 * @version 2014年12月28日 下午6:51:35
 */
public class PromptDialog extends JDialog {

	/** serialVersionUID */
	private static final long serialVersionUID = 2857496548979951207L;

	/** 窗口大小 */
	private Dimension dimen = new Dimension(250, 150);

	private Vanish vanish;

	public PromptDialog() {
		this.setUndecorated(true);
		// 创建透明色
		this.setBackground(new Color(0, 0, 0, 0.0f));
		this.setSize(dimen);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		vanish = new Vanish(); // 固定时间窗口消失
	}

	public void start() {
		vanish.start();
	}

	public void setComp(Component comp) {
		this.add(comp);
		this.setVisible(true);
	}

	public static void show(String title, String prompt) {
		PromptDialog promptDialog = new PromptDialog();
		promptDialog.setComp(new PromptPanel(title, prompt));
		promptDialog.start(); // 固定时间关闭窗口
	}

	private class Vanish extends Thread {

		/** 窗体透明值 */
		protected float hyalineValue = 1f;

		public void run() {
			try {
				Thread.sleep(5000);
				while(true) {
					Thread.sleep(20);
					hyalineValue -= 0.05f;
					if (hyalineValue < 0) {
						hyalineValue = 0;
					}
					PromptDialog.this.setOpacity(hyalineValue);
					if (hyalineValue == 0) {
						PromptDialog.this.dispose();
						break;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
