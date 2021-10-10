package application;

import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import controller.ControllerGUI;
import model.IntegratedSensorSuite;

public class Main {

    final static String FILE_PATH = "data.txt";
    
    public static void main(String[] args) {
        
        IntegratedSensorSuite myISS = new IntegratedSensorSuite(1);
        myISS.serializeSelf(FILE_PATH);
        
        ControllerGUI myConsole = new ControllerGUI(FILE_PATH); //create new console and pass the filepath
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                myConsole.createAndShowGUI();

            }
        });
    }
    
    /**
   * A method which takes a filepath name and object to serialize. The file can then be deserialized to return the object. 
   * @author chanteltrainer
   * @param theFileName
   * @param theObject
   */
public static void serialize(String theFilePath, Object theObject) {
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
          out.writeObject(theObject); 
            
          out.close(); 
          file.close(); 
            
          System.out.println("Object has been serialized"); 

      } 
        
      catch(IOException ex) 
      { 
          System.out.println("Serialization Failed."); 
          ex.printStackTrace();
      } 
  }
}
    

