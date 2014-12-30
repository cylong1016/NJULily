package ui.differui.manager.strategy.myui;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
		
		this.setModel(model);
		this.setTableHeader(getJTableHeader());
		this.setRowSelectionAllowed(true);	
	}
	
	public JTableHeader getJTableHeader() {
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	    return tableH;
	}
}
