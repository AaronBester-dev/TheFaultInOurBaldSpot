package AlexPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AlexPackage.EnemiesClass.*;
import AlexPackage.*;
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
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 *
 * @author alexander.rejep819
 */
public class AlexForm extends javax.swing.JFrame {
    public int health = 3;
    public int counter = 120;
    Timer gameTimer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            counter--;
            timerLabel.setText(String.valueOf(counter));
            // System.out.println("Seconds Passed: " + counter);
            if (counter == 115) {
                gameTimer.scheduleAtFixedRate(EnemyAnimation, 400, 400);
            }
        }
    };
    TimerTask Animate = new TimerTask() {
        public void run() {
            //System.out.println("MOVE");
            
            try {
                for (JLabel item : bullets) {
                    item.setLocation(item.getLocation().x, item.getLocation().y - 5);
                }
                for (JLabel item : impBullets) {
                    if ( checkBulletCollisionPlane(item,0,4) == true){
                          impBullets.remove(item);
                }
                    item.setLocation(item.getLocation().x, item.getLocation().y + 4);
                }

                for (JLabel item : bullets) {
                    if (item.getLocation().y < -20) {
                        bullets.remove(item);
                    }
                }

                for (JLabel item : impBullets) {
                    if (item.getLocation().y > 980) {
                        impBullets.remove(item);
                    }
                }
                for (int i = 0; i < enemyStats1.length; i++) {
                    if (i == 0) {
                        for (EnemiesClass item : impStats) {
                            int fireBullet = (int) (Math.random() * 400 + 1);
                            if (fireBullet == 5) {
                                JLabel impBullet = new JLabel();
                                getContentPane().add(impBullet);
                                impBullet.setBounds(item.getLabel().getLocation().x + item.getLabel().getWidth() / 2, item.getLabel().getLocation().y + 40, 14, 20);
                                try {
                                    impBullet.setIcon(new ImageIcon((ImageIO.read(new File("impBullet.png"))).getScaledInstance(impBullet.getWidth(), impBullet.getHeight(), Image.SCALE_SMOOTH)));
                                } catch (IOException ex) {
                                    Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                impBullets.add(impBullet);
                            }
                            if (item.getLabel().getLocation().x >= 100 && item.getLabel().getLocation().y == 200) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x + 2, item.getLabel().getLocation().y);
                            }
                            if (item.getLabel().getLocation().x == 700 && item.getLabel().getLocation().y >= 200) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 2);
                            }
                            if (item.getLabel().getLocation().x <= 700 && item.getLabel().getLocation().y == 400) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x - 2, item.getLabel().getLocation().y);
                            }
                            if (item.getLabel().getLocation().x == 100 && item.getLabel().getLocation().y <= 400) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y - 2);
                            }
                        }
                    }
                    if (i == 1) {
                        for (EnemiesClass item : demonStats) {
                            if (item.getLabel().getLocation().y >= 250) {
                            } else {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 2);
                            }
                        }
                    }
                    if (i == 2) {
                        for (EnemiesClass item : beholderStats) {
                            if (item.getLabel().getLocation().x <= 80) {
                                item.setDirection(true);
                            }
                            if (item.getLabel().getLocation().x >= 720) {
                                item.setDirection(false);
                            }
                            if (item.getDirection() == true) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x + 2, item.getLabel().getLocation().y);
                            }
                            if (item.getDirection() == false) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x - 2, item.getLabel().getLocation().y);
                            }
                        }
                    }
                    if (i == 3) {
                        for (EnemiesClass item : deathWishStats) {
                            item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 10);
                        }
                    }
                }

            } catch (Exception e) {
            }
            // bullets.forEach((bullet) ->System.out.println("BULLET") );//bullet.setLocation(bullet.getLocation().x, bullet.getLocation().y -10));
        repaint();
        }
    };

    TimerTask EnemyAnimation = new TimerTask() {
        public void run() {
            //System.out.println("MOVE");
            int createEnemy = (int) (Math.random() * 3 + 1);
            if (createEnemy == 3) {
                System.out.println("Enemy Spawning");
                enemySpawning();
            }
            // bullets.forEach((bullet) ->System.out.println("BULLET") );//bullet.setLocation(bullet.getLocation().x, bullet.getLocation().y -10));
        }
    };

