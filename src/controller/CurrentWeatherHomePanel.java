package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import model.IntegratedSensorSuite;

/**
 *
 * @author chanteltrainer
 */
public class CurrentWeatherHomePanel extends javax.swing.JPanel implements PropertyChangeListener {
    
    private static final long serialVersionUID = 3261357348985372652L;
    
    private JFrame myWindow;
    
    private IntegratedSensorSuite myISS;
    
    private HighsAndLowsPanel myHighsAndLowsPanel = new HighsAndLowsPanel(myWindow, this, myISS);
    
    /**
     * Creates new form CurrentWeatherPanel
     */
    public CurrentWeatherHomePanel(JFrame theWindow, IntegratedSensorSuite theISS) {
        myWindow = theWindow;
        myISS = theISS;
        myISS.initializePropertyChangeSupport();
        myISS.run();
        initComponents();
        myISS.addPropertyChangeListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        ViewPanel = new javax.swing.JPanel();
        label_WindSpeed = new javax.swing.JLabel();
        textField_WindSpeed = new javax.swing.JTextField(myISS.myWindSpeed.getData());
        label_WindDirection = new javax.swing.JLabel();
        textField_WindDirection = new javax.swing.JTextField(myISS.myWindDirection.getData());
        label_Temperature = new javax.swing.JLabel();
        textField_Temperature = new javax.swing.JTextField(myISS.myTemperature.getData());
        label_Humidity = new javax.swing.JLabel();
        textField_Humidity = new javax.swing.JTextField(myISS.myHumidity.getData());
        label_Rain = new javax.swing.JLabel();
        textField_Rain = new javax.swing.JTextField(myISS.myRainSensor.getData());
        label_UV = new javax.swing.JLabel();
        textField_UV = new javax.swing.JTextField(myISS.myUVSensor.getData());
        jSeparator1 = new javax.swing.JSeparator();
        label_Forecast = new javax.swing.JLabel();
        button_WindSpeed = new javax.swing.JToggleButton("Wind Speed", true);
        button_WindDirection = new javax.swing.JToggleButton("Wind Direction", true);
        button_Temperature = new javax.swing.JToggleButton("Temperature", true);
        button_Humidity = new javax.swing.JToggleButton("Humidity", true);
        button_Rain = new javax.swing.JToggleButton("Rain", true);
        button_UV = new javax.swing.JToggleButton("UV Radiation", true);
        label_CurrentWeather = new javax.swing.JLabel();
        button_Setup = new javax.swing.JButton();
        button_HighLows = new javax.swing.JButton();
        button_Alarm = new javax.swing.JButton();
        button_Graphs = new javax.swing.JButton();

        setBackground(new java.awt.Color(160, 213, 253));

        ViewPanel.setBackground(new java.awt.Color(223, 241, 254));

        label_WindSpeed.setText("Wind Speed:");

        textField_WindSpeed.setEditable(false);
        textField_WindSpeed.setBorder(null);

        label_WindDirection.setText("Wind Direction:");

        textField_WindDirection.setEditable(false);
        textField_WindDirection.setBorder(null);

        label_Temperature.setText("Temperature:");

        textField_Temperature.setEditable(false);
        textField_Temperature.setBorder(null);

        label_Humidity.setText("Humidity:");

        textField_Humidity.setEditable(false);
        textField_Humidity.setBorder(null);

        label_Rain.setText("Rain (in/hr):");

        textField_Rain.setEditable(false);
        textField_Rain.setBorder(null);
 
        label_UV.setText("UV Radiation:");

        textField_UV.setEditable(false);
        textField_UV.setBorder(null);
   
        label_Forecast.setText("Forecast:");

//        button_WindSpeed.setText("Wind Speed");

//        button_WindDirection.setText("Wind Direction");

//        button_Temperature.setText("Temperature");

//        button_Humidity.setText("Humidity");

//        button_Rain.setText("Rain");

//        button_UV.setText("UV Radiation");

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewPanelLayout.createSequentialGroup()
                        .addComponent(label_Forecast)
                        .addGap(0, 362, Short.MAX_VALUE))
                    .addGroup(ViewPanelLayout.createSequentialGroup()
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_UV)
                            .addComponent(label_Humidity)
                            .addComponent(label_Temperature))
                        .addGap(30, 30, 30)
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField_Temperature, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(textField_Humidity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_Humidity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_Temperature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                        .addComponent(label_Rain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewPanelLayout.createSequentialGroup()
                                .addComponent(textField_Rain, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                                .addComponent(textField_UV, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_UV, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(button_Rain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ViewPanelLayout.createSequentialGroup()
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_WindDirection)
                            .addComponent(label_WindSpeed))
                        .addGap(18, 18, 18)
                        .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                                .addComponent(textField_WindSpeed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_WindSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                                .addComponent(textField_WindDirection)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_WindDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_WindSpeed)
                    .addComponent(textField_WindSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_WindSpeed))
                .addGap(7, 7, 7)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_WindDirection)
                    .addComponent(textField_WindDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_WindDirection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Temperature)
                    .addComponent(textField_Temperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Temperature))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Humidity)
                    .addComponent(button_Humidity)
                    .addComponent(textField_Humidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Rain)
                    .addComponent(textField_Rain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Rain))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_UV)
                    .addComponent(textField_UV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_UV))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_Forecast)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        label_CurrentWeather.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label_CurrentWeather.setText("Current Weather Mode");

        button_Setup.setText("Setup");
        button_Setup.setMaximumSize(new java.awt.Dimension(140, 40));
        button_Setup.setMinimumSize(new java.awt.Dimension(140, 40));
        button_Setup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SetupActionPerformed(evt);
            }
        });

        button_HighLows.setText("Highs and Lows");
        button_HighLows.setMaximumSize(new java.awt.Dimension(140, 40));
        button_HighLows.setMinimumSize(new java.awt.Dimension(140, 40));
        button_HighLows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HighLowsActionPerformed(evt);
            }
        });

        button_Alarm.setText("Alarms");
        button_Alarm.setMaximumSize(new java.awt.Dimension(140, 40));
        button_Alarm.setMinimumSize(new java.awt.Dimension(140, 40));
        button_Alarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AlarmActionPerformed(evt);
            }
        });

        button_Graphs.setText("Graphs");
        button_Graphs.setMaximumSize(new java.awt.Dimension(140, 40));
        button_Graphs.setMinimumSize(new java.awt.Dimension(140, 40));
        button_Graphs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_GraphsActionPerformed(evt);
            }
        });
        
        button_WindSpeed.setText("Wind Speed");
        button_WindSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_WindSpeedActionPerformed(evt);
            }
        });
        
        button_WindDirection.setText("Wind Direction");
        button_WindDirection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_WindDirectionActionPerformed(evt);
            }
        });
        
        button_Temperature.setText("Temperature");
        button_Temperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_TemperatureActionPerformed(evt);
            }
        });
        
        button_Humidity.setText("Humidity");
        button_Humidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HumidityActionPerformed(evt);
            }
        });
        
        button_Rain.setText("Rain");
        button_Rain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RainActionPerformed(evt);
            }
        });

        button_UV.setText("UV Radiation");
        button_UV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button_Alarm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Setup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_HighLows, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Graphs, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_CurrentWeather)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_CurrentWeather)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_Setup, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_HighLows, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Graphs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        ); 
    }                                           

    private void button_SetupActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void button_HighLowsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        myWindow.setContentPane(new HighsAndLowsPanel(myWindow, this, myISS));
        myWindow.pack();
    }                                                 

    private void button_AlarmActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void button_GraphsActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    @Override
    /** Updates the values whenever there is a property change fired. */
    public void propertyChange(PropertyChangeEvent theEvent) {           
        
        if (theEvent.getPropertyName().equals("SENSOR_VALUES_CHANGE")) {
            if (button_WindDirection.isSelected()) {
                textField_WindDirection.setText(myISS.myWindDirection.getData());
            }
            if (button_WindSpeed.isSelected()) {
                textField_WindSpeed.setText(myISS.myWindSpeed.getData());
            }
            if (button_Temperature.isSelected()) {
                textField_Temperature.setText(myISS.myTemperature.getData());
            }
            if (button_Humidity.isSelected()) {
                textField_Humidity.setText(myISS.myHumidity.getData());
            }
            if (button_Rain.isSelected()) {
                textField_Rain.setText(myISS.myRainSensor.getData());
            }
            if (button_UV.isSelected()) {
                textField_UV.setText(myISS.myUVSensor.getData());
            }
            repaint();
        } 
    }   
    
    private void button_WindSpeedActionPerformed(java.awt.event.ActionEvent evt) {                 
        if (button_WindSpeed.isSelected()) {
            textField_WindSpeed.setText(myISS.myWindSpeed.getData());
        } else {
            textField_WindSpeed.setText(null);
        }
    }
    
    private void button_WindDirectionActionPerformed(java.awt.event.ActionEvent evt) {                             
        if (button_WindDirection.isSelected()) {
            textField_WindDirection.setText(myISS.myWindDirection.getData());
        } else {
            textField_WindDirection.setText(null);
        }
    }
    
    private void button_TemperatureActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (button_Temperature.isSelected()) {
            textField_Temperature.setText(myISS.myTemperature.getData());
        } else {
            textField_Temperature.setText(null);
        }
    }
    
    private void button_HumidityActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (button_Humidity.isSelected()) {
            textField_Humidity.setText(myISS.myHumidity.getData());
        } else {
            textField_Humidity.setText(null);
        }
    }
    
    private void button_RainActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (button_Rain.isSelected()) {
            textField_Rain.setText(myISS.myRainSensor.getData());
        } else {
            textField_Rain.setText(null);
        }
    }
    
    private void button_UVActionPerformed(java.awt.event.ActionEvent evt) {                         
        if (button_UV.isSelected()) {
            textField_UV.setText(myISS.myUVSensor.getData());
        } else {
            textField_UV.setText(null);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JButton button_Alarm;
    private javax.swing.JButton button_Graphs;
    private javax.swing.JButton button_HighLows;
    private javax.swing.JToggleButton button_Humidity;
    private javax.swing.JToggleButton button_Rain;
    private javax.swing.JButton button_Setup;
    private javax.swing.JToggleButton button_Temperature;
    private javax.swing.JToggleButton button_UV;
    private javax.swing.JToggleButton button_WindDirection;
    private javax.swing.JToggleButton button_WindSpeed;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_CurrentWeather;
    private javax.swing.JLabel label_Forecast;
    private javax.swing.JLabel label_Humidity;
    private javax.swing.JLabel label_Rain;
    private javax.swing.JLabel label_Temperature;
    private javax.swing.JLabel label_UV;
    private javax.swing.JLabel label_WindDirection;
    private javax.swing.JLabel label_WindSpeed;
    private javax.swing.JTextField textField_Humidity;
    private javax.swing.JTextField textField_Rain;
    private javax.swing.JTextField textField_Temperature;
    private javax.swing.JTextField textField_UV;
    private javax.swing.JTextField textField_WindDirection;
    private javax.swing.JTextField textField_WindSpeed;
    // End of variables declaration                   

}
