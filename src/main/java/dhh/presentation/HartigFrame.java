package dhh.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HartigFrame extends JFrame {
    public void createPanel(){
        JFrame frame = new HartigFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("De Hartige Hap Keuken");
        JPanel panel = new HartigPanel();
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
