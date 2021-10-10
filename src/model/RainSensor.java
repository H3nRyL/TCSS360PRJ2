package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * A sensor that returns the rain data.
 * 
 * @author Haoying Li
 * @version 7/12/2020
 */
public class RainSensor extends AbstractSensor {
 
    private static final long serialVersionUID = 3681279401983356501L;
    
    private double myDailyRain;
    private final double MAXDAILY = 99.99;
    
    private Random rand = new Random();

    //TODO Hyeong: Implementing storing Low and High
    private double myRainHigh;
    private double myRainLow;
    
    public RainSensor() {
        updateInterval = 20000; // refresh rate 50s
        refreshData();
        
        myRainHigh = 0.0;
        myRainLow = 0.0;
        
        setHighAndLow();
    }
    
    @Override
    public String getData() {
        return String.valueOf(myDailyRain);
    }

    @Override
    public void refreshData() {
        BigDecimal bd = new BigDecimal(MAXDAILY * rand.nextDouble());
    	   bd = bd.setScale(1, RoundingMode.HALF_EVEN);
        myDailyRain = bd.doubleValue();
        
        setHighAndLow();
    }
    
    public void setDailyRain(double theDailyRain) {
       myDailyRain = theDailyRain;
    }
    
    public double getDailyRain() {
        return myDailyRain;
    }
    
    
    public void setHighAndLow() {
    	if(myRainHigh == 0.0 && myRainLow == 0.0) {
    		myRainHigh = myDailyRain;
    		myRainLow = myDailyRain;
    	} else if(myDailyRain > myRainHigh) {
    		myRainHigh = myDailyRain;
    	} else if(myDailyRain < myRainLow) {
    		myRainLow = myDailyRain;
    	}
    	
    }
    
    public String getRainHigh() {
    	return myRainHigh + "";
    }
    
    public String getRainLow() {
    	return myRainLow + "";
    }
}
