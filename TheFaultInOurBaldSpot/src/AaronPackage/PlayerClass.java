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
public class PlayerClass {
      int health, speed, strength, height;
    String picFile, soundFile;
    boolean direction;
    javax.swing.JLabel enemyLabel;

    public int getHealth() {
        return health;
    }

    public void setHealth(int hP){
        health = hP;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed (int sP){
        speed = sP;
    }
    
    public int getStrength() {
        return strength;
    }

    public void setStrength (int sT){
        strength = sT;
    }
   
       public int getHeight() {
        return height;
    }

    public void setHeight(int hT){
        height = hT;
    } 
    
     public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean dT){
        direction =dT;
    }
    public javax.swing.JLabel getLabel() {
        return enemyLabel;
    }
     public void setLabel(javax.swing.JLabel jL){
        enemyLabel = jL;
    }
}
