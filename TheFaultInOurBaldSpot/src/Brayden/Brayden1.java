package Brayden;

/*
 * Written by Brayden McQueen
 * May 21, 2019
 * Brayden's Game
 * Game that makes the user feed poor homless people and do it fast!
 */
//imports
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

public class Brayden1 extends javax.swing.JFrame {
public int counter = 150;
//This makes the main timer
Timer timer = new Timer();
TimerTask task = new TimerTask(){
        public void run(){
        counter--;
        timerBoy.setText(String.valueOf(counter));
        }
        };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderOne = new javax.swing.JLabel();
        orderTwo = new javax.swing.JLabel();
        orderThree = new javax.swing.JLabel();
        orderFour = new javax.swing.JLabel();
        orderFive = new javax.swing.JLabel();
        orderSix = new javax.swing.JLabel();
        timerBoy = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        wallLabel = new javax.swing.JLabel();
        wallLabel1 = new javax.swing.JLabel();
        pot = new javax.swing.JLabel();
        potato = new javax.swing.JLabel();
        tomato = new javax.swing.JLabel();
        bar = new javax.swing.JLabel();
        sink = new javax.swing.JLabel();
        dryRack = new javax.swing.JLabel();
        onion = new javax.swing.JLabel();
        pot1 = new javax.swing.JLabel();
        pot2 = new javax.swing.JLabel();
        table = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 178, 59));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(102, 0, 0));
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 880));
        setSize(new java.awt.Dimension(1080, 720));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        orderOne.setText("orderOne");
        getContentPane().add(orderOne);
        orderOne.setBounds(550, 10, 60, 60);
        orderOne.getAccessibleContext().setAccessibleName("order1");

        orderTwo.setText("orderTwo");
        getContentPane().add(orderTwo);
        orderTwo.setBounds(650, 10, 60, 60);

        orderThree.setText("orderThree");
        getContentPane().add(orderThree);
        orderThree.setBounds(730, 10, 60, 60);

        orderFour.setText("orderFour");
        getContentPane().add(orderFour);
        orderFour.setBounds(830, 10, 60, 60);

        orderFive.setText("orderFive");
        getContentPane().add(orderFive);
        orderFive.setBounds(920, 10, 60, 60);

        orderSix.setText("orderSix");
        getContentPane().add(orderSix);
        orderSix.setBounds(1010, 10, 60, 60);

        timerBoy.setBackground(new java.awt.Color(255, 51, 51));
        timerBoy.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        timerBoy.setForeground(new java.awt.Color(255, 0, 51));
        timerBoy.setText("120");
        getContentPane().add(timerBoy);
        timerBoy.setBounds(100, 20, 70, 70);

        user.setText("User");
        getContentPane().add(user);
        user.setBounds(10, 371, 102, 127);

        wallLabel.setText("wall1");
        getContentPane().add(wallLabel);
        wallLabel.setBounds(0, 836, 1080, 22);
        wallLabel.getAccessibleContext().setAccessibleName("wallLabel");
        wallLabel.getAccessibleContext().setAccessibleDescription("");

        wallLabel1.setText("wall2");
        getContentPane().add(wallLabel1);
        wallLabel1.setBounds(0, 86, 1080, 22);

        pot.setText("Pot1");
        getContentPane().add(pot);
        pot.setBounds(212, 119, 60, 60);

        potato.setText("Potato");
        getContentPane().add(potato);
        potato.setBounds(212, 765, 60, 60);

        tomato.setText("Tomato");
        getContentPane().add(tomato);
        tomato.setBounds(290, 765, 60, 60);

        bar.setText("jLabel1");
        getContentPane().add(bar);
        bar.setBounds(0, 0, 1080, 85);

        sink.setText("Sink");
        getContentPane().add(sink);
        sink.setBounds(667, 749, 60, 60);

        dryRack.setText("DishRack");
        getContentPane().add(dryRack);
        dryRack.setBounds(745, 741, 60, 60);

        onion.setText("onion");
        getContentPane().add(onion);
        onion.setBounds(368, 770, 60, 60);

        pot1.setText("Pot2");
        getContentPane().add(pot1);
        pot1.setBounds(282, 119, 60, 60);

        pot2.setText("Pot3");
        getContentPane().add(pot2);
        pot2.setBounds(352, 119, 60, 60);

        table.setText("table");
        getContentPane().add(table);
        table.setBounds(265, 347, 540, 175);

        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(0, 0, 1080, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //check if a collision between images is occurring
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
    Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        
    //creates an array to tell the collision what the user cant run into    
    javax.swing.JLabel blocks[] = new javax.swing.JLabel[3];
    blocks[0] = wallLabel;
    blocks[1] = wallLabel1;
    blocks[2] = table;
//cheacks the collision and returns teu or false
   for(javax.swing.JLabel item :blocks){
           if (rect.intersects(item.getBounds())) {
          return true;
      }     
   }
     return false;  
    }
        private void arrayMaker() { 
        soup soupBoy[] = new soup[6];
        soupBoy[0] = new soup();
        soupBoy[1] = new soup();
        soupBoy[2] = new soup();
        soupBoy[3] = new soup();
        soupBoy[4] = new soup();
        soupBoy[5] = new soup();
        }

    //checks which key is pressed and moves image if no collision is detected
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        //System.out.println(evt.getKeyCode());

        //up key pressed (w)
        if (evt.getKeyCode() == 87) {
            if (!checkCollision(user, 0, -30)) {
                user.setLocation(user.getLocation().x, user.getLocation().y - 30);
            }
        }
        //down key pressed(s)
        if (evt.getKeyCode() == 83) {
            if (!checkCollision(user, 0, 30)) {
                user.setLocation(user.getLocation().x, user.getLocation().y + 30);
            }
        }
        //left key pressed(a)
        if (evt.getKeyCode() == 65) {
            if (!checkCollision(user, -30, 0)) {
                user.setLocation(user.getLocation().x - 30, user.getLocation().y);
            }
        }
        //right key pressed(d)
        if (evt.getKeyCode() == 68) {
            if (!checkCollision(user, 30, 0)) {
                user.setLocation(user.getLocation().x + 30, user.getLocation().y);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * Creates new form NewJFrame
     */
    public Brayden1() {
        initComponents();
        //Initialize the label with the scaled image icon
        myInitComponents(user);
    }

    //Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //starts timer
        timer.scheduleAtFixedRate(task, 1000, 1000 );
        //Set the jLables' icon to the image it needs
        try {
            user.setIcon(new ImageIcon((ImageIO.read(new File("braydenNude.png"))).getScaledInstance(user.getWidth(), user.getHeight(), Image.SCALE_SMOOTH)));
         
            wallLabel.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel.getWidth(), wallLabel.getHeight(), Image.SCALE_SMOOTH)));

            wallLabel1.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel1.getWidth(), wallLabel1.getHeight(), Image.SCALE_SMOOTH)));

            pot1.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot1.getWidth(), pot1.getHeight(), Image.SCALE_SMOOTH)));

            pot2.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot2.getWidth(), pot2.getHeight(), Image.SCALE_SMOOTH)));

            pot.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot.getWidth(), pot.getHeight(), Image.SCALE_SMOOTH)));

            table.setIcon(new ImageIcon((ImageIO.read(new File("tab.png"))).getScaledInstance(table.getWidth(), table.getHeight(), Image.SCALE_SMOOTH)));

            bar.setIcon(new ImageIcon((ImageIO.read(new File("bar.png"))).getScaledInstance(bar.getWidth(), bar.getHeight(), Image.SCALE_SMOOTH)));

            potato.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potato.getWidth(), potato.getHeight(), Image.SCALE_SMOOTH)));

            tomato.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(tomato.getWidth(), tomato.getHeight(), Image.SCALE_SMOOTH)));

            onion.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(onion.getWidth(), onion.getHeight(), Image.SCALE_SMOOTH)));

            background.setIcon(new ImageIcon((ImageIO.read(new File("floor.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));

            sink.setIcon(new ImageIcon((ImageIO.read(new File("sink.png"))).getScaledInstance(sink.getWidth(), sink.getHeight(), Image.SCALE_SMOOTH)));

            dryRack.setIcon(new ImageIcon((ImageIO.read(new File("dish.png"))).getScaledInstance(dryRack.getWidth(), dryRack.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Brayden1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Brayden1().setVisible(true);
            }
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bar;
    private javax.swing.JLabel dryRack;
    private javax.swing.JLabel onion;
    private javax.swing.JLabel orderFive;
    private javax.swing.JLabel orderFour;
    private javax.swing.JLabel orderOne;
    private javax.swing.JLabel orderSix;
    private javax.swing.JLabel orderThree;
    private javax.swing.JLabel orderTwo;
    private javax.swing.JLabel pot;
    private javax.swing.JLabel pot1;
    private javax.swing.JLabel pot2;
    private javax.swing.JLabel potato;
    private javax.swing.JLabel sink;
    private javax.swing.JLabel table;
    private javax.swing.JLabel timerBoy;
    private javax.swing.JLabel tomato;
    private javax.swing.JLabel user;
    private javax.swing.JLabel wallLabel;
    private javax.swing.JLabel wallLabel1;
    // End of variables declaration//GEN-END:variables
}
