/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlexPackage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import thefaultinourbaldspot.TheFaultInOurBaldSpotView;

/**
 *
 * @author alexander.rejep819
 */
public class Victory extends javax.swing.JFrame {

    /**
     * Creates new form Victory
     */
    public Victory() {
        initComponents();
        myInitComponents();
    }
    
    public void myInitComponents() {
        BufferedImage img = null;
        //same as above, but in a condensed version
        

        try {
            // backGround.setIcon(new ImageIcon((ImageIO.read(new File("hellBackground5.png"))).getScaledInstance(backGround.getWidth(), backGround.getHeight(), Image.SCALE_SMOOTH)));
            backGround.setIcon(new ImageIcon((ImageIO.read(new File("sunnyBackground.png"))).getScaledInstance(backGround.getWidth(), backGround.getHeight(), Image.SCALE_SMOOTH)));
              winPlane.setIcon(new ImageIcon((ImageIO.read(new File("planeFlying.png"))).getScaledInstance(winPlane.getWidth(), winPlane.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(AlexForm.class
                    .getName()).log(Level.SEVERE, null, ex);
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

        victoryLabel = new javax.swing.JLabel();
        winPlane = new javax.swing.JLabel();
        returnMain = new javax.swing.JButton();
        Winner = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(Victory.class);
        victoryLabel.setFont(resourceMap.getFont("victoryLabel.font")); // NOI18N
        victoryLabel.setForeground(resourceMap.getColor("victoryLabel.foreground")); // NOI18N
        victoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        victoryLabel.setText(resourceMap.getString("victoryLabel.text")); // NOI18N
        victoryLabel.setName("victoryLabel"); // NOI18N
        getContentPane().add(victoryLabel);
        victoryLabel.setBounds(0, 0, 500, 90);

        winPlane.setText(resourceMap.getString("winPlane.text")); // NOI18N
        winPlane.setName("winPlane"); // NOI18N
        getContentPane().add(winPlane);
        winPlane.setBounds(130, 160, 210, 140);

        returnMain.setText(resourceMap.getString("returnMain.text")); // NOI18N
        returnMain.setName("returnMain"); // NOI18N
        returnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnMainActionPerformed(evt);
            }
        });
        getContentPane().add(returnMain);
        returnMain.setBounds(200, 460, 103, 23);

        Winner.setFont(resourceMap.getFont("Winner.font")); // NOI18N
        Winner.setText(resourceMap.getString("Winner.text")); // NOI18N
        Winner.setName("Winner"); // NOI18N
        getContentPane().add(Winner);
        Winner.setBounds(10, 370, 460, 80);

        backGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGround.setText(resourceMap.getString("backGround.text")); // NOI18N
        backGround.setName("backGround"); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnMainActionPerformed
        // TODO add your handling code here:
dispose();
        
    }//GEN-LAST:event_returnMainActionPerformed

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
            java.util.logging.Logger.getLogger(Victory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Victory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Victory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Victory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Victory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Winner;
    private javax.swing.JLabel backGround;
    private javax.swing.JButton returnMain;
    private javax.swing.JLabel victoryLabel;
    private javax.swing.JLabel winPlane;
    // End of variables declaration//GEN-END:variables
}
