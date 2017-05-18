
import lejos.nxt.SensorPortListener;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;


import lejos.nxt.*;
import lejos.robotics.objectdetection.*;

public class LightSensorListener implements SensorPortListener
{   
    public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
        /*SensorPort.S2.addSensorPortListener(this);*/
        //^is instiated in the actual program for the challenge.
        if (aOldValue != aNewValue) {
            System.out.println(aNewValue);
            Button.waitForAnyPress();
        }
    }
}