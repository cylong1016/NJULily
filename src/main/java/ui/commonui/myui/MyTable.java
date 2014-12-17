package ui.commonui.myui;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable{

	private static final long serialVersionUID = 1L;
	
	Boolean flag = false;
	
	public MyTable(String[] headers){
			
		Object[][] cellData = null;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { //这里让表不可修改
			
					return false;
				
			}
		};
		
		this.setModel(model);
		this.setRowSelectionAllowed(true);	
	    JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	}
	
	public MyTable(String[] headers, Boolean _flag){
		
	Object[][] cellData = null;
	
	flag = _flag;
	
	Color foreColor = new Color(158, 213, 220);
	Color backColor = new Color(46, 52, 101);
	
	
	DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) { //这里让表不可修改
			if(flag == false){
				return false;
			}else if(flag == true && column >= 3){
				return true;
			}else{
				return false;
			}
		}
	};
	
	this.setModel(model);
	this.setRowSelectionAllowed(true);	
    JTableHeader tableH = this.getTableHeader();	 
    tableH.setBackground(backColor);  
    tableH.setForeground(foreColor);
    tableH.setReorderingAllowed(false); 
}
	
	public MyTable(String[] headers, int _flag){
		
		Object[][] cellData = null;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		
		
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { //这里让表不可修改
				return true;
			}
		};
		
		this.setModel(model);
		this.setRowSelectionAllowed(true);	
	    JTableHeader tableH = this.getTableHeader();	 
	    tableH.setBackground(backColor);  
	    tableH.setForeground(foreColor);
	    tableH.setReorderingAllowed(false); 
	}
}
