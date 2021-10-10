package model;
/**
 * A sensor that returns the outside humidity level.
 * Refreshes every 
 * @author chanteltrainer
 * @version 7/12/2020
 */
public class HumiditySensor extends AbstractSensor {
    
    private static final long serialVersionUID = 1548592743824231157L;
    
    private Integer myHumidity;

    //TODO Hyeong: Implementing storing Low and High
    private Integer myHumidHigh;
    private Integer myHumidLow;
    
    public HumiditySensor() {
        updateInterval = 50000; //Amount of time between each data refresh - 50s
        refreshData();
        
        myHumidHigh = null;
        myHumidLow = null;
        
        setHighAndLow();
    }
    
    @Override
    public String getData() {
        return Integer.toString(myHumidity);
    }

    @Override
    public void refreshData() {
        setHumidity(random.nextInt(101)); //from 0-100, represents percentage
        setHighAndLow();
    }

    public Integer getHumidity() {
        return myHumidity;
    }

    public void setHumidity(Integer theHumidity) {
        myHumidity = theHumidity;
    }
    
    public void setHighAndLow() {
    	if(myHumidHigh == null && myHumidLow == null) {
    		myHumidHigh = myHumidity;
    		myHumidLow = myHumidity;
    	} else if(myHumidity > myHumidHigh) {
    		myHumidHigh = myHumidity;
    	} else if(myHumidity < myHumidLow) {
    		myHumidLow = myHumidity;
    	}
    	
    }
    
    public String getHumidityHigh() {
    	return Integer.toString(myHumidHigh);
    }
    
    public String getHumidityLow() {
    	return Integer.toString(myHumidLow);
    }
}
