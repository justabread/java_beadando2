package main;

import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainWindow extends javax.swing.JFrame {
    
    private final DefaultListModel<String> wishListModel;
    private final DefaultTableModel priceTableModel; 
    private final DefaultTableModel kosarTableModel;
    private final SetAmountWindow setAW;
    
    public MainWindow() {
        initComponents();
        wishListModel = new DefaultListModel<>();
        priceTableModel = (DefaultTableModel) priceTable.getModel();
        kosarTableModel = (DefaultTableModel) kosarTable.getModel();
        wishList.setModel(wishListModel);
        setAW = new SetAmountWindow();
        setAW.setmW(this);
    }

    public DefaultTableModel getKosarTableModel() {
        return kosarTableModel;
    }
    
    public JFrame getJFrame()
    {
        return this;
    }

    public DefaultTableModel getPriceTableModel() {
        return priceTableModel;
    }       
    
    public JButton getAddWishlistButton() {
        return addWishlistButton;
    }

    public JButton getFizetesButton() {
        return fizetesButton;
    }

    public JComboBox<String> getjComboBox1() {
        return searchTypeCombo;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JTextField getjTextField1() {
        return searchField;
    }

    public JButton getKosarbaButton() {
        return kosarbaButton;
    }

    public JTable getPriceTable() {
        return priceTable;
    }

    public JList<String> getWishList() {
        return wishList;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        priceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchTypeCombo = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        kosarbaButton = new javax.swing.JButton();
        fizetesButton = new javax.swing.JButton();
        kosarbolButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        kosarTable = new javax.swing.JTable();
        plusButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        wishList = new javax.swing.JList<>();
        addWishlistButton = new javax.swing.JButton();
        wishListbolButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Számítógép Alkatrészek");

        priceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Név", "Ár", "Típus", "Darabszám Raktáron"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(priceTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Számítógép Alkatrészek");

        searchTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Név", "Ár", "Típus" }));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        jTabbedPane1.setToolTipText("");

        kosarbaButton.setText("Kosárba");
        kosarbaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kosarbaButtonMouseClicked(evt);
            }
        });

        fizetesButton.setText("Fizetés");

        kosarbolButton.setText("Eltávolítás");
        kosarbolButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kosarbolButtonMouseClicked(evt);
            }
        });

        kosarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Név", "Darabszám"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
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
        jScrollPane4.setViewportView(kosarTable);

        plusButton.setText("+1");

        minusButton.setText("-1");

        jLabel3.setText("Darabszám");

        jLabel4.setText("változtatása:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 9, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kosarbaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kosarbolButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fizetesButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(plusButton)
                        .addGap(14, 14, 14)
                        .addComponent(minusButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kosarbaButton)
                    .addComponent(fizetesButton)
                    .addComponent(kosarbolButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bevásárlókosár", jPanel1);

        jScrollPane3.setViewportView(wishList);

        addWishlistButton.setText("Hozzáadás Wishlisthez");
        addWishlistButton.setToolTipText("");
        addWishlistButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addWishlistButtonMouseClicked(evt);
            }
        });

        wishListbolButton.setText("Eltávolítás");
        wishListbolButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wishListbolButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addWishlistButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wishListbolButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWishlistButton)
                    .addComponent(wishListbolButton))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Wishlist", jPanel2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Keresés");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(497, 497, 497))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kosarbaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kosarbaButtonMouseClicked
        setAW.setVisible(true);        
    }//GEN-LAST:event_kosarbaButtonMouseClicked

    private void kosarbolButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kosarbolButtonMouseClicked

    }//GEN-LAST:event_kosarbolButtonMouseClicked

    private void addWishlistButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWishlistButtonMouseClicked
        Object element = priceTable.getValueAt(priceTable.getSelectedRow(), 0);                     
        wishListModel.addElement(String.valueOf(element));
    }//GEN-LAST:event_addWishlistButtonMouseClicked

    private void wishListbolButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wishListbolButtonMouseClicked
        int index = wishList.getSelectedIndex();
        if (index != -1) {
            wishListModel.remove(index);
        }
    }//GEN-LAST:event_wishListbolButtonMouseClicked

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        String type = (String)searchTypeCombo.getSelectedItem();
        
        switch(type)
        {
            case "Név":
                if(!searchField.getText().isEmpty())
                {
                    priceTableModel.setRowCount(0);                    
                    MainController.getProductMap().forEach((k1,v1) -> 
                        {
                            if(v1.getName().toLowerCase().contains(searchField.getText().toLowerCase()))
                            {
                                priceTableModel.addRow(new Object[] {v1.getName(), v1.getPrice(), v1.getType(), v1.getStored()});                          
                            }
                        }
                    );
                }
                else
                {
                    priceTableModel.setRowCount(0);
                    MainController.getProductMap().forEach((k2,v2) -> 
                        priceTableModel.addRow(new Object[] {v2.getName(), v2.getPrice(), v2.getType(), v2.getStored()})
                    );
                }
                
                break;
            case "Ár":
                if(!searchField.getText().isEmpty())
                {
                    priceTableModel.setRowCount(0);                    
                    MainController.getProductMap().forEach((k1,v1) -> 
                        {
                            
                            if(String.valueOf(v1.getPrice()).toLowerCase().contains(searchField.getText().toLowerCase()))
                            {
                                priceTableModel.addRow(new Object[] {v1.getName(), v1.getPrice(), v1.getType(), v1.getStored()});
                            }
                        }
                    );
                }
                else
                {
                    priceTableModel.setRowCount(0);
                    MainController.getProductMap().forEach((k2,v2) -> 
                        priceTableModel.addRow(new Object[] {v2.getName(), v2.getPrice(), v2.getType(), v2.getStored()})
                    );
                }
                
                break;
            case "Típus":
                if(!searchField.getText().isEmpty())
                {
                    priceTableModel.setRowCount(0);                    
                    MainController.getProductMap().forEach((k1,v1) -> 
                        {
                            if(v1.getType().toLowerCase().contains(searchField.getText().toLowerCase()))
                            {
                                priceTableModel.addRow(new Object[] {v1.getName(), v1.getPrice(), v1.getType(), v1.getStored()});                          
                            }
                        }
                    );
                }
                else
                {
                    priceTableModel.setRowCount(0);
                    MainController.getProductMap().forEach((k2,v2) -> 
                        priceTableModel.addRow(new Object[] {v2.getName(), v2.getPrice(), v2.getType(), v2.getStored()})
                    );
                }
                
                break;            
        }
        
    }//GEN-LAST:event_searchFieldKeyTyped

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWishlistButton;
    private javax.swing.JButton fizetesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable kosarTable;
    private javax.swing.JButton kosarbaButton;
    private javax.swing.JButton kosarbolButton;
    private javax.swing.JButton minusButton;
    private javax.swing.JButton plusButton;
    private javax.swing.JTable priceTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchTypeCombo;
    private javax.swing.JList<String> wishList;
    private javax.swing.JButton wishListbolButton;
    // End of variables declaration//GEN-END:variables
}
