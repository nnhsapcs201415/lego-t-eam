import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class Challenge
{
    public static void main(String[] args) {
        DifferentialPilot pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
        LightSensor light = new LightSensor(SensorPort.S1);
        UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);
                                                                     
        int BLACK_LIGHT_VALUE = 20;
        //light value inside box is 50-something
        int MAX_BOX_DISTANCE = 12;
        int BOX_LENGTH = 27; //assuming we start at the back
        int BOX_HALF_PLUS_ROBOT_HALF = 48;
        int ROTATION_DEGREE = 15;
        int counter = 0;
        boolean end = false;
        
        /*
         * state = 0  in box
         * state = 1  searching for cans
         * state = 2  finished
         */
        int state = 0;

        while (!end) {
            if (state == 0) {
                double distance = sonic.getDistance();
                while (distance <= 12) {
                    pilot.rotate(10);
                }
                while (light.getLightValue() > BLACK_LIGHT_VALUE) {
                    pilot.travel(1);
                    counter += 1;
                }
                pilot.travel(-1 * (counter - 70));
                counter = 0;
                state = 1;
            }
            else if (state == 1) {
                for (int i = 0; i < 4; i++) {
                    pilot.rotate(90);
                    for(int j = 0; j < (180 / ROTATION_DEGREE); j++) {
                        while (light.getLightValue() > BLACK_LIGHT_VALUE) {
                            pilot.travel(1);
                            counter += 1;
                        }
                        pilot.travel(-1 * counter);
                        counter = 0;
                        pilot.rotate(-1 * ROTATION_DEGREE);
                    }
                    pilot.travel(BOX_HALF_PLUS_ROBOT_HALF);
                    pilot.rotate(-90);
                    pilot.travel(BOX_HALF_PLUS_ROBOT_HALF);
                    pilot.rotate(90);
                }
            }
            else if (state == 2) {
                LCD.drawString("How did", 0, 0);
                LCD.drawString("I do?", 0, 1);
                Button.waitForAnyPress();
                end = true;
            }
        }
    }
}
