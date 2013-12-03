package Maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


import javax.swing.*;
import javax.swing.Timer;


public class Map{

	 
	private Scanner m; 
	private Scanner m1;
	private String Map[] = new String[14];
	private Timer timer;
	private boolean play =false;
	
	private Image grass,
					finish,
					path,
					wall;
	
	public Map(){
		ImageIcon img = new ImageIcon("C:\\Users\\Maria\\game\\grass.png");
		grass = img.getImage();
		img = new ImageIcon("C:\\Users\\Maria\\game\\tile.png");
		wall = img.getImage();
		img = new ImageIcon("C:\\Users\\Maria\\game\\path.png");
		path = img.getImage();
		img = new ImageIcon("C:\\Users\\Maria\\game\\finish.png");
		finish = img.getImage();
		
		openFile();
		readFile();
		closeFile();
		
		
	}
	
	public Image getGrass(){
		return grass;
	}
	public Image getWall(){
		return wall;
	}
	public Image getFinish(){
		return finish;
	}
	public Image getPath(){
		return path;
	}
	public String getMap(int x, int y){
		String index = Map[y].substring(x,x+1);
		return index;
	}
	
	
			//Thread.sleep(1000;)
			
	// load and draw map - one method 
		
		
	
	
	
	public void openFile()
	{				
			try{
					m = new Scanner(new File("C:\\Users\\Maria\\game\\Map1.txt"));
						Thread.sleep(100);					 
				}catch(Exception ex){
						System.out.println("Error");
					}
			try {
				m = new Scanner(new File("C:\\Users\\Maria\\game\\Map.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void readFile(){
		while(m.hasNext()){
			for(int i=0; i<14; i++){
				Map[i] = m.next();
			}
		}
	}
	public void closeFile(){
	 m.close();	
	}

	

	
}
