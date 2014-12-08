package ui.differui.inventory.commodity_management.addgood;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

import message.ResultMessage;
import businesslogic.commoditybl.Commodity;
import businesslogic.commoditysortbl.CommoditySort;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;
import ui.commonui.myui.MyTree;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import vo.commodity.CommodityAddVO;
import vo.commodity.CommoditySortVO;

public class CommodityAddingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_finish, button_confirm;
	MyTextField tf_name, tf_model, tf_salePrice, tf_purPrice;
	MyTree tree;
	JLabel word_sort;
	DefaultMutableTreeNode note;
	String sortName = "无";
	Boolean haveChoose = false;
	public static JButton addGood;
	
	public CommodityAddingPanel(){
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
			
		int y = 10;
		sortName = "无";
		
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
		word_name.setBounds(45 + 15, 50 + y, 60, 25);
		this.add(word_name);
		
		JLabel word_model = new JLabel("商品型号:");
		word_model.setForeground(Color.WHITE);
		word_model.setBackground(new Color(0, 0, 0, 0));
		word_model.setBounds(290 + 20, 50 + y, 60, 25);
		this.add(word_model);
		
		JLabel word_purPrice = new JLabel("默认进价:");
		word_purPrice.setForeground(Color.WHITE);
		word_purPrice.setBackground(new Color(0, 0, 0, 0));
		word_purPrice.setBounds(45 + 15, 50 + y + 50, 60, 25);
		this.add(word_purPrice);
		
		JLabel word_yuan1= new JLabel("元");
		word_yuan1.setForeground(Color.WHITE);
		word_yuan1.setBackground(new Color(0, 0, 0, 0));
		word_yuan1.setBounds(260, 50 + y + 50, 25, 25);
		this.add(word_yuan1);
		
		JLabel word_yuan2= new JLabel("元");
		word_yuan2.setForeground(Color.WHITE);
		word_yuan2.setBackground(new Color(0, 0, 0, 0));
		word_yuan2.setBounds(260 + 245, 50 + y + 50, 25, 25);
		this.add(word_yuan2);
		
		JLabel word_salePrice = new JLabel("默认售价:");
		word_salePrice.setForeground(Color.WHITE);
		word_salePrice.setBackground(new Color(0, 0, 0, 0));
		word_salePrice.setBounds(290 + 20, 50 + y + 50, 60, 25);
		this.add(word_salePrice);
		
		JLabel word_tip2 = new JLabel("选择商品所属分类:");
		word_tip2.setForeground(Color.RED);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(25, 90 + y + 50, 120, 25);
		this.add(word_tip2);
		
		word_sort = new JLabel("所选商品分类:     "+sortName);
		word_sort.setForeground(Color.WHITE);
		word_sort.setBackground(new Color(0, 0, 0, 0));
		word_sort.setBounds(60, 360 + 50, 200, 25);
		this.add(word_sort);
			
		//some textFields
		tf_name = new MyTextField(120 + 15, 54 + y, 140, 20);
		this.add(tf_name);
		
		tf_model = new MyTextField(360 + 20, 54 + y, 140, 20);
		this.add(tf_model);
		
		tf_purPrice = new MyTextField(120 + 15, 104 + y, 120, 20);
		this.add(tf_purPrice);
		
		tf_salePrice = new MyTextField(360 + 20, 104 + y, 120, 20);
		this.add(tf_salePrice);
		
		
		//the sort tree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有商品分类"); 
		
		tree = new MyTree(root);		
		JScrollPane jsp=new JScrollPane(tree);
		jsp.setBounds(25, 125 + y + 50, 550, 170);
		jsp.getViewport().setBackground(new Color(0,0,0));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//buttons
		button_return = new MyJButton("返回");
		button_return.setBounds(475, 410 + 50, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_finish = new MyJButton("确认添加");
		button_finish.setBounds(475, 380 + 50, 100, 20);
		button_finish.addActionListener(this);
		this.add(button_finish);
		
		button_confirm = new MyJButton("选择所选商品分类");
		button_confirm.setBounds(435, 315 + 50, 140, 20);
		button_confirm.addActionListener(this);
		this.add(button_confirm);	
		
		addGood = new JButton();
		addGood.addActionListener(this);
		this.add(addGood);		
	}
	
	public String getSortID(DefaultMutableTreeNode note){
		CommoditySort controller = new CommoditySort();
		ArrayList<CommoditySortVO> list = controller.show();
		
		for(int i = 1; i < list.size(); i++){
			if(list.get(i).name.equals(note.toString())){
				return list.get(i).ID;
			}
		}
		
		return null;
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("CommodityAddingUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_confirm){
			note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			
			if(tree.getSelectionCount() != 1){
				WarningFrame wf = new WarningFrame("请选择一个商品分类！");
				wf.setVisible(true);
			}else{
				sortName = note.toString();
				word_sort.setText("所选商品分类:     " + sortName);
				haveChoose = true;
			}
		}
		
		if(events.getSource() == button_finish){
			
			if(haveChoose == false){		
				WarningFrame wf = new WarningFrame("请选择商品所属的商品分类！");
				wf.setVisible(true);
			}else{
				
				if(tf_name.getText().isEmpty() || tf_model.getText().isEmpty()
						|| tf_purPrice.getText().isEmpty() || tf_salePrice.getText().isEmpty()){
					WarningFrame wf = new WarningFrame("请检查信息填写是否完整！");
					wf.setVisible(true);
				}else{
					ExitFinishFrame eff = new ExitFinishFrame("add a good");
					eff.setVisible(true);
				}
			}
		}
		
		if(events.getSource() == addGood){
			Commodity controller = new Commodity();
			ResultMessage rm = controller.addCommo(new CommodityAddVO(controller.getID(getSortID(note)), 
					tf_name.getText(), tf_model.getText(), getSortID(note), 
					0, Double.parseDouble(tf_purPrice.getText()), Double.parseDouble(tf_salePrice.getText())));
			
			if(rm.equals(ResultMessage.SUCCESS)){
				WarningFrame wf = new WarningFrame("商品添加成功！");
				wf.setVisible(true);
				CommodityManagementUI.showAll.doClick();
			}else{
				WarningFrame wf = new WarningFrame("商品无法添加！");
				wf.setVisible(true);
			}
		}
	}
}
