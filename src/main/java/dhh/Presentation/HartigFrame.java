package dhh.Presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HartigFrame extends JFrame {
    public void createPanel(){
        JFrame frame = new HartigFrame();
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("De Hartige Hap - Keuken Module");
        JPanel panel = new HartigPanel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
