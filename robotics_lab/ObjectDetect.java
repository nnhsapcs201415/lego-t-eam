
import lejos.nxt.*;
import lejos.robotics.objectdetection.*;

public class ObjectDetect implements FeatureListener {
    public static void main(String[] args) throws Exception {
        ObjectDetect listener = new ObjectDetect();
        UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S2);
        FeatureDetector detector = new RangeFeatureDetector(sensor, 80, 500);
        detector.addListener(listener);
        System.out.println("Ready to run");
        Button.waitForAnyPress();
        LCD.clear();
    }

    public void featureDetected(Feature feature, FeatureDetector detector) {
        int range = (int)feature.getRangeReading().getRange();
        Sound.playTone(1200 - (range * 10), 100);
        System.out.println("Range:" + range);
    }
}