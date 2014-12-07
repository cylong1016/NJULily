package ui.differui.inventory.commodity_management.delsort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;

import message.ResultMessage;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import vo.commodity.CommoditySortVO;
import businesslogic.commoditysortbl.CommoditySortController;

public class SortDelPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_confirm;
	static DefaultMutableTreeNode delNode;
	static String str;
	
	public SortDelPanel(DefaultMutableTreeNode note){
		
		str = note.toString();
		delNode = note;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("删除商品分类",JLabel.CENTER);
		infoBar.setBounds(0, 0 , 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//texts
		JLabel word_tip1 = new JLabel("商品分类名称:  " + str);
		word_tip1.setForeground(Color.white);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(165, 40 , 300, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("*警告！一旦删除将无法恢复");
		word_tip2.setForeground(Color.white);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(165, 90 , 300, 25);
		this.add(word_tip2);
				
		//buttons
		button_return = new MyJButton("取消");
		button_return.setBounds(475, 145, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);

		button_confirm = new MyJButton("确认删除");
		button_confirm.setBounds(475, 115, 100, 20);
		button_confirm.addActionListener(this);
		this.add(button_confirm);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("SortDelUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_confirm){
			deleteSort();
		}	
	}	
	
	public static void deleteSort(){
		CommoditySortController controller = new CommoditySortController();
		
		ArrayList<CommoditySortVO> csvo = controller.show();
		
		String ID = "";
		
		for(int i = 1; i < csvo.size(); i++){
			if(csvo.get(i).name.equals(str)){
				ID = csvo.get(i).ID;
			}
		}
		
		ResultMessage rs = controller.deleteCommoSort(ID);
		
		if(rs.equals(ResultMessage.SUCCESS)){
			CommodityManagementUI.button_buildTree.doClick();
		}else{
			WarningFrame wf = new WarningFrame("商品分类无法删除！");
			wf.setVisible(true);
		}
	}
}
