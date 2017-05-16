import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class TravelTest {
    DifferentialPilot pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
    TouchSensor bump = new TouchSensor(SensorPort.S1);
  
  public void go() {
    pilot.travel(100, true);
    while (pilot.isMoving()) {
      if (bump.isPressed()) {
          pilot.stop();
    }
    System.out.println(" "+pilot.getMovement().getDistanceTraveled());
    Button.waitForAnyPress();
  }
}
  public static void main(String[] args) {
    TravelTest traveler = new TravelTest();
    traveler.pilot = new DifferentialPilot(7.5, 22, Motor.A, Motor.C);
    traveler.go();
  }
}
