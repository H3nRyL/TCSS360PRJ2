package model;
/**
 *  The sensor that returns the outside temperature.
 *  Sensor refreshes every 10s.
 * @author chanteltrainer
 * @version 7/12/2020
 */
public class TemperatureSensor extends AbstractSensor {

    private static final long serialVersionUID = -144935746630910190L;
    
    private Integer myTemperature;
    
    //TODO Hyeong: Implementing storing Low and High
    private Integer myTempHigh;
    private Integer myTempLow;
    
    /** Constructor for a TemperatureSensor.*/
    public TemperatureSensor() {
        updateInterval = 10000; //Amount of time between each data refresh - 10s
        refreshData();
        
        myTempHigh = null;
        myTempLow = null;
        
        setHighAndLow();
    }
    
    @Override
    public String getData() {
        return Integer.toString(myTemperature);
    }

    @Override
    public void refreshData() {
        Integer temp = random.nextInt(150);
        if(random.nextBoolean()) {
            temp = -temp; //50% chance to be negative value
        }
        setTemperature(temp); //from 0-150, represented in degrees F.
        
        setHighAndLow();
    }

    public Integer getTemperature() {
        return myTemperature;
    }

    public void setTemperature(Integer theTemp) {
        myTemperature = theTemp;
    }
    
    public void setHighAndLow() {
    	if(myTempHigh == null && myTempLow == null) {
    		myTempHigh = myTemperature;
    		myTempLow = myTemperature;
    	} else if(myTemperature > myTempHigh) {
    		myTempHigh = myTemperature;
    	} else if(myTemperature < myTempLow) {
    		myTempLow = myTemperature;
    	}
    	
    }

    public String getTempHigh() {
    	return Integer.toString(myTempHigh);
    }
    
    public String getTempLow() {
    	return Integer.toString(myTempLow);
    }
}
