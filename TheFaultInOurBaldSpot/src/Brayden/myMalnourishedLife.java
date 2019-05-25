/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brayden;

//import java.awt.Component;
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

public class myMalnourishedLife extends javax.swing.JFrame {
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

//    for(javax.swing.JLabel item :blocks){
//            if (rect.intersects(item.getBounds())) {
//            return true;
//        } 
         
            
//    }
     return false;  
    
    }

    //checks which key is pressed and moves image if no collision is detected
    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
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
    }  
    public myMalnourishedLife() {
        initComponents();
        //Initialize the label with the scaled image icon
        myInitComponents(user);
    }
    
     //Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
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
            Logger.getLogger(myMalnourishedLife.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            wallLabel1.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel1.getWidth(), wallLabel1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(myMalnourishedLife.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            pot1.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot1.getWidth(), pot1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(myMalnourishedLife.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot2.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot2.getWidth(), pot2.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(myMalnourishedLife.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot.getWidth(), pot.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(myMalnourishedLife.class.getName()).log(Level.SEVERE, null, ex);
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

        pot = new javax.swing.JLabel();
        pot1 = new javax.swing.JLabel();
        pot2 = new javax.swing.JLabel();
        potato = new javax.swing.JLabel();
        tomato = new javax.swing.JLabel();
        onion = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        wallLabel = new javax.swing.JLabel();
        wallLabel1 = new javax.swing.JLabel();
        table = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(myMalnourishedLife.class);
        pot.setText(resourceMap.getString("pot.text")); // NOI18N
        pot.setName("pot"); // NOI18N

        pot1.setText(resourceMap.getString("pot1.text")); // NOI18N
        pot1.setName("pot1"); // NOI18N

        pot2.setText(resourceMap.getString("pot2.text")); // NOI18N
        pot2.setName("pot2"); // NOI18N

        potato.setText(resourceMap.getString("potato.text")); // NOI18N
        potato.setName("potato"); // NOI18N

        tomato.setText(resourceMap.getString("tomato.text")); // NOI18N
        tomato.setName("tomato"); // NOI18N

        onion.setText(resourceMap.getString("onion.text")); // NOI18N
        onion.setName("onion"); // NOI18N

        user.setText(resourceMap.getString("user.text")); // NOI18N
        user.setName("user"); // NOI18N

        wallLabel.setText(resourceMap.getString("wallLabel.text")); // NOI18N
        wallLabel.setName("wallLabel"); // NOI18N

        wallLabel1.setText(resourceMap.getString("wallLabel1.text")); // NOI18N
        wallLabel1.setName("wallLabel1"); // NOI18N

        table.setText(resourceMap.getString("table.text")); // NOI18N
        table.setName("table"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pot1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(pot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(potato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(tomato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pot2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wallLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wallLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(290, 290, 290))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pot1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pot2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tomato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(onion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wallLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wallLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(599, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(myMalnourishedLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myMalnourishedLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myMalnourishedLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myMalnourishedLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myMalnourishedLife().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel onion;
    private javax.swing.JLabel pot;
    private javax.swing.JLabel pot1;
    private javax.swing.JLabel pot2;
    private javax.swing.JLabel potato;
    private javax.swing.JLabel table;
    private javax.swing.JLabel tomato;
    private javax.swing.JLabel user;
    private javax.swing.JLabel wallLabel;
    private javax.swing.JLabel wallLabel1;
    // End of variables declaration//GEN-END:variables



}
