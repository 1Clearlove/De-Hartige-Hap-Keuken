/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dhh.Presentation;

import javax.swing.*;

public class LoginFrame extends JFrame{
    
    public void createPanel()
    {
        JFrame frame = new LoginFrame();
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        JPanel panel = new loginPanel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
