/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PayWindow extends javax.swing.JFrame {
    private MainWindow mW;
    
    public void setmW(MainWindow mW) {
        this.mW = mW;
    }
    
    public PayWindow() {
        initComponents();
        numberField.setDocument(new JTextFieldLimit(19));
        yearField.setDocument(new JTextFieldLimit(2));
        monthField.setDocument(new JTextFieldLimit(2));
        ccvField.setDocument(new JTextFieldLimit(3)); 
        
        setToDefault();
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        numberField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yearField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ccvField = new javax.swing.JTextField();
        payButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        osszegField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Fizetés");

        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });

        numberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numberFieldKeyPressed(evt);
            }
        });

        jLabel2.setText("Bankkártyán szereplő név:");

        jLabel3.setText("Bankkártya száma:");

        jLabel4.setText("Lejárati dátum (HH/ÉÉ):");

        yearField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yearFieldKeyPressed(evt);
            }
        });

        monthField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthFieldKeyPressed(evt);
            }
        });

        jLabel5.setText("CCV/CCT");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("/");

        ccvField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ccvFieldKeyPressed(evt);
            }
        });

        payButton.setText("Fizetés");
        payButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payButtonMouseClicked(evt);
            }
        });

        backButton.setText("Vissza");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        osszegField.setEditable(false);

        jLabel7.setText("Végösszeg:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ccvField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(osszegField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(numberField))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ccvField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osszegField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payButton)
                    .addComponent(backButton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setToDefault()
    {
        nameField.setText("");
        numberField.setText("");
        yearField.setText("");
        monthField.setText("");
        ccvField.setText("");
    }
    
    private void numberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyPressed
        int length = numberField.getText().length();
        
        if (Character.isLetter(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar()) && !(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_SHIFT || evt.getKeyCode() == KeyEvent.VK_SPACE)) {
            JOptionPane.showMessageDialog(this, "Csak számokat írjon be!");
            evt.consume();
            numberField.setText(""+numberField.getText().substring(0, numberField.getText().length() - 1));
        }else
        {
            switch(length)
        {
            case 4:
                if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE)
                {
                    try {
                        numberField.getDocument().insertString(4, " ", null);
                    } catch (Exception e) {
                    }               
                    break;
                }
            case 9:
                if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE)
                {
                    try {
                        numberField.getDocument().insertString(9, " ", null);
                    } catch (Exception e) {
                    }               
                    break;
                }
            case 14:
                if(evt.getKeyCode() != KeyEvent.VK_BACK_SPACE)
                {
                    try {
                        numberField.getDocument().insertString(14, " ", null);
                    } catch (Exception e) {
                    }               
                    break;
                }
            }
        }       
    }//GEN-LAST:event_numberFieldKeyPressed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        this.setVisible(false);
        setToDefault();
    }//GEN-LAST:event_backButtonMouseClicked

    private void payButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payButtonMouseClicked
        if((!nameField.getText().isEmpty()) && 
            (!numberField.getText().isEmpty()) && 
            (!yearField.getText().isEmpty()) && 
            (!monthField.getText().isEmpty()) && 
            (!ccvField.getText().isEmpty()) && 
            numberField.getText().length() == 19 && 
            yearField.getText().length() == 2 && 
            monthField.getText().length() == 2 &&
            ccvField.getText().length() == 3)
        {
            if(mW.getKosarTable().getRowCount() != 0)
            {
                if(!(monthField.getText().equalsIgnoreCase("")) && !(yearField.getText().equalsIgnoreCase("")) && !(nameField.getText().equalsIgnoreCase("")) && !(numberField.getText().equalsIgnoreCase("")) && !(ccvField.getText().equalsIgnoreCase("")))
                {
                    if(Integer.parseInt(monthField.getText()) <= 12 && Integer.parseInt(monthField.getText()) > 0)
                    {
                        if(Integer.parseInt(yearField.getText()) >= 0)
                        {                   
                            try {
                            File buyFile = new File("buyFile.txt");
                            if (buyFile.createNewFile()) {
                                try {
                                    FileWriter buyFileWriter = new FileWriter(buyFile, true);
                                    buyFileWriter.write("Kézbesítés " + nameField.getText() + " számára:");
                                    buyFileWriter.write(System.lineSeparator());
                                    for(int k = 0; k < mW.getKosarTable().getRowCount(); k++)
                                    {

                                        buyFileWriter.write(mW.getKosarTable().getValueAt(k, 0).toString() + " - " + mW.getKosarTable().getValueAt(k, 1).toString() + " Ft");
                                        buyFileWriter.write(System.lineSeparator());
                                    }

                                    buyFileWriter.close();
                                } catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    FileWriter buyFileWriter = new FileWriter(buyFile, true);
                                    buyFileWriter.write("Kézbesítés " + nameField.getText() + " számára");
                                    buyFileWriter.write(System.lineSeparator());
                                    for(int k = 0; k < mW.getKosarTable().getRowCount(); k++)
                                    {

                                        buyFileWriter.write(mW.getKosarTable().getValueAt(k, 0).toString() + " - " + mW.getKosarTable().getValueAt(k, 1).toString() + " Ft");
                                        buyFileWriter.write(System.lineSeparator());
                                    }

                                    buyFileWriter.close();
                                } catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }
                            }
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }

                            for(int i = 0; i < mW.getPriceTable().getRowCount(); i++)
                            {
                                for(int j = 0; j < mW.getKosarTable().getRowCount(); j++)
                                {
                                    if(mW.getPriceTable().getValueAt(i, 0).toString().equalsIgnoreCase(mW.getKosarTable().getValueAt(j, 0).toString()))
                                    {                               
                                        int darab = Integer.parseInt(mW.getPriceTable().getValueAt(i, 3).toString()) - Integer.parseInt(mW.getKosarTable().getValueAt(j, 2).toString());
                                        mW.getPriceTable().setValueAt(darab,i, 3);                               
                                    }                           
                                }
                            }
                            mW.getKosarTableModel().setRowCount(0);
                            this.setVisible(false);
                        }else
                        {
                            JOptionPane.showMessageDialog(this, "Nem megfelelő év formátum!");
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(this, "Nem megfelelő hónap formátum!");
                    }
                }else
                {
                    JOptionPane.showMessageDialog(this, "Mező nem maradhat üresen!");
                }
            }else
            {
                JOptionPane.showMessageDialog(this, "A bevásárló kosár üres!");
            }
        }else
        {
            JOptionPane.showMessageDialog(this, "Beviteli mező nem maradhat üresen, vagy nem teljesen kitöltve!");
        }
    }//GEN-LAST:event_payButtonMouseClicked

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed
        if(Character.isLetter(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar()) || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_SHIFT || evt.getKeyCode() == KeyEvent.VK_SPACE))
        {
            evt = evt;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Csak betűket írjon be!");
            evt.consume();
            nameField.setText(""+nameField.getText().substring(0, nameField.getText().length() - 1));
        }
    }//GEN-LAST:event_nameFieldKeyPressed

    private void monthFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthFieldKeyPressed
        if(!(Character.isLetter(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar())) || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_SHIFT || evt.getKeyCode() == KeyEvent.VK_SPACE))
        {
            evt = evt;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Csak számokat írjon be!");
            evt.consume();
            monthField.setText(""+monthField.getText().substring(0, monthField.getText().length() - 1));
        }
    }//GEN-LAST:event_monthFieldKeyPressed

    private void yearFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearFieldKeyPressed
        if(!(Character.isLetter(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar())) || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_SHIFT || evt.getKeyCode() == KeyEvent.VK_SPACE))
        {
            evt = evt;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Csak számokat írjon be!");
            evt.consume();
            yearField.setText(""+yearField.getText().substring(0, yearField.getText().length() - 1));
        }
    }//GEN-LAST:event_yearFieldKeyPressed

    private void ccvFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ccvFieldKeyPressed
        if(!(Character.isLetter(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar())) || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_SHIFT || evt.getKeyCode() == KeyEvent.VK_SPACE))
        {
            evt = evt;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Csak számokat írjon be!");
            evt.consume();
            ccvField.setText(""+ccvField.getText().substring(0, ccvField.getText().length() - 1));
        }
    }//GEN-LAST:event_ccvFieldKeyPressed
   
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
            java.util.logging.Logger.getLogger(PayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayWindow().setVisible(true);
            }
        });        
    }

    public JTextField getOsszegField() {
        return osszegField;
    }

    public void setOsszegField(JTextField osszegField) {
        this.osszegField = osszegField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField ccvField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField monthField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JTextField osszegField;
    private javax.swing.JButton payButton;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
