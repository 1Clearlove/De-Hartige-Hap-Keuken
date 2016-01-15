package dhh.presentation;

import dhh.businesslogic.OrderManager;
import dhh.domain.Dish;
import dhh.domain.Order;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import dhh.businesslogic.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class OrderPanel extends javax.swing.JPanel {
    /**
     * Creates new form HartigPanel
     */
    
    private DefaultTableModel dishTableModel;
    
    public OrderPanel() {
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
        jButton2 = new javax.swing.JButton();

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

        jButton2.setText("Beheer gerechten");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManageDishesFrame manageDishesFrame = new ManageDishesFrame();
        manageDishesFrame.createPanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fillTable() { //TIMER INBOUWEN
        dishTableModel = new DefaultTableModel();
        jTable1.setModel(dishTableModel);
        dishTableModel.addColumn("Tafelnummer");
        dishTableModel.addColumn("Aantal");
        dishTableModel.addColumn("Gerecht");
        dishTableModel.addColumn("Besteld"); 
        dishTableModel.addColumn("Opmerkingen");                              
        dishTableModel.addColumn("Gereed melden"); 
        OrderManager manager = new OrderManager();
        

        jTable1.getColumnModel().getColumn(0).setMinWidth(100);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        
        jTable1.getColumnModel().getColumn(1).setMinWidth(60);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
        
        jTable1.getColumnModel().getColumn(2).setMinWidth(200);
        
        jTable1.getColumnModel().getColumn(3).setMinWidth(60);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(60);      
        
        jTable1.getColumnModel().getColumn(4).setMinWidth(200);
        
        jTable1.getColumnModel().getColumn(5).setMinWidth(200);
        
        Action readyDish = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                //manager.readyDish(dish);
                JOptionPane.showMessageDialog(jButton1, "Gerecht is gereed gemeld!");
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn((jTable1), readyDish, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        ArrayList<Order> orderList = manager.generateDishOrderList();
        
        for (Order currentOrder : orderList) {
            for (Dish currentDish : currentOrder.getDishes()) {
                dishTableModel.addRow(new Object[]{currentOrder.getTableNumber(), currentDish.getAmount(), currentDish.getName(), currentDish.getOrderTime(), currentDish.getComment(), "Gereed melden"});
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
