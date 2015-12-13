package dhh.presentation;

import dhh.businesslogic.ManageManager;
import dhh.domain.manageDish;
import java.awt.Font;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ManageDishesPanel extends javax.swing.JPanel {
    /**
     * Creates new form HartigPanel
     */
    
    private DefaultTableModel ordersTableModel;
    
    public ManageDishesPanel() {
        initComponents();        
        fillTable();
        
        tblDishes.setFont(new Font(tblDishes.getFont().getFontName(), Font.PLAIN, 20));
        tblDishes.setRowHeight(tblDishes.getRowHeight()+tblDishes.getFont().getSize()); //Set the row height for each row to fit the current font size
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDishes = new javax.swing.JTable();
        btnAddDish = new javax.swing.JButton();

        tblDishes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDishes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDishesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDishes);

        btnAddDish.setText("Voeg gerecht toe");
        btnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddDish)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAddDish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDishActionPerformed
        ManageDishFrame newDishFrame = new ManageDishFrame();
    }//GEN-LAST:event_btnAddDishActionPerformed

    private void tblDishesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDishesMouseClicked
        int selectedRowIndex = tblDishes.getSelectedRow();
        String dishName = (String)tblDishes.getModel().getValueAt(selectedRowIndex, 0);
        Time dishPreparationTime = (Time)tblDishes.getModel().getValueAt(selectedRowIndex, 1);
        String dishCourse = (String)tblDishes.getModel().getValueAt(selectedRowIndex, 2);

        ManageDishFrame editDishFrame = new ManageDishFrame(new manageDish(dishName, dishPreparationTime));
    }//GEN-LAST:event_tblDishesMouseClicked

    private void fillTable() {
        ordersTableModel = new DefaultTableModel();
        tblDishes.setModel(ordersTableModel);
        ordersTableModel.addColumn("Gerechtnaam"); 
        ordersTableModel.addColumn("Bereidingstijd");
        ordersTableModel.addColumn("Gang"); 
        ordersTableModel.addColumn("Handelingen"); 
        
        tblDishes.getColumnModel().getColumn(1).setMinWidth(100);
        tblDishes.getColumnModel().getColumn(1).setMaxWidth(100);
        
        ManageManager manager = new ManageManager();
        ArrayList<manageDish> dishList = manager.getDishes();
        
        for (manageDish currentDish : dishList) {
            ordersTableModel.addRow(new Object[]{currentDish.getName(), currentDish.getPreparationTime()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDish;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDishes;
    // End of variables declaration//GEN-END:variables
}
