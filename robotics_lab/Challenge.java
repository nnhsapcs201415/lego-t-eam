

public class Challenge
{
    public static void main(String[] args) {
        DifferentialPilot pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
        LightSensor light = new LightSensor(SensorPort.S3);
        
        //getting the robot out of the box
        double distance = feature.getRangeReading().getRange();
        while (distance < BOX_DISTANCE) {
            pilot.rotate(45);
       }
       while (light.getLightValue() > BLACK_LIGHT_VALUE) {
           pilot.move(1);
       }
    }
}
