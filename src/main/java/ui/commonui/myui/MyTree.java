package ui.commonui.myui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import vo.CommoditySortVO;
import businesslogic.commoditysortbl.CommoditySortController;

public class MyTree extends JTree{

	private static final long serialVersionUID = 1L;
	private boolean expandsSelectedPaths;
	
	public MyTree(TreeNode root){
				
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
        expandsSelectedPaths = true;
        updateUI();
        setModel(new DefaultTreeModel(root, true));
	}
	
	public void buildTheTree(DefaultMutableTreeNode root){
		
		CommoditySortController controller = new CommoditySortController();	
		ArrayList<CommoditySortVO> csvo = controller.show();
		int addCount = 0;
		
		for(int i = 0; i < csvo.size(); i++){
			if(csvo.get(i).fatherID.equals("father")){
				root.add(new DefaultMutableTreeNode(csvo.get(i).name));
				addCount++;
			}
		}
		
	}
}
