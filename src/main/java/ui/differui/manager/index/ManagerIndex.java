package ui.differui.manager.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.differui.manager.frame.Frame_Manager;

public class ManagerIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyBackground indexBack0, indexBack1, indexBack3, indexBack4, indexBack5, indexBack6;
	MyButton bt1, bt3, bt4, bt5, bt6;
	
	public ManagerIndex(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		initButtons();
		initBackgrounds();
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt1){
			Frame_Manager.visibleTrue(1);
			this.setVisible(false);
		}
				
		if(events.getSource() == bt3){
			Frame_Manager.visibleTrue(2);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt4){
			Frame_Manager.visibleTrue(3);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt5){
			Frame_Manager.visibleTrue(4);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt6){
			Frame_Manager.visibleTrue(5);
			this.setVisible(false);
		}
				
	}
	
	public void initButtons(){
		bt1 = new MyButton(503, 141, 680, 142);
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
			
		bt3 = new MyButton(503, 296, 224, 123);
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
		
		bt4 = new MyButton(740, 296, 224, 123);
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
		
		bt5 = new MyButton(969, 296, 224, 123);
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
		
		bt6 = new MyButton(503, 430, 680, 158);
		bt6.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack6.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack6.setVisible(false);
			}
			}); 
		bt6.addActionListener(this);
		this.add(bt6);
	}
	
	public void initBackgrounds(){
		
		indexBack6 = new MyBackground("ui/image/manager/index6.png");
		indexBack6.setVisible(false);
		this.add(indexBack6);
		
		indexBack5 = new MyBackground("ui/image/manager/index5.png");
		indexBack5.setVisible(false);
		this.add(indexBack5);
		
		indexBack4 = new MyBackground("ui/image/manager/index4.png");
		indexBack4.setVisible(false);
		this.add(indexBack4);
		
		indexBack3 = new MyBackground("ui/image/manager/index3.png");
		indexBack3.setVisible(false);
		this.add(indexBack3);

		indexBack1 = new MyBackground("ui/image/manager/index1.png");
		indexBack1.setVisible(false);
		this.add(indexBack1);
		
		indexBack0 = new MyBackground("ui/image/manager/index0.png");
		this.add(indexBack0); 
	}
}

