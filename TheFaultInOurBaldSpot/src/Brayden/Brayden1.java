package Brayden;



/*
 * Written by Mr. van Straten
 * May 21, 2019
 * JFrameImages
 * This is a demo program for images and collision detection
 */


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
import java.util.Timer;
import java.util.TimerTask;

public class Brayden1 extends javax.swing.JFrame {
int counter = 120;

Timer timerBoy = new Timer();
TimerTask task = new TimerTask(){
        public void run(){
        counter--;
         
        }
        };





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setSize(new java.awt.Dimension(1080, 720));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

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

     javax.swing.JLabel blocks[] = new javax.swing.JLabel[3];

    //fill in elements
    blocks[0] = wallLabel;
    blocks[1] = wallLabel1;
    blocks[2] = table;

   for(javax.swing.JLabel item :blocks){
           if (rect.intersects(item.getBounds())) {
          return true;
      } 
         
            
   }
     return false;  
    
    }

    //checks which key is pressed and moves image if no collision is detected
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        // System.out.println(evt.getKeyCode());

        //up key pressed
        if (evt.getKeyCode() == 38) {
            if (!checkCollision(user, 0, -10)) {
                user.setLocation(user.getLocation().x, user.getLocation().y - 20);
            }
        }
        //down key pressed
        if (evt.getKeyCode() == 40) {
            if (!checkCollision(user, 0, 10)) {
                user.setLocation(user.getLocation().x, user.getLocation().y + 20);
            }
        }
        //left key pressed
        if (evt.getKeyCode() == 37) {
            if (!checkCollision(user, -10, 0)) {
                user.setLocation(user.getLocation().x - 20, user.getLocation().y);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(user, 10, 0)) {
                user.setLocation(user.getLocation().x + 20, user.getLocation().y);
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
       
        //timerBoy.setText(counter);
        
//set the Buffered Image to the picture file
        try {
            img = ImageIO.read(new File("braydenNude.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Create a temporary Image and scale it to the size of the label 
        Image tempImg = img.getScaledInstance(jLabel1.getWidth(), user.getHeight(),
                Image.SCALE_SMOOTH);
        //Create and Image Icon from the new scaled image
        ImageIcon imageIcon = new ImageIcon(tempImg);
        //Set the label's icon property to the new icon
        user.setIcon(imageIcon);

        
        //same as above, but in a condensed version
        try {
            wallLabel.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel.getWidth(), wallLabel.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            wallLabel1.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel1.getWidth(), wallLabel1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            pot1.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot1.getWidth(), pot1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot2.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot2.getWidth(), pot2.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot.getWidth(), pot.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            table.setIcon(new ImageIcon((ImageIO.read(new File("tab.png"))).getScaledInstance(table.getWidth(), table.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bar.setIcon(new ImageIcon((ImageIO.read(new File("bar.png"))).getScaledInstance(bar.getWidth(), bar.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            potato.setIcon(new ImageIcon((ImageIO.read(new File("potatoBox.png"))).getScaledInstance(potato.getWidth(), potato.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tomato.setIcon(new ImageIcon((ImageIO.read(new File("tomatoBox.png"))).getScaledInstance(tomato.getWidth(), tomato.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            onion.setIcon(new ImageIcon((ImageIO.read(new File("mushroomBox.png"))).getScaledInstance(onion.getWidth(), onion.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            background.setIcon(new ImageIcon((ImageIO.read(new File("floor.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            background.setIcon(new ImageIcon((ImageIO.read(new File("floor.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
