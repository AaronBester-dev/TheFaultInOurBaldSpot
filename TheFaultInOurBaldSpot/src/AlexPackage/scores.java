/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlexPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alexander.rejep819
 */
public class scores extends javax.swing.JFrame {

    /**
     * Creates new form scores
     */
    public scores() throws IOException {
        initComponents();
        jLabel1.setText("Game High Scores");
        //dummy varible
        BufferedReader readFile;

        //array list to store the data from the file 
        ArrayList ScoreArrayList = new ArrayList<Integer>();
        ArrayList InitialsArrayList = new ArrayList<String>();
        //OptionPane to ask the reader what local file they would like the program to read
        //NO SAFE GAURD FOR THE NULL POINTER EXCEPTION, THIS HAS BEEN APPROVED BY MR.V

        //Opens the text file and attaches a BufferedReader
        readFile = new BufferedReader(new FileReader("HighScoresAlex.txt"));

        //do loop to continue to get data until theres no more lines to read
        String myLine;
        do {
            //myLine is equal to line being read
            myLine = readFile.readLine();
            if (myLine == null) {
                // if nothing is there to be read, the loop is exited
                break;
            } else {
                //adds the number to its arraylist
                InitialsArrayList.add(myLine);
                //reads the next line
                //  myLine =;
                // adds that line to the psalm arraylist
                ScoreArrayList.add(Integer.parseInt(readFile.readLine()));
            }
        } while (myLine != null);
        System.out.println("");

        //prints the text, uses for loop to print each line on its own line
        for (int i = 0; i < ScoreArrayList.size(); i++) {
            System.out.println(ScoreArrayList.get(i));
        }
        selectionSort(ScoreArrayList, InitialsArrayList);
        System.out.println("These numbers in a sorted list are: " + ScoreArrayList);
        highScore1.setText(String.valueOf(ScoreArrayList.get(0)));
        highScore2.setText(String.valueOf(ScoreArrayList.get(1)));
        highScore3.setText(String.valueOf(ScoreArrayList.get(2)));
        highScore4.setText(String.valueOf(ScoreArrayList.get(3)));
        highScore5.setText(String.valueOf(ScoreArrayList.get(4)));

        Initial1.setText(String.valueOf(InitialsArrayList.get(0)));
        Initial2.setText(String.valueOf(InitialsArrayList.get(1)));
        Initial3.setText(String.valueOf(InitialsArrayList.get(2)));
        Initial4.setText(String.valueOf(InitialsArrayList.get(3)));
        Initial5.setText(String.valueOf(InitialsArrayList.get(4)));

    }

    public static void selectionSort(ArrayList<Integer> myArrayList, ArrayList<String> TextArray) {
        int smallest;
        for (int i = 0; i < myArrayList.size() - 1; i++) {
            smallest = i;
            //see if there is a smaller number further in the array
            for (int index = i + 1; index < myArrayList.size(); index++) {
                //the conditions in this if statement are switched (compared to the previous statement) to make it descending 
                if (myArrayList.get(smallest) < myArrayList.get(index)) {
                    swap(myArrayList, TextArray, smallest, index);
                }
            }
        }
    }

