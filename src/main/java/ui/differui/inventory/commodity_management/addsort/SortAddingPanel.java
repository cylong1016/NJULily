package ui.differui.inventory.commodity_management.addsort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;

public class SortAddingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_confirm;
	MyTextField tf_name;
	
	public SortAddingPanel(){
		
		String str = "Plipala";
		
		//information bar
		JLabel infoBar = new JLabel("新增商品分类",JLabel.CENTER);
		infoBar.setBounds(0, 0 , 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(Color.black);
		infoBar.setBackground(new Color(0, 1, 1, 0.5f));
		this.add(infoBar);
		
		//texts
		JLabel word_tip1 = new JLabel("商品分类名称:");
		word_tip1.setForeground(Color.white);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(165, 40 , 85, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("商品分类属于:         "+ str);
		word_tip2.setForeground(Color.white);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(165, 90 , 200, 25);
		this.add(word_tip2);
		
		//TextField
		tf_name = new MyTextField(260, 42, 140, 20);
		this.add(tf_name);
		
		//buttons
		button_return = new MyJButton("取消");
		button_return.setBounds(475, 145, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);

		button_confirm = new MyJButton("确认添加");
		button_confirm.setBounds(475, 115, 100, 20);
		button_confirm.addActionListener(this);
		this.add(button_confirm);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("SortAddingUI");
			epf.setVisible(true);
		}
		
	}	
}