//    static ArrayList<JLabel> impLabels = new ArrayList<JLabel>(0);
//    static ArrayList<JLabel> beholderLabels = new ArrayList<JLabel>(0);
//    static ArrayList<JLabel> demonLabels = new ArrayList<JLabel>(0);
//    static ArrayList<JLabel> deathWishLabels = new ArrayList<JLabel>(0);
//    //static ArrayList<JLabel> enemyLabels = new ArrayList<JLabel>(0);
//    static ArrayList[] enemyLabels1 = new ArrayList[4];
    static ArrayList<EnemiesClass> impStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> beholderStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> demonStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> deathWishStats = new ArrayList<EnemiesClass>(0);
    //static ArrayList<EnemiesClass> enemyStats = new ArrayList<EnemiesClass>(0);
    static ArrayList[] enemyStats1 = new ArrayList[4];

    ArrayList<JLabel> bullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> impBullets = new ArrayList<JLabel>(0);

    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(rightSideWall.getBounds()) || rect.intersects(leftSideWall.getBounds()) || rect.intersects(hellWallBottom.getBounds()) || rect.intersects(hellWallTop.getBounds())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBulletCollisionPlane(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel    
      
            if (rect.intersects(tataPlane.getBounds())) {
                health --;
                healthLabel.setText(String.valueOf(health));
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
            // backGround.setIcon(new ImageIcon((ImageIO.read(new File("hellBackground5.png"))).getScaledInstance(backGround.getWidth(), backGround.getHeight(), Image.SCALE_SMOOTH)));
            tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlane2.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
            leftSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallLeft.png"))).getScaledInstance(leftSideWall.getWidth(), leftSideWall.getHeight(), Image.SCALE_SMOOTH)));
            rightSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallRight.png"))).getScaledInstance(rightSideWall.getWidth(), rightSideWall.getHeight(), Image.SCALE_SMOOTH)));
            hellWallBottom.setIcon(new ImageIcon((ImageIO.read(new File("hellWallBottom.png"))).getScaledInstance(hellWallBottom.getWidth(), hellWallBottom.getHeight(), Image.SCALE_SMOOTH)));
            // hellWallTop.setIcon(new ImageIcon((ImageIO.read(new File("hellWallTop.png"))).getScaledInstance(hellWallTop.getWidth(), hellWallTop.getHeight(), Image.SCALE_SMOOTH)));

        } catch (IOException ex) {
            Logger.getLogger(AlexForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

//        enemyLabels1[0] = impLabels;
//        enemyLabels1[1] = demonLabels;
//        enemyLabels1[2] = beholderLabels;
//        enemyLabels1[3] = deathWishLabels;
        enemyStats1[0] = impStats;
        enemyStats1[1] = demonStats;
        enemyStats1[2] = beholderStats;
        enemyStats1[3] = deathWishStats;

        gameTimer.scheduleAtFixedRate(Animate, 100, 10);
        
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
        healthLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        rightSideWall = new javax.swing.JLabel();
        leftSideWall = new javax.swing.JLabel();
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        tataPlane.setText(resourceMap.getString("tataPlane.text")); // NOI18N
        tataPlane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tataPlane.setName("tataPlane"); // NOI18N
        getContentPane().add(tataPlane);
        tataPlane.setBounds(410, 640, 60, 60);

        healthLabel.setFont(resourceMap.getFont("healthLabel.font")); // NOI18N
        healthLabel.setForeground(resourceMap.getColor("healthLabel.foreground")); // NOI18N
        healthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthLabel.setText(resourceMap.getString("healthLabel.text")); // NOI18N
        healthLabel.setToolTipText(resourceMap.getString("healthLabel.toolTipText")); // NOI18N
        healthLabel.setName("healthLabel"); // NOI18N
        getContentPane().add(healthLabel);
        healthLabel.setBounds(0, 0, 60, 60);

        timerLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timerLabel.setForeground(resourceMap.getColor("timerLabel.foreground")); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText(resourceMap.getString("timerLabel.text")); // NOI18N
        timerLabel.setName("timerLabel"); // NOI18N
        getContentPane().add(timerLabel);
        timerLabel.setBounds(820, 0, 80, 50);

        rightSideWall.setIcon(resourceMap.getIcon("rightSideWall.icon")); // NOI18N
        rightSideWall.setText(resourceMap.getString("rightSideWall.text")); // NOI18N
        rightSideWall.setName("rightSideWall"); // NOI18N
        getContentPane().add(rightSideWall);
        rightSideWall.setBounds(820, 0, 80, 1000);

        leftSideWall.setText(resourceMap.getString("leftSideWall.text")); // NOI18N
        leftSideWall.setName("leftSideWall"); // NOI18N
        getContentPane().add(leftSideWall);
        leftSideWall.setBounds(0, 0, 80, 1000);

        hellWallTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallTop.setText(resourceMap.getString("hellWallTop.text")); // NOI18N
        hellWallTop.setName("hellWallTop"); // NOI18N
        getContentPane().add(hellWallTop);
        hellWallTop.setBounds(0, 0, 900, 60);
        hellWallTop.getAccessibleContext().setAccessibleName(resourceMap.getString("hellWallTop.AccessibleContext.accessibleName")); // NOI18N

        hellWallBottom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallBottom.setText(resourceMap.getString("hellWallBottom.text")); // NOI18N
        hellWallBottom.setName("hellWallBottom"); // NOI18N
        getContentPane().add(hellWallBottom);
        hellWallBottom.setBounds(0, 920, 900, 80);

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
//this.repaint();

        //Try layeredPane layout instead of Null layout
        //https://docs.oracle.com/javase/tutorial/uiswing/components/layeredpane.html#depth
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
            if (!checkCollision(tataPlane, -25, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x - 25, tataPlane.getLocation().y);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(tataPlane, 25, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x + 25, tataPlane.getLocation().y);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 88) {
//            JLabel bullet = new JLabel();
//
//            System.out.println("Label Created");
//            getContentPane().add(bullet);
//            bullet.setBounds(tataPlane.getX() + tataPlane.getWidth() / 2, tataPlane.getY() - 10, 5, 10);
//
//            System.out.println("Bounds Set");
//            try {
//                bullet.setIcon(new ImageIcon((ImageIO.read(new File("bullet.png"))).getScaledInstance(bullet.getWidth(), bullet.getHeight(), Image.SCALE_SMOOTH)));
//            } catch (IOException ex) {
//                System.out.println("NO IMAGE");
//                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            setComponentZOrder(bullet, 0);
//            System.out.println("Try performed");
            bullet();
        }
    }//GEN-LAST:event_formKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        int strength, speed, health;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlexForm().setVisible(true);
            }
        });

    }

