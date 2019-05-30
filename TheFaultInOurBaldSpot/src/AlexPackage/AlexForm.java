package AlexPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author alexander.rejep819
 */
public class AlexForm extends javax.swing.JFrame {
    public int counter = 120;
    Timer gameTimer  = new Timer(); 
    TimerTask task = new TimerTask() {
        public void run() {
            counter --;
            timerLabel.setText(String.valueOf(counter));
            System.out.println("Seconds Passed: " + counter);
        }
    };
  
    /**
     * Creates new form AlexForm
     */
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(rightSideWall.getBounds()) || rect.intersects(leftSideWall.getBounds())) {
            return true;
        } else {
            return false;
        }
    }

    public AlexForm() {
        initComponents();

        myInitComponents();
    }

    public void myInitComponents() {
        BufferedImage img = null;
        //same as above, but in a condensed version
        gameTimer.scheduleAtFixedRate(task, 1000, 1000);
        try {
            backGround.setIcon(new ImageIcon((ImageIO.read(new File("hellBackground5.png"))).getScaledInstance(backGround.getWidth(), backGround.getHeight(), Image.SCALE_SMOOTH)));
            tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlane2.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
            leftSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallLeft.png"))).getScaledInstance(leftSideWall.getWidth(), leftSideWall.getHeight(), Image.SCALE_SMOOTH)));
            rightSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallRight.png"))).getScaledInstance(rightSideWall.getWidth(), rightSideWall.getHeight(), Image.SCALE_SMOOTH)));
           // hellWallBottom.setIcon(new ImageIcon((ImageIO.read(new File("hellWallBottom.png"))).getScaledInstance(hellWallBottom.getWidth(), hellWallBottom.getHeight(), Image.SCALE_SMOOTH)));
           // hellWallTop.setIcon(new ImageIcon((ImageIO.read(new File("hellWallTop.png"))).getScaledInstance(hellWallTop.getWidth(), hellWallTop.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
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

        hellWallTop1 = new javax.swing.JLabel();
        tataPlane = new javax.swing.JLabel();
        rightSideWall = new javax.swing.JLabel();
        leftSideWall = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        hellWallTop = new javax.swing.JLabel();
        hellWallBottom = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        hellWallTop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(AlexForm.class);
        hellWallTop1.setText(resourceMap.getString("hellWallTop1.text")); // NOI18N
        hellWallTop1.setToolTipText(resourceMap.getString("hellWallTop1.toolTipText")); // NOI18N
        hellWallTop1.setName("hellWallTop1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 1000));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 1000));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        tataPlane.setText(resourceMap.getString("tataPlane.text")); // NOI18N
        tataPlane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tataPlane.setName("tataPlane"); // NOI18N
        getContentPane().add(tataPlane);
        tataPlane.setBounds(410, 640, 60, 60);

        rightSideWall.setIcon(resourceMap.getIcon("rightSideWall.icon")); // NOI18N
        rightSideWall.setText(resourceMap.getString("rightSideWall.text")); // NOI18N
        rightSideWall.setName("rightSideWall"); // NOI18N
        getContentPane().add(rightSideWall);
        rightSideWall.setBounds(820, 0, 80, 1000);

        leftSideWall.setText(resourceMap.getString("leftSideWall.text")); // NOI18N
        leftSideWall.setName("leftSideWall"); // NOI18N
        getContentPane().add(leftSideWall);
        leftSideWall.setBounds(0, 0, 80, 1000);

        timerLabel.setFont(resourceMap.getFont("timerLabel.font")); // NOI18N
        timerLabel.setForeground(resourceMap.getColor("timerLabel.foreground")); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText(resourceMap.getString("timerLabel.text")); // NOI18N
        timerLabel.setName("timerLabel"); // NOI18N
        getContentPane().add(timerLabel);
        timerLabel.setBounds(680, 20, 80, 50);

        hellWallTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallTop.setText(resourceMap.getString("hellWallTop.text")); // NOI18N
        hellWallTop.setName("hellWallTop"); // NOI18N
        getContentPane().add(hellWallTop);
        hellWallTop.setBounds(80, 0, 740, 80);
        hellWallTop.getAccessibleContext().setAccessibleName(resourceMap.getString("hellWallTop.AccessibleContext.accessibleName")); // NOI18N

        hellWallBottom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallBottom.setText(resourceMap.getString("hellWallBottom.text")); // NOI18N
        hellWallBottom.setName("hellWallBottom"); // NOI18N
        getContentPane().add(hellWallBottom);
        hellWallBottom.setBounds(80, 810, 740, 80);

        backGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGround.setText(resourceMap.getString("Background.text")); // NOI18N
        backGround.setName("Background"); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 900, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //up key pressed
        if (evt.getKeyCode() == 38) {
            if (!checkCollision(tataPlane, 0, -15)) {
                tataPlane.setLocation(tataPlane.getLocation().x, tataPlane.getLocation().y - 15);
            }
        }
        //down key pressed
        if (evt.getKeyCode() == 40) {
            if (!checkCollision(tataPlane, 0, 15)) {
                tataPlane.setLocation(tataPlane.getLocation().x, tataPlane.getLocation().y + 15);
            }
        }
        //left key pressed
        if (evt.getKeyCode() == 37) {
            if (!checkCollision(tataPlane, -15, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x - 15, tataPlane.getLocation().y);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(tataPlane, 15, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x + 15, tataPlane.getLocation().y);
            }
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(AlexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlexForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel hellWallBottom;
    private javax.swing.JLabel hellWallTop;
    private javax.swing.JLabel hellWallTop1;
    private javax.swing.JLabel leftSideWall;
    private javax.swing.JLabel rightSideWall;
    private javax.swing.JLabel tataPlane;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
