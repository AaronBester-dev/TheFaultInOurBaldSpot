/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AaronPackage;

/**
 *
 * @author aaron.bester708
 */
public class EnemyClass {
       int health;
    String picFile, soundFile;
    boolean direction;
    javax.swing.JLabel enemyLabel;

    public int getHealth() {
        return health;
    }

    public void setHealth(int hP){
        health = hP;
    }
    
    public javax.swing.JLabel getLabel() {
        return enemyLabel;
    }
     public void setLabel(javax.swing.JLabel jL){
        enemyLabel = jL;
    }
}
