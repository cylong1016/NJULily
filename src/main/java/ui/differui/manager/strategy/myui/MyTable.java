package ui.differui.manager.strategy.myui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.commonui.myui.MyColor;

public class MyTable extends JTable{

	private static final long serialVersionUID = 1L;
	boolean flag = false;
	
	public MyTable(String[] headers, Object[][] cellData){
			
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { //这里让表不可修改
			
					return false;
				
			}
		};
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		this.setDefaultRenderer(Object.class, tcr);
		
		this.setModel(model);
		this.setTableHeader(getJTableHeader());
		this.setRowSelectionAllowed(true);	
	}
	
	public JTableHeader getJTableHeader() {
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	    return tableH;
	}
}
