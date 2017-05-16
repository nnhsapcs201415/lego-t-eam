import lejos.nxt.*;

public class MultipleEchoTest {
    public static void main(String args[]) throws Exception {
        System.out.println("Echo Test Begin");
        Button.waitForAnyPress();
        LCD.clear();
        UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S2);
        int[] data = new int[8];
        int col = 0;
        boolean more = true;
        while (more) {
        sensor.ping();
        Sound.pause(30);
        sensor.getDistances(data);
        for(int i = 0; i < data.length; i++) {
            LCD.drawInt(data[i], 4, 4*col, i);
        }                      
        col++;
        if (col > 4) {
            more = Button.waitForAnyPress() != Button.ID_ESCAPE;
            col = 0;
        }
    }
}
}

