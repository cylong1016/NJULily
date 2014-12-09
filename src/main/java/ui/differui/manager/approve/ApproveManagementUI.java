package ui.differui.manager.approve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import vo.ApprovalVO;
import businesslogic.approvalbl.Approval;

public class ApproveManagementUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public ApproveManagementUI(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("审批单据");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
			
		show();
	}
	
	public void show(){
		Approval approval = new Approval();
		ApprovalVO vo = approval.show();
		System.out.println(vo.purchaseVOs.size());
	} 
	
	public void actionPerformed(ActionEvent events) {
		
	}
}