package _01_Olympic_Rings;

import java.awt.Color;
import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
    public static void main(String[] args) {
        new OlympicRings_Threaded().start();
    }
    
    void start() {
        ArrayList<RobotRing> robots = new ArrayList<RobotRing>();
        Color[] olypmicColors = { Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED };
        
        for( int i = 0; i < 5; i++ ) {
            int xPos = i*200 + 200;
            int yPos = ( i % 2 == 0 ) ? 500 : 700;
            robots.add( new RobotRing( xPos, yPos, olypmicColors[i] ) );
        }
        
        for( RobotRing r : robots ) {
            Thread rThread = new Thread(()->{r.drawCircle(10); r.robot.penUp(); r.robot.moveTo( 50, 50 );});
            rThread.start();
        }
    }
    
    class RobotRing {
        public int xPos;
        public int yPos;
        public Color color;
        public Robot robot;
        
        RobotRing( int xPos, int yPos, Color c ){
            this.xPos = xPos;
            this.yPos = yPos;
            this.color = c;
            
            this.robot = new Robot();
            this.robot.penDown();
            this.robot.setPenWidth( 10 );
            this.robot.setPenColor( color );
            this.robot.setSpeed( 10 );
            this.robot.setX( this.xPos );
            this.robot.setY( this.yPos );
        }
        
        void drawCircle( int size ) {
            for( int i = 0; i < 360/size; i++ ) {
                this.robot.move( 3 * size );
                this.robot.turn( size );
                System.out.println( "helo" );
            }
        }
        
        void setPenColor( Color c ) {
            this.robot.setPenColor( c );
        }
    }
}

