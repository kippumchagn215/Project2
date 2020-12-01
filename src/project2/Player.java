//kjc190001 kippumchang
package project2;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Player {
	String name;
	float atbat; 
	float hits;
	float walks;
	float so;
	float hbp;
	float sacrifice;
	float plateappearance;
	float [] hitarray = new float[30];
	public String toString()
	{   //printing out the stat of each player
    	DecimalFormat df = new DecimalFormat();
    	df.setMinimumFractionDigits(3); // forcing to printout 3 decimal points// below return string that includes all the data for the player
    	return name+"\t"+Math.round(atbat)+"\t"+Math.round(hits)+"\t"+Math.round(walks)+"\t"+Math.round(so)+"\t"+Math.round(hbp)+"\t"+Math.round(sacrifice)+"\t"+df.format(BA())+"\t"+df.format(OB());
	}
	public float BA() { // function to calculate the batting average and return the batting average
		float battingaverage = 0;
		if (atbat > 0) { // if at bat is higher than 0
            battingaverage = (hits/(atbat)); // batting average is calculated by dividing atbat by hits
            return battingaverage;
        } 
		else {//if at-bat value is zero, then set the value of battingaverage to zero
            battingaverage = 0;
            return battingaverage;
        }
	}
	public float OB() { // function to calculate on base percentage
		float OB = (hits+walks+hbp)/plateappearance; // on base percentage is calculated by dividing h+w+hbp by the plateappearance
		if(plateappearance==0) {OB=0;} // if the plate appearance is zero, then ob is automatically zero, and this prevents dividing by zero error
		return OB; // return on base percentage
	}
}
	
		 
		

