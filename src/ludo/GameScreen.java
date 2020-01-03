package ludo;

import javax.swing.JFrame;

public class GameScreen {
   String p1,p2,p3,p4;
	   /*public static void main(String[] args) {
	        JFrame jframe = new JFrame();
	        jframe.setBounds(10,10,1000,600);
	        jframe.setTitle("LUDO");
	        jframe.setResizable(false);
	        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        GameMoves gm = new GameMoves(p1,p2,p3,p4);
	        gm.setFocusable(true);
	        gm.addKeyListener(gm);
	        gm.addMouseListener(gm);
	        jframe.add(gm);
	        jframe.setVisible(true);
	   }*/
           public  GameScreen(String p1,String p2,String p3,String p4)
           {
               this.p1 = p1;
               this.p2 = p2;
               this.p3 = p3;
               this.p4 = p4;
                JFrame jframe = new JFrame();
	        jframe.setBounds(10,10,1000,600);
	        jframe.setTitle("LUDO");
	        jframe.setResizable(false);
	        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        GameMoves gm = new GameMoves(p1,p2,p3,p4);
	        gm.setFocusable(true);
	        gm.addKeyListener(gm);
	        gm.addMouseListener(gm);
	        jframe.add(gm);
	        jframe.setVisible(true);
           }
          
}
