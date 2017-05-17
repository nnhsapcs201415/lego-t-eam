import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.Button;

public class TouchTest {
  public static void main(String[] args) throws Exception {
    TouchSensor touch = new TouchSensor(SensorPort.S1);
    while (!touch.isPressed()) {
    }
    LCD.drawString("You touched it!", 3, 4);
    Button.waitForAnyPress();
  }
}