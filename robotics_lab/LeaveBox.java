import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class LeaveBox
{
    public static void main(String[] args) {
        UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);
        DifferentialPilot pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
        LightSensor light = new LightSensor(SensorPort.S1);
        double distance = sonic.getDistance();
        int counter = 0;
        while (distance <= 12) {
            pilot.rotate(10);
        }
        while (light.getLightValue() > 20) {
            pilot.travel(1);
            counter += 1;
        }
        pilot.travel(-1 * counter);
    }
}
