package ui.differui.finace.index;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.differui.finace.frame.Frame_Finace;

public class FinaceIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyBackground indexBack0, indexBack1, indexBack2, indexBack3, indexBack4, indexBack5, indexBack6, indexBack7;
	MyButton bt1, bt2, bt3, bt4, bt5, bt6, bt7;
	
	public FinaceIndex(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		initButtons();
		initBackgrounds();
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt1){
			Frame_Finace.visibleTrue(1);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt2){
			Frame_Finace.visibleTrue(11);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt3){
			Frame_Finace.visibleTrue(3);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt4){
			Frame_Finace.visibleTrue(4);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt5){
			Frame_Finace.visibleTrue(5);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt6){
			Frame_Finace.visibleTrue(6);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt7){
			Frame_Finace.visibleTrue(7);
			this.setVisible(false);
		}
		
	}
	
	public void initButtons(){
		bt1 = new MyButton(503, 141, 403, 142);
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
		
		bt2 = new MyButton(920, 141, 262, 142);
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
		
		bt6 = new MyButton(503, 430, 330, 158);
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
		
		bt7 = new MyButton(847, 430, 330, 158);
		bt7.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack7.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack7.setVisible(false);
			}
			}); 
		bt7.addActionListener(this);
		this.add(bt7);
	}
	
	public void initBackgrounds(){
		indexBack7 = new MyBackground("ui/image/finace/index7.png");
		indexBack7.setVisible(false);
		this.add(indexBack7);
		
		indexBack6 = new MyBackground("ui/image/finace/index6.png");
		indexBack6.setVisible(false);
		this.add(indexBack6);
		
		indexBack5 = new MyBackground("ui/image/finace/index5.png");
		indexBack5.setVisible(false);
		this.add(indexBack5);
		
		indexBack4 = new MyBackground("ui/image/finace/index4.png");
		indexBack4.setVisible(false);
		this.add(indexBack4);
		
		indexBack3 = new MyBackground("ui/image/finace/index3.png");
		indexBack3.setVisible(false);
		this.add(indexBack3);
		
		indexBack2 = new MyBackground("ui/image/finace/index2.png");
		indexBack2.setVisible(false);
		this.add(indexBack2);
		
		indexBack1 = new MyBackground("ui/image/finace/index1.png");
		indexBack1.setVisible(false);
		this.add(indexBack1);
		
		indexBack0 = new MyBackground("ui/image/finace/index0.png");
		this.add(indexBack0); 
	}
}

