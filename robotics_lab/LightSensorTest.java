import lejos.nxt.*;
import lejos.robotics.objectdetection.*;

public class LightSensorTest
{
    public static void main(String args[]) {
        LightSensor sensor = new LightSensor(SensorPort.S3);
        RangeFeatureDetector fd = new RangeFeatureDetector(sensor, 80, 500);
        LightSensorListener listener = new LightSensorListener(SensorPort.S3);
        fd.add(listener);
    while(true) {
        LCD.clear();
        System.out.println(sensor.readValue());
        Button.waitForAnyPress();
    }
    }
} 
