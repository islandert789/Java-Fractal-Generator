//import java.awt.*;

public class Main {

    public static void main(String[] args) {
        double[] base = {90};
        Fractal f = new Fractal(base,10,true).setOptimalAngle().display();
    }
}
