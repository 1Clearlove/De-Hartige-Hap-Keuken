package dhh.presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import dhh.businesslogic.LoginManager;
import dhh.businesslogic.EmailValidator;
import dhh.datastorage.DishDAO;
import java.sql.ResultSet;

public class loginPanel extends javax.swing.JPanel {

    private String email;
    boolean valid;
    
    /**
     * Creates new form loginPanel
     */
    public loginPanel() {
        initComponents();
        JFrame frame = getParentFrame();
        if (frame!=null) frame.getRootPane().setDefaultButton(btnLogin);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbEmployeeCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("De Hartige Hap Keuken");

        tbEmployeeCode.setText("jandehaan@gmail.com");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Medewerkerscode");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbEmployeeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbEmployeeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addContainerGap(342, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
      
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LogIn();
    }//GEN-LAST:event_btnLoginActionPerformed
                                    
    public void LogIn(){
        email = tbEmployeeCode.getText();
        EmailValidator validator = new EmailValidator();
        valid = validator.validate(email);
        
        if(valid == true) {
            LoginManager Lmanager = new LoginManager();
            if(Lmanager.checkLogin(email).equals("")){
                JOptionPane.showMessageDialog(this, "This email address does not belong to a master chef");
            }else{
                if(email.equals(Lmanager.checkLogin(email))){
                    JFrame frame = getParentFrame();
                    frame.dispose();
                    OrderFrame hframe = new OrderFrame();
                    hframe.createPanel();
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "This is not a valid email address!");
        }        
    }
    
    private JFrame getParentFrame()
    {
        return (JFrame) SwingUtilities.getWindowAncestor(this);
    }
    
    public javax.swing.JButton getDefaultButton()
    {
        return btnLogin;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tbEmployeeCode;
    // End of variables declaration//GEN-END:variables
}
