import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class Challenge
{
    public static void main(String[] args) {
        DifferentialPilot pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
        LightSensor light = new LightSensor(SensorPort.S3);
        UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);
        TouchSensor bump1 = new TouchSensor(SensorPort.S1);
        TouchSensor bump2 = new TouchSensor(SensorPort.S4);
        
        int BLACK_LIGHT_VALUE = 1;
        int MAX_BOX_DISTANCE = 1;
        
        /*
         * state = 0  in box
         * state = 1  searching for cans
         * state = 2  push can
         * state = 3  at black line
         * state = 4  against box
         */
        int state = 0;
        
        while (true) {
            if (state == 0) {
                double distance = sonic.getDistance();
                while (distance <= MAX_BOX_DISTANCE) {
                    pilot.rotate(10);
                }
                while (light.getLightValue() > BLACK_LIGHT_VALUE) {
                    pilot.travel(1);
                }
                state = 3;
            }
            else if (state == 1) {
                
            }
            else if (state == 2) {
                while (light.getLightValue() != BLACK_LIGHT_VALUE || (!bump1.isPressed() || !bump2.isPressed())) {
                    pilot.travel(1);
                }
                if(light.getLightValue() == BLACK_LIGHT_VALUE) {
                    state = 3;
                }
                else {
                    state = 4;
                }
            }
            else if (state == 3) { //3 is always the terminating condition
                pilot.stop();
                pilot.travel(/* how much??? where to??? */);
            }
            else if (state == 4) {
                
            }
        }
    }
}
