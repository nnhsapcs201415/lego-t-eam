import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorTutor3
{
    public static void main(String[] args)
    {
        System.out.println("Program 3");
        Motor.A.rotate(1440);
        System.out.println(Motor.A.getTachoCount());
        Motor.A.rotateTo(0);
        System.out.println(Motor.A.getTachoCount());
        Button.waitForAnyPress();
    }
}