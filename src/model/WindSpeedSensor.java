package model;

/** The sensor which returns wind speed data, 0 - 200 MPH. 
 * Sensor refreshes every 3s.
 * @author chanteltrainer
 *
 */
public class WindSpeedSensor extends AbstractSensor {

    private static final long serialVersionUID = 4737056243427179637L;
    
    private Integer myWindSpeed;
    
    //TODO Hyeong: Implementing storing Low and High
    private Integer myWindHigh;
    private Integer myWindLow;
    
    public WindSpeedSensor() {
        updateInterval = 3000; //Amount of time between each data refresh - 3s
        refreshData();
        
        myWindHigh = null;
        myWindLow = null;
        
        setHighAndLow();
    }
    
    @Override
    public String getData() {
        return Integer.toString(myWindSpeed);
    }

    @Override
    public void refreshData() {
        myWindSpeed = random.nextInt(200); //0-200 MPH
        
        setHighAndLow();
        
    }
    
    public Integer getSpeed() {
        return myWindSpeed;
    }

    public void setWindSpeed(Integer theWindSpeed) {
        myWindSpeed = theWindSpeed;
    }

    public void setHighAndLow() {
    	if(myWindHigh == null && myWindLow == null) {
    		myWindHigh = myWindSpeed;
    		myWindLow = myWindSpeed;
    	} else if(myWindSpeed > myWindHigh) {
    		myWindHigh = myWindSpeed;
    	} else if(myWindSpeed < myWindLow) {
    		myWindLow = myWindSpeed;
    	}
    	
    }
    
    public String getWindHigh() {
//    	return myWindHigh + "";
    	return Integer.toString(myWindHigh);
    }
    
    public String getWindLow() {
    	return Integer.toString(myWindLow);
    }

}
