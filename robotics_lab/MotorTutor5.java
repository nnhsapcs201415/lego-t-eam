import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorTutor5
{
    public static void main(String[] args) {
        System.out.println("Program 5");
        Motor.A.setSpeed(720);
        Motor.C.setSpeed(720);
        Motor.A.rotate(720, true);
        Motor.C.rotate(720, true);
        for(int i = 0; i < 8; i++) {
            Delay.msDelay(200);
            System.out.println("Tacho Count A: " + Motor.A.getTachoCount());
            System.out.println("Tacho Count C: " + Motor.C.getTachoCount());
        }
        while( Motor.A.isMoving() || Motor.B.isMoving() || Motor.C.isMoving()) {
            Button.waitForAnyPress();
        }
    }
}
