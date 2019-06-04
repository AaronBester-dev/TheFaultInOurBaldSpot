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
    
public soup (String uPhotoCode){
  potato  = randomB();
  tomato = randomB();
  mushroom = randomB();
  photoCode = uPhotoCode;  
}
public boolean randomB(){
int numOne = (int)(Math.random() * 2 + 1);
    if (numOne == 1) {
        return true;
    } else {
        return false;
    
}
    
    

}
    
    
}
