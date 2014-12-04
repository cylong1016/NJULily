package ui.commonui.myui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import ui.commonui.exitprogram.ExitProgramFrame;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	MyButton button_exit;
	
	boolean isDraging;
	int xx, yy, X0, Y0, X, Y, openTime = 0;	 
    
	public MyFrame(){	
		
		//setWindowStyle ();
		
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
			
		this.setUndecorated(true);
		GetLocation io = new GetLocation();
		
		if(openTime++ == 0){
			this.setBounds(getLocation(scrSize.width,1280), getLocation(scrSize.height,720), 1280, 720);
			io.setX(getLocation(scrSize.width,1280));
			io.setY(getLocation(scrSize.height,720));
		}else{
			this.setBounds(io.getX() ,io.getY(), 1280, 720);
		}
		
		this.setLayout(null);	
		
		//the button for action exit
		button_exit = new MyButton(1220, 0, 50, 35);
		button_exit.setIcon(new ImageIcon("ui/image/login/exit.png"));
		button_exit.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				button_exit.setIcon(new ImageIcon("ui/image/login/exit2.png"));
			}
			public void mouseExited(MouseEvent arg0) {
				button_exit.setIcon(new ImageIcon("ui/image/login/exit.png"));
			}
			public void mouseClicked(MouseEvent arg0){	
				ExitProgramFrame epf = new ExitProgramFrame();
				epf.setVisible(true);
			}
			}); 
		this.add(button_exit);
		
		//the codes that make the frame mouse-drag-able
		this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocus();
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
            }
 
            public void mouseReleased(MouseEvent e) {
                isDraging = false;
            }
        });
		
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDraging) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    setLocation(left + e.getX() - xx, top + e.getY() - yy);
                    X = left + e.getX() - xx;
                    Y = top + e.getY() - yy;
                    GetLocation io = new GetLocation();
                    io.setX(X);
                    io.setY(Y);
                }
            }
        }); 
	}
	
	//return a location to make sure the frame initialize in the middle of users computer
	private int getLocation(int a,int b){
		return (a-b)/2;
	}
	
	public String getCurrentLocation(int X, int Y){
		return String.valueOf(X) + ";" + String.valueOf(Y);
	}
	
//	private  void setWindowStyle () {
//		try {
//			String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//			UIManager.setLookAndFeel(windows);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
