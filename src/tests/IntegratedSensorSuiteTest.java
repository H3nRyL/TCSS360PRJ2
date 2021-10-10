package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IntegratedSensorSuite;
/**
 * Tests for IntegratedSensorSuite class. 
 * 
 * @author chanteltrainer
 *
 */
class IntegratedSensorSuiteTest {

    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    IntegratedSensorSuite myTestISS;
    
    @BeforeEach
    void setUp() throws Exception {
        myTestISS = new IntegratedSensorSuite(1);
    }


    @Test
    void testGetTransmitterId() {
        assertEquals(1, myTestISS.getTransmitterId(), "Error at getTransmitterId()");
    }

    @Test
    void testSetTransmitterId() {
        myTestISS.setTransmitterId(5);
        assertEquals(5, myTestISS.getTransmitterId(), "Error at setting transmitterId()");
        assertNotEquals(1, myTestISS.getTransmitterId());
    }

    
    @Test
    void testSetSensorReadings() {
        myTestISS.setSensorReadings(1, 2, 3, 4, 5.0, 6.0);
        assertEquals(1, myTestISS.myWindDirection.getWindDirection(), "failed to set wind direction");
        assertEquals(2, myTestISS.myWindSpeed.getSpeed(), "failed to set wind speed");
        assertEquals(3, myTestISS.myHumidity.getHumidity(), "failed to set humidity");
        assertEquals(4, myTestISS.myTemperature.getTemperature(), "failed to set temperature");
        assertEquals(5.0, myTestISS.myRainSensor.getDailyRain(), "failed to set rain amount");
        assertEquals(6.0, myTestISS.myUVSensor.getRadiationDose(), "failed to set UV amount");
    }
    
    @Test
    void testToString() {
        myTestISS.setSensorReadings(1, 2, 3, 4, 5.0, 6.0);
        assertEquals("Wind Direction: 1. Wind Speed: 2. Humidity: 3%. Temperature: 4°F. Rain Amount: 5.0. UV: 6.0.", 
                     myTestISS.toString());
    }
    
    @Test
    void testCurrHighAndLowToString() {
    	Integer ws = myTestISS.myWindSpeed.getSpeed();
    	Integer humid = myTestISS.myHumidity.getHumidity();
    	Integer temp = myTestISS.myTemperature.getTemperature();
    	double rain = myTestISS.myRainSensor.getDailyRain();
    	double uv = myTestISS.myUVSensor.getRadiationDose();
    	assertEquals("Wind Speed High: " + Integer.toString(ws) + "\nWind Speed Low: " + Integer.toString(ws)
    			+ "\n\nHumidity High: " + Integer.toString(humid) + "\nHumidity Low: " + Integer.toString(humid)
    			+ "\n\nTemperature High: " + Integer.toString(temp) + "\nTemperature Low: " + Integer.toString(temp)
    			+ "\n\nRain High: " + rain + "" + "\nRain Low: " + rain + "" 
    			+ "\n\nUV High: " + uv + "" + "\nUV Low: " + uv + "", myTestISS.currHighAndLowToString());
    }
}
