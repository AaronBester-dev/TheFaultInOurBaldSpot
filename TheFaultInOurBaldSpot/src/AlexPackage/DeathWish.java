/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlexPackage;

//*File Name: TheFaultInOurBaldSpot
//* Date: June 17, 2019
//* Name: Alex Rejep
// *Description: This form creates the deathwish constructor
public class DeathWish extends EnemiesClass {
//deathwish Constructor
    public DeathWish() {
        health = 1;
        speed = 3;
        strength = 3;
        height = (int)(Math.random()*10+1);
    }
}