    public static void swap(ArrayList<Integer> array2, ArrayList<String> array3, int first, int second) {
        int hold = array2.get(first);
        array2.set(first, array2.get(second));
        array2.set(second, hold);
        String hold2 = array3.get(first);
        array3.set(first, array3.get(second));
        array3.set(second, hold2);
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
        highScore4 = new javax.swing.JLabel();
        highScore5 = new javax.swing.JLabel();
        Initial1 = new javax.swing.JLabel();
        Initial2 = new javax.swing.JLabel();
        Initial3 = new javax.swing.JLabel();
        Initial4 = new javax.swing.JLabel();
        Initial5 = new javax.swing.JLabel();
        Victory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(scores.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 580, 80);

        highScore1.setFont(resourceMap.getFont("highScore1.font")); // NOI18N
        highScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore1.setText(resourceMap.getString("highScore1.text")); // NOI18N
        highScore1.setName("highScore1"); // NOI18N
        getContentPane().add(highScore1);
        highScore1.setBounds(300, 100, 100, 40);

        highScore2.setFont(resourceMap.getFont("highScore2.font")); // NOI18N
        highScore2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore2.setText(resourceMap.getString("highScore2.text")); // NOI18N
        highScore2.setToolTipText(resourceMap.getString("highScore2.toolTipText")); // NOI18N
        highScore2.setName("highScore2"); // NOI18N
        getContentPane().add(highScore2);
        highScore2.setBounds(300, 200, 100, 40);

        highScore3.setFont(resourceMap.getFont("highScore3.font")); // NOI18N
        highScore3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore3.setText(resourceMap.getString("highScore3.text")); // NOI18N
        highScore3.setName("highScore3"); // NOI18N
        getContentPane().add(highScore3);
        highScore3.setBounds(300, 300, 100, 40);

        highScore4.setFont(resourceMap.getFont("highScore4.font")); // NOI18N
        highScore4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore4.setText(resourceMap.getString("highScore4.text")); // NOI18N
        highScore4.setName("highScore4"); // NOI18N
        getContentPane().add(highScore4);
        highScore4.setBounds(300, 400, 100, 40);

        highScore5.setFont(resourceMap.getFont("highScore5.font")); // NOI18N
        highScore5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore5.setText(resourceMap.getString("highScore5.text")); // NOI18N
        highScore5.setName("highScore5"); // NOI18N
        getContentPane().add(highScore5);
        highScore5.setBounds(300, 500, 100, 40);

        Initial1.setFont(resourceMap.getFont("Initial1.font")); // NOI18N
        Initial1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Initial1.setText(resourceMap.getString("Initial1.text")); // NOI18N
        Initial1.setName("Initial1"); // NOI18N
        getContentPane().add(Initial1);
        Initial1.setBounds(200, 100, 100, 40);

        Initial2.setFont(resourceMap.getFont("Initial2.font")); // NOI18N
        Initial2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Initial2.setText(resourceMap.getString("Initial2.text")); // NOI18N
        Initial2.setName("Initial2"); // NOI18N
        getContentPane().add(Initial2);
        Initial2.setBounds(200, 200, 100, 40);

        Initial3.setFont(resourceMap.getFont("Initial3.font")); // NOI18N
        Initial3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Initial3.setText(resourceMap.getString("Initial3.text")); // NOI18N
        Initial3.setName("Initial3"); // NOI18N
        getContentPane().add(Initial3);
        Initial3.setBounds(200, 300, 100, 40);

        Initial4.setFont(resourceMap.getFont("Initial4.font")); // NOI18N
        Initial4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Initial4.setText(resourceMap.getString("Initial4.text")); // NOI18N
        Initial4.setName("Initial4"); // NOI18N
        getContentPane().add(Initial4);
        Initial4.setBounds(200, 400, 100, 40);

        Initial5.setFont(resourceMap.getFont("Initial5.font")); // NOI18N
        Initial5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Initial5.setText(resourceMap.getString("Initial5.text")); // NOI18N
        Initial5.setName("Initial5"); // NOI18N
        getContentPane().add(Initial5);
        Initial5.setBounds(200, 500, 100, 40);

        Victory.setText(resourceMap.getString("Victory.text")); // NOI18N
        Victory.setName("Victory"); // NOI18N
        Victory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VictoryActionPerformed(evt);
            }
        });
        getContentPane().add(Victory);
        Victory.setBounds(270, 540, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VictoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VictoryActionPerformed
        // TODO add your handling code here:
        JFrame Victory1 = new Victory();
        Victory1.setVisible(true);
        dispose();
    }//GEN-LAST:event_VictoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(scores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new scores().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Initial1;
    private javax.swing.JLabel Initial2;
    private javax.swing.JLabel Initial3;
    private javax.swing.JLabel Initial4;
    private javax.swing.JLabel Initial5;
    private javax.swing.JButton Victory;
    private javax.swing.JLabel highScore1;
    private javax.swing.JLabel highScore2;
    private javax.swing.JLabel highScore3;
    private javax.swing.JLabel highScore4;
    private javax.swing.JLabel highScore5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
