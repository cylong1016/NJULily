package ui.saleUI.clientManagement;


import java.awt.Color;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> origin/master

import javax.swing.JScrollPane;

import ui.myUI.MyComboBox;
import ui.myUI.MyJButton;
import ui.myUI.MyPanel;
import ui.myUI.MyTable;
import ui.myUI.MyTextField;

<<<<<<< HEAD
public class Panel_ClientManagement extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_return, button_add;
	
=======
public class Panel_ClientManagement extends MyPanel{

	private static final long serialVersionUID = 1L;

>>>>>>> origin/master
	public Panel_ClientManagement(){
		
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"};
		MyComboBox comboBox = new MyComboBox(25, 15, 200, 25,comboBoxStr);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(235, 15, 200, 25);
		textField.setText("在此输入搜索关键字");
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(445, 15, 130, 25);
<<<<<<< HEAD
		button_search.addActionListener(this);
=======
>>>>>>> origin/master
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		MyJButton button_showAll = new MyJButton("显示全部客户");
		button_showAll.setBounds(944, 15, 130, 25);
<<<<<<< HEAD
		button_showAll.addActionListener(this);
=======
>>>>>>> origin/master
		this.add(button_showAll);	
		
		//add a table for showing the information of the clients(the table is contained in a scroll pane)
		String[] headers = {"行号","客户编号","客户分类","客户星级"
				,"客户名称","默认业务员","应收付差额","应收","应付"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(25, 50, 1050, 550);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//add a button for adding a new client
<<<<<<< HEAD
		button_add = new MyJButton("新增一名客户");
		button_add.setBounds(25 + 420, 610, 130, 25);
		button_add.addActionListener(this);
=======
		MyJButton button_add = new MyJButton("新增一名客户");
		button_add.setBounds(25 + 420, 610, 130, 25);
>>>>>>> origin/master
		this.add(button_add);	
		
		//add a button for deleting a selected client
		MyJButton button_del = new MyJButton("删除所选客户");
		button_del.setBounds(165 + 420, 610, 130, 25);
<<<<<<< HEAD
		button_del.addActionListener(this);
=======
>>>>>>> origin/master
		this.add(button_del);	
		
		//add a button for checking and modifying the information of a selected client
		MyJButton button_cam = new MyJButton("修改或查看所选客户详细信息");
		button_cam.setBounds(305 + 420, 610, 210, 25);
<<<<<<< HEAD
		button_cam.addActionListener(this);
		this.add(button_cam);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450, 610, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
					
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_return){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_add){
			Panel_ClientAdding panelAdd = new Panel_ClientAdding();
			this.add(panelAdd);
			System.out.println("aaa");
		}
	}
=======
		this.add(button_cam);	
		
		//add a button for returning to the last UI
		MyJButton button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450, 610, 100, 25);
		this.add(button_return);	
					
	}
>>>>>>> origin/master
}
