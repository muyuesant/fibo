package regular;

import java.awt.BorderLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class m1 extends JApplet {
 public void init(){
	 this.setLayout(new BorderLayout());
	 JTextField tf = new JTextField(10);
	 add(tf,BorderLayout.NORTH);
	 
	 JButton jb = new JButton("Clear");
	 add(jb,BorderLayout.EAST);
	 
	 
	 add((new m1Carvas(tf,jb)), BorderLayout.SOUTH);
	 
	 setSize(600,600);
 }
}
