package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{

		private Timer timer;
		
		private Player p;		
		private Map m;
		private boolean win = false;
		private String Message = "";
		private Font font = new Font("Serif",Font.BOLD,48);
		
	  	public Board(){
	  		m = new Map();
	  		p= new Player();
	  		
	  		addKeyListener(new Al());
	  		// fire keyboard events
	  		setFocusable(true);
	  		
	  		timer = new Timer(25,this);
	  		timer.start();
	  	}
	    public void actionPerformed(ActionEvent e){
	    	if(m.getMap(p.getTileX(),p.getTileY()).equals("f")){
	    		Message = "Winner!";
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
		    			if(m.getMap(x, y).equals("f")){
		    				g.drawImage(m.getFinish(),x*32,y*32,null);
		    			}
		    			if(m.getMap(x, y).equals("g")){
		    				g.drawImage(m.getGrass(),x*32,y*32,null);
		    			}
		    			if(m.getMap(x, y).equals("w")){
		    				g.drawImage(m.getWall(),x*32,y*32,null);
		    			}
		    			if(m.getMap(x, y).equals("p")){
		    				g.drawImage(m.getPath(),x*32,y*32,null);
		    			}
		    		}
	    		
	    		}
		    	g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
		    	
	    	}
	    	if(win)
	    	{
	    		g.setColor(Color.RED);
	    		g.setFont(font);	    	
	    		g.drawString(Message, 150, 200);
	    		
	    	}
	    	
	    }
	   
	   //public class moveCharacter extends Action 
	    
	   public class Al extends KeyAdapter
	   {
	 
		   public void keyPressed(KeyEvent e){
			   int keycode = e.getKeyCode();
			   
			   //move up
			   if(keycode == KeyEvent.VK_W){
				   //check for collisions
				   if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("w")){
					    p.move(0, -1);
				   }				  
			   }
			   //move down
				if(keycode == KeyEvent.VK_S){
					if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("w")){
						p.move(0, 1);
					}					 
				}
				if(keycode == KeyEvent.VK_A){
					if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("w")){
						 p.move(-1, 0);
					}
					
				}
				if(keycode == KeyEvent.VK_D){
					if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("w")){
						 p.move(1, 0);
					}				  
				}
		   }
		 
	   }
}
 
