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
import java.util.Timer;
import java.util.TimerTask;

public class OrderPanel extends javax.swing.JPanel {
    private DefaultTableModel dishTableModel;
    private int refreshTime = 15;
    private int currentTime;
    
    public OrderPanel() {
        initComponents();        
        refreshTable();
        
        tblOrders.setFont(new Font(tblOrders.getFont().getFontName(), Font.PLAIN, 20));
        tblOrders.setRowHeight(tblOrders.getRowHeight()+tblOrders.getFont().getSize()); //Set the row height for each row to fit the current font size
        
        setRefreshTableTimer();
    }

    private void setRefreshTableTimer(){ 
        currentTime = refreshTime;
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                currentTime--;
                btnRefresh.setText("Refresh (in " + Integer.toString(currentTime) + "s)");
                if(currentTime < 1) {
                    refreshTable();
                    currentTime = refreshTime;
                }
            }
        };

        timer.schedule(myTask, 1000, 1000); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnManageDishes = new javax.swing.JButton();

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOrders);

        btnManageDishes.setText("Beheer gerechten");
        btnManageDishes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDishesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnManageDishes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnManageDishes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnManageDishesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDishesActionPerformed
        ManageDishesFrame manageDishesFrame = new ManageDishesFrame();
        manageDishesFrame.createPanel();
    }//GEN-LAST:event_btnManageDishesActionPerformed

    private void refreshTable() {
        dishTableModel = new DefaultTableModel();
        tblOrders.setModel(dishTableModel);
        dishTableModel.addColumn("Tafelnummer");
        dishTableModel.addColumn("Aantal");
        dishTableModel.addColumn("Gerecht");
        dishTableModel.addColumn("Besteld"); 
        dishTableModel.addColumn("Opmerkingen");                              
        dishTableModel.addColumn("Gereed melden"); 
        OrderManager manager = new OrderManager();
        

        tblOrders.getColumnModel().getColumn(0).setMinWidth(100);
        tblOrders.getColumnModel().getColumn(0).setMaxWidth(100);
        
        tblOrders.getColumnModel().getColumn(1).setMinWidth(60);
        tblOrders.getColumnModel().getColumn(1).setMaxWidth(60);
        
        tblOrders.getColumnModel().getColumn(2).setMinWidth(200);
        
        tblOrders.getColumnModel().getColumn(3).setMinWidth(60);
        tblOrders.getColumnModel().getColumn(3).setMaxWidth(60);      
        
        tblOrders.getColumnModel().getColumn(4).setMinWidth(200);
        
        tblOrders.getColumnModel().getColumn(5).setMinWidth(200);
        
        Action readyDish = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                //manager.readyDish(dish);
                JOptionPane.showMessageDialog(btnRefresh, "Gerecht is gereed gemeld!");
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn((tblOrders), readyDish, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        ArrayList<Order> orderList = manager.generateDishOrderList();
        
        for (Order currentOrder : orderList) {
            for (Dish currentDish : currentOrder.getDishes()) {
                dishTableModel.addRow(new Object[]{currentOrder.getTableNumber(), currentDish.getAmount(), currentDish.getName(), currentDish.getOrderTime(), currentDish.getComment(), "Gereed melden"});
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageDishes;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}
