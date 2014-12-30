package ui.differui.manager.strategy.fuction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyPanel;
import ui.commonui.warning.WarningFrame;
import vo.InventoryBillVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import dataenum.ClientLevel;
import blservice.promotionblservice.PromoInputInfo;
import blservice.promotionblservice.PromotionClientBLService;
import businesslogic.promotionbl.type.PromotionClientController;

public class LevelPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1, textField_date2, textField_date1;
	private JButton button_return, button_finish;
	private static ArrayList<CommodityItemVO> commoPool;
	private JComboBox<String> comboBox, comboBox_1, comboBox_2;
	private JCheckBox checkBox, checkBox_1, checkBox_2;
	public LevelPanel(){
		
		commoPool = new ArrayList<CommodityItemVO>();
		
		int width = 400;
		int height = 500;
		
		int y = 15;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("按客户星级添加促销策略",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		button_return = new JButton("返回");
		button_return.setBounds(273, 460, 113, 20);
		button_return.addActionListener(this);
		button_return.setBackground(backColor);
		button_return.setForeground(foreColor);
		add(button_return);
		
		button_finish = new JButton("完成");
		button_finish.setBounds(273 - 113 - 10, 460, 113, 20);
		button_finish.addActionListener(this);
		button_finish.setBackground(backColor);
		button_finish.setForeground(foreColor);
		add(button_finish);
		
		JLabel label = new JLabel("*选择星级");
		label.setForeground(Color.RED);
		label.setBounds(25, 45, 72, 18);
		add(label);
		
		String[] str = {"一星级", "二星级", "三星级", "四星级", "五星级"};
		comboBox = new JComboBox<String>(str);
		comboBox.setBounds(120, 42, 198, 24);
		comboBox.setBackground(backColor);
		comboBox.setForeground(foreColor);
		add(comboBox);
		
		JLabel label_1 = new JLabel("*选择一种促销方式");
		label_1.setForeground(Color.RED);
		label_1.setBounds(25, 92, 134, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("折扣：");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(60, 169 - y, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("代金券数额：");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(60, 241 - y, 99, 18);
		add(label_3);
		
		JLabel label_a = new JLabel("*填写初始以及结束日期(格式YYYYMMDD)：");
		label_a.setForeground(Color.RED);
		label_a.setBounds(25, 370, 400, 18);
		add(label_a);
		
		textField_date1 = new JTextField();
		textField_date1.setBounds(50, 398, 134, 24);
		textField_date1.setBackground(backColor);
		textField_date1.setForeground(foreColor);
		add(textField_date1);
		
		textField_date2 = new JTextField();
		textField_date2.setBounds(210, 398, 134, 24);
		textField_date2.setBackground(backColor);
		textField_date2.setForeground(foreColor);
		add(textField_date2);
		
		JLabel label_date = new JLabel("~");
		label_date.setForeground(Color.WHITE);
		label_date.setBounds(194, 400, 72, 18);
		add(label_date);
		
		String[] str2 = {"98折", "95折", "9折", "88折", "85折", "8折", "79折", "75折", "7折", "65折"
				, "6折", "58折", "5折"};
		comboBox_1 = new JComboBox<String>(str2);
		comboBox_1.setBounds(157, 166 - y, 134, 24);
		comboBox_1.setOpaque(false);
		comboBox_1.setBackground(backColor);
		comboBox_1.setForeground(foreColor);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(157, 238 - y, 134, 24);
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		add(textField);
		
		JLabel label_4 = new JLabel("元");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(298, 241 - y, 72, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("赠品选择：");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(60, 317 - y, 83, 18);
		add(label_5);
		
		comboBox_2 = new JComboBox<String>(getGift());
		comboBox_2.setBounds(157, 314 - y, 134, 24);
		comboBox_2.setBackground(backColor);
		comboBox_2.setForeground(foreColor);
		add(comboBox_2);
		
		JLabel label_6 = new JLabel("赠品个数：");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(60, 351 - y, 99, 18);
		add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 348 - y, 134, 24);
		add(textField_1);
		textField_1.setBackground(backColor);
		textField_1.setForeground(foreColor);
		
		JLabel label_7 = new JLabel("件");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(298, 351 - y, 72, 18);
		add(label_7);
		
		checkBox = new JCheckBox("折让");
		checkBox.setForeground(Color.RED);
		checkBox.setOpaque(false);
		checkBox.setBackground(null);	
		checkBox.setBounds(25, 133 - y, 133, 27);
		add(checkBox);
		
		checkBox_1 = new JCheckBox("代金券");
		checkBox_1.setForeground(Color.RED);
		checkBox_1.setOpaque(false);
		checkBox_1.setBackground(null);
		checkBox_1.setBounds(26, 205 - y, 133, 27);
		add(checkBox_1);
		
		checkBox_2 = new JCheckBox("赠品");
		checkBox_2.setForeground(Color.RED);
		checkBox_2.setOpaque(false);
		checkBox_2.setBackground(null);
		checkBox_2.setBounds(25, 283 - y, 133, 27);
		add(checkBox_2);
		
		
	}
	
	private double getAllowance(){
		switch(comboBox_1.getSelectedIndex()){
		//"98折", "95折", "9折", "88折", "85折", "8折", "79折", "75折", "7折", "65折"
		//"6折", "58折", "5折"
		case 0:return 0.98;
		case 1:return 0.95;
		case 2:return 0.9;
		case 3:return 0.88;
		case 4:return 0.85;
		case 5:return 0.8;
		case 6:return 0.79;
		case 7:return 0.75;
		case 8:return 0.7;
		case 9:return 0.65;
		case 10:return 0.6;
		case 11:return 0.58;
		default:return 0.5;
		}
	}
	
	private ClientLevel getLevel(){
		switch(comboBox.getSelectedIndex()){
			case 0:return ClientLevel.LEVEL_1;
			case 1:return ClientLevel.LEVEL_2;
			case 2:return ClientLevel.LEVEL_3;
			case 3:return ClientLevel.LEVEL_4;
			default:return ClientLevel.VIP;
		}
	}
	
	private String[] getGift(){
		
		commoPool.clear();
		
		String str = "";
		
		PromotionClientBLService controller = new PromotionClientController();
		ArrayList<InventoryBillVO> list = controller.showGifts();
		if(list != null)
			for(int i =0; i < list.size(); i++){
				InventoryBillVO vo = list.get(i);
				ArrayList<CommodityItemVO> commoList = vo.commodities;
				
				if(commoList != null)
					for(int j = 0; j < commoList.size(); j++){
						CommodityItemVO cvo = commoList.get(j);
						str = str + cvo.name + ";";
						commoPool.add(cvo);
					}
			}
		if(commoPool.size() > 0){
			return str.split(";");
		}else{
			String[] str2 = {"暂时没有赠品"};
			return str2;
		}
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == button_return){
			ExitFunctionFrame eff = new ExitFunctionFrame("LevelFrame");
			eff.setVisible(true);
		}
		
		if(events.getSource() == button_finish){
			int counter = 0;
			int flag = 0;
			
			if(checkBox.isSelected()){
				counter++;
				flag = 1;
			}
			
			if(checkBox_1.isSelected()){
				counter++;
				flag = 2;
			}
			
			if(checkBox_2.isSelected()){
				counter++;
				flag = 3;
			}
			
			if(counter == 0){
				WarningFrame wf = new WarningFrame("请选择一种促销方式!");
				wf.setVisible(true);
			}else if(counter > 1){
				WarningFrame wf = new WarningFrame("请只选择一种促销方式!");
				wf.setVisible(true);
			}else{
				if(textField_date1.getText().isEmpty() || textField_date2.getText().isEmpty()){
					WarningFrame wf = new WarningFrame("请检查时间填写是否完整!");
					wf.setVisible(true);
				}else{
					if(flag == 1){
						PromotionClientBLService controller = new PromotionClientController();
						controller.getID();
						controller.setClient(getLevel());
						//String beginDate, String endDate, double allowance, int voucher
						controller.submit(new PromoInputInfo(textField_date1.getText()
								, textField_date2.getText(), getAllowance(), 0));
						
						WarningFrame wf = new WarningFrame("添加成功!");
						wf.setVisible(true);
						
						LevelFrame.button_close.doClick();
						StrategyManagementUI.refresh.doClick();
						
					}else if(flag == 2){
						if(textField.getText().isEmpty()){
							WarningFrame wf = new WarningFrame("请检查信息填写是否完整!");
							wf.setVisible(true);
						}else{
							PromotionClientBLService controller = new PromotionClientController();
							controller.getID();
							controller.setClient(getLevel());
							//String beginDate, String endDate, double allowance, int voucher
							controller.submit(new PromoInputInfo(textField_date1.getText()
									, textField_date2.getText(), 1, Integer.parseInt(textField.getText())));
							
							WarningFrame wf = new WarningFrame("添加成功!");
							wf.setVisible(true);
							
							LevelFrame.button_close.doClick();
							StrategyManagementUI.refresh.doClick();
						}
					}else{
						if(textField_1.getText().isEmpty()){
							WarningFrame wf = new WarningFrame("请检查信息填写是否完整!");
							wf.setVisible(true);
						}else{
							PromotionClientBLService controller = new PromotionClientController();
							controller.getID();
							controller.setClient(getLevel());
							int index = comboBox_2.getSelectedIndex();
							CommodityItemVO old = commoPool.get(index);
							//String ID, int number, double price, String remark, String name, String type
							CommodityItemVO gift = new CommodityItemVO(old.ID, Integer.parseInt(textField_1.getText()),
									old.price, old.remark, old.name, old.type);
							controller.addGifts(gift);
							
							//String beginDate, String endDate, double allowance, int voucher
							controller.submit(new PromoInputInfo(textField_date1.getText()
									, textField_date2.getText(), 1, 0));
							
							WarningFrame wf = new WarningFrame("添加成功!");
							wf.setVisible(true);
							
							LevelFrame.button_close.doClick();
							StrategyManagementUI.refresh.doClick();
						}
					}
				}
			}
		}
	}
}

