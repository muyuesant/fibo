package mcv;

import java.util.Observable;

public class model extends Observable{
	private int r = 1;
	private int numTh = 0;
	
	public int getR(){
		for(int i=1 ;i< numTh; i++)
			r+=r;
		return r;
	}
    public void setNumTh(int numTh){
    	this.numTh = numTh;
    	setChanged();
    	notifyObservers();
    }
}
