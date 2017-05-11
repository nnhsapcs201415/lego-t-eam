import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class SquareTracer
{
    DifferentialPilot pilot;
   
    public static void main(String[]args)
    {
        SquareTracer sq = new SquareTracer();
        sq.pilot = new DifferentialPilot(8, 3.5, Motor.A, Motor.C);
        sq.drawSquare(20); 
    }
    
    public void drawSquare(double length) 
    {
        for(int i = 0; i < 4; i++)
        {
            pilot.travel(length);
            pilot.rotate(90); 
        }
    }
}
