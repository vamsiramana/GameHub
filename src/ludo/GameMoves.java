package ludo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GameMoves extends JPanel implements KeyListener, ActionListener,MouseListener{
    String[] pl = new String[4];
	
	private static final long serialVersionUID = 1L;
	Layout la;
	Build_Player p;
	Timer time;
	int delay=10;
	int current_player,dice;
	int flag=0,roll,kill=0;
	public GameMoves(String p1,String p2,String p3,String p4) {
        pl[0] = p1;
        pl[1] = p2;
        pl[2] = p3;
        pl[3] = p4;
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        current_player=0;
        la = new Layout(80,50,pl[0],pl[1],pl[2],pl[3]);
        p=new Build_Player(la.height,la.width);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }

    @Override
    public void paint(Graphics g) {
    	la.draw((Graphics2D)g);
    	p.draw((Graphics2D)g);
    	if(p.pl[current_player].coin==4) {
    		g.setColor(Color.WHITE);
    		g.fillRect(590, 100, 380,130);
    		if(current_player==0) {
				g.setColor(Color.RED);
			}
			else if(current_player==1) {
				g.setColor(Color.GREEN);
			}
			else if(current_player==2) {
				g.setColor(Color.YELLOW);
			}
			else if(current_player==3) {
				g.setColor(Color.BLUE);
			}
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Player "+(pl[current_player])+" wins.", 600, 150);
            g.drawString("Congratulations.", 600, 200);
            if(current_player == 0)
            update_score(pl[0],pl[1],pl[2],pl[3]);
            else if(current_player == 1)
                update_score(pl[1],pl[0],pl[2],pl[3]);
            else if(current_player == 2)
                update_score(pl[2],pl[0],pl[1],pl[3]);
            else if(current_player == 3)
                update_score(pl[3],pl[0],pl[1],pl[2]);
            
    	}
    	else if(dice!=0) {
    		g.setColor(Color.WHITE);
    		g.fillRect(590, 100, 380,130);
    		if(current_player==0) {
				g.setColor(Color.RED);
			}
			else if(current_player==1) {
				g.setColor(Color.GREEN);
			}
			else if(current_player==2) {
				g.setColor(Color.YELLOW);
			}
			else if(current_player==3) {
				g.setColor(Color.BLUE);
			}
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Player "+(current_player+1), 600, 150);
            g.drawString("Number on dice is "+dice, 600, 200);
    	}
    	if(flag==0&&dice!=0&&dice!=6&&kill==0) {
			current_player=(current_player+1)%4;
		}
    	kill=0;
    }
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) {
			roll=0;
			dice=1 + (int)(Math.random() * 6);
			repaint();
			for(int i=0;i<4;i++) {
    			if(p.pl[current_player].pa[i].current!=-1&&p.pl[current_player].pa[i].current!=56&&(p.pl[current_player].pa[i].current+dice)<=56) {
    				flag=1;
    				break;
    			}
    		}
    		if(flag==0&&dice==6) {
    			for(int i=0;i<4;i++) {
    				if(p.pl[current_player].pa[i].current==-1) {
    					flag=1;
    					break;
    				}
    			}
    		}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(flag==1) {
			int x=e.getX();
			int y=e.getY();
			x=x-80;
			y=y-50;
			x=x/30;
			y=y/30;
			int value=-1;
			//System.out.println(x+" "+y);
			if(dice==6) {
				for(int i=0;i<4;i++) {
					if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
						value=i;
						flag=0;
						break;
					}	
				}
				if(value!=-1) {
					p.pl[current_player].pa[value].current+=dice;
					if(p.pl[current_player].pa[value].current==56) {
						p.pl[current_player].coin++;
					}
					int k=0;
					int hou=p.pl[current_player].pa[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51)
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][p.pl[current_player].pa[value].current],tem2=Path.ay[current_player][p.pl[current_player].pa[value].current];
								if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
									p.pl[i].pa[j].current=-1;
									kill=1;
									k=1;
									break;
								}
							}
						}
						if(k==1)
							break;
					}
					}
				}
				else {
					for(int i=0;i<4;i++) {
						if(p.pl[current_player].pa[i].current==-1) {
							p.pl[current_player].pa[i].current=0;
							flag=0;
							break;
						}	
					}
				}
			}
			else {
				for(int i=0;i<4;i++) {
					if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
						value=i;
						flag=0;
						break;
					}	
				}
				if(value!=-1) {
					p.pl[current_player].pa[value].current+=dice;
					if(p.pl[current_player].pa[value].current==56) {
						p.pl[current_player].coin++;
					}
					int k=0;
					int hou=p.pl[current_player].pa[value].current;
					if((hou%13)!=0&&(hou%13)!=8&&hou<51)
					{
					for(int i=0;i<4;i++) {
						if(i!=current_player) {
							for(int j=0;j<4;j++) {
								int tem1=Path.ax[current_player][p.pl[current_player].pa[value].current],tem2=Path.ay[current_player][p.pl[current_player].pa[value].current];
								if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
									p.pl[i].pa[j].current=-1;
									kill=1;
									k=1;
									break;
								}
							}
						}
						if(k==1)
							break;
					}
					}
				}
			}
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
        public void update_score(String winner,String l1,String l2,String l3)
        {
            
            try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/newdatabase","root2","password");  
            Statement stmt=con.createStatement();  
            Statement s = con.createStatement();
           
            
           
                String q = "update LudoLeaderBoard set wins = wins + 1 where name  =  '"+ winner+"'";
                stmt.executeUpdate(q);
                q = "update LudoLeaderBoard set lost = lost + 1 where name  =  '"+ l1+"'";
                stmt.executeUpdate(q);
                q = "update LudoLeaderBoard set lost = lost + 1 where name  =  '"+ l2+"'";
                stmt.executeUpdate(q);
                q = "update LudoLeaderBoard set lost = lost + 1 where name  =  '"+ l3+"'";
                stmt.executeUpdate(q);
            
            
            
                //stmt.executeUpdate(q);
            
        }
            catch(Exception e){;}
        }
}
