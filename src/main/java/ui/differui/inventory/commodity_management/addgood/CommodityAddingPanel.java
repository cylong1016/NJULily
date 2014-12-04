package ui.differui.inventory.commodity_management.addgood;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;
import ui.commonui.myui.MyTree;


public class CommodityAddingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_finish, button_add, button_confirm;
	MyTextField tf_name, tf_model;
	
	public CommodityAddingPanel(){
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
			
		int y = 10;
		String sortName = "无";
		
		//information bar
		JLabel infoBar = new JLabel("新增一件商品",JLabel.CENTER);
		infoBar.setBounds(0, 0, 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//some texts
		JLabel word_tip1 = new JLabel("填写商品信息:");
		word_tip1.setForeground(Color.RED);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(25, 25 + y, 85, 25);
		this.add(word_tip1);
		
		JLabel word_name = new JLabel("商品名称:");
		word_name.setForeground(Color.WHITE);
		word_name.setBackground(new Color(0, 0, 0, 0));
		word_name.setBounds(45 + 15, 50 + y, 60 + 0, 25);
		this.add(word_name);
		
		JLabel word_model = new JLabel("商品型号:");
		word_model.setForeground(Color.WHITE);
		word_model.setBackground(new Color(0, 0, 0, 0));
		word_model.setBounds(290 + 20, 50 + y, 60, 25);
		this.add(word_model);
		
		JLabel word_tip2 = new JLabel("选择商品所属分类:");
		word_tip2.setForeground(Color.RED);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(25, 90 + y, 120, 25);
		this.add(word_tip2);
		
		JLabel word_sort = new JLabel("所选商品分类:     "+sortName);
		word_sort.setForeground(Color.WHITE);
		word_sort.setBackground(new Color(0, 0, 0, 0));
		word_sort.setBounds(60, 360, 200, 25);
		this.add(word_sort);
			
		//some textFields
		tf_name = new MyTextField(120 + 15, 54 + y, 140, 20);
		this.add(tf_name);
		
		tf_model = new MyTextField(360 + 20, 54 + y, 140, 20);
		this.add(tf_model);
		
		
		//the sort tree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有商品分类"); 
		root.add(new DefaultMutableTreeNode("日光灯"));
		
		MyTree tree = new MyTree(root);		
		JScrollPane jsp=new JScrollPane(tree);
		jsp.setBounds(25, 125 + y, 550, 170);
		jsp.getViewport().setBackground(new Color(0,0,0));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//buttons
		button_return = new MyJButton("返回");
		button_return.setBounds(475, 410, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_finish = new MyJButton("确认添加");
		button_finish.setBounds(475, 380, 100, 20);
		button_finish.addActionListener(this);
		this.add(button_finish);
		
		button_add = new MyJButton("添加商品分类");
		button_add.setBounds(285, 315, 140, 20);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		button_confirm = new MyJButton("选择所选商品分类");
		button_confirm.setBounds(435, 315, 140, 20);
		button_confirm.addActionListener(this);
		this.add(button_confirm);	
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("CommodityAddingUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_add){
			
		}
	}
}
