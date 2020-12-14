package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MainWindow extends javax.swing.JFrame {
    
    private final DefaultTableModel wishTableModel;
    private final DefaultTableModel priceTableModel; 
    private final DefaultTableModel kosarTableModel;
    private final SetAmountWindow setaW;
    private final payWindow setpW;
    
    public MainWindow() {
        initComponents();
        finalPriceField.setText("0");
        priceTableModel = (DefaultTableModel) priceTable.getModel();
        kosarTableModel = (DefaultTableModel) kosarTable.getModel();
        wishTableModel = (DefaultTableModel) wishTable.getModel();
        setaW = new SetAmountWindow();
        setpW = new payWindow();
        setaW.setmW(this);
        setpW.setmW(this);
        updateFinalPrice();
    }
            
    private int updateFinalPrice()
    {
        int finalPrice = 0;
        for (int i = 0; i < kosarTable.getRowCount(); i++) {
            finalPrice += (Integer.parseInt(kosarTable.getValueAt(i, 1).toString())*Integer.parseInt(kosarTable.getValueAt(i, 2).toString()));
        }
                
        finalPriceField.setText(String.valueOf(finalPrice) + " Ft");
        return finalPrice;
    }

    public JTextField getFinalPriceField() {
        return finalPriceField;
    }
    
    private void kosarTableToFile()
    {
        try {
            File kosarFile = new File("kosarFile.txt");
            if (kosarFile.createNewFile()) {
            } else {
                try {
                    FileWriter kosarFileWriter = new FileWriter(kosarFile);
                    for(int i = 0; i < kosarTable.getRowCount(); i++)
                    {
                        kosarFileWriter.write(kosarTable.getValueAt(i, 0).toString() + ";" + kosarTable.getValueAt(i, 1).toString() + ";" + kosarTable.getValueAt(i, 2).toString());
                        kosarFileWriter.write(System.lineSeparator());
                    }
                    
                    kosarFileWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public DefaultTableModel getWishTableModel() {
        return wishTableModel;
    }

    public JTable getWishTable() {
        return wishTable;
    }
    
    private void wishTableToFile()
    {
        try {
            File wishFile = new File("wishFile.txt");
            if (wishFile.createNewFile()) {
            } else {
                try {
                    FileWriter wishFileWriter = new FileWriter(wishFile);
                    for(int i = 0; i < wishTable.getRowCount(); i++)
                    {
                        wishFileWriter.write(wishTable.getValueAt(i, 0).toString() + ";" + wishTable.getValueAt(i, 1).toString());
                        wishFileWriter.write(System.lineSeparator());
                    }
                    
                    wishFileWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private void PriceTableToFile()
    {
        try {
            File termekFile = new File("termekek.txt");
            FileWriter termekFileWriter = new FileWriter(termekFile);
            for(int i = 0; i < priceTable.getRowCount(); i++)
            {
                termekFileWriter.write(priceTable.getValueAt(i, 0).toString() + ";" + priceTable.getValueAt(i, 1).toString() + ";" + priceTable.getValueAt(i, 2).toString() + ";" + priceTable.getValueAt(i, 3).toString());
                termekFileWriter.write(System.lineSeparator());
            }

            termekFileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }     
    }

    private void searchItem()
    {
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
                break;            
        }
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

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JTextField getjTextField1() {
        return searchField;
    }

    public JButton getKosarbaButton() {
        return kosarbaButton;
    }

    public JTable getKosarTable() {
        return kosarTable;
    }

    public JTable getPriceTable() {
        return priceTable;
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
        jLabel5 = new javax.swing.JLabel();
        finalPriceField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addWishlistButton = new javax.swing.JButton();
        wishListbolButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        wishTable = new javax.swing.JTable();
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
        priceTable.getModel().addTableModelListener(
            new TableModelListener() 
            {
                public void tableChanged(TableModelEvent evt) 
                {
                    PriceTableToFile();
                }
            });
            jScrollPane2.setViewportView(priceTable);
            if (priceTable.getColumnModel().getColumnCount() > 0) {
                priceTable.getColumnModel().getColumn(0).setResizable(false);
                priceTable.getColumnModel().getColumn(1).setResizable(false);
                priceTable.getColumnModel().getColumn(2).setResizable(false);
                priceTable.getColumnModel().getColumn(3).setResizable(false);
            }

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
            jLabel1.setText("Számítógép Alkatrészek");

            searchTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Név", "Ár", "Típus" }));
            searchTypeCombo.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    searchTypeComboItemStateChanged(evt);
                }
            });

            searchField.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    searchFieldKeyReleased(evt);
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
            fizetesButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    fizetesButtonMouseClicked(evt);
                }
            });

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
                    "Név", "Ár", "Darabszám"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            kosarTable.getModel().addTableModelListener(
                new TableModelListener() 
                {
                    public void tableChanged(TableModelEvent evt) 
                    {
                        updateFinalPrice();
                        kosarTableToFile();
                    }
                });
                jScrollPane4.setViewportView(kosarTable);
                if (kosarTable.getColumnModel().getColumnCount() > 0) {
                    kosarTable.getColumnModel().getColumn(0).setResizable(false);
                    kosarTable.getColumnModel().getColumn(1).setResizable(false);
                    kosarTable.getColumnModel().getColumn(2).setResizable(false);
                }

                plusButton.setText("+1");
                plusButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        plusButtonMouseClicked(evt);
                    }
                });

                minusButton.setText("-1");
                minusButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        minusButtonMouseClicked(evt);
                    }
                });

                jLabel3.setText("Darabszám");

                jLabel4.setText("változtatása:");

                jLabel5.setText("Végösszeg:");

                finalPriceField.setEditable(false);
                finalPriceField.setText("0");

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
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(0, 9, Short.MAX_VALUE))
                                    .addComponent(finalPriceField)))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plusButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minusButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kosarbaButton)
                            .addComponent(fizetesButton)
                            .addComponent(kosarbolButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Bevásárlókosár", jPanel1);

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

                wishTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Név", "Ár"
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
                wishTable.getModel().addTableModelListener(
                    new TableModelListener() 
                    {
                        public void tableChanged(TableModelEvent evt) 
                        {
                            wishTableToFile();
                        }
                    });
                    jScrollPane1.setViewportView(wishTable);
                    if (wishTable.getColumnModel().getColumnCount() > 0) {
                        wishTable.getColumnModel().getColumn(0).setResizable(false);
                        wishTable.getColumnModel().getColumn(1).setResizable(false);
                    }

                    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                    jPanel2.setLayout(jPanel2Layout);
                    jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(addWishlistButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(wishListbolButton)
                                    .addGap(0, 97, Short.MAX_VALUE)))
                            .addContainerGap())
                    );
                    jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
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
                                .addComponent(jScrollPane2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchField)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(487, 487, 487))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTabbedPane1)))
                            .addContainerGap())
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
        setaW.setVisible(true);
    }//GEN-LAST:event_kosarbaButtonMouseClicked

    private void kosarbolButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kosarbolButtonMouseClicked
        if(kosarTable.getSelectedRow() != -1)
        {
            kosarTableModel.removeRow(kosarTable.getSelectedRow());
        }       
    }//GEN-LAST:event_kosarbolButtonMouseClicked

    private void addWishlistButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWishlistButtonMouseClicked
        boolean contains = false;
        for (int i = 0; i < wishTable.getRowCount(); i++) {
            if(priceTable.getValueAt(priceTable.getSelectedRow(), 0).toString().equalsIgnoreCase(wishTable.getValueAt(i, 0).toString())) {
                contains = true;
            }
        }

        if(contains) {
            JOptionPane.showMessageDialog(this, "Ez a termék már szerepel a wish listben!");
        }else
        {
            wishTableModel.addRow(new Object[] {priceTable.getValueAt(priceTable.getSelectedRow(), 0), priceTable.getValueAt(priceTable.getSelectedRow(), 1)});
        }        
    }//GEN-LAST:event_addWishlistButtonMouseClicked

    private void wishListbolButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wishListbolButtonMouseClicked
        if(wishTable.getSelectedRow() != -1)
        {
            wishTableModel.removeRow(wishTable.getSelectedRow());
        }    
    }//GEN-LAST:event_wishListbolButtonMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        searchItem();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchTypeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchTypeComboItemStateChanged
        searchItem();
    }//GEN-LAST:event_searchTypeComboItemStateChanged

    private void plusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusButtonMouseClicked
        int stored = 0;
        int amount = 0;
          
        if(kosarTable.getSelectedRow() != -1)
        {
            amount = Integer.parseInt(kosarTableModel.getValueAt(kosarTable.getSelectedRow(), 2).toString());
            stored = (Integer)priceTable.getValueAt(kosarTable.getSelectedRow(), 3);
            
            if(stored > amount && amount > 0)
            {
                amount++;
                kosarTableModel.setValueAt(amount, kosarTable.getSelectedRow(), 2);
            }
        }
    }//GEN-LAST:event_plusButtonMouseClicked

    private void minusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusButtonMouseClicked
        int amount = 0;
        if(kosarTable.getSelectedRow() != -1)
        {
            amount = Integer.parseInt(kosarTableModel.getValueAt(kosarTable.getSelectedRow(), 2).toString());
        }
        
        if(amount > 0 && amount != 1)
        {
            amount--;
            kosarTableModel.setValueAt(amount, kosarTable.getSelectedRow(), 2);
        }else if(amount == 1)
        {
            if(kosarTable.getSelectedRow() != -1)
            {
                kosarTableModel.removeRow(kosarTable.getSelectedRow());
            }
            
        }
    }//GEN-LAST:event_minusButtonMouseClicked

    private void fizetesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fizetesButtonMouseClicked
        if(kosarTable.getRowCount() != 0 && kosarTable.getColumnCount() != 0)
        {
            setpW.setVisible(true);
            setpW.getOsszegField().setText(finalPriceField.getText());
        }else
        {
            JOptionPane.showMessageDialog(this, "A kosara üres!");
        }
    }//GEN-LAST:event_fizetesButtonMouseClicked

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
    private javax.swing.JTextField finalPriceField;
    private javax.swing.JButton fizetesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JButton wishListbolButton;
    private javax.swing.JTable wishTable;
    // End of variables declaration//GEN-END:variables
}