//    public void int impMovement(int x, int y) {
//        
//        
//        return y;
//    }
    public void enemySpawning() {
        int spawn = (int) (Math.random() * 100 + 1);
        if (spawn <= 40) {
            impSpawn();
        }
        if (spawn > 40 && spawn <= 50) {
            demonSpawn();
        }
        if (spawn > 50 && spawn <= 80) {
            beholderSpawn();
        }
        if (spawn > 80 && spawn <= 100) {
            deathWishSpawn();
        }
    }

    public void impSpawn() {
        System.out.println("IMP Coming");
        Imp imp = new Imp();
        impStats.add(imp);
        JLabel label = new JLabel();
        imp.setLabel(label);
        getContentPane().add(imp.getLabel());
        imp.getLabel().setBounds(100, imp.getHeight() * 50, 40, 40);
        try {
            imp.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Impling.png"))).getScaledInstance(imp.getLabel().getWidth(), imp.getLabel().getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void demonSpawn() {
        System.out.println("Demon Coming");
        Demon demon = new Demon();
        demonStats.add(demon);
        JLabel label = new JLabel();
        demon.setLabel(label);
        getContentPane().add(demon.getLabel());
        demon.getLabel().setBounds(390, -100, 120, 80);
        try {
            demon.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Dmon.png"))).getScaledInstance(demon.getLabel().getWidth(), demon.getLabel().getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void beholderSpawn() {
        System.out.println("Beholder Coming");
        Beholder beholder = new Beholder();
        beholderStats.add(beholder);
        JLabel label = new JLabel();
        beholder.setLabel(label);
        getContentPane().add(beholder.getLabel());
        beholder.getLabel().setBounds(80, beholder.getHeight() * 50, 80, 80);
        try {
            beholder.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Beholder.png"))).getScaledInstance(beholder.getLabel().getWidth(), beholder.getLabel().getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deathWishSpawn() {
        System.out.println("deathWish Coming");
        DeathWish suicide = new DeathWish();
        deathWishStats.add(suicide);
        JLabel label = new JLabel();
        suicide.setLabel(label);
        getContentPane().add(suicide.getLabel());
        suicide.getLabel().setBounds(60 * suicide.getHeight(), -55, 50, 50);
        try {
            suicide.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("uicide.png"))).getScaledInstance(suicide.getLabel().getWidth(), suicide.getLabel().getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bullet() {
        JLabel bullet = new JLabel();
        System.out.println("Label Created");
        getContentPane().add(bullet);
        bullet.setBounds(tataPlane.getX() + tataPlane.getWidth() / 2 - 2, tataPlane.getY() - 10, 8, 12);
        System.out.println("Bounds Set");
        try {
            bullet.setIcon(new ImageIcon((ImageIO.read(new File("bullet.png"))).getScaledInstance(bullet.getWidth(), bullet.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //setComponentZOrder(bullet, 0);
        // getContentPane().repaint();
        bullets.add(bullet);
        System.out.println("Try performed");
    }

    public void impBullet() {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel hellWallBottom;
    private javax.swing.JLabel hellWallTop;
    private javax.swing.JLabel hellWallTop1;
    private javax.swing.JLabel leftSideWall;
    private javax.swing.JLabel rightSideWall;
    private javax.swing.JLabel tataPlane;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
