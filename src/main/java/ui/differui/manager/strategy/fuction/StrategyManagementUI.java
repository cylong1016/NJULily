package ui.differui.manager.strategy.fuction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.differui.manager.strategy.myui.AddBargainPane;
import ui.differui.manager.strategy.myui.MyButton;
import ui.differui.manager.strategy.myui.MyJScrollPane;
import ui.differui.manager.strategy.myui.MyTable;
import ui.differui.manager.strategy.myui.PromotionData;



public class StrategyManagementUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private AddBargainPane addBargainPane;
	
	private MyButton addBargainButton, addClientButton, addTotalButton;
	
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
	}
	
	private void addPromotionTable() {
		
		PromotionData data = new PromotionData();
		
		String[] headersClient = {"编号","起始时间","结束时间","客户等级","应送赠品","折扣","代金券"};
		MyTable clientTable = new MyTable(headersClient, data.getClientPromotion());
		MyJScrollPane clientScrollPane = new MyJScrollPane(clientTable, 80, 70, 1111, 220);		
		this.add(clientScrollPane);	
		
		String[] headersClient2 = {"编号","起始时间","结束时间","总价","应送赠品","折扣","代金券"};
		MyTable clientTable2 = new MyTable(headersClient2, data.getClientPromotion());
		MyJScrollPane clientScrollPane2 = new MyJScrollPane(clientTable2, 80, 320, 1111, 220);		
		this.add(clientScrollPane2);	
	}

	private void addButtons() {
		int gap = 150;
		int y = 570, buttonH = 20, buttonW = 120;
		
		addBargainPane = new AddBargainPane();
		
		addBargainButton = new MyButton("制定特价包", 775, y, buttonW, buttonH);
		addBargainButton.setPanel(this, addBargainPane);
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
		if(events.getSource() == addClientButton){
			LevelFrame lf = new LevelFrame();
			lf.setVisible(true);
		}
		
		if(events.getSource() == refresh){
			refresh();
		}
	}
	
	private void refresh(){
		
	}
}
