//Program title: The FaultInOurBaldSpot 
//Author: John Diemert
//Date: june 17th, 2019
//Program Description: surgeon simulator game

package JohnPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author john.diemert744
 */
public class scoreFrame extends javax.swing.JFrame {

    int score;

    /**
     * Creates new form scoreFrame
     */
    public scoreFrame() throws IOException {
        //declares varibles
        BufferedReader readFile = null;
        String reading = "";
        int intReading = 0;
        //array list to store the data from the file 
        ArrayList myArrayList = new ArrayList<Integer>();
        //initializes components 
        initComponents();
        myInitComponents(john);
        //creates fonts
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        Font font2 = new Font("SansSerif", Font.BOLD, 20);
        //sets text and font to various labels and buttons
        jButton1.setText("MINIGAME?");
        goTo.setText("GO TO INTRO");
        jLabel1.setText("Game High Scores");
        jLabel1.setFont(font1);
        yourScoreLabel.setText("Your Score:");
        yourScoreLabel.setFont(font2);
        yourScore.setFont(font2);
        highScore1.setFont(font2);
        highScore2.setFont(font2);
        highScore3.setFont(font2);
        winLabel.setText("Congrats on your great cutting and a great 4 years, thanks MR.V");
        winLabel.setFont(font2);
        //Opens the text file and attaches a BufferedReader
        readFile = new BufferedReader(new FileReader("HighScores.txt"));
        //do loop to continue to get data until theres no more lines to read
        do {
            //sets the line of the external file to the dummy varible
            reading = readFile.readLine();
            //if statment to not get a "null" line when printing the array 
            if (reading != null) {
                //adds line to array
                try {
                    intReading = Integer.parseInt(reading);
                } catch (NumberFormatException e) {
                }
                myArrayList.add(intReading);
            }
        } while (reading != null);
        //closes text file as thats proper coding 
        readFile.close();
        //prints the text, uses for loop to print each line on its own line
        //gets the last index added and sets it equal to "score"
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
            score = (Integer) myArrayList.get(i);
        }
        //prints last score to a label
        yourScore.setText("" + score);
        //callse sort function
        selectionSort(myArrayList);
        System.out.println("These numbers in a sorted list are: " + myArrayList);
        //sets highest scores to labels
        highScore1.setText(String.valueOf(myArrayList.get(0)));
        highScore2.setText(String.valueOf(myArrayList.get(1)));
        highScore3.setText(String.valueOf(myArrayList.get(2)));
    }

    public static void selectionSort(ArrayList myArrayList) {
        int smallest;
        for (int i = 0; i < myArrayList.size() - 1; i++) {
            smallest = i;
            //see if there is a smaller number further in the array
            for (int index = i + 1; index < myArrayList.size(); index++) {
                //the conditions in this if statement are switched (compared to the previous statement) to make it descending 
                if ((Integer) myArrayList.get(smallest) < (Integer) myArrayList.get(index)) {
                    swap(myArrayList, smallest, index);
                }
            }
        }
    }

    public static void swap(ArrayList array2, int first, int second) {
        int hold = (Integer) array2.get(first);
        array2.set(first, array2.get(second));
        array2.set(second, hold);
    }

    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //try to cathc IOexceptions
        try {
            //sets icons to labels 
            mrV.setIcon(new ImageIcon((ImageIO.read(new File("mrVnormal.jpg"))).getScaledInstance(mrV.getWidth(), mrV.getHeight(), Image.SCALE_SMOOTH)));
            brayden.setIcon(new ImageIcon((ImageIO.read(new File("brayden.jpg"))).getScaledInstance(brayden.getWidth(), brayden.getHeight(), Image.SCALE_SMOOTH)));
            aaron.setIcon(new ImageIcon((ImageIO.read(new File("aaronJohnGame.jpg"))).getScaledInstance(aaron.getWidth(), aaron.getHeight(), Image.SCALE_SMOOTH)));
            john.setIcon(new ImageIcon((ImageIO.read(new File("john.jpg"))).getScaledInstance(john.getWidth(), john.getHeight(), Image.SCALE_SMOOTH)));
            alex.setIcon(new ImageIcon((ImageIO.read(new File("alex.jpg"))).getScaledInstance(alex.getWidth(), alex.getHeight(), Image.SCALE_SMOOTH)));
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

        jLabel1 = new javax.swing.JLabel();
        highScore1 = new javax.swing.JLabel();
        highScore2 = new javax.swing.JLabel();
        highScore3 = new javax.swing.JLabel();
        yourScoreLabel = new javax.swing.JLabel();
        yourScore = new javax.swing.JLabel();
        winLabel = new javax.swing.JLabel();
        john = new javax.swing.JLabel();
        mrV = new javax.swing.JLabel();
        brayden = new javax.swing.JLabel();
        aaron = new javax.swing.JLabel();
        alex = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        goTo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 713));
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(scoreFrame.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 380, 47);

        highScore1.setText(resourceMap.getString("highScore1.text")); // NOI18N
        highScore1.setName("highScore1"); // NOI18N
        getContentPane().add(highScore1);
        highScore1.setBounds(10, 80, 72, 20);

        highScore2.setText(resourceMap.getString("highScore2.text")); // NOI18N
        highScore2.setName("highScore2"); // NOI18N
        getContentPane().add(highScore2);
        highScore2.setBounds(10, 110, 72, 20);

        highScore3.setText(resourceMap.getString("highScore3.text")); // NOI18N
        highScore3.setName("highScore3"); // NOI18N
        getContentPane().add(highScore3);
        highScore3.setBounds(10, 140, 72, 20);

        yourScoreLabel.setText(resourceMap.getString("yourScoreLabel.text")); // NOI18N
        yourScoreLabel.setName("yourScoreLabel"); // NOI18N
        getContentPane().add(yourScoreLabel);
        yourScoreLabel.setBounds(760, 20, 130, 30);

        yourScore.setText(resourceMap.getString("yourScore.text")); // NOI18N
        yourScore.setName("yourScore"); // NOI18N
        getContentPane().add(yourScore);
        yourScore.setBounds(900, 20, 120, 30);

        winLabel.setText(resourceMap.getString("winLabel.text")); // NOI18N
        winLabel.setName("winLabel"); // NOI18N
        getContentPane().add(winLabel);
        winLabel.setBounds(170, 190, 790, 80);

        john.setText(resourceMap.getString("john.text")); // NOI18N
        john.setName("john"); // NOI18N
        getContentPane().add(john);
        john.setBounds(180, 300, 130, 130);

        mrV.setText(resourceMap.getString("mrV.text")); // NOI18N
        mrV.setName("mrV"); // NOI18N
        getContentPane().add(mrV);
        mrV.setBounds(400, 380, 170, 160);

        brayden.setText(resourceMap.getString("brayden.text")); // NOI18N
        brayden.setName("brayden"); // NOI18N
        getContentPane().add(brayden);
        brayden.setBounds(660, 310, 130, 130);

        aaron.setText(resourceMap.getString("aaron.text")); // NOI18N
        aaron.setName("aaron"); // NOI18N
        getContentPane().add(aaron);
        aaron.setBounds(180, 520, 130, 130);

        alex.setText(resourceMap.getString("alex.text")); // NOI18N
        alex.setName("alex"); // NOI18N
        getContentPane().add(alex);
        alex.setBounds(650, 530, 130, 130);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(880, 300, 120, 40);

        goTo.setText(resourceMap.getString("goTo.text")); // NOI18N
        goTo.setName("goTo"); // NOI18N
        goTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToMouseClicked(evt);
            }
        });
        getContentPane().add(goTo);
        goTo.setBounds(880, 360, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        //opens mini game
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        miniGame johnObject = new miniGame();
        johnObject.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
        //go to intro screen by closing form
    private void goToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToMouseClicked
        //closes form 
        this.dispose();
    }//GEN-LAST:event_goToMouseClicked

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
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new scoreFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(scoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aaron;
    private javax.swing.JLabel alex;
    private javax.swing.JLabel brayden;
    private javax.swing.JButton goTo;
    private javax.swing.JLabel highScore1;
    private javax.swing.JLabel highScore2;
    private javax.swing.JLabel highScore3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel john;
    private javax.swing.JLabel mrV;
    private javax.swing.JLabel winLabel;
    private javax.swing.JLabel yourScore;
    private javax.swing.JLabel yourScoreLabel;
    // End of variables declaration//GEN-END:variables
}
