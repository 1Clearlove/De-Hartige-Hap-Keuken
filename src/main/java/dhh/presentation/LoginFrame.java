package dhh.presentation;

import javax.swing.*;

public class LoginFrame extends JFrame{
    
    public void createPanel() {
        JFrame frame = new LoginFrame();
        frame.setTitle("De Hartige Hap Keuken - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setResizable(false);                  
        JPanel panel = new LoginPanel();
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
