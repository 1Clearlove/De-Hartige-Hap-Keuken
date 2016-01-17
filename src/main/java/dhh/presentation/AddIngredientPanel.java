package dhh.presentation;

import dhh.businesslogic.ManageManager;
import dhh.domain.manageDish;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AddIngredientPanel extends javax.swing.JPanel {
    private manageDish currentDish;
    private ManageManager manager;    
    public AddIngredientPanel(manageDish currentDish) {         
        initComponents();
        this.currentDish = currentDish;
        
        manager = new ManageManager();
        
        ArrayList<String> ingredientList = manager.getAllIngredients();
        
        for (String currentIngredient : ingredientList) {
            cmbIngredients.addItem(currentIngredient);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIngredient = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        cmbIngredients = new javax.swing.JComboBox();
        btnAddIngredient = new javax.swing.JButton();
        txtAmount = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(300, 91));
        setPreferredSize(new java.awt.Dimension(300, 91));

        lblIngredient.setText("Ingrediënt:");

        lblAmount.setText("Hoeveelheid:");

        cmbIngredients.setPreferredSize(new java.awt.Dimension(200, 20));

        btnAddIngredient.setText("Ingrediënt toevoegen");
        btnAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIngredientActionPerformed(evt);
            }
        });

        txtAmount.setMinimumSize(new java.awt.Dimension(75, 20));
        txtAmount.setPreferredSize(new java.awt.Dimension(75, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIngredient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmount))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddIngredient)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngredient)
                    .addComponent(lblAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddIngredient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIngredientActionPerformed
        try {
            Double.parseDouble(txtAmount.getText());
            if(manager.addIngredientToDish(currentDish.getName(), cmbIngredients.getSelectedItem().toString(), Double.parseDouble(txtAmount.getText()))) {
                JOptionPane.showMessageDialog(null, "Het ingrediënt is succesvol toegevoegd.", "" + currentDish.getName() + " is toegevoegd.", JOptionPane.INFORMATION_MESSAGE);
                JFrame frame = getParentFrame();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Er is iets fout gegaan, neem contact op met uw leidinggegevende.", "Er is iets fout gegaan.", JOptionPane.INFORMATION_MESSAGE);
            }   
       }
       catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "De ingevoerde hoeveelheid is niet correct ingevoerd.", "Controleer uw invoer.", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_btnAddIngredientActionPerformed

    private JFrame getParentFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor(this);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIngredient;
    private javax.swing.JComboBox cmbIngredients;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblIngredient;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
