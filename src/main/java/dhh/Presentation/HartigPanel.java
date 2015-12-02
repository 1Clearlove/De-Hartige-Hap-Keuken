package dhh.Presentation;

import dhh.BusinessLogic.OrderManager;
import dhh.Domain.Dish;
import dhh.Domain.Order;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class HartigPanel extends javax.swing.JPanel {
    /**
     * Creates new form HartigPanel
     */
    
    private DefaultTableModel beverageTableModel;
    
    public HartigPanel() {
        initComponents();        
        fillTable();
        
        jTable1.setFont(new Font(jTable1.getFont().getFontName(), Font.PLAIN, 20));
        jTable1.setRowHeight(jTable1.getRowHeight()+jTable1.getFont().getSize()); //Set the row height for each row to fit the current font size
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fillTable() //TIMER INBOUWEN
    {
        beverageTableModel = new DefaultTableModel();
        jTable1.setModel(beverageTableModel);
        beverageTableModel.addColumn("Gerecht"); 
        beverageTableModel.addColumn("Hoeveelheid");
        beverageTableModel.addColumn("Ordernummer"); 
        beverageTableModel.addColumn("Tafelnummer"); 
        beverageTableModel.addColumn("Opmerkingen"); 
        beverageTableModel.addColumn("Handelingen"); 
        
        for(int i=1; i<4; i++){ //Loop through the columns with numbers to decrease their width
            jTable1.getColumnModel().getColumn(i).setMinWidth(100);
            jTable1.getColumnModel().getColumn(i).setMaxWidth(100);
        }
        
        OrderManager manager = new OrderManager();
        ArrayList<Order> orderList = manager.generateDishOrderList();
        
        for (Order currentOrder : orderList) {
            for (Dish currentDish : currentOrder.getDishes()) {
                beverageTableModel.addRow(new Object[]{currentDish.getName(), currentDish.getAmount(), currentOrder.getOrderNumber(), currentOrder.getTableNumber(), currentDish.getComment(), "Meer Info / Gereed"});
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
