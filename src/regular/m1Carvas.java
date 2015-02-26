package regular;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.*;

public class m1Carvas extends Canvas implements ActionListener{
	JTextField tf;
	JButton clear;
	//JScrollPane h = new JScrollPane(0,1),
		//		v = new JScrollPane(1,0);
	int r = 1;
	int numTh=0;
	int x=10, y=50;
	
	public static Vector<Integer> fibArr = new Vector<Integer>(0);
	public static Vector<Point2D> centerPoint = new Vector<Point2D>();
	Point2D p =null;
	
	public m1Carvas(JTextField tf, JButton clear){
		
		this.tf = tf;
		tf.addActionListener(this);
		this.clear= clear;
		clear.addActionListener(this);
		
		setSize(1000,500);
		setVisible(true);
		setBackground(Color.black);
		

	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		for(int i=0 ; i<numTh ; i++){
			r= fibo(i+1);
			//g.drawArc((int) cp(i+1).getX(),(int) cp(i+1).getY(), r*20, r*20, 0+(i)*90, 90);
			g.drawArc(x,y, r*20, r*20, 0+(i)*90, 90);
		}
		
		g.setColor(Color.white);
		for(int j = 0; j< numTh ; j++){
			x+=100;
			if(j%10 == 0){
				y+=20;
				x=10;
			}
			g.drawString(Integer.toString(fibo(j+1)), x, y);
		}
	}

	public int fibo(int numTh) {
		if(fibArr.size() == 0){
			fibArr.add(1);
			fibArr.add(1);
		}
		else if(numTh > fibArr.size())
			for(int i = fibArr.size() ; i < numTh; i++){
				fibArr.add(fibArr.lastElement() + fibArr.elementAt(fibArr.size()-2) );
			}
		return fibArr.elementAt(numTh-1);
	}
	
	public Point2D cp(int numTh){
		int offsetOfCP = 0;
		int offsetDirect = 4; // 0:down, 1: right, 2: up, 3:left, 
		
		if(centerPoint.size() == 0){
			p.setLocation(200.0,200.0);
			centerPoint.add(p);
			centerPoint.add(p);
		}
		else if(numTh > centerPoint.size())
			for(int k = centerPoint.size(); k < numTh; k++){
				offsetOfCP = fibo(k);
				offsetDirect = (k - 1) % 4;
				switch(offsetDirect){
				case 0:{
					p.setLocation(cp(k).getX(), cp(k).getY()+offsetOfCP);
					centerPoint.add(p);
					break;
				}
				case 1:{
					p.setLocation(cp(k).getX()+offsetOfCP, cp(k).getY());
					centerPoint.add(p);
					break;
				}
				case 2:{
					p.setLocation(cp(k).getX(), cp(k).getY()-offsetOfCP);
					centerPoint.add(p);
					break;
				}
				case 3:{
					p.setLocation(cp(k).getX()-offsetOfCP, cp(k).getY());
					centerPoint.add(p);
					break;
				}
				}
				
			}
		
		return centerPoint.elementAt(numTh-1);
	}
	
	@Override
 	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf){
			numTh = Integer.valueOf(tf.getText()) ;
			for(int i = 0 ; i< numTh;i++)
				System.out.println(cp(i));
			
		}
		else numTh =0;
		
		repaint();	
		
	}
	

}
