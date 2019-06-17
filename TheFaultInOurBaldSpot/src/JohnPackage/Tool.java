//Program title: The FaultInOurBaldSpot 
//Author: John Diemert
//Date: june 17th, 2019
//Program Description: surgeon simulator game

package JohnPackage;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author john.diemert744
 */
public class Tool {
    //declares varibles/properties of the tools
    javax.swing.JLabel toolLabel;
    int damage;
    boolean isClicked = false;
    //default constructor left blank
    public Tool() {
    }
    //construtor with damage and label
    public Tool(javax.swing.JLabel _toolLabel, int _damage) {
        toolLabel = _toolLabel;
        damage = _damage;
    }
    //sets is clicked property
    public void setClicked (boolean _clicked){
        isClicked = _clicked;
    }
    //gets is clicked property
    public boolean getClicked (){
        return isClicked;
    }
    //damage encapsulation 
    public void damage (int _damage){
       damage = _damage;
    }
    //gets damage
    public int getDamage (){
        return damage;
    }
    //gets label
    public javax.swing.JLabel getLabel() {
        return toolLabel;
    }
    
}
