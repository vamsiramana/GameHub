package ludo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vamsi dinavahi
 */
import java.awt.Graphics2D;

public class Player {
	int height,width,status,coin;
	Pawn[] pa=new Pawn[4];
	public Player(int height,int width) {
		status=-1;
		coin=0;
		for(int i=0;i<4;i++) {
			pa[i]=new Pawn(height,width);
		}
	}
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
	
	}
}
