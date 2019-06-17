//Program title: The FaultInOurBaldSpot 
//Author: John Diemert
//Date: june 17th, 2019
//Program Description: surgeon simulator game

package JohnPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author John Diemert
 */
public class intro extends javax.swing.JFrame {
        //declares varibles 
        int counter = 0;
    /**
     * Creates new form intro
     */
    public intro() {
        //inislizes form and images
        initComponents();
        myInitComponents(introBackground);
        //creates font (as I have to do it manually for some reason)
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        Font font2 = new Font("SansSerif", Font.BOLD, 15);
        //sets text, colour, and font to various lables and buttons 
        play.setText("PLAY");
        quit.setText("QUIT");
        instructions.setText("INSTRUCTIONS");
        jLabel1.setText("MY TEACHER'S KEEPER");
        jLabel1.setFont(font1);
        jLabel1.setForeground(Color.blue);
        jLabel2.setText("I'm a surgeon");
        jLabel3.setText("Patient: Joel VanStraton");
        jLabel3.setFont(font2);
        jLabel4.setText("Notes: wants Dr.Diemert to preform the");
        jLabel4.setFont(font2);  
        jLabel5.setText("surgery and to give good news to his widow");
        jLabel5.setFont(font2);
        //adds addio, the "Like a surgeon" song
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("likeASurgeon.wav"));
            // Get a sound clip resource.
            Clip clip1 = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip1.open(audio);
            clip1.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
        //starts tier
        coffinBoxTimer();
    }
    //timer which makes coffin move on screen
    public void coffinBoxTimer() {
        //creates timer
        Timer coffinTimer = new Timer();
        TimerTask moveBox = new TimerTask() {
            //when timer runs
            public void run() {
                //increases counter
                counter++;
                if (counter <= 15) {
                    malPractice.setLocation(malPractice.getLocation().x - 1, malPractice.getLocation().y);
                } else if (counter > 15 & counter <= 45) {
                    malPractice.setLocation(malPractice.getLocation().x + 1, malPractice.getLocation().y);
                } else if (counter >= 45 & counter < 76) {
                    malPractice.setLocation(malPractice.getLocation().x - 1, malPractice.getLocation().y);
                } else if (counter > 75) {
                    counter = 15;
                }
            }
        };
        //counter runs at fixed rate
        coffinTimer.scheduleAtFixedRate(moveBox, 50, 50);
    }
    //initilizes components 
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        try {
            //sets icons to labels
            introBackground.setIcon(new ImageIcon((ImageIO.read(new File("hospital.jpg"))).getScaledInstance(introBackground.getWidth(), introBackground.getHeight(), Image.SCALE_SMOOTH)));
            john.setIcon(new ImageIcon((ImageIO.read(new File("john.jpg"))).getScaledInstance(john.getWidth(), john.getHeight(), Image.SCALE_SMOOTH)));
            thoughtBubble.setIcon(new ImageIcon((ImageIO.read(new File("thoughtBubble.png"))).getScaledInstance(thoughtBubble.getWidth(), thoughtBubble.getHeight(), Image.SCALE_SMOOTH)));
            mrV.setIcon(new ImageIcon((ImageIO.read(new File("mrVnormal.jpg"))).getScaledInstance(mrV.getWidth(), mrV.getHeight(), Image.SCALE_SMOOTH)));
            malPractice.setIcon(new ImageIcon((ImageIO.read(new File("coffin.png"))).getScaledInstance(malPractice.getWidth(), malPractice.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(JohnF.class
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

        instructions = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        play = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        thoughtBubble = new javax.swing.JLabel();
        john = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mrV = new javax.swing.JLabel();
        malPractice = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        introBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(580, 450));
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(intro.class);
        instructions.setText(resourceMap.getString("instructions.text")); // NOI18N
        instructions.setName("instructions"); // NOI18N
        instructions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instructionsMouseClicked(evt);
            }
        });
        getContentPane().add(instructions);
        instructions.setBounds(320, 360, 120, 26);

        quit.setText(resourceMap.getString("quit.text")); // NOI18N
        quit.setName("quit"); // NOI18N
        quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitMouseClicked(evt);
            }
        });
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(450, 360, 90, 26);

        play.setText(resourceMap.getString("play.text")); // NOI18N
        play.setName("play"); // NOI18N
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(210, 360, 90, 26);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 530, 60);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 230, 90, 50);

        thoughtBubble.setText(resourceMap.getString("thoughtBubble.text")); // NOI18N
        thoughtBubble.setName("thoughtBubble"); // NOI18N
        getContentPane().add(thoughtBubble);
        thoughtBubble.setBounds(120, 220, 100, 90);

        john.setText(resourceMap.getString("john.text")); // NOI18N
        john.setName("john"); // NOI18N
        getContentPane().add(john);
        john.setBounds(10, 290, 100, 130);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 100, 280, 16);

        mrV.setText(resourceMap.getString("mrV.text")); // NOI18N
        mrV.setName("mrV"); // NOI18N
        getContentPane().add(mrV);
        mrV.setBounds(370, 90, 140, 150);

        malPractice.setText(resourceMap.getString("malPractice.text")); // NOI18N
        malPractice.setName("malPractice"); // NOI18N
        getContentPane().add(malPractice);
        malPractice.setBounds(390, 250, 60, 60);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 120, 310, 16);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 140, 330, 20);

        introBackground.setText(resourceMap.getString("introBackground.text")); // NOI18N
        introBackground.setName("introBackground"); // NOI18N
        getContentPane().add(introBackground);
        introBackground.setBounds(0, 0, 560, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //if play button is clicked
    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        //calles main game form
       JohnF johnObject = new JohnF();
       johnObject.setVisible(true);
    }//GEN-LAST:event_playMouseClicked

    private void quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitMouseClicked
        
    }//GEN-LAST:event_quitMouseClicked
    //if instruction button is clicked
    private void instructionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructionsMouseClicked
       //calls instrution form
       instructions johnObject = new instructions();
       johnObject.setVisible(true);
    }//GEN-LAST:event_instructionsMouseClicked

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        //closes game
        this.dispose();
        //stops song
    }//GEN-LAST:event_quitActionPerformed

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
            java.util.logging.Logger.getLogger(intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new intro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton instructions;
    private javax.swing.JLabel introBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel john;
    private javax.swing.JLabel malPractice;
    private javax.swing.JLabel mrV;
    private javax.swing.JButton play;
    private javax.swing.JButton quit;
    private javax.swing.JLabel thoughtBubble;
    // End of variables declaration//GEN-END:variables
}
