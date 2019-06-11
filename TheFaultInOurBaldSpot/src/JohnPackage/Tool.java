/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    javax.swing.JLabel toolLabel;
    int damage;
    boolean isClicked = false;
    
    public Tool() {
    }
    
    public Tool(javax.swing.JLabel _toolLabel, int _damage) {
        toolLabel = _toolLabel;
        damage = _damage;
    }
    
    public void setClicked (boolean _clicked){
        isClicked = _clicked;
    }
    
    public boolean getClicked (){
        return isClicked;
    }
    
    public javax.swing.JLabel getLabel() {
        return toolLabel;
    }
    
}
