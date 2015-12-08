package dhh.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderFrame extends JFrame {
    public void createPanel(){
        JFrame frame = new OrderFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("De Hartige Hap Keuken");
        JPanel panel = new OrderPanel();
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
