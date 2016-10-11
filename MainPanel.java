import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    Fractal f;

    public MainPanel(Fractal f) {
        super();
        this.f = f;
    }

    public void paint(Graphics g) {

        double width = getWidth();
        double height = getHeight();

        double x;
        double y;
        double xf;
        double yf;
        double lineLength;

        double direction = f.angle;
        double dx = f.bounds[2] - f.bounds[0];
        double dy = f.bounds[3] - f.bounds[1];
        double margins = 0.07;

        if (dy * width > dx * height) {
            x = width*margins*0.5+0.5*(width*(1-margins)-height*(1-margins)*dx/dy)-height*(1-margins)*f.bounds[0]/dy;
            y = height*margins*0.5-height*(1-margins)*f.bounds[1]/dy;
            lineLength = height*(1-margins)/dy;
        } else {
            x = height*margins*0.5+0.5*(height*(1-margins)-width*(1-margins)*dy/dx)-width*(1-margins)*f.bounds[1]/dx;
            y = width*margins*0.5-width*(1-margins)*f.bounds[0]/dx;
            lineLength = width*(1-margins)/dx;
        }
        xf = x + lineLength*Math.cos(direction);
        yf = y + lineLength*Math.sin(direction);
        g.drawLine((int)x,(int)y,(int)xf,(int)yf);
        x = xf;
        y = yf;

        int baseSize = f.base.length + 1;
        for (int i = 1; i <= f.turns; i++) {
            int turnN = i;
            while (turnN % baseSize == 0) {
                turnN /= baseSize;
            }
            if (f.mirrored) {
                if ((turnN/baseSize)%2==0) {
                    direction += f.base[turnN%baseSize-1];
                } else {
                    direction -= f.base[f.base.length-turnN%baseSize];
                }
            } else {
                direction += f.base[turnN%baseSize-1];
            }
            xf = x + lineLength * Math.cos(direction);
            yf = y + lineLength * Math.sin(direction);
            g.drawLine((int)x,(int)y,(int)xf,(int)yf);
            x = xf;
            y = yf;
        }
    }
}
