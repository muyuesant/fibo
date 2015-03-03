package regular;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Iterator;
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
	public static Vector<Point2D> centerPoint = new Vector<Point2D>(0);
	public Point2D p =null;
	
	public static Vector<point> centerPoint2 = new Vector<point>(0);
	point p2 = new point(200,200);
	
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
			g.drawArc( cp2(i+1).getX(), cp2(i+1).getY(), r, r, 0+(i)*90, 90);
			//g.drawArc(x,y, r*20, r*20, 0+(i)*90, 90);
		}
		g.setColor(Color.green);
		int xx=0;
		//for(point i: centerPoint2){
			//g.fillOval(i.getX(), i.getY(), 5, 5);
			//g.drawString(Integer.toString(i.getX())+" "+ Integer.toString(i.getY()), 10+xx*80, 100);
			//xx++;
	//	}
		Iterator iter ;
		iter=centerPoint2.iterator();
		while(iter.hasNext()){
			
				xx++;

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

	   
	public point cp2(int numTh){
		int offsetOfCP = 0;
		int offsetDirect = 4; // 0:down, 1: right, 2: up, 3:left, 
		
		if(centerPoint2.size() == 0){
			//p.setLocation(200.0,200.0);
			centerPoint2.add(p2);
			centerPoint2.add(p2);
			p2.setLocation(0, 0);
		}
		else if(numTh > centerPoint2.size())
			for(int k = centerPoint2.size(); k <=numTh; k++){
				offsetOfCP = fibo(k-1);
				offsetDirect = (k - 1) % 4;
				switch(offsetDirect){
				case 0:{
					p2.setLocation(cp2(k).getX(), cp2(k).getY()+offsetOfCP);
					centerPoint2.add(p2);
					break;
				}
				case 1:{
					p2.setLocation(cp2(k).getX()+offsetOfCP, cp2(k).getY());
					centerPoint2.add(p2);
					break;
				}
				case 2:{
					p2.setLocation(cp2(k).getX(), cp2(k).getY()-offsetOfCP);
					centerPoint2.add(p2);
					break;
				}
				case 3:{
					p2.setLocation(cp2(k).getX()-offsetOfCP, cp2(k).getY());
					centerPoint2.add(p2);
					break;
				}
				p.setLocation(0,0);
				}	
			}	
		return centerPoint2.elementAt(numTh-1);
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
		return fibArr.elementAt(numTh-1)*20;
	}

	
	@Override
 	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf){
			numTh = Integer.valueOf(tf.getText()) ;
			
		}
		else{ 
			numTh =0;
			x=10;
			y=50;
		}
		repaint();	
		
	}
	

}
