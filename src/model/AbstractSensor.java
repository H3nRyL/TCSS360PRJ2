package model;

import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/** AbstractSensor includes behavior of a sensor within the Integrated Sensor Suite. 
 * @author chanteltrainer
 * @version 7/9/2020
 * */
public abstract class AbstractSensor implements Runnable, Serializable {

    private static final long serialVersionUID = 4446875898537528308L;

    protected static Random random = new Random();
    
    /*This is the amount of time between each refresh of data for the sensor. Each differs */
    public int updateInterval;
    
    /** This method will return the data collected by that sensor in String format. */ 
    public abstract String getData();
  
    /** This method will refresh the data to get a new reading according the the specifications and boundaries of that sensor */
    public abstract void refreshData();
   
    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                refreshData();
            }
        }, 0, updateInterval); //runs once initially then again every 3 seconds
    }
  
}
