package ui.differui.manager.strategy.fuction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;









import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import ui.commonui.warning.WarningFrame;
import ui.differui.manager.strategy.myui.MyButton;
import ui.differui.manager.strategy.myui.MyJScrollPane;
import ui.differui.manager.strategy.myui.MyTable;
import ui.differui.manager.strategy.myui.PromotionData;



public class StrategyManagementUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private MyButton addBargainButton, addClientButton, addTotalButton;
	
	private MyTable clientTable, clientTable2;
	
	public static JButton refresh;
	
	public StrategyManagementUI(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("制定促销策略");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.WHITE);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		addPromotionTable();	
		addButtons();
		
		refresh = new JButton();
		refresh.addActionListener(this);
		this.add(refresh);
		
		refresh();
	}
	
	private void addPromotionTable() {
		
		PromotionData data = new PromotionData();
		
		String[] headersClient = {"编号","起始时间","结束时间","客户等级","应送赠品","折扣","代金券"};
		clientTable = new MyTable(headersClient, data.getClientPromotion());
		MyJScrollPane clientScrollPane = new MyJScrollPane(clientTable, 80, 70, 1111, 220);		
		this.add(clientScrollPane);	
		
		String[] headersClient2 = {"编号","起始时间","结束时间","总价","应送赠品","折扣","代金券"};
		clientTable2 = new MyTable(headersClient2, data.getTotalPromotion());
		MyJScrollPane clientScrollPane2 = new MyJScrollPane(clientTable2, 80, 320, 1111, 220);		
		this.add(clientScrollPane2);	
	}

	private void addButtons() {
		int gap = 150;
		int y = 570, buttonH = 20, buttonW = 120;
				
		addBargainButton = new MyButton("制定特价包", 775, y, buttonW, buttonH);
		addBargainButton.addActionListener(this);
		add(addBargainButton);
		
		addClientButton = new MyButton("制定客户促销", 775 + gap, y, buttonW, buttonH);
		addClientButton.addActionListener(this);
		add(addClientButton);
		
		addTotalButton = new MyButton("制定总价促销", 775 + 2 * gap, y, buttonW, buttonH);
		addTotalButton.addActionListener(this);
		add(addTotalButton);
		
	}

	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == addBargainButton){
			WarningFrame wf = new WarningFrame("暂时不支持此功能！");
			wf.setVisible(true);
		}
		
		if(events.getSource() == addClientButton){
			LevelFrame lf = new LevelFrame();
			lf.setVisible(true);
		}
		
		if(events.getSource() == addTotalButton){
			TotalFrame tf = new TotalFrame();
			tf.setVisible(true);
		}
		
		if(events.getSource() == refresh){
			refresh();
		}
	}
	
	private void refresh(){
		DefaultTableModel tablemodel1 = (DefaultTableModel) clientTable.getModel();
		DefaultTableModel tablemodel2 = (DefaultTableModel) clientTable2.getModel();
		int rowCount = tablemodel1.getRowCount();
		int rowCount2 = tablemodel2.getRowCount();
		
		for(int i = 0; i < rowCount; i++)
			tablemodel1.removeRow(0);
		
		for(int i = 0; i < rowCount2; i++)
			tablemodel2.removeRow(0);
		PromotionData pd = new PromotionData();
		Object[][] rowData = pd.getClientPromotion();
		Object[][] rowData2 = pd.getTotalPromotion();
		
		for(int i = 0; i < rowData.length; i++){
			Object[] obj = {rowData[i][0], rowData[i][1], rowData[i][2], rowData[i][3]
					, rowData[i][4], rowData[i][5], rowData[i][6]};
				tablemodel1.addRow(obj);
		}
		
		for(int i = 0; i < rowData2.length; i++){
			Object[] obj = {rowData2[i][0], rowData2[i][1], rowData2[i][2], rowData2[i][3]
					, rowData2[i][4], rowData2[i][5], rowData2[i][6]};
				tablemodel2.addRow(obj);
		}
	}
}
