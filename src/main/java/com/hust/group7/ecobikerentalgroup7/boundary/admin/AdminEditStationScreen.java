/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.boundary.admin;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Station;
import com.hust.group7.ecobikerentalgroup7.Entity.User;
import com.hust.group7.ecobikerentalgroup7.MainEntry;
import com.hust.group7.ecobikerentalgroup7.boundary.ViewListBikeScreen;
import com.hust.group7.ecobikerentalgroup7.boundary.ViewListBikeScreen;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminEditStationScreen extends javax.swing.JFrame {

    /**
     * Creates new form StationInfoScreen
     */
    private JFrame backScreen;
    private Station station;
    private User user;
    private DataBase db;

    public AdminEditStationScreen(JFrame backScreen, User user, Station station) throws SQLException {
        initComponents();
        this.station = station;
        this.user = user;
        System.out.println("station name info: " + station.getName());
        this.backScreen = backScreen;
        showStationInfo();
        imageMap.showImage(new File("station.jpg"));
        db = new DataBase();
    }

    private void showStationInfo() {
        DefaultTableModel model = (DefaultTableModel) stationInfoTable.getModel();
        System.out.println("set model infor");
        model.setValueAt(station.getName(), 0, 1);
        model.setValueAt(station.getAddress(), 1, 1);
        model.setValueAt(station.getNumberOfEmptyDocks(), 2, 1);
        stationNameTitle.setText(station.getName());

        model.fireTableDataChanged();
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stationNameTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stationInfoTable = new javax.swing.JTable();
        buttonViewbikelist = new javax.swing.JButton();
        imageMap = new com.hust.group7.ecobikerentalgroup7.boundary.ImageCodePanel();
        backButton = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Station");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        stationNameTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        stationNameTitle.setText("Station name");

        stationInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Name station", null},
                {"Address", null},
                {"Area", null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stationInfoTable.setColumnSelectionAllowed(true);
        stationInfoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(stationInfoTable);
        stationInfoTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (stationInfoTable.getColumnModel().getColumnCount() > 0) {
            stationInfoTable.getColumnModel().getColumn(0).setResizable(false);
            stationInfoTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            stationInfoTable.getColumnModel().getColumn(1).setResizable(false);
            stationInfoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        buttonViewbikelist.setText("View list bike");
        buttonViewbikelist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewbikelistActionPerformed(evt);
            }
        });

        imageMap.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout imageMapLayout = new javax.swing.GroupLayout(imageMap);
        imageMap.setLayout(imageMapLayout);
        imageMapLayout.setHorizontalGroup(
            imageMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        imageMapLayout.setVerticalGroup(
            imageMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stationNameTitle)
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonViewbikelist))
                            .addComponent(imageMap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(stationNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonViewbikelist)
                    .addComponent(backButton)
                    .addComponent(btnSave))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backButtonActionPerformed

    private void buttonViewbikelistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewbikelistActionPerformed
        try {
            MainEntry.move(this, new AdminManageBikes(this, user, station));
        } catch (SQLException ex) {
            Logger.getLogger(AdminEditStationScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonViewbikelistActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) stationInfoTable.getModel();
        model.fireTableDataChanged();
        String stationName = model.getValueAt(0, 1).toString();
        String stationAddress = model.getValueAt(1, 1).toString();
        String stationArea = model.getValueAt(2, 1).toString();

        String sql = "UPDATE stations SET name = '" + stationName + "', address = '" + stationAddress + "'" + " WHERE id = " + station.getStationId();

        try {
            db.update(sql);
            JOptionPane.showMessageDialog(this, "Saved!");
            MainEntry.move(this, new AdminManageStation(user, new AdminHomeScreen(user, null)));
        } catch (SQLException ex) {
            System.out.println("ERROR! SQL");
            Logger.getLogger(AdminEditStationScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton buttonViewbikelist;
    private com.hust.group7.ecobikerentalgroup7.boundary.ImageCodePanel imageMap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stationInfoTable;
    private javax.swing.JLabel stationNameTitle;
    // End of variables declaration//GEN-END:variables
}
