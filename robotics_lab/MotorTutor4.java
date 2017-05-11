import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorTutor4
{
    public static void main(String[] args) {
        System.out.println("Program 4");
        Button.waitForAnyPress();
        while ( Button.readButtons() > 0) {
            LCD.clear();
            Motor.A.rotateTo(1440, true);
        }
        while(Motor.A.isMoving()) {
            Delay.msDelay(200);
            LCD.clear();
            System.out.println(Motor.A.getTachoCount());
            if(Button.readButtons() > 0) {
                Motor.A.stop();
            }
        }
        System.out.println(Motor.A.getTachoCount());
        Button.waitForAnyPress();
    }
}
