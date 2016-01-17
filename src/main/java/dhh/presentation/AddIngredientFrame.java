package dhh.presentation;

import dhh.domain.manageDish;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddIngredientFrame extends JFrame {
    public void createPanel(manageDish currentDish){
        JFrame frame = new AddIngredientFrame();
        frame.setSize(325, 150);
        frame.setTitle("De Hartige Hap Keuken - Ingrediënt toevoegen");
        JPanel panel = new AddIngredientPanel(currentDish);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
