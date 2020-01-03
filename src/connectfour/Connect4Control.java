package connectfour;

public class Connect4Control {
	
	public int[][] cont;
		
	private int player;
	
	private boolean win;
	
	public boolean getWin(){
		return win;
	}
	public void setWin(boolean win){
		this.win=win;
	}
	
	public int getPlayer(){
		return player;
	}
	public void setPlayer(int player){
		this.player=player;
	}
	
	public Connect4Control(){
		player = 1;
		cont= new int[7][8];//bug add extra one to row from 6 to seven as col 7 was not being accessed.
		
		for(int row=1;row<7;row++){
			for(int col=1;col<8;col++){
				cont[row][col]=0;
			}
			
		}
		
	}
	
	public void win(){
		//85 different wins
		//=========================================================================================
		if(cont[3][1]==1&&cont[4][2]==1&&cont[5][3]==1&&cont[6][4]==1||cont[3][1]==2&&cont[4][2]==2&&cont[5][3]==2&&cont[6][4]==2){
	
			win=true;
		}
		if(cont[2][1]==1&&cont[3][2]==1&&cont[4][3]==1&&cont[5][4]==1||cont[3][2]==1&&cont[4][3]==1&&cont[5][4]==1&&cont[6][5]==1
			||cont[2][1]==2&&cont[3][2]==2&&cont[4][3]==2&&cont[5][4]==2||cont[3][2]==2&&cont[4][3]==2&&cont[5][4]==2&&cont[6][5]==2){
			
			win=true;
		}  
		if(cont[1][1]==1&&cont[2][2]==1&&cont[3][3]==1&&cont[4][4]==1
			||cont[2][2]==1&&cont[3][3]==1&&cont[4][4]==1&&cont[5][5]==1
			||cont[3][3]==1&&cont[4][4]==1&&cont[5][5]==1&&cont[6][6]==1
			
				||cont[1][1]==2&&cont[2][2]==2&&cont[3][3]==2&&cont[4][4]==2
						||cont[2][2]==2&&cont[3][3]==2&&cont[4][4]==2&&cont[5][5]==2
						||cont[3][3]==2&&cont[4][4]==2&&cont[5][5]==2&&cont[6][6]==2){
		
			win=true;
		}
		if(cont[1][2]==1&&cont[2][3]==1&&cont[3][4]==1&&cont[4][5]==1
				||cont[2][3]==1&&cont[3][4]==1&&cont[4][5]==1&&cont[5][6]==1
				||cont[3][4]==1&&cont[4][5]==1&&cont[5][6]==1&&cont[6][7]==1
				
					||cont[1][2]==2&&cont[2][3]==2&&cont[3][4]==2&&cont[4][5]==2
							||cont[2][3]==2&&cont[3][4]==2&&cont[4][5]==2&&cont[5][6]==2
							||cont[3][4]==2&&cont[4][5]==2&&cont[5][6]==2&&cont[6][7]==2){
			
			win=true;
		}
		if(cont[1][3]==1&&cont[2][4]==1&&cont[3][5]==1&&cont[4][6]==1
				||cont[2][4]==1&&cont[3][5]==1&&cont[4][6]==1&&cont[5][7]==1
				
				||cont[1][3]==2&&cont[2][4]==2&&cont[3][5]==2&&cont[4][6]==2
				||cont[2][4]==2&&cont[3][5]==2&&cont[4][6]==2&&cont[5][7]==2){
			
			win=true;
		}
		if(cont[1][4]==1&&cont[2][5]==1&&cont[3][6]==1&&cont[4][7]==1||cont[1][4]==2&&cont[2][5]==2&&cont[3][6]==2&&cont[4][7]==2){
			
			win=true;
		}
		//=======================================================================================
		if(cont[4][1]==1&&cont[3][2]==1&&cont[2][3]==1&&cont[1][4]==1||cont[4][1]==2&&cont[3][2]==2&&cont[2][3]==2&&cont[1][4]==2){
			
		}
		if(cont[5][1]==1&&cont[4][2]==1&&cont[3][3]==1&&cont[2][4]==1||cont[4][2]==1&&cont[3][3]==1&&cont[2][4]==1&&cont[1][5]==1
			||cont[5][1]==2&&cont[4][2]==2&&cont[3][3]==2&&cont[2][4]==2||cont[4][2]==2&&cont[3][3]==2&&cont[2][4]==2&&cont[1][5]==2){
			
			win=true;
		}  
		if(cont[6][1]==1&&cont[5][2]==1&&cont[4][3]==1&&cont[3][4]==1
			||cont[5][2]==1&&cont[4][3]==1&&cont[3][4]==1&&cont[2][5]==1
			||cont[4][3]==1&&cont[3][4]==1&&cont[2][5]==1&&cont[1][6]==1
			
			||cont[6][1]==2&&cont[5][2]==2&&cont[4][3]==2&&cont[3][4]==2
			||cont[5][2]==2&&cont[4][3]==2&&cont[3][4]==2&&cont[2][5]==2
			||cont[4][3]==2&&cont[3][4]==2&&cont[2][5]==2&&cont[1][6]==2){
			
			win=true;
		}
		if(cont[6][2]==1&&cont[5][3]==1&&cont[4][4]==1&&cont[3][5]==1
			|| cont[5][3]==1 && cont[4][4]==1 && cont[3][5]==1 && cont[2][6]==1
			||cont[4][4]==1 && cont[3][5]==1 && cont[2][6]==1 && cont[1][7]==1
				
			||cont[6][2]==2&&cont[5][3]==2&&cont[4][4]==2&&cont[3][5]==2
			||cont[5][3]==2&&cont[4][4]==2&&cont[3][5]==2&&cont[2][6]==2
			||cont[4][4]==2&&cont[3][5]==2&&cont[2][6]==2&&cont[1][7]==2){
			
			win=true;
		}
		if(cont[6][3]==1&&cont[5][4]==1&&cont[4][5]==1&&cont[3][6]==1
				||cont[5][4]==1&&cont[4][5]==1&&cont[3][6]==1&&cont[2][7]==1
				
				||cont[6][3]==2&&cont[5][4]==2&&cont[4][5]==2&&cont[3][6]==2
				||cont[5][4]==2&&cont[4][5]==2&&cont[3][6]==2&&cont[2][7]==2){
			
		}
		if(cont[6][4]==1&&cont[5][5]==1&&cont[4][6]==1&&cont[3][7]==1||cont[6][4]==2&&cont[5][5]==2&&cont[4][6]==2&&cont[3][7]==2){
			
			win=true;
		}
		//=========================================================================================
		
		if(cont[1][1]==1&&cont[1][2]==1&&cont[1][3]==1&&cont[1][4]==1
			||cont[1][2]==1&&cont[1][3]==1&&cont[1][4]==1&&cont[1][5]==1
			||cont[1][3]==1&&cont[1][4]==1&&cont[1][5]==1&&cont[1][6]==1
			||cont[1][4]==1&&cont[1][5]==1&&cont[1][6]==1&&cont[1][7]==1
			
			||cont[1][1]==2&&cont[1][2]==2&&cont[1][3]==2&&cont[1][4]==2
			||cont[1][2]==2&&cont[1][3]==2&&cont[1][4]==2&&cont[1][5]==2
			||cont[1][3]==2&&cont[1][4]==2&&cont[1][5]==2&&cont[1][6]==2
			||cont[1][4]==2&&cont[1][5]==2&&cont[1][6]==2&&cont[1][7]==2){
			
			
			win=true;
		}
		if(cont[2][1]==1&&cont[2][2]==1&&cont[2][3]==1&&cont[2][4]==1
				||cont[2][2]==1&&cont[2][3]==1&&cont[2][4]==1&&cont[2][5]==1
				||cont[2][3]==1&&cont[2][4]==1&&cont[2][5]==1&&cont[2][6]==1
				||cont[2][4]==1&&cont[2][5]==1&&cont[2][6]==1&&cont[2][7]==1
				
				||cont[2][1]==2&&cont[2][2]==2&&cont[2][3]==2&&cont[2][4]==2
				||cont[2][2]==2&&cont[2][3]==2&&cont[2][4]==2&&cont[2][5]==2
				||cont[2][3]==2&&cont[2][4]==2&&cont[2][5]==2&&cont[2][6]==2
				||cont[2][4]==2&&cont[2][5]==2&&cont[2][6]==2&&cont[2][7]==2){
			
			
			win=true;
			
		}
		if(cont[3][1]==1&&cont[3][2]==1&&cont[3][3]==1&&cont[3][4]==1
				||cont[3][2]==1&&cont[3][3]==1&&cont[3][4]==1&&cont[3][5]==1
				||cont[3][3]==1&&cont[3][4]==1&&cont[3][5]==1&&cont[3][6]==1
				||cont[3][4]==1&&cont[3][5]==1&&cont[3][6]==1&&cont[3][7]==1
				
				||cont[3][1]==2&&cont[3][2]==2&&cont[3][3]==2&&cont[3][4]==2
				||cont[3][2]==2&&cont[3][3]==2&&cont[3][4]==2&&cont[3][5]==2
				||cont[3][3]==2&&cont[3][4]==2&&cont[3][5]==2&&cont[3][6]==2
				||cont[3][4]==2&&cont[3][5]==2&&cont[3][6]==2&&cont[3][7]==2){
			
			
			win=true;
		}
		if(cont[4][1]==1&&cont[4][2]==1&&cont[4][3]==1&&cont[4][4]==1
				||cont[4][2]==1&&cont[4][3]==1&&cont[4][4]==1&&cont[4][5]==1
				||cont[4][3]==1&&cont[4][4]==1&&cont[4][5]==1&&cont[4][6]==1
				||cont[4][4]==1&&cont[4][5]==1&&cont[4][6]==1&&cont[4][7]==1
				
				||cont[4][1]==2&&cont[4][2]==2&&cont[4][3]==2&&cont[4][4]==2
				||cont[4][2]==2&&cont[4][3]==2&&cont[4][4]==2&&cont[4][5]==2
				||cont[4][3]==2&&cont[4][4]==2&&cont[4][5]==2&&cont[4][6]==2
				||cont[3][4]==2&&cont[4][5]==2&&cont[4][6]==2&&cont[4][7]==2){
			
			
			win=true;
		}
		if(cont[5][1]==1&&cont[5][2]==1&&cont[5][3]==1&&cont[5][4]==1
				||cont[5][2]==1&&cont[5][3]==1&&cont[5][4]==1&&cont[5][5]==1
				||cont[5][3]==1&&cont[5][4]==1&&cont[5][5]==1&&cont[5][6]==1
				||cont[5][4]==1&&cont[5][5]==1&&cont[5][6]==1&&cont[5][7]==1
				
				||cont[5][1]==2&&cont[5][2]==2&&cont[5][3]==2&&cont[5][4]==2
				||cont[5][2]==2&&cont[5][3]==2&&cont[5][4]==2&&cont[5][5]==2
				||cont[5][3]==2&&cont[5][4]==2&&cont[5][5]==2&&cont[5][6]==2
				||cont[5][4]==2&&cont[5][5]==2&&cont[5][6]==2&&cont[5][7]==2){
			
			
			win=true;
		}
		if(cont[6][1]==1&&cont[6][2]==1&&cont[6][3]==1&&cont[6][4]==1
				||cont[6][2]==1&&cont[6][3]==1&&cont[6][4]==1&&cont[6][5]==1
				||cont[6][3]==1&&cont[6][4]==1&&cont[6][5]==1&&cont[6][6]==1
				||cont[6][4]==1&&cont[6][5]==1&&cont[6][6]==1&&cont[6][7]==1
				
				||cont[6][1]==2&&cont[6][2]==2&&cont[6][3]==2&&cont[6][4]==2
				||cont[6][2]==2&&cont[6][3]==2&&cont[6][4]==2&&cont[6][5]==2
				||cont[6][3]==2&&cont[6][4]==2&&cont[6][5]==2&&cont[6][6]==2
				||cont[6][4]==2&&cont[6][5]==2&&cont[6][6]==2&&cont[6][7]==2){
			
			
			win=true;
		}
		
		//===================================================================================================
		if(cont[1][1]==1&&cont[2][1]==1&&cont[3][1]==1&&cont[4][1]==1
				||cont[2][1]==1&&cont[3][1]==1&&cont[4][1]==1&&cont[5][1]==1
				||cont[3][1]==1&&cont[4][1]==1&&cont[5][1]==1&&cont[6][1]==1
				
				||cont[1][1]==2&&cont[2][1]==2&&cont[3][1]==2&&cont[4][1]==2
				||cont[2][1]==2&&cont[3][1]==2&&cont[4][1]==2&&cont[5][1]==2
				||cont[3][1]==2&&cont[4][1]==2&&cont[5][1]==2&&cont[6][1]==2){
			
			
			win=true;
			
		}
		if(cont[1][2]==1&&cont[2][2]==1&&cont[3][2]==1&&cont[4][2]==1
				||cont[2][2]==1&&cont[3][2]==1&&cont[4][2]==1&&cont[5][2]==1
				||cont[3][2]==1&&cont[4][2]==1&&cont[5][2]==1&&cont[6][2]==1
				
				||cont[1][2]==2&&cont[2][2]==2&&cont[3][2]==2&&cont[4][2]==2
				||cont[2][2]==2&&cont[3][2]==2&&cont[4][2]==2&&cont[5][2]==2
				||cont[3][2]==2&&cont[4][2]==2&&cont[5][2]==2&&cont[6][2]==2){
			
			win=true;
		}
		if(cont[1][3]==1&&cont[2][3]==1&&cont[3][3]==1&&cont[4][3]==1
				||cont[2][3]==1&&cont[3][3]==1&&cont[4][3]==1&&cont[5][3]==1
				||cont[3][3]==1&&cont[4][3]==1&&cont[5][3]==1&&cont[6][3]==1
				
				||cont[1][3]==2&&cont[2][3]==2&&cont[3][3]==2&&cont[4][3]==2
				||cont[2][3]==2&&cont[3][3]==2&&cont[4][3]==2&&cont[5][3]==2
				||cont[3][3]==2&&cont[4][3]==2&&cont[5][3]==2&&cont[6][3]==2){
			
			win=true;
		}
		if(cont[1][4]==1&&cont[2][4]==1&&cont[3][4]==1&&cont[4][4]==1
				||cont[2][4]==1&&cont[3][4]==1&&cont[4][4]==1&&cont[5][4]==1
				||cont[3][4]==1&&cont[4][4]==1&&cont[5][4]==1&&cont[6][4]==1
				
				||cont[1][4]==2&&cont[2][4]==2&&cont[3][4]==2&&cont[4][4]==2
				||cont[2][4]==2&&cont[3][4]==2&&cont[4][4]==2&&cont[5][4]==2
				||cont[3][4]==2&&cont[4][4]==2&&cont[5][4]==2&&cont[6][4]==2){
			
			win=true;
		}
		if(cont[1][5]==1&&cont[2][5]==1&&cont[3][5]==1&&cont[4][5]==1
				||cont[2][5]==1&&cont[3][5]==1&&cont[4][5]==1&&cont[5][5]==1
				||cont[3][5]==1&&cont[4][5]==1&&cont[5][5]==1&&cont[6][5]==1
				
				||cont[1][5]==2&&cont[2][5]==2&&cont[3][5]==2&&cont[4][5]==2
				||cont[2][5]==2&&cont[3][5]==2&&cont[4][5]==2&&cont[5][5]==2
				||cont[3][5]==2&&cont[4][5]==2&&cont[5][5]==2&&cont[6][5]==2){
			
			win=true;
		}
		if(cont[1][6]==1&&cont[2][6]==1&&cont[3][6]==1&&cont[4][6]==1
				||cont[2][6]==1&&cont[3][6]==1&&cont[4][6]==1&&cont[5][6]==1
				||cont[3][6]==1&&cont[4][6]==1&&cont[5][6]==1&&cont[6][6]==1
				
				||cont[1][6]==2&&cont[2][6]==2&&cont[3][6]==2&&cont[4][6]==2
				||cont[2][6]==2&&cont[3][6]==2&&cont[4][6]==2&&cont[5][6]==2
				||cont[3][6]==2&&cont[4][6]==2&&cont[5][6]==2&&cont[6][6]==2){
			
			win=true;
		}
		if(cont[1][7]==1&&cont[2][7]==1&&cont[3][7]==1&&cont[4][7]==1
				||cont[2][7]==1&&cont[3][7]==1&&cont[4][7]==1&&cont[5][7]==1
				||cont[3][7]==1&&cont[4][7]==1&&cont[5][7]==1&&cont[6][7]==1
				
				||cont[1][7]==2&&cont[2][7]==2&&cont[3][7]==2&&cont[4][7]==2
				||cont[2][7]==2&&cont[3][7]==2&&cont[4][7]==2&&cont[5][7]==2
				||cont[3][7]==2&&cont[4][7]==2&&cont[5][7]==2&&cont[6][7]==2){
			
			win=true;
		}
		//=======================================================================================================
		
		
	}
	
