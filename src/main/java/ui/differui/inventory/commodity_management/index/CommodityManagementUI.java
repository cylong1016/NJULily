package ui.differui.inventory.commodity_management.index;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.myui.MyTree;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.addgood.CommodityAddingUI;
import ui.differui.inventory.commodity_management.addsort.SortAddingUI;
import ui.differui.inventory.commodity_management.detailgood.CommodityDetailUI;
import ui.differui.inventory.commodity_management.detailsort.SortDetailUI;
import ui.differui.inventory.frame.Frame_Inventory;

public class CommodityManagementUI extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_add, button_cam, button_add2, button_cam2;
	
	public static JButton button_close, button_buildTree;
	
	JScrollPane jsp;
	MyTree tree;
	
	public CommodityManagementUI(){
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setBackground(null);
		this.setOpaque(false);
		this.setBounds(0, 0, 1280, 720);
				
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有商品分类"); 
		tree = new MyTree(root); 
					
		jsp = new JScrollPane(tree);
		jsp.getViewport().add(tree, null);
		jsp.setBounds(50, 60, 225, 425);
		jsp.setVisible(true);
		this.add(jsp);
			
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "商品编号(ID)",  "商品分类", "商品名称", "客户"};
		MyComboBox comboBox = new MyComboBox(25 + 190 + 120, 60, 200, 25,comboBoxStr);
		comboBox.setForeground(foreColor);
		comboBox.setBackground(backColor);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(235 + 190 + 120, 60, 200, 25);
		textField.setText("在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(445 + 190 + 120, 60, 130, 25);
		button_search.addActionListener(this);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		MyJButton button_showAll = new MyJButton("显示全部商品");
		button_showAll.setBounds(944 + 150, 60, 130, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);	
		
		//add a table for showing the information of the goods(the table is contained in a scroll pane)
		String[] headers = {"商品编号","商品分类","商品名称","商品型号","库存数量"};
		MyTable table = new MyTable(headers);
		JTableHeader head = table.getTableHeader();
		head.setForeground(foreColor);
		head.setBackground(backColor);
		
		JScrollPane jsp2=new JScrollPane(table);
		jsp2.setBounds(335, 95, 890, 475);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		//add a button for adding a new good
		button_add = new MyJButton("新增商品");
		button_add.setBounds(25 + 420 + 150, 580, 130, 25);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		//add a button for deleting a selected good
		MyJButton button_del = new MyJButton("删除所选商品");
		button_del.setBounds(165 + 420 + 150, 580, 130, 25);
		button_del.addActionListener(this);
		this.add(button_del);	
		
		//add a button for modifying the information of a selected good
		button_cam = new MyJButton("修改或查看所选商品详细信息");
		button_cam.setBounds(305 + 420 + 150, 580, 210, 25);
		button_cam.addActionListener(this);
		this.add(button_cam);	
		
		///////////////////////////////////////////////////////////////////////////////
		
		//add a button for adding a new good sort
		button_add2 = new MyJButton("新增商品分类");
		button_add2.setBounds(50, 560 - 80 + 25, 225, 25);
		button_add2.addActionListener(this);
		this.add(button_add2);	
		
		//add a button for deleting a selected good sort
		MyJButton button_del2 = new MyJButton("删除所选商品分类");
		button_del2.setBounds(50, 595 - 80 + 25, 225, 25);
		button_del2.addActionListener(this);
		this.add(button_del2);	
		
		//add a button for  modifying the information of a selected good sort
		button_cam2 = new MyJButton("修改所选商品分类");
		button_cam2.setBounds(50, 550 + 25, 225, 25);
		button_cam2.addActionListener(this);
		this.add(button_cam2);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450 + 150, 580, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		button_buildTree = new JButton();
		button_buildTree.addActionListener(this);
		this.add(button_buildTree);
	}
		
	public void actionPerformed(ActionEvent events) {
	
		if(events.getSource() == button_add){
			CommodityAddingUI cau = new CommodityAddingUI();
			cau.setVisible(true);
		}
		
		if(events.getSource() == button_add2){
			DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if(tree.getSelectionCount() != 1){
				WarningFrame wf = new WarningFrame("请选择一个商品分类的所属类别！");
				wf.setVisible(true);
			}else{
				SortAddingUI sau = new SortAddingUI(note);
				sau.setVisible(true);
			}
		}
		
		if(events.getSource() == button_cam){
			CommodityDetailUI cdu = new CommodityDetailUI();
			cdu.setVisible(true);
		}
		
		if(events.getSource() == button_cam2){
			SortDetailUI sdu = new SortDetailUI();
			sdu.setVisible(true);
		}
		
		if(events.getSource() == button_return){
			Frame_Inventory.destination = 0;
			ExitFunctionFrame efp = new ExitFunctionFrame("Inventory");
			efp.setVisible(true);
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_buildTree){
					
			jsp.remove(tree);
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有商品分类"); 
			tree = new MyTree(root); 
			tree.updateUI();
			jsp.add(tree);
			jsp.updateUI();
		}
	}
	
}
