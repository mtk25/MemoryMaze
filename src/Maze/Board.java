package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{

		private Timer timer;
		
		private Player player;		
		private Map map;
		private boolean win = false;
		private String Message = "";
		private Font font = new Font("Serif",Font.BOLD,48);
		
	  	public Board(){
	  		map = new Map();
	  		player= new Player();
	  		
	  		addKeyListener(new Moves());
	  		// fire keyboard events
	  		setFocusable(true);
	  		
	  		timer = new Timer(25,this);
	  		timer.start();
	  	}
	    public void actionPerformed(ActionEvent e){
	    	if(map.getMap(player.getTileX(),player.getTileY()).equals("f")){
	    		Message = "WIN!";
	    		win = true;
	    		
	    	}
	    	repaint();
	    	
	    }
	    
	    public void paint(Graphics g){
	    	super.paint(g);
	    	if(!win)
	    	{
		    	for(int y =0; y<14 ; y++)
		    	{
		    		for(int x = 0; x<14; x++)
		    		{
		    			if(map.getMap(x, y).equals("f")){
		    				g.drawImage(map.getFinish(),x*32,y*32,null);
		    			}
		    			if(map.getMap(x, y).equals("g")){
		    				g.drawImage(map.getGrass(),x*32,y*32,null);
		    			}
		    			if(map.getMap(x, y).equals("w")){
		    				g.drawImage(map.getWall(),x*32,y*32,null);
		    			}
		    			if(map.getMap(x, y).equals("p")){
		    				g.drawImage(map.getPath(),x*32,y*32,null);
		    			}
		    		}
	    		
	    		}
		    	g.drawImage(player.getPlayer(),player.getTileX()*32,player.getTileY()*32,null);
		    	
	    	}
	    	if(win)
	    	{
	    		g.setColor(Color.RED);
	    		g.setFont(font);	    	
	    		g.drawString(Message, 150, 200);
	    		
	    	}
	    	
	    }
	   
	   //public class moveCharacter extends Action 
	    
	   public class Moves extends KeyAdapter
	   {
	 
		   public void keyPressed(KeyEvent e){
			   int keycode = e.getKeyCode();
			   
			   //move up
			   if(keycode == KeyEvent.VK_UP){
				   //check for collisions
				   if(!map.getMap(player.getTileX(), player.getTileY()-1).equals("w")){
					    player.move(0, -1);
				   }				  
			   }
			   //move down
				if(keycode == KeyEvent.VK_DOWN){
					if(!map.getMap(player.getTileX(), player.getTileY()+1).equals("w")){
						player.move(0, 1);
					}					 
				}
				if(keycode == KeyEvent.VK_LEFT){
					if(!map.getMap(player.getTileX()-1, player.getTileY()).equals("w")){
						 player.move(-1, 0);
					}
					
				}
				if(keycode == KeyEvent.VK_RIGHT){
					if(!map.getMap(player.getTileX()+1, player.getTileY()).equals("w")){
						 player.move(1, 0);
					}				  
				}
		   }
		 
	   }
}
 
