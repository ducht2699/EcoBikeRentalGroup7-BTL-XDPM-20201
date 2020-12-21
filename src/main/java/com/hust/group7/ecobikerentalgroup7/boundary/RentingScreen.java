/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.boundary;

import com.hust.group7.ecobikerentalgroup7.Constants;
import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.Entity.Transaction;
import com.hust.group7.ecobikerentalgroup7.Entity.User;
import com.hust.group7.ecobikerentalgroup7.MainEntry;
import static com.hust.group7.ecobikerentalgroup7.boundary.HomeScreen.user;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RentingScreen extends javax.swing.JFrame {

    /**
     * Creates new form Renting
     */
    private JFrame backScreen;
    private Bike bike;
    private User user;
    private Transaction transaction;
    private DataBase db;
    private long money = 0;

    public RentingScreen(Transaction transaction, User user, Bike bike, JFrame backScreen) throws SQLException {
        initComponents();
        this.backScreen = backScreen;
        this.bike = bike;
        this.user = user;
        this.transaction = transaction;
        this.db = new DataBase();
        try {
            showInfoTable(transaction, bike);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showInfoTable(Transaction transaction, Bike bike) throws ParseException {

        DefaultTableModel model = (DefaultTableModel) rentingBikeTable.getModel();
        System.out.println("set Model here");
        model.setValueAt(bike.getName(), 0, 1);
        model.setValueAt(bike.getType(), 1, 1);
        model.setValueAt(bike.getWeight(), 2, 1);
        model.setValueAt(bike.getLicensePlate(), 3, 1);
        model.setValueAt(bike.getManufacturingDate(), 4, 1);
        model.setValueAt(bike.getProducer(), 5, 1);
        model.setValueAt(bike.getBateryPercentage(), 6, 1);
        model.setValueAt(bike.getLoadCycles(), 7, 1);
        model.setValueAt(transaction.getStartTime(), 8, 1);
        model.setValueAt(bike.getBarcode(), 9, 1);
        if (bike.getStatus() == 0) {
            model.setValueAt("Available", 10, 1);
        } else {
            model.setValueAt("Renting", 10, 1);
        }
        //TODO: set sattion name
        String sql = "SELECT * FROM stations WHERE id = " + bike.getStationId();
        try {
            ResultSet rs = db.query(sql);
            rs.next();
            model.setValueAt(rs.getString("name"), 11, 1);

            sql = "SELECT * FROM cost WHERE bike_type = '" + bike.getType() + "'";
            rs = db.query(sql);
            rs.next();
            model.setValueAt(rs.getFloat("deposit"), 12, 1);
        } catch (SQLException ex) {
            Logger.getLogger(RentingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        String startTimeString = transaction.getStartTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = formatter.parse(startTimeString);
        Timer t = new Timer();

        t.scheduleAtFixedRate(
                new TimerTask() {
            public void run() {
                long currentTime = System.currentTimeMillis();
                long rentingTime = currentTime - startTime.getTime();
//                	long day = TimeUnit.MILLISECONDS.toDays(rentingTime);
                long hour = rentingTime / (1000 * 60 * 60);
                long minutes = (rentingTime / (1000 * 60)) % 60;
                long seconds = (rentingTime / (1000)) % 60;

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                transaction.setEndTime(dtf.format(now));

                String timeRentingString = Long.toString(hour) + ":" + Long.toString(minutes) + ":" + Long.toString(seconds);
                rentingTimeField.setText(timeRentingString);

                long timeMinu = rentingTime / (1000 * 60);
                long amountPayment = 0;
                if (timeMinu <= 10) {
                    amountPayment = 10;
                } else {
                    timeMinu -= 10;
                    if (timeMinu <= 30) {
                        amountPayment = (long) ((float) timeMinu / 30 * 10);
                    } else {
                        timeMinu -= 30;
                        amountPayment = 10 + timeMinu / 15 * 3;
                    }
                }
                money = amountPayment * 1000;
                String amountPaymentString = Long.toString(amountPayment);
                if (amountPayment != 0) {
                    amountPaymentString += "000 VND";
                } else {
                    amountPaymentString += " VND";
                }
                model.setValueAt(amountPaymentString, 8, 1);
            }
        },
                0, // run first occurrence immediatetly
                1000);
        System.out.println(System.getProperty("user.dir") + bike.getImage());
        imageCodePanel.showImage(new File(this.bike.getImage()));
        imageCodePanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rentingBikeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        imageCodePanel = new com.hust.group7.ecobikerentalgroup7.boundary.ImageCodePanel();
        rentingTimeLabel = new javax.swing.JLabel();
        rentingTimeField = new javax.swing.JTextField();
        backButton = new javax.swing.JToggleButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Renting Information");
        setResizable(false);

        rentingBikeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Name", null},
                {"Bike Type", null},
                {"Weight", null},
                {"License Plate", null},
                {"Manufacturing Date", null},
                {"Producer", null},
                {"Battery Percentage", null},
                {"Load Cycles", null},
                {"Money count", null},
                {"Barcode", null},
                {"Status", null},
                {"Station", null},
                {"Price", null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rentingBikeTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Renting Information");

        javax.swing.GroupLayout imageCodePanelLayout = new javax.swing.GroupLayout(imageCodePanel);
        imageCodePanel.setLayout(imageCodePanelLayout);
        imageCodePanelLayout.setHorizontalGroup(
            imageCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );
        imageCodePanelLayout.setVerticalGroup(
            imageCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        rentingTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rentingTimeLabel.setText("Renting Time:");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Return Bike");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rentingTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rentingTimeField))
                            .addComponent(returnButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rentingTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentingTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(returnButton))
                .addGap(55, 55, 55))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed

        try {

            EnterStationScreen scs = new EnterStationScreen(transaction, user, bike, backScreen, this.money);
            MainEntry.move(this, scs);

        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_returnButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton backButton;
    private com.hust.group7.ecobikerentalgroup7.boundary.ImageCodePanel imageCodePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rentingBikeTable;
    private javax.swing.JTextField rentingTimeField;
    private javax.swing.JLabel rentingTimeLabel;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
