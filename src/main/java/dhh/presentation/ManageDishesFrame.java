package dhh.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManageDishesFrame extends JFrame {
    public void createPanel(){
        JFrame frame = new OrderFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setTitle("De Hartige Hap Keuken - Beheer gerechten");
        JPanel panel = new ManageDishesPanel();
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
