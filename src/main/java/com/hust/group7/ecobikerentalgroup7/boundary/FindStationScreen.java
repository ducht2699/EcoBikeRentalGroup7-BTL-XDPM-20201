/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.boundary;


import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Station;
import com.hust.group7.ecobikerentalgroup7.Entity.User;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.hust.group7.ecobikerentalgroup7.MainEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FindStationScreen extends javax.swing.JFrame {

    /**
     * Creates new form FindStationScreen
     */
    private JFrame backScreen;
    private ArrayList<Station> arrStation;
    private DataBase db;
    private User user;
    private Station passStation;

    public FindStationScreen(User user, JFrame backScreen) throws SQLException {
        initComponents();
        this.backScreen = backScreen;
        this.db = new DataBase();
        this.user = user;
        showInfoTable();
        sortTable();
    }

    public void showInfoTable() throws SQLException {
        arrStation = new ArrayList<>();
        try {
            String sqlString = "select * from stations";
            ResultSet rs = db.query(sqlString);
            while (rs.next()) {
            	System.out.println("set station" + rs.getString("name"));
                Station s = new Station();
                s.setStationId(rs.getInt("id"));
                s.setName(rs.getString("name"));         
                s.setAddress(rs.getString("address"));
                s.setDistance(rs.getFloat("distance_to_walk"));
                s.setTime(rs.getFloat("time_to_walk"));
                s.setNumberOfDocks(rs.getInt("number_of_docks"));
                arrStation.add(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        DefaultTableModel model = (DefaultTableModel) stationListTable.getModel();
        System.out.println("set Model here" + arrStation.size());
        model.fireTableDataChanged();
        for (int i = 0; i < arrStation.size(); i++) {
            Station s = arrStation.get(i);

        

            String sqlGetBikeAvailable = "select * from bikes  where station_id='" + s.getStationId() + "' and status='0'";
            int numbikeAvailable = db.getRow(sqlGetBikeAvailable);
            System.out.println("num bike avail: " + numbikeAvailable);
            s.setNumberOfEmptyDocks(s.getNumberOfDocks()-numbikeAvailable);

            model.addRow(new Object[]{i + 1, s.getName(), s.getDistance()+ " m", s.getAddress(), s.getNumberOfEmptyDocks()});
            System.out.println("add row" + s.getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        stationListTable = new javax.swing.JTable();
        textFieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonViewStationInfo = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find Station");
        setResizable(false);

        stationListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Station Name", "Distance(m)", "Address", "Bike Avail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stationListTable.setToolTipText("");
        stationListTable.setRowHeight(18);
        stationListTable.setRowMargin(2);
        stationListTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(stationListTable);
        if (stationListTable.getColumnModel().getColumnCount() > 0) {
            stationListTable.getColumnModel().getColumn(0).setResizable(false);
            stationListTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            stationListTable.getColumnModel().getColumn(1).setResizable(false);
            stationListTable.getColumnModel().getColumn(1).setPreferredWidth(160);
            stationListTable.getColumnModel().getColumn(2).setResizable(false);
            stationListTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            stationListTable.getColumnModel().getColumn(3).setPreferredWidth(250);
            stationListTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Search Station");

        buttonViewStationInfo.setText("View Station Info");
        buttonViewStationInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonViewStationInfoActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(backButton)
                        .addGap(28, 28, 28)
                        .addComponent(buttonViewStationInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldSearch)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonViewStationInfo)
                    .addComponent(backButton))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSearchActionPerformed

    private void buttonViewStationInfoActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_buttonViewStationInfoActionPerformed
        int column = 1;
        int row = stationListTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "You have not choose station");
        } else {
            String value = stationListTable.getModel().getValueAt(row, column).toString();
            
            arrStation.forEach((Station s) -> {
                if (s.getName().equals(value)) {
                    passStation = s;
                }
            });
            MainEntry.move(this, new StationInfoScreen(this, user, passStation));
            System.out.println("value: " + value);;
        }
    }//GEN-LAST:event_buttonViewStationInfoActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainEntry.move(this, backScreen);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sortTable() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(stationListTable.getModel());
        stationListTable.setRowSorter(sorter);
        textFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textFieldSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textFieldSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton buttonViewStationInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stationListTable;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
