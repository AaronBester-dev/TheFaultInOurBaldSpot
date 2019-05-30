/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlexPackage;

/**
 *
 *
 */
public class EnemiesClass {

    int health, speed, strength;

    public EnemiesClass(int hP, int sP, int sT) {
        health = hP;
        speed = sP;
        strength = sT;
        // add gets and sets for health speed and strength
    }

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
    
    public class Imp extends EnemiesClass {

    }

    public class Demon extends EnemiesClass {

    }

    public class Beholder extends EnemiesClass {

    }

    public class DeathWishDemon extends EnemiesClass {

    }
}
