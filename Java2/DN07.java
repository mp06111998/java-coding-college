import java.awt.Color;
import java.util.Random;
/**
 *
 * @author Marcel
 */
public class DN07 {
    public static void main(String[] args) {
        Random rand = new Random();
        int N = 200;
        int VISINA = 20;
        int SIRINA = 32;
        StdDraw.setCanvasSize(SIRINA*30, VISINA*30);
        
        for(int i = 0; i < N; i++){
            int redValue = rand.nextInt(255);
            int greenValue = rand.nextInt(255);
            int blueValue = rand.nextInt(255);
            Color clr = new Color(redValue, greenValue, blueValue);
            
            double  n = rand.nextDouble();
            
            double leftLimit1 = 0;
            double rightLimit1 = SIRINA;
            double x1 = leftLimit1 + new Random().nextDouble() * (rightLimit1 - leftLimit1);
            
            double leftLimit2 = 0;
            double rightLimit2 = VISINA;
            double y1 = leftLimit2 + new Random().nextDouble() * (rightLimit2 - leftLimit2);
            draw(x1,y1,clr,n+0.01);
        }
    }
    
    private static void draw(double x, double y, Color c, double v) {
        double zamik = v * 0.25;
        StdDraw.setXscale(0, 32);
        StdDraw.setYscale(0, 20);
        StdDraw.setPenRadius(v/100);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.line(x, y, x, y-v*4.5);
        StdDraw.setPenColor(c);
        StdDraw.filledCircle(x-(v+zamik), y, v);
        StdDraw.filledCircle(x+(v+zamik), y, v);
        StdDraw.filledCircle(x, y-(v+zamik), v);
        StdDraw.filledCircle(x, y+(v+zamik), v);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(x, y, v/1.7);
    }
}
