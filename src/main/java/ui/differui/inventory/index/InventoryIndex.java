package ui.differui.inventory.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.differui.inventory.frame.Frame_Inventory;

public class InventoryIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyBackground indexBack0, indexBack1, indexBack2, indexBack3, indexBack4, indexBack5;
	MyButton bt1, bt2, bt3, bt4, bt5;
	
	public InventoryIndex(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		initButtons();
		initBackgrounds();
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt1){
			Frame_Inventory.visibleTrue(1);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt2){
			Frame_Inventory.visibleTrue(2);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt3){
			Frame_Inventory.visibleTrue(3);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt4){
			Frame_Inventory.visibleTrue(4);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt5){
			Frame_Inventory.visibleTrue(5);
			this.setVisible(false);
		}
		
	}
	
	public void initButtons(){
		bt1 = new MyButton(503, 145, 416, 288);
		bt1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack1.setVisible(false);
			}
			}); 
		bt1.addActionListener(this);
		this.add(bt1);
		
		bt2 = new MyButton(940, 145, 244, 138);
		bt2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack2.setVisible(false);
			}
			}); 
		bt2.addActionListener(this);
		this.add(bt2);
		
		bt3 = new MyButton(940, 293, 244, 138);
		bt3.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack3.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack3.setVisible(false);
			}
			}); 
		bt3.addActionListener(this);
		this.add(bt3);
		
		bt4 = new MyButton(503, 448, 333, 145);
		bt4.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack4.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack4.setVisible(false);
			}
			}); 
		bt4.addActionListener(this);
		this.add(bt4);
		
		bt5 = new MyButton(852, 448, 333, 145);
		bt5.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack5.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack5.setVisible(false);
			}
			}); 
		bt5.addActionListener(this);
		this.add(bt5);
	}
	
	public void initBackgrounds(){
		indexBack5 = new MyBackground("ui/image/inventory/index5.png");
		indexBack5.setVisible(false);
		this.add(indexBack5);
		
		indexBack4 = new MyBackground("ui/image/inventory/index4.png");
		indexBack4.setVisible(false);
		this.add(indexBack4);
		
		indexBack3 = new MyBackground("ui/image/inventory/index3.png");
		indexBack3.setVisible(false);
		this.add(indexBack3);
		
		indexBack2 = new MyBackground("ui/image/inventory/index2.png");
		indexBack2.setVisible(false);
		this.add(indexBack2);
		
		indexBack1 = new MyBackground("ui/image/inventory/index1.png");
		indexBack1.setVisible(false);
		this.add(indexBack1);
		
		indexBack0 = new MyBackground("ui/image/inventory/index.png");
		this.add(indexBack0); 
	}
}
