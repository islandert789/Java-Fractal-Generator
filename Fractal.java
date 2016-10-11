public class Fractal {

    public double[] base;
    public int iteration;
    public boolean mirrored;
    public double angle;

    public double[] bounds = {0,0,0,0};
    public int turns;

    private MainFrame frame;
    public int width = 1276;
    public int height = 775;

    public Fractal(double[] base, int iteration, boolean mirrored) {
        this.base = base;
        for (int i = 0; i < base.length; i++) {
            base[i]=Math.toRadians(base[i]);
        }
        this.iteration = iteration;
        this.mirrored = mirrored;
        setTurns();
        this.angle = 0;
    }

    public Fractal display() {
        frame = new MainFrame(width, height, this);
        return this;
    }

    public Fractal setAngle(double angle) {
        this.angle = Math.toRadians(angle);
        setBounds();
        return this;
    }

    private void setTurns() {
        turns = base.length;
        for (int i = 0; i < iteration; i++) {
            turns = base.length + base.length*turns + turns;
        }
    }

    public void setBounds() {
        double direction = angle;
        double x = Math.cos(direction);
        double y = Math.sin(direction);

        bounds[0] = Math.min(0.0,x);
        bounds[1] = Math.min(0.0,y);
        bounds[2] = Math.max(0.0,x);
        bounds[3] = Math.max(0.0,y);

        int baseSize = base.length+1;
        for (int i = 1; i <= turns; i++) {
            int turnN = i;
            while (turnN % baseSize == 0) {
                turnN /= baseSize;
            }
            if (mirrored) {
                if ((turnN/baseSize)%2==0) {
                    direction += base[turnN%baseSize-1];
                } else {
                    direction -= base[base.length-turnN%baseSize];
                }
            } else {
                direction += base[turnN%baseSize-1];
            }
            x += Math.cos(direction);
            y += Math.sin(direction);

            bounds[0] = Math.min(bounds[0],x);
            bounds[1] = Math.min(bounds[1],y);
            bounds[2] = Math.max(bounds[2],x);
            bounds[3] = Math.max(bounds[3],y);
        }
    }

    public Fractal setOptimalAngle() {

        int levels = 5;
        int divisions = 5;
        double minAngle = 0;
        double maxAngle = Math.toRadians(360);
        double bestAngle = 0;
        double maxArea = 0;

        for (int i = 0; i < levels; i++) {
            double dAngle = (maxAngle-minAngle)/divisions;
            for (int j = 0; j <= divisions; j++) {
                angle = minAngle + dAngle * j;
                setBounds();
                double dx = bounds[2]-bounds[0];
                double dy = bounds[3]-bounds[1];
                double area;
                if (dy * width > height * dx) {
                    area = height * height * dx / dy;
                } else {
                    area = width * width * dy / dx;
                }
                if (area > maxArea) {
                    maxArea = area;
                    bestAngle = angle;
                }
            }
            minAngle = bestAngle - dAngle;
            maxAngle = bestAngle + dAngle;
        }
        angle = bestAngle;
        setBounds();
        return this;
    }

}
