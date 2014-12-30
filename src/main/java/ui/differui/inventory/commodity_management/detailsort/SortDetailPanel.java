package ui.differui.inventory.commodity_management.detailsort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;

import dataenum.ResultMessage;
import blservice.commoditysortblservice.CommoditySortBLService;
import businesslogic.commoditysortbl.CommoditySortController;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import vo.commodity.CommoditySortVO;

public class SortDetailPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_confirm, button_show;
	static MyTextField tf_name;
	static String str = "";
	
	public SortDetailPanel(DefaultMutableTreeNode note){
		
		str = note.toString();
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		//information bar
		JLabel infoBar = new JLabel("修改或查看所选商品分类",JLabel.CENTER);
		infoBar.setBounds(0, 0 , 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//texts
		JLabel word_tip1 = new JLabel("商品分类名称:");
		word_tip1.setForeground(Color.white);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(165, 40 + 20, 85, 25);
		this.add(word_tip1);
				
		//TextField
		tf_name = new MyTextField(260, 42 + 20, 140, 20);
		tf_name.setText(str);
		this.add(tf_name);
		
		//buttons
		button_return = new MyJButton("取消");
		button_return.setBounds(475, 145, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);

		button_confirm = new MyJButton("确认修改");
		button_confirm.setBounds(475, 115, 100, 20);
		button_confirm.addActionListener(this);
		this.add(button_confirm);
		
		button_show = new MyJButton("显示此分类下所含的所有商品");
		button_show.setBounds(165, 115, 235, 20);
		button_show.addActionListener(this);
		this.add(button_show);
	}
	
	public static void changeName(){
		CommoditySortBLService controller = new CommoditySortController();
		ArrayList<CommoditySortVO> list = controller.show();
		String ID = "";
		
		for(int i = 1; i < list.size(); i++){
			if(str.equals(list.get(i).name)){
				ID = list.get(i).ID;
			}
		}
		ResultMessage rm = controller.updCommoSort(ID, tf_name.getText());
		
		if(rm.equals(ResultMessage.SUCCESS)){
			CommodityManagementUI.button_buildTree.doClick();
		}else{
			WarningFrame wf = new WarningFrame("商品分类修改失败！");
			wf.setVisible(true);	
		}
		
	} 
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("SortDetailUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_confirm){
			ExitFinishFrame eff = new ExitFinishFrame("Change sort's name");
			eff.setVisible(true);
		}
		
	}	
}