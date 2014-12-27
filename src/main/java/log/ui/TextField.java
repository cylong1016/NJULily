package log.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * @author cylong
 * @version 2014年12月28日 上午1:57:04
 */
public class TextField extends JTextField {

	/** serialVersionUID */
	private static final long serialVersionUID = -6857760594273517171L;

	public TextField() {
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.addMouseListener(new Listener());
	}

	private class Listener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		}
	}

}
