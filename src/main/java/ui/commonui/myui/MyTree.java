package ui.commonui.myui;

import java.awt.Color;



import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import vo.commodity.CommoditySortVO;
import blservice.commoditysortblservice.CommoditySortBLService;
import businesslogic.commoditybl.CommodityController;
import businesslogic.commoditysortbl.CommoditySortController;


public class MyTree extends JTree{

	private static final long serialVersionUID = 1L;
	
	DefaultMutableTreeNode root;
	
	CommoditySortBLService controller;
	
	public MyTree(DefaultMutableTreeNode _root){
		
		root = _root;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
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
        
        controller = new CommoditySortController();

        initTree(root, controller.show().get(0).ID);
        
        DefaultTreeModel model = new DefaultTreeModel(root, true);
        model.reload();
        setModel(model);
           
        this.setForeground(foreColor);
		this.setBackground(backColor);
		
		DefaultTreeCellRenderer cellRender = new DefaultTreeCellRenderer();
		cellRender.setBackgroundNonSelectionColor(backColor);
		cellRender.setBackgroundSelectionColor(Color.BLACK);
		cellRender.setBorderSelectionColor(Color.WHITE);
		cellRender.setTextSelectionColor(Color.WHITE);
		cellRender.setTextNonSelectionColor(Color.WHITE);
				
		this.setCellRenderer(cellRender);
	}
	
	public String getName(String ID){
		
		controller = new CommoditySortController();
		
		if(ID.equals(controller.show().get(0).ID)){
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
	
	public void initTree(DefaultMutableTreeNode fatherNode, String parentID){
		controller = new CommoditySortController();
		ArrayList<CommoditySortVO> list = controller.show();
		
		for(int j = 1; j < list.size(); j++){
			if(list.get(j).fatherID.equals(parentID)){
				DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(list.get(j).name); 
				fatherNode.add(childNode);
				initTree(childNode, list.get(j).ID);
			}
		}		
	}

//	public void buildTheTree(){
//		controller = new CommoditySortController();
//		ArrayList<CommoditySortVO> list = controller.show();
//		String addingPool = "00";
//		String[] _fatherID;
//		int addedNum = 1;
//		
//		while(addedNum < list.size()){
//					
//			_fatherID = addingPool.split(";");
//			addingPool = "";
//			
//			for(int i = 0; i < _fatherID.length; i++){
//				
//				if(_fatherID[i].equals("00")){
//					fatherNode = root;
//				}else{
//					fatherNode = new DefaultMutableTreeNode(getName(_fatherID[i])); 
//					fatherNode.setParent(root);
//				}
//				
//				for(int j = 1; j < list.size(); j++){
//					
//					if(list.get(j).fatherID.equals(_fatherID[i])){
//						
//						childNode = new DefaultMutableTreeNode(list.get(j).name); 
//						
//						fatherNode.add(childNode);	
//						
//						addingPool = addingPool + list.get(j).ID + ";";
//						addedNum++;
//					}
//					
//				}
//			}
//		}
//	}
}
	

