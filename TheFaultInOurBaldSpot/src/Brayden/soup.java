/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brayden;

/**
 *
 * @author Brayd
 */
public class soup {

    private boolean potato, tomato, mushroom;
    private String photoCode;

    public soup() {
        int numOne = (int) (Math.random() * 3 + 1);
        do {
            if (numOne == 1) {
                potato = true;
                photoCode = "potatoBox.png";
                break;
            }
            if (numOne == 2) {
                tomato = true;
                photoCode = "tomatoBox.png";
                break;
            }
            if (numOne == 3) {
                mushroom = true;
                photoCode = "mushroomBox.png";
                break;
            }

        } while (true);

    
    
    

}
    
    
}
