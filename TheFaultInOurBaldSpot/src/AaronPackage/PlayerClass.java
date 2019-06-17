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

//Class that deals with all of the health and label stuff for the player character
public class PlayerClass {
    //Declares the health and playerlabel variable
      int health; 
    javax.swing.JLabel playerLabel;

    //Void gets the health of the player character
    public int getHealth() {
       
        return health;
    }
//Void sets the health of a player character to a new health value
    public void setHealth(int hP){
        health = hP;
    }
    
  //Void gets the label of the player character
    public javax.swing.JLabel getLabel() {
        return playerLabel;
    }
    //Void sets the label of the player character
     public void setLabel(javax.swing.JLabel jL){
        playerLabel = jL;
    }
}
