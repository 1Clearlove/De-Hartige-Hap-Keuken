package dhh.presentation;

import dhh.businesslogic.ManageManager;
import dhh.domain.Ingredient;
import dhh.domain.manageDish;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageDishPanel extends javax.swing.JPanel {
    manageDish currentDish;
    ManageManager manager;
    
    public ManageDishPanel() {
        initComponents();
        
        manager = new ManageManager();
        
        ArrayList<String> courseList = manager.getCourses();
        ArrayList<String> categoryList = manager.getCategories();
        
        for (String currentCourse : courseList) {
            cmbCourse.addItem(currentCourse);
        }
        
        for (String currentCategory : categoryList) {
            cmbCategory.addItem(currentCategory);
        }
    }
    
    public ManageDishPanel(manageDish currentDish) {
        initComponents();
        this.currentDish = currentDish;
        
        manager = new ManageManager();
        
        txtDishName.setText(currentDish.getName());
        txtPreparationTime.setText(currentDish.getPreparationTime().toString());
        txtDescription.setText(currentDish.getDescription());
        
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        txtPrice.setText(String.valueOf(df.format(currentDish.getPrice())));
        
        ArrayList<String> courseList = manager.getCourses();
        ArrayList<String> categoryList = manager.getCategories();
        
        for(int i = 0; i < courseList.size(); i++) {
            cmbCourse.addItem(courseList.get(i));
            if(cmbCourse.getItemAt(i).toString().equals(currentDish.getCourse())){
                cmbCourse.setSelectedIndex(i);
            }
        }
        
        for(int i = 0; i < categoryList.size(); i++) {
            cmbCategory.addItem(categoryList.get(i));
            if(cmbCategory.getItemAt(i).toString().equals(currentDish.getCategory())){
                cmbCategory.setSelectedIndex(i);
            }
        }
        
        
        DefaultTableModel ingredientTableModel = new DefaultTableModel();
        tblIngredients.setModel(ingredientTableModel);
        ingredientTableModel.addColumn("Ingrediëntnaam"); 
        ingredientTableModel.addColumn("Hoeveelheid");
        
        tblIngredients.getColumnModel().getColumn(1).setMinWidth(100);
        tblIngredients.getColumnModel().getColumn(1).setMaxWidth(100);
        
        ArrayList<Ingredient> ingredientsList = manager.getIngredients(currentDish.getName());
        
        if(ingredientsList.size() > 0){
            for (Ingredient currentIngredient : ingredientsList) {
                ingredientTableModel.addRow(new Object[]{currentIngredient.getName(), currentIngredient.getAmount() + " " + currentIngredient.getMeasurement()});
            }
        }
        else
            ingredientTableModel.addRow(new Object[]{"Geen ingrediënten gevonden"});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDishName = new javax.swing.JTextField();
        txtPreparationTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIngredients = new javax.swing.JTable();
        btnAddIngredient = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Gerechtnaam");

        txtDishName.setToolTipText("");

        txtPreparationTime.setText("00:00:00");
        txtPreparationTime.setToolTipText("");

        jLabel2.setText("Bereidingstijd");

        jLabel3.setText("Gang");

        cmbCourse.setToolTipText("");

        jLabel4.setText("Ingrediënten");

        tblIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblIngredients);

        btnAddIngredient.setText("Wijzig ingrediënten");

        btnSave.setText("Bewerk");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cmbCategory.setToolTipText("");

        jLabel5.setText("Categorie");

        jLabel6.setText("Beschrijving");

        jScrollPane3.setViewportView(txtDescription);

        jLabel7.setText("Prijs");

        txtPrice.setText("0.00");

        jLabel8.setText("€");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDishName)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cmbCourse, 0, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPreparationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddIngredient))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDishName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreparationTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnAddIngredient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Time timeValue = null;
        double priceValue = 0.00;
        JFrame parentFrame = (JFrame)javax.swing.SwingUtilities.getWindowAncestor(this);
        
        try {
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            timeValue = new java.sql.Time(formatter.parse(txtPreparationTime.getText()).getTime());
            
            priceValue = Double.parseDouble(txtPrice.getText());
        }
        catch (Exception exc){
            System.out.println(exc);
        }
        
        if(currentDish == null){
            if(manager.insertDish(new manageDish(txtDishName.getText(), priceValue, txtDescription.getText(), cmbCourse.getSelectedItem().toString(), cmbCategory.getSelectedItem().toString(), timeValue))) {
                JOptionPane.showMessageDialog(null, "Het gerecht is succesvol toegevoegd.", txtDishName.getText() + " is toegevoegd.", JOptionPane.INFORMATION_MESSAGE);
                parentFrame.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Het gerecht kon niet worden toegevoegd.", "Het gerecht is niet toegevoegd, neem contact op met uw leidinggevende.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(manager.updateDish(currentDish.getName(), new manageDish(txtDishName.getText(), priceValue, txtDescription.getText(), cmbCourse.getSelectedItem().toString(), cmbCategory.getSelectedItem().toString(), timeValue))) {
                JOptionPane.showMessageDialog(null, "Het gerecht is succesvol aangepast.", txtDishName.getText() + " is aangepast.", JOptionPane.INFORMATION_MESSAGE);
                parentFrame.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Het gerecht kon niet worden aangepast.", "Het gerecht is niet aangepast, neem contact op met uw leidinggevende.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIngredient;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JComboBox cmbCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblIngredients;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JTextField txtDishName;
    private javax.swing.JTextField txtPreparationTime;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
