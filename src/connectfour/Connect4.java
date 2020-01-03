package connectfour;
import java.awt.Color;
import java.awt.Dimension;


import java.awt.Toolkit;


import javax.swing.JFrame;



public class Connect4 extends JFrame {
	static String p1,p2;
	private static final long serialVersionUID = 1L;
	public Connect4Panel pan;
	public Dimension dim;
	int locX;
	int locY;
	public Connect4(String p1,String p2) throws InterruptedException{
		
                this.p1 = p1;
                this.p2 = p2;
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		locX=(int) dim.getWidth()*4/12;//this is to set the game into the center of the screen
		locY=(int) dim.getHeight()*2/12;
		pan = new Connect4Panel(p1,p2);
		this.setTitle("Connect4");
		this.setSize(350,520);
		this.setLocation(locX, locY);
		this.add(pan);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);
                this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException{
		new Connect4(p1,p2);
	}


}
