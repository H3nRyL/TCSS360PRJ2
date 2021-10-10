package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import controller.ControllerGUI;

/** The integrated sensor suite is a device that contains many connected sensors which collect data about their environments.
 * 
 * @author chanteltrainer
 * @version July 12, 2020
 */
public class IntegratedSensorSuite implements Serializable, Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = 4721190505387048162L;

    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;

    final static String FILE_PATH = "data.txt";
    
    //Serialized fields must be public. 
    public WindDirectionSensor myWindDirection;
    
    public WindSpeedSensor myWindSpeed;
    
    public HumiditySensor myHumidity;
    
    public TemperatureSensor myTemperature;
    
    public RainSensor myRainSensor;
    
    public UVSensor myUVSensor;
    
    /** Each Vantage Pro2 console can receive data from up to 8 different wireless transmitters.
     *  The default transmitter ID for the sensor suite is 1, and in most cases it is not necessary to change it.
     */
    public int myTransmitterId = 1;
    
    /** Manager for Property Change Listeners. */
    private transient PropertyChangeSupport myPcs;
    
    /** 
     * Constructor of a Integrated Sensor Suite which contains a variety of sensors and stores the current data. 
     * @param theTransmitterId
     */
    public IntegratedSensorSuite(int theTransmitterId) {
        myWindDirection = new WindDirectionSensor();
        myWindSpeed = new WindSpeedSensor();
        myHumidity = new HumiditySensor();
        myTemperature = new TemperatureSensor();
        myRainSensor = new RainSensor();
        myUVSensor = new UVSensor();
        myTransmitterId = theTransmitterId;
    }

    /** Returns the transmitter ID. */
    public int getTransmitterId() {
        return myTransmitterId;
    };
    
    /** Changes the transmitter ID. */
    public void setTransmitterId(int theInt) {
        myTransmitterId = theInt;
    }
    
    /** Changes current sensor readings to exact values (for testing purposes) */
    public void setSensorReadings(int theWindDirection, int theWindSpeed, int theHumidity, int theTemp, double theRain, double theUV) {
        myWindDirection.setWindDirection(theWindDirection);
        myWindSpeed.setWindSpeed(theWindSpeed);
        myHumidity.setHumidity(theHumidity);
        myTemperature.setTemperature(theTemp);
        myRainSensor.setDailyRain(theRain);
        myUVSensor.setRadiationDose(theUV);
    }
    
    @Override
    public String toString() {
        return "Wind Direction: " + myWindDirection.getData().toString() + ". Wind Speed: " + myWindSpeed.getData().toString() + ". Humidity: " 
                + myHumidity.getData().toString() + "%. Temperature: " + myTemperature.getData().toString() + DEGREE_SYMBOL + "F. Rain Amount: "
                + myRainSensor.getData().toString() + ". UV: " + myUVSensor.getData().toString() + ".";
    }
    
    public String currHighAndLowToString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Wind Speed High: " +  myWindSpeed.getWindHigh());
    	sb.append("\nWind Speed Low: " +  myWindSpeed.getWindLow());
    	
    	sb.append("\n\nHumidity High: " +  myHumidity.getHumidityHigh());
    	sb.append("\nHumidity Low: " +  myHumidity.getHumidityLow());
    	
    	sb.append("\n\nTemperature High: " +  myTemperature.getTempHigh());
    	sb.append("\nTemperature Low: " +  myTemperature.getTempLow());
    	
    	sb.append("\n\nRain High: " +  myRainSensor.getRainHigh());
    	sb.append("\nRain Low: " +  myRainSensor.getRainLow());
    	
    	sb.append("\n\nUV High: " +  myUVSensor.getRadiationHigh());
    	sb.append("\nUV Low: " +  myUVSensor.getRadiationLow());
    	
    	return sb.toString();
    }

    @Override
    public void run() {
        myWindDirection.run();
        myWindSpeed.run();
        myHumidity.run();
        myTemperature.run();
        myRainSensor.run();
        myUVSensor.run();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                serializeSelf(FILE_PATH);  
            }
        }, 0, 3000); //runs once initially then again every 3 seconds
          
    }
        
    /** Helper method - when called this instance serializes itself. */
    public void serializeSelf(String theFilePath) {
        serialize(theFilePath, this);
        if (myPcs!=null) {
            myPcs.firePropertyChange("SENSOR_VALUES_CHANGE", null, this);
        }
    }
    
        /**
       * A method which takes a filepath name and object to serialize. The file can then be deserialized to return the object. 
       * @author chanteltrainer
       * @param theFileName
       * @param theObject
       */
    public static void serialize(String theFilePath, IntegratedSensorSuite theISS) {
         try
          {    
              //This will clear the file of any previous data
              PrintWriter writer = new PrintWriter(theFilePath);
              writer.print("");
              writer.close();
             
              //Saving of object in a file 
              FileOutputStream file = new FileOutputStream(theFilePath); 
              ObjectOutputStream out = new ObjectOutputStream(file); 
                
              // Method for serialization of object 
              out.writeObject(theISS); 
                
              out.close(); 
              file.close(); 
                
              System.out.println("Object has been serialized: " + theISS.toString()); 
    
          } 
            
          catch(IOException ex) 
          { 
              System.out.println("Serialization Failed."); 
              ex.printStackTrace();
          } 
      }
    
    /** Helper method to initialize property change support after the object has been deserialized by the view controller. 
     * The reason for doing this is because PCS is not serializable so cannot be sent (thus it is marked transient, then
     * initialzed after the GUI has the instance.
     */
    public void initializePropertyChangeSupport() {
        myPcs = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);
    }


}
    
