import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;
/**
 * Rotates the motor exactly 4 revolutions 
 */
public class MotorTutor2
{
    public static void main(String[] arg)
    {
        System.out.println("Program 2");
        Button.waitForAnyPress();
        Motor.A.setSpeed(720);
        Motor.A.forward();
        LCD.clear();
        Delay.msDelay(2000);
        System.out.println(Motor.A.getTachoCount());
        Motor.A.stop();
        System.out.println(Motor.A.getTachoCount());
        Motor.A.backward();
        while (Motor.A.getTachoCount()> 0)
        {
            System.out.println(Motor.A.getTachoCount());
        }
        Motor.A.stop();
        System.out.println(Motor.A.getTachoCount());
        Button.waitForAnyPress();
        
    }
}