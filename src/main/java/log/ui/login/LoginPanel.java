package log.ui.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import log.LoginCheck;
import log.config.LogUIConfig;
import log.ui.Button;
import log.ui.TextField;
import log.ui.logmsg.LogFrame;
import log.ui.warning.PromptDialog;
import dataservice.userdataservice.LoginInfo;

/**
 * @author cylong
 * @version 2014年12月27日 下午11:20:38
 */
public class LoginPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -6549493833516155941L;
	
	/** 背景图片 */
	private static final Image IMG_BACK = new ImageIcon("ui/image/log/login/back.jpg").getImage();
	/** 用户名图片 */
	private static final Image IMG_USERNAME = new ImageIcon("ui/image/log/login/username.png").getImage();
	/** 密码图片 */
	private static final Image IMG_PASS = new ImageIcon("ui/image/log/login/password.png").getImage();
	/** 登录按钮图片 */
	private static final Image IMG_GO_1 = new ImageIcon("ui/image/log/login/go_button_1.png").getImage();
	/** 移动到登录按钮上的图片 */
	private static final Image IMG_GO_2 = new ImageIcon("ui/image/log/login/go_button_2.png").getImage();

	/** 用户名输入框 */
	private TextField userText;
	/** 用户名输入框的位置 */
	private Point userFieldPoint = new Point(460, 415);
	/** 密码输入框 */
	private JPasswordField passText;
	/** 输入框的大小 */
	private Dimension fieldDimen = new Dimension(172, 38);
	/** 是否点击输入框 */
	private boolean isClicked = false;
	/** 登录按钮 */
	private Button loginBtn;

	/** 鼠标监听 */
	private Listener listener;

	public LoginPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		listener = new Listener();
		addInputField();
		addLoginBtn();
	}

	private void addInputField() {
		userText = new TextField();
		userText.setSize(fieldDimen);
		userText.setLocation(userFieldPoint.x + 4, userFieldPoint.y + 2);
		userText.setFont(LogUIConfig.LOGIN_FONT);
		userText.addMouseListener(listener);
		this.add(userText);
		passText = new JPasswordField();
		passText.setSize(fieldDimen);
		passText.setLocation(userFieldPoint.x + 187, userFieldPoint.y + 2);
		passText.setBorder(BorderFactory.createEmptyBorder());
		passText.setForeground(LogUIConfig.INPUT_FONT_COLOR);
		passText.setOpaque(false);
		passText.addMouseListener(listener);
		this.add(passText);
	}

	private void addLoginBtn() {
		loginBtn = new Button(IMG_GO_1, IMG_GO_2);
		loginBtn.setLocation(userFieldPoint.x + 364, userFieldPoint.y);
		loginBtn.addMouseListener(listener);
		this.add(loginBtn);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(IMG_BACK, 0, 0, this);
		if(!isClicked) {
			g.drawImage(IMG_USERNAME, userFieldPoint.x, userFieldPoint.y, this);
			g.drawImage(IMG_PASS, userFieldPoint.x + 182, userFieldPoint.y, this);
		}
		super.paintComponent(g);
	}
	

	private class Listener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == loginBtn) {
				new Thread() {

					// 解决卡顿
					public void run() {
						LoginInfo info = new LoginInfo(userText.getText(), new String(passText.getPassword()), false);
						try {
							LoginCheck check = new LoginCheck();
							if (check.login(info)) {
								Component frame = LoginPanel.this.getParent();
								while(!(frame instanceof LoginFrame)) {
									frame = frame.getParent();
								}
								((LoginFrame)frame).dispose();
								new LogFrame();
							} else {
								PromptDialog.show("登录失败", "用户名或者密码错误");
							}
						} catch (Exception e) {
							e.printStackTrace();
							PromptDialog.showConnectionError();
						}
					}
				}.start();
			}
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == passText | e.getSource() == userText) {
				isClicked = true;
				repaint();
			}
			
		}
		

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == passText) {
				passText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == passText) {
				passText.setBorder(BorderFactory.createEmptyBorder());
			}
		}
	}

}

class Label extends JLabel {

	/** serialVersionUID */
	private static final long serialVersionUID = -7036067736017742948L;

	/**
	 * @param text
	 * @author cylong
	 * @version 2014年12月27日 下午11:39:48
	 */
	public Label(String text) {
		super(text, JLabel.CENTER);
		this.setFont(LogUIConfig.LOGIN_FONT);
	}
}