	//check columns for spaces an to change the color of the player.
	
	public void checkCol1(){
	
		
												//need to check this out as the columns are meant to count 6 squares not 7.
		/*if(cont[1][1]!=0){
				System.out.println(" full up col 1 -----------------------------");
				if(player == 2){player=player-1;
			}
			else{player=player+1;
		}
	}*/
		
			if(cont[6][1]==0){
				cont[6][1]=player;
			}else if(cont[5][1]==0){
				cont[5][1]=player;
			}else if(cont[4][1]==0){
				cont[4][1]=player;
			}else if(cont[3][1]==0){
				cont[3][1]=player;
			}else if(cont[2][1]==0){
				cont[2][1]=player;
			}else if(cont[1][1]==0){
				cont[1][1]=player;
			}
	}
	public void checkCol2(){
		
		
		if(cont[1][2]!=0){
				System.out.println(" full up col 2 -----------------------------");
				if(player == 2){
						player=player-1;
					}
				else{
					player=player+1;
				}
	}
		
		if(cont[6][2]==0){
			cont[6][2]=player;
		}else if(cont[5][2]==0){
			cont[5][2]=player;
		}else if(cont[4][2]==0){
			cont[4][2]=player;
		}else if(cont[3][2]==0){
			cont[3][2]=player;
		}else if(cont[2][2]==0){
			cont[2][2]=player;
		}else if(cont[1][2]==0){
			cont[1][2]=player;
		}
		
	}
	public void checkCol3(){
		
		if(cont[1][3]!=0){System.out.println(" full up col 3 -----------------------------");
		if(player == 2){
				player=player-1;
			}
			else{
				player=player+1;
			}
	}
		
		if(cont[6][3]==0){
			cont[6][3]=player;
		}else if(cont[5][3]==0){
			cont[5][3]=player;
		}else if(cont[4][3]==0){
			cont[4][3]=player;
		}else if(cont[3][3]==0){
			cont[3][3]=player;
		}else if(cont[2][3]==0){
			cont[2][3]=player;
		}else if(cont[1][3]==0){
			cont[1][3]=player;
		}
		
	}
	public void checkCol4(){
		
		
		if(cont[1][4]!=0){System.out.println(" full up col 4 -----------------------------");
		if(player == 2){
				player=player-1;
			}
			else{player=player+1;
			}
		}
		
		if(cont[6][4]==0){
			cont[6][4]=player;
		}else if(cont[5][4]==0){
			cont[5][4]=player;
		}else if(cont[4][4]==0){
			cont[4][4]=player;
		}else if(cont[3][4]==0){
			cont[3][4]=player;
		}else if(cont[2][4]==0){
			cont[2][4]=player;
		}else if(cont[1][4]==0){
			cont[1][4]=player;
		}
		
	}
	public void checkCol5(){
		
		if(cont[1][5]!=0){System.out.println(" full up col 5 -----------------------------");
		if(player == 2){
				player=player-1;
				}
				else{
					player=player+1;
				}
		}
		
		if(cont[6][5]==0){
			cont[6][5]=player;
		}else if(cont[5][5]==0){
			cont[5][5]=player;
		}else if(cont[4][5]==0){
			cont[4][5]=player;
		}else if(cont[3][5]==0){
			cont[3][5]=player;
		}else if(cont[2][5]==0){
			cont[2][5]=player;
		}else if(cont[1][5]==0){
			cont[1][5]=player;
		}
		
	}
	public void checkCol6(){
		
		if(cont[1][6]!=0){System.out.println(" full up col 6 -----------------------------");
		
			if(player == 2){
					player=player-1;
				}
				else{
					player=player+1;
				}
		}
		if(cont[6][6]==0){
			cont[6][6]=player;
		}else if(cont[5][6]==0){
			cont[5][6]=player;
		}else if(cont[4][6]==0){
			cont[4][6]=player;
		}else if(cont[3][6]==0){
			cont[3][6]=player;
		}else if(cont[2][6]==0){
			cont[2][6]=player;
		}else if(cont[1][6]==0){
			cont[1][6]=player;
		}
		
	}
	public void checkCol7(){
		
		if(cont[1][7]!=0){System.out.println(" full up col 7 -----------------------------");
		if(player == 2){
				player=player-1;
			}
			else{
				player=player+1;
			}
		}
		if(cont[6][7]==0){
			cont[6][7]=player;
		}else if(cont[5][7]==0){
			cont[5][7]=player;
		}else if(cont[4][7]==0){
			cont[4][7]=player;
		}else if(cont[3][7]==0){
			cont[3][7]=player;
		}else if(cont[2][7]==0){
			cont[2][7]=player;
		}else if(cont[1][7]==0){
			cont[1][7]=player;
		}
		
	}/*
	public void checkRow1(){
		//blueCount = 0;
		//redCount = 0;
		
		for(int row = 0; row <7;row++){
			if(cont[row][0]== 1){
				System.out.println("Row 1 true and" +(row+1));
				//blueCount++;
			}
			if(cont[row][0]== 2){
				//redCount++;
			}
		}
	}
	public void checkRow2(){
		//blueCount = 0;
		//redCount = 0;
		for(int row = 0; row <7;row++){
			if(cont[row][1]== 1){
				//blueCount++;
			}
			if(cont[row][1]== 2){
				//redCount++;
			}
		}
	}
	public void checkRow3(){
		//blueCount = 0;
		//redCount = 0;
		for(int row = 0; row <7;row++){
			if(cont[row][2]== 1){
				//blueCount++;
			}
			if(cont[row][2]== 2){
				//redCount++;
			}
		}
	}
	public void checkRow4(){
		for(int row = 0; row <7;row++){
			//blueCount = 0;
			//redCount = 0;
			if(cont[row][3]== 1){
			//	blueCount++;
			}
			if(cont[row][3]== 2){
				//redCount++;
			}
		}
	}
	public void checkRow5(){
		//blueCount = 0;
		//redCount = 0;
		for(int row = 0; row <7;row++){
			if(cont[row][4]== 1){
			//	blueCount++;
			}
			if(cont[row][4]== 2){
			//	redCount++;
			}
		}
	}
	public void checkRow6(){
		blueCount = 0;
		redCount = 0;
		for(int row = 0; row <7;row++){
			if(cont[row][5]== 1){
				blueCount++;
			}
			if(cont[row][5]== 2){
				redCount++;
			}
		}
	}*/
	
}


