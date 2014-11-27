package ui.differui.inventory.commodity_management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.myui.MyTree;

public class CommodityManagementUI extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_add, button_cam, button_add2, button_cam2;
	
	public static JButton button_close;
	
	public CommodityManagementUI(){
		
		JLabel infoBar = new JLabel("                     商品分类与商品管理");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);

		MyTree tree = new MyTree();		
		JScrollPane jsp=new JScrollPane(tree);
		jsp.setBounds(25, 50 + 20, 180, 480);
		jsp.getViewport().setBackground(new Color(0,0,0));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
			
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "商品编号(ID)",  "商品分类", "商品名称", "客户"};
		MyComboBox comboBox = new MyComboBox(25 + 190, 15 + 20, 200, 25,comboBoxStr);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(235 + 190, 15 + 20, 200, 25);
		textField.setText("在此输入搜索关键字");
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(445 + 190, 15 + 20, 130, 25);
		button_search.addActionListener(this);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		MyJButton button_showAll = new MyJButton("显示全部商品");
		button_showAll.setBounds(944, 15 + 20, 130, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);	
		
		//add a table for showing the information of the goods(the table is contained in a scroll pane)
		String[] headers = {"商品编号","商品分类","商品名称","商品型号"
				,"库存数量","库区"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp2=new JScrollPane(table);
		jsp2.setBounds(215, 70, 860, 550);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		//add a button for adding a new good
		button_add = new MyJButton("新增商品");
		button_add.setBounds(25 + 420, 630, 130, 25);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		//add a button for deleting a selected good
		MyJButton button_del = new MyJButton("删除所选商品");
		button_del.setBounds(165 + 420, 630, 130, 25);
		button_del.addActionListener(this);
		this.add(button_del);	
		
		//add a button for modifying the information of a selected good
		button_cam = new MyJButton("修改或查看所选商品详细信息");
		button_cam.setBounds(305 + 420, 610 + 20, 210, 25);
		button_cam.addActionListener(this);
		this.add(button_cam);	
		
		///////////////////////////////////////////////////////////////////////////////
		
		//add a button for adding a new good sort
		button_add2 = new MyJButton("新增商品分类");
		button_add2.setBounds(25, 560, 180, 25);
		button_add2.addActionListener(this);
		this.add(button_add2);	
		
		//add a button for deleting a selected good sort
		MyJButton button_del2 = new MyJButton("删除所选商品分类");
		button_del2.setBounds(25, 595, 180, 25);
		button_del2.addActionListener(this);
		this.add(button_del2);	
		
		//add a button for  modifying the information of a selected good sort
		button_cam2 = new MyJButton("修改所选商品分类");
		button_cam2.setBounds(25, 610 + 20, 180, 25);
		button_cam2.addActionListener(this);
		this.add(button_cam2);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450, 610 + 20, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		
		
	}
}
