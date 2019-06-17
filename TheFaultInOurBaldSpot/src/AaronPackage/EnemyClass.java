

//Program title: The FaultInOurBaldSpot 
//Author: Aaron Bester
//Date: June 17th, 2019
//Program Description: Mega Man Game



package AaronPackage;

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
