package dhh.presentation;

import dhh.domain.manageDish;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManageDishFrame extends JFrame {
    public ManageDishFrame(){
        JFrame frame = new OrderFrame();
        frame.setSize(400, 425);
        frame.setTitle("De Hartige Hap Keuken - Nieuw Gerecht");
        JPanel panel = new ManageDishPanel();
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public ManageDishFrame(manageDish currentDish){
        JFrame frame = new OrderFrame();
        frame.setSize(400, 425);
        frame.setTitle("De Hartige Hap Keuken - Beheer " + currentDish.getName().toLowerCase());
        JPanel panel = new ManageDishPanel(currentDish);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
