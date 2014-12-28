package log.ui.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
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

	/** 用户名和密码标签 */
	private Label username, password;
	/** 用户名输入框 */
	private TextField userText;
	/** 密码输入框 */
	private JPasswordField passText;
	/** 输入框的大小 */
	private Dimension fieldDimen = new Dimension(150, 30);

	/** 登录按钮 */
	private Button loginBtn;
	/** 登录按钮大小 */
	private Dimension btnDimen = new Dimension(200, 40);

	/** 上面那些组件的容器 */
	private JPanel[] container;

	/** 鼠标监听 */
	private Listener listener;

	public LoginPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 40));
		listener = new Listener();
		initPanel();
		addInputField();
		addLoginBtn();
	}

	private void initPanel() {
		container = new JPanel[3];
		for(int i = 0; i < container.length; i++) {
			container[i] = new JPanel();
			container[i].setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
			this.add(container[i]);
		}
	}

	private void addInputField() {
		username = new Label("用户名");
		userText = new TextField();
		userText.setPreferredSize(fieldDimen);
		userText.setFont(LogUIConfig.LOGIN_FONT);
		container[0].add(username);
		container[0].add(userText);
		password = new Label("密　码");
		passText = new JPasswordField();
		passText.setPreferredSize(fieldDimen);
		passText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		passText.addMouseListener(listener);
		container[1].add(password);
		container[1].add(passText);
	}

	private void addLoginBtn() {
		loginBtn = new Button("登录");
		loginBtn.setFont(LogUIConfig.LOGIN_FONT);
		loginBtn.setPreferredSize(btnDimen);
		loginBtn.addMouseListener(listener);
		container[2].add(loginBtn);
	}

	private class Listener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
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
							PromptDialog.show("错误", "连接服务器失败");
						}
					}
				}.start();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == passText) {
				passText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == passText) {
				passText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
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
