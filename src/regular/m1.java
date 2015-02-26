package regular;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class m1 extends JApplet {
 public void init(){
	 this.setLayout(new FlowLayout());
	 
	 JTextField tf = new JTextField(10);
	// add(tf,BorderLayout.NORTH);
	 add(tf);
	 
	 JButton jb = new JButton("Clear");
	// add(jb,BorderLayout.EAST);
	 add(jb);
	 
	 //JScrollPane h = new JScrollPane(0,1),
		//	 v = new JScrollPane(1,0);
	
	 //add((new m1Carvas(tf,jb)), BorderLayout.SOUTH);
	 add((new m1Carvas(tf,jb)));
	 
	 setSize(1000,600);
 }
}
