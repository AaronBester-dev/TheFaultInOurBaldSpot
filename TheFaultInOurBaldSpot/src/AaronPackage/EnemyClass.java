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
//Class that is responsible for the enemies
public class EnemyClass {
    //Declares all the variables the enemy needs
       int health;
    String picFile, soundFile;
    boolean direction;
    javax.swing.JLabel enemyLabel;
//Void that gets the health of the enemy
    public int getHealth() {
        return health;
    }
//Void that sets the health of the enemy
    public void setHealth(int hP){
        health = hP;
    }
    //Void that gets the label of the enemy
    public javax.swing.JLabel getLabel() {
        return enemyLabel;
    }
    //Void that sets the label of the enemy to something new
     public void setLabel(javax.swing.JLabel jL){
        enemyLabel = jL;
    }
}
