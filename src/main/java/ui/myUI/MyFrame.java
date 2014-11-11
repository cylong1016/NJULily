package ui.myUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	MyButton button_exit;
	
	boolean isDraging;
	int xx,yy,X0,Y0;	 
    
	public MyFrame(){	
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setUndecorated(true);
		this.setBounds(getLocation(scrSize.width,1280), getLocation(scrSize.height,720), 1280, 720);
		this.setLayout(null);	
		
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the button for action exit
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the button for action exit
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the button for action exit
=======
		//���ӹرհ�ť
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
		button_exit = new MyButton(1220, 0, 50, 35);
		button_exit.setIcon(new ImageIcon("image/login/exit.png"));
		button_exit.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				button_exit.setIcon(new ImageIcon("image/login/exit2.png"));
			}
			public void mouseExited(MouseEvent arg0) {
				button_exit.setIcon(new ImageIcon("image/login/exit.png"));
			}
			public void mouseClicked(MouseEvent arg0){
				System.exit(0);
			}
			}); 
		this.add(button_exit);
		
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the codes that make the frame mouse-drag-able
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the codes that make the frame mouse-drag-able
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
		//the codes that make the frame mouse-drag-able
=======
		//ʹ�ô����ܱ�����϶�
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
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
                }
            }
        }); 
	}
	
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
	//return a location to make sure the frame initialize in the middle of users computer
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
	//return a location to make sure the frame initialize in the middle of users computer
=======
<<<<<<< HEAD:src/main/java/ui/myUI/MyFrame.java
	//return a location to make sure the frame initialize in the middle of users computer
=======
	//����λ����꣬ʹ��Frame������Ļ������
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
>>>>>>> origin/master:src/main/java/ui/myUI/MyFrame.java
	private int getLocation(int a,int b){
		return (a-b)/2;
	}
}
