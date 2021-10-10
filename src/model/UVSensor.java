package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *  The sensor that returns the radiation dose.
 *  
 * @author Haoying Li
 * @version 7/12/2020
 */
public class UVSensor extends AbstractSensor {

    private static final long serialVersionUID = -7031802244875215128L;
    
    private double myRadiationDose;
    private final double MAXRADIATIONDOSE = 199;
    
    private Random rand = new Random();

    //TODO Hyeong: Implementing storing Low and High
    private double myRadiationHigh;
    private double myRadiationLow;
    
    /** Constructor for an UVSensor.*/
    public UVSensor() {
        updateInterval = 50000; // refresh rate 50s
        refreshData();
        
        myRadiationHigh = 0.0;
        myRadiationLow = 0.0;
        
        setHighAndLow();
    }
    
    @Override
    public String getData() {
        return String.valueOf(myRadiationDose);
    }

    @Override
    public void refreshData() {
        BigDecimal bd = new BigDecimal(MAXRADIATIONDOSE * rand.nextDouble());
    	bd = bd.setScale(1, RoundingMode.HALF_EVEN);
        myRadiationDose = bd.doubleValue();
        
        setHighAndLow();
    }
    
    public void setRadiationDose(double theDose) {
        myRadiationDose = theDose;
    }
    
    public double getRadiationDose() {
        return myRadiationDose;
    }
    
    public void setHighAndLow() {
    	if(myRadiationHigh == 0.0 && myRadiationLow == 0.0) {
    		myRadiationHigh = myRadiationDose;
    		myRadiationLow = myRadiationDose;
    	} else if(myRadiationDose > myRadiationHigh) {
    		myRadiationHigh = myRadiationDose;
    	} else if(myRadiationDose < myRadiationLow) {
    		myRadiationLow = myRadiationDose;
    	}
    	
    }
    
    public String getRadiationHigh() {
    	return myRadiationHigh + "";
    }
    
    public String getRadiationLow() {
    	return myRadiationLow + "";
    }
}
