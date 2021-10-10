package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.IntegratedSensorSuite;
/**
 * The controllor GUI is the starting point of running the console. It requires the input of a String which denotes
 * the filepath that contains the serialized data of an IntegratedSensorSuite object.
 * @author chanteltrainer
 *
 */
public class ControllerGUI extends JPanel {
    
	//TODO Hyeong: Name it history.txt for now, feel free to rename it later
	final static String FILE_PATH = "history.txt";
 
	
    private static final long serialVersionUID = 1367902465871308357L;

    IntegratedSensorSuite myISS;
    
    final JFrame myWindow = new JFrame("Integrated Sensor Suite Console");
    
    private CurrentWeatherHomePanel myHomePanel;
    
    public ControllerGUI(String theFilePath) {
        myISS = deserialize(theFilePath);
        
        myHomePanel = new CurrentWeatherHomePanel(myWindow, myISS);
    }

    /**
     * Creates and shows the GUI, which also calls the view panel.
     */
    public void createAndShowGUI() {
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setContentPane(myHomePanel);
        myWindow.setResizable(false);
        myWindow.pack();
        myWindow.setVisible(true); 
    }
    
    /**
     * A method to deserialize the ISS model object. Can return null if no object is found.
     * @param theFilePath
     */
    public static IntegratedSensorSuite deserialize(String theFilePath) {
        IntegratedSensorSuite theSuite = null;
        
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(theFilePath); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            theSuite = (IntegratedSensorSuite) in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized"); 
            
            System.out.println(theSuite.toString());
            
            //TODO Hyeong: Printing and save history.txt
            System.out.println("\nHere Prints current Highs and Lows");
            System.out.println(theSuite.currHighAndLowToString()); //TODO Hyeong: This is just for printing, 
            													   // Now, we have access to current High and Low 
            													   //values in each sensors
            PrintWriter writer = new PrintWriter(FILE_PATH);
            writer.print(theSuite.currHighAndLowToString());
            writer.close();
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        }
        return theSuite; 
    }
  
}

