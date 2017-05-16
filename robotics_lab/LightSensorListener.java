import lejos.nxt.SensorPortListener;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;

public class LightSensorListener implements SensorPortListener
{
    private SensorPort port;

    /**
     * Default constructor for objects of class LightSensorListener
     */
    public LightSensorListener(SensorPort input)
    {
        port = input;
        SensorPort.S3.addSensorPortListener(this);
    }

    public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
        if (aOldValue != aNewValue) {
            System.out.println(aNewValue);
            Button.waitForAnyPress();
        }
    }
}
