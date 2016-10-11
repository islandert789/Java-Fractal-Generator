import javax.swing.*;

public class MainFrame extends JFrame {
    public MainPanel panel;

    public MainFrame(int width, int height, Fractal f) {
        super("Fractal");
        panel = new MainPanel(f);
        this.add(panel);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
