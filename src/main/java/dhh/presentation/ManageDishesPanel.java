package dhh.presentation;

import dhh.businesslogic.ManageManager;
import dhh.domain.manageDish;
import java.awt.Font;
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
        
        jTable1.setFont(new Font(jTable1.getFont().getFontName(), Font.PLAIN, 20));
        jTable1.setRowHeight(jTable1.getRowHeight()+jTable1.getFont().getSize()); //Set the row height for each row to fit the current font size
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Voeg gerecht toe");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManageDishFrame newDishFrame = new ManageDishFrame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fillTable() {
        ordersTableModel = new DefaultTableModel();
        jTable1.setModel(ordersTableModel);
        ordersTableModel.addColumn("Gerechtnaam"); 
        ordersTableModel.addColumn("Bereidingstijd");
        ordersTableModel.addColumn("Gang"); 
        ordersTableModel.addColumn("Handelingen"); 
        
        jTable1.getColumnModel().getColumn(1).setMinWidth(100);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        
        ManageManager manager = new ManageManager();
        ArrayList<manageDish> dishList = manager.getDishes();
        
        for (manageDish currentDish : dishList) {
            ordersTableModel.addRow(new Object[]{currentDish.getName(), currentDish.getPreparationTime()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
