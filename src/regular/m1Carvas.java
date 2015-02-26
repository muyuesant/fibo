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
	
	int r = 1;
	int numTh=1;
	int x=250, y=250;
	
	public static Vector<Integer> fibArr = new Vector<Integer>(0);
	public static Vector<Point2D> oPoint = new Vector<Point2D>(0);
	Point2D p;
	
	public m1Carvas(JTextField tf, JButton clear){
		
		this.tf = tf;
		tf.addActionListener(this);
		this.clear= clear;
		clear.addActionListener(this);
		
		setSize(500,500);
		setVisible(true);
		setBackground(Color.black);

	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		for(int i=1 ; i< numTh ; i++){
			r= fibo(i);
			g.drawArc(x, y, r*20, r*20, 0+(i-1)*90, 90);
		g.setColor(Color.white);
		for(int j = 0; j< numTh ; j++)
			g.drawString(Integer.toString(fibo(j+1)), 50+j*10, 50);
			
		}	
	}

	public int fibo(int numTh) {
	    /*
		if(numTh<=2)
			return 1;
		else
			return fibo(numTh-1) + fibo(numTh-2);
//		*/
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
	
	public Point2D oP(int numTh){
		if(oPoint.size() == 0){
			p.setLocation(250,250);
		}
		else{
			if(numTh > oPoint.size()){
				oPoint.add();
			}
		}
		return null;
	}
	
	@Override
 	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf){
			numTh = Integer.valueOf(tf.getText()) ;
			
			
		}
		else numTh =0;
		
		repaint();	
		
	}
	

}
