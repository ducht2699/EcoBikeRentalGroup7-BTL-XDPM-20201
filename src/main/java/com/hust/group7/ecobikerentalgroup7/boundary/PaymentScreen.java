/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.boundary;

import com.hust.group7.ecobikerentalgroup7.Constants;
import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.Entity.PaymentMethod;
import com.hust.group7.ecobikerentalgroup7.Entity.Transaction;
import com.hust.group7.ecobikerentalgroup7.Entity.User;
import com.hust.group7.ecobikerentalgroup7.MainEntry;
import com.hust.group7.ecobikerentalgroup7.controller.RentBikeController;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PaymentScreen extends javax.swing.JFrame {

    private RentBikeController rbc;
    private JFrame backScreen;
    private PaymentMethod[] paymentMethod;
    private DataBase db;
    private String[] nameMethod;
    private static HttpURLConnection connection;
    private Bike bike;
    private User user;
    private Transaction transaction;
    private boolean isPayDeposit = false;

    public PaymentScreen(User user, Bike bike, JFrame backScreen) throws SQLException, Exception {
        initComponents();
        rbc = new RentBikeController();
        this.db = new DataBase();
        this.backScreen = backScreen;
        this.bike = bike;
        this.user = user;
        rbc.showInfoDeposit(bike, valueBikeModel, valueBike, valueDeposit);
        getPaymentMethod();
        btnConfirm.setEnabled(false);
    }

    private void getPaymentMethod() {
        try {
            String sqlString = "select * from payment_methods WHERE user_id = " + user.getUserId();
            ResultSet rs = db.query(sqlString);
            int size = db.getRow(sqlString);
            paymentMethod = new PaymentMethod[size];
            nameMethod = new String[size];
            int i = 0;
            while (rs.next()) {
                paymentMethod[i] = new PaymentMethod();
                paymentMethod[i].setMethodID(rs.getInt("payment_id"));
                paymentMethod[i].setVirtual_acount_id(rs.getInt("virtual_account_id"));
                sqlString = "select * from virtual_accounts WHERE account_id = " + paymentMethod[i].getVirtual_acount_id();
                ResultSet rs2 = db.query(sqlString);
                while (rs2.next()) {
                    paymentMethod[i].setCardholderName(rs2.getString("card_holder_name"));
                    paymentMethod[i].setCardNumber(rs2.getString("card_number"));
                    paymentMethod[i].setIssuingBank(rs2.getString("issuing_bank"));
                    paymentMethod[i].setExpirationDate(rs2.getDate("expiration_date").toString());
                    paymentMethod[i].setSecurityCode(rs2.getInt("cvv"));
                    paymentMethod[i].setRemainingAmount(rs2.getFloat("amount_money"));
                    nameMethod[i] = rs2.getString("issuing_bank") + " - " + rs2.getString("card_number");
                }
                i++;
            }
            depositComboBox.setModel(new DefaultComboBoxModel(nameMethod));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        depositComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        confirmCheckBox = new javax.swing.JCheckBox();
        bikeModelLabel = new javax.swing.JLabel();
        valueBikeLabel = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        valueBikeModel = new javax.swing.JLabel();
        valueBike = new javax.swing.JLabel();
        depositLabel = new javax.swing.JLabel();
        valueDeposit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDes = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payment");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        depositComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        depositComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Choose payment method");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("You have to pay deposit\nequal 40% bike's price\nAfter you return bike, you\nwill receive your deposit.");
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        confirmCheckBox.setText("Pay deposit");
        confirmCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCheckBoxActionPerformed(evt);
            }
        });

        bikeModelLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bikeModelLabel.setText("Bike to rent :");

        valueBikeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        valueBikeLabel.setText("Value of bike :");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        valueBikeModel.setText("MX_123");

        valueBike.setText("2.000.000 vnd");

        depositLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        depositLabel.setText("Deposit to pay :");

        valueDeposit.setText("800.000 vnd");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton2.setText("Add Payment Method");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMoveToAddPaymentMethodActionPerformed(evt);
            }
        });

        jLabel2.setText("If you don't have any payment method");

        jLabel3.setText("Description :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfDes))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2)
                        .addComponent(depositComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueBikeLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bikeModelLabel)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valueDeposit)
                                .addComponent(valueBike)
                                .addComponent(valueBikeModel))
                            .addComponent(btnConfirm, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(depositLabel)
                    .addComponent(confirmCheckBox))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(depositComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bikeModelLabel)
                            .addComponent(valueBikeModel))
                        .addGap(38, 38, 38)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueBikeLabel)
                    .addComponent(valueBike))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(depositLabel)
                            .addComponent(valueDeposit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(confirmCheckBox)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirm)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmCheckBoxActionPerformed
        // TODO add your handling code here:
        isPayDeposit = !isPayDeposit;
        if (isPayDeposit) {
            btnConfirm.setEnabled(true);
        } else {
            btnConfirm.setEnabled(false);
        }
    }//GEN-LAST:event_confirmCheckBoxActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        for (PaymentMethod pm : paymentMethod) {
            if ((pm.getIssuingBank() + " - " + pm.getCardNumber()).equals(depositComboBox.getSelectedItem())) {
                float deposit = 0;
                switch (bike.getType()) {
                    case "Bike":
                        deposit = 400000.0f;
                        break;
                    case "Twin Bike":
                        deposit = 550000.0f;
                        break;
                    case "EBike":
                        deposit = 700000.0f;
                        break;
                }
                if (pm.getRemainingAmount() >= deposit) {
                    pm.setRemainingAmount(pm.getRemainingAmount() - deposit);

                    try {
                        //set transaction
                        String sql = "INSERT INTO transactions (`id`, `bike_id`, `user_id`, `payment_method_id`, `end_time`, `status`, `description`, `deposit`) VALUES (null, "
                                + bike.getBikeId() + ", "
                                + user.getUserId() + ", "
                                + pm.getMethodID() + ", null, 1, '"
                                + tfDes.getText() + "', "
                                + deposit + ")";
                        db.insert(sql);
                        //decrease amount money
                        sql = "UPDATE virtual_accounts SET amount_money = " + pm.getRemainingAmount() + " WHERE account_id = " + pm.getVirtual_acount_id();
                        db.update(sql);
                        //update bike status
                        sql = "UPDATE bikes SET status = 1 " + "WHERE id = " + bike.getBikeId() ;
                        db.update(sql);
                        //update user status
                        sql = "UPDATE users SET status = 1 " + "WHERE ID = " + user.getUserId();
                        this.user.setStatus(1);
                        db.update(sql);
                        //home
                        JOptionPane.showMessageDialog(this, "Rent sucessfully!");
                        MainEntry.move(this, new HomeScreen(this.user, new LoginScreen()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PaymentScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Not enough money!");
                }

            }
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void depositComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositComboBoxActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backActionPerformed

    private void handleMoveToAddPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleMoveToAddPaymentMethodActionPerformed
        try {
            AddPayentMethodScreen addPayentMethodScreen = new AddPayentMethodScreen(user, bike, this);
            MainEntry.move(this, addPayentMethodScreen);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_handleMoveToAddPaymentMethodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bikeModelLabel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JCheckBox confirmCheckBox;
    private javax.swing.JComboBox<String> depositComboBox;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField tfDes;
    private javax.swing.JLabel valueBike;
    private javax.swing.JLabel valueBikeLabel;
    private javax.swing.JLabel valueBikeModel;
    private javax.swing.JLabel valueDeposit;
    // End of variables declaration//GEN-END:variables
}
