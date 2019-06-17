
//Program title: The FaultInOurBaldSpot 
//Author: Aaron Bester
//Date: June 17th, 2019
//Program Description: Mega Man Game



package AaronPackage;


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
