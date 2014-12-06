package ui.commonui.myui;

import java.awt.Color;



import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import vo.CommoditySortVO;
import businesslogic.commoditysortbl.CommoditySortController;




public class MyTree extends JTree{

	private static final long serialVersionUID = 1L;
	
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode fatherNode;
	
	public MyTree(DefaultMutableTreeNode _root){
		
		root = _root;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setForeground(foreColor);
		this.setBackground(backColor);
		
		DefaultTreeCellRenderer cellRender = new DefaultTreeCellRenderer();
		cellRender.setBackgroundNonSelectionColor(foreColor);
		cellRender.setBackgroundSelectionColor(Color.BLACK);
		cellRender.setBorderSelectionColor(backColor);
		cellRender.setTextSelectionColor(Color.WHITE);
				
		this.setCellRenderer(cellRender);
		
		toggleClickCount = 2;     
        setLayout(null);
        rowHeight = 16;
        visibleRowCount = 20;
        rootVisible = true;
        selectionModel = new DefaultTreeSelectionModel();
        cellRenderer = null;
        scrollsOnExpand = true;
        setOpaque(true);
        //  expandsSelectedPaths = true;
        updateUI();
              
        buildTheTree();
        
        setModel(new DefaultTreeModel(root, true));
	}
	
	CommoditySortController controller;
	
	public String getName(String ID){
		if(ID.equals("00")){
			return "所有商品分类";
		}else{
			controller = new CommoditySortController();
			ArrayList<CommoditySortVO> list = controller.show();
			for(int j = 1; j < list.size(); j++){
				if(list.get(j).ID.equals(ID)){
					return list.get(j).name;
				}
			}
			return null;
		}
	}
	
	public void buildTheTree(){
		controller = new CommoditySortController();
		ArrayList<CommoditySortVO> list = controller.show();
		String addingPool = "00";
		String[] _fatherID;
		int addedNum = 1;
		
		while(addedNum < list.size()){
					
			_fatherID = addingPool.split(";");
			addingPool = "";
			
			for(int i = 0; i < _fatherID.length; i++){
				
				fatherNode = new DefaultMutableTreeNode(getName(_fatherID[i])); 
				DefaultMutableTreeNode childNode;
				
				for(int j = 1; j < list.size(); j++){
					
					if(list.get(j).fatherID.equals(_fatherID[i])){
						
						childNode = new DefaultMutableTreeNode(list.get(j).name); 
						
						if(_fatherID[i].equals("00")){
							root.add(childNode);
						}else{
							fatherNode.add(childNode);	
						}						
						addingPool = addingPool + list.get(j).ID + ";";
						addedNum++;
					}
					
				}
			}
		}
	}
}
	

