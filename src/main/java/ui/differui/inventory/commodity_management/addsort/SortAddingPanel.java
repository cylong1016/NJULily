package ui.differui.inventory.commodity_management.addsort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;

import blservice.commoditysortblservice.CommoditySortBLService;
import businesslogic.commoditysortbl.CommoditySortController;
import message.ResultMessage;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import vo.commodity.CommoditySortVO;

public class SortAddingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_confirm;
	public static MyTextField tf_name;
	static DefaultMutableTreeNode father;
	
	public SortAddingPanel(DefaultMutableTreeNode note){
		
		String str = note.toString();
		father = note;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("新增商品分类",JLabel.CENTER);
		infoBar.setBounds(0, 0 , 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//texts
		JLabel word_tip1 = new JLabel("商品分类名称:");
		word_tip1.setForeground(Color.white);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(165, 40 , 85, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("商品分类属于:    "+ str);
		word_tip2.setForeground(Color.white);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(165, 90 , 300, 25);
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
		
		if(events.getSource() == button_confirm){
			ExitFinishFrame eff = new ExitFinishFrame("adding a sort");
			eff.setVisible(true);
		}	
	}	
	
	public static void addingConfirm(){
		CommoditySortBLService controller = new CommoditySortController();
		
		ResultMessage rs = null;
		
		if(father.toString().equals("所有商品分类")){
			// TODO SP为所有商品分类的分类ID，这个需要从数据层获得,我不知道你在哪获得的，就先写成SP
			rs = controller.addCommoSort(tf_name.getText(),"SP");
		}else{
			ArrayList<CommoditySortVO> csvo = controller.show();
			
			for(int i = 0; i < csvo.size(); i++){
				if(csvo.get(i).name.equals(father.toString())){
					rs = controller.addCommoSort(tf_name.getText(), csvo.get(i).ID);
				}
			}
		}	
		
		if(rs.equals(ResultMessage.SUCCESS)){
			CommodityManagementUI.button_buildTree.doClick();
		}else{
			WarningFrame wf = new WarningFrame("商品分类添加失败！");
			wf.setVisible(true);
		}
	}
}
