/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricesavvymart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class owner extends javax.swing.JFrame {

    /**
     * Creates new form owner
     */
    public owner() {
        initComponents();
        Connect();
        Fetch();
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pricesavvy_db","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void Fetch(){
        try {
        String storeId = storeidbox.getSelectedItem().toString(); // Get the selected store ID from the combo box

        // Check the store ID and select the appropriate table
        String tableName;
        if (storeId.equals("A1")) {
            tableName = "taskmart";
        } else if (storeId.equals("A2")) {
            tableName = "quickstore";
        } else {
            // Invalid store ID
            JOptionPane.showMessageDialog(this, "Invalid store ID!");
            return;
        }

        pst = con.prepareStatement("SELECT * FROM " + tableName);
        rs = pst.executeQuery();

        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);

        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getString("product_id"));
            v.add(rs.getString("product"));
            v.add(rs.getString("price"));
            v.add(rs.getString("quantity"));
            d.addRow(v);
        }
    } catch (SQLException ex) {
        Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpid = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtstoreid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtOwner = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        storeidbox = new javax.swing.JComboBox<>();
        btnselect = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("product name:");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("product price:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("   product Qty:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Product Id:");

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addGap(35, 35, 35)
                .addComponent(btnUpdate)
                .addGap(26, 26, 26)
                .addComponent(btnDelete)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "product ID", "Product Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("          Store id:");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("       Owner Id:");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("    Store id:");

        storeidbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2" }));

        btnselect.setText("Select");
        btnselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQty)
                    .addComponent(txtPrice)
                    .addComponent(txtPname)
                    .addComponent(txtstoreid)
                    .addComponent(txtOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(storeidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnselect)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storeidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnselect))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstoreid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSearch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        try {
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            String StoreId = txtstoreid.getText();
            String ownerId = txtOwner.getText();
            
            if (pname.isEmpty() || price.isEmpty() || qty.isEmpty() || StoreId.isEmpty() || ownerId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields!");
        return;
        }
            pst = con.prepareStatement("SELECT * FROM owner WHERE id = ? AND storeId = ?");
        pst.setString(1, ownerId);
        pst.setString(2, StoreId);
        rs = pst.executeQuery();
            
            if (rs.next()) {
            if (StoreId.equals("A1")) {
            pst = con.prepareStatement("INSERT INTO taskmart (product,price,quantity,store_id) VALUES(?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.setString(4, StoreId);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added successfully!!!");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtstoreid.setText("");
                txtOwner.setText("");
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to save!!");
            }
            }else if(StoreId.equals("A2")){
              pst = con.prepareStatement("INSERT INTO quickstore (product,price,quantity,store_id) VALUES(?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.setString(4, StoreId);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added successfully!!!");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtstoreid.setText("");
                txtOwner.setText("");
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to save!!");
            }  
            
           }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid owner ID or store ID. Authentication failed.");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
        String storeId = storeidbox.getSelectedItem().toString(); // Get the store ID from the text field
        String productId = txtpid.getSelectedItem().toString(); // Get the selected product ID

        // Check the store ID and select the appropriate table
        String tableName;
        if (storeId.equals("A1")) {
            tableName = "taskmart";
        } else if (storeId.equals("A2")) {
            tableName = "quickstore";
        } else {
            // Invalid store ID
            JOptionPane.showMessageDialog(this, "Invalid store ID!");
            return;
        }

        pst = con.prepareStatement("SELECT * FROM " + tableName + " WHERE product_id = ?");
        pst.setString(1, productId);
        rs = pst.executeQuery();

        if (rs.next()) {
            String productName = rs.getString("product");
            String productPrice = rs.getString("price");
            String productQty = rs.getString("quantity");

            txtPname.setText(productName);
            txtPrice.setText(productPrice);
            txtQty.setText(productQty);
        } else {
            // No matching product ID found
            JOptionPane.showMessageDialog(this, "Product not found!");
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
        }
    } catch (SQLException ex) {
        Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselectActionPerformed
        Fetch();
        try {
        String storeId = storeidbox.getSelectedItem().toString(); // Get the store ID from the text field

        // Check the store ID and select the appropriate table
        String tableName;
        if (storeId.equals("A1")) {
            tableName = "taskmart";
        } else if (storeId.equals("A2")) {
            tableName = "quickstore";
        } else {
            // Invalid store ID
            JOptionPane.showMessageDialog(this, "Invalid store ID!");
            return;
        }

        pst = con.prepareStatement("SELECT product_id FROM " + tableName);
        rs = pst.executeQuery();

        txtpid.removeAllItems();
        while (rs.next()) {
            txtpid.addItem(rs.getString(1));
        }
    } catch (SQLException ex) {
        Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnselectActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
        String storeId = storeidbox.getSelectedItem().toString(); // Get the selected store ID from the combo box

        // Check the store ID and select the appropriate table
        String tableName;
        if (storeId.equals("A1")) {
            tableName = "taskmart";
        } else if (storeId.equals("A2")) {
            tableName = "quickstore";
        } else {
            // Invalid store ID
            JOptionPane.showMessageDialog(this, "Invalid store ID!");
            return;
        }

        String productId = txtpid.getSelectedItem().toString(); // Get the selected product ID from the combo box
        String productName = txtPname.getText();
        String productPrice = txtPrice.getText();
        String productQty = txtQty.getText();

        pst = con.prepareStatement("UPDATE " + tableName + " SET product = ?, price = ?, quantity = ? WHERE product_id = ?");
        pst.setString(1, productName);
        pst.setString(2, productPrice);
        pst.setString(3, productQty);
        pst.setString(4, productId);

        int result = pst.executeUpdate();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Record updated successfully!");
            // Clear the text fields after updating
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update record!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
        String storeId = storeidbox.getSelectedItem().toString(); // Get the selected store ID from the combo box

        // Check the store ID and select the appropriate table
        String tableName;
        if (storeId.equals("A1")) {
            tableName = "taskmart";
        } else if (storeId.equals("A2")) {
            tableName = "quickstore";
        } else {
            // Invalid store ID
            JOptionPane.showMessageDialog(this, "Invalid store ID!");
            return;
        }

        String productId = txtpid.getSelectedItem().toString(); // Get the selected product ID from the combo box

        pst = con.prepareStatement("DELETE FROM " + tableName + " WHERE product_id = ?");
        pst.setString(1, productId);

        int result = pst.executeUpdate();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            // Clear the text fields after deleting
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete record!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(owner.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnselect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> storeidbox;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpid;
    private javax.swing.JTextField txtstoreid;
    // End of variables declaration//GEN-END:variables
}
