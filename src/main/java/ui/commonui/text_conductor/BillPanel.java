package ui.commonui.text_conductor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dataenum.BillType;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import vo.ValueObject;

public class BillPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_no;
	JTextArea ta;
	
	public BillPanel(BillType billType, ValueObject bill){
			
		int width = 700;
		int height = 560;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("单据查看",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setBackground(backColor);
		ta.setForeground(foreColor);
		TextConductor tc = new TextConductor();
		ta.setText(tc.writeBill(billType, bill));
		
		JScrollPane jsp2 = new JScrollPane(ta);
		jsp2.setBounds(25, 40, 650, 465);
		this.add(jsp2);
		
		button_no = new MyJButton("返回");
		button_no.setBounds(700 - 25 - 120, 560 - 25 - 10, 120, 25);
		button_no.setForeground(foreColor);
		button_no.setBackground(backColor);
		button_no.addActionListener(this);
		this.add(button_no);
		
	}
	
	public void actionPerformed(ActionEvent events){
		
		if(events.getSource() == button_no){
			ExitFunctionFrame eff = new ExitFunctionFrame("BillFrame");
			eff.setVisible(true);
		}
		
	}
}


