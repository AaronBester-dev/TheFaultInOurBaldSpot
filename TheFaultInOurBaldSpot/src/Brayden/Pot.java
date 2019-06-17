/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brayden;


public class Pot {
private boolean potatoI;
private boolean tomatoI;
private boolean mushroomI;
private boolean potatoS;
private boolean tomatoS;
private boolean mushroomS;

public Pot(){
 potatoI = false;
 tomatoI = false;
 mushroomI = false;
 potatoS = false;
 tomatoS = false;
 mushroomS = false; 
    
}

public void setPotato(boolean input){
    potatoI= input;   
} 

public boolean getPotato(){
    return potatoI;
}
public void setTomato(boolean input){
    tomatoI= input;   
} 

public boolean getTomato(){
    return tomatoI;
}

public void setMushroom(boolean input){
    mushroomI= input;   
} 

public boolean getMushroom(){
    return mushroomI;
}
public void setPotatoS(boolean input){
    potatoS= input;   
} 

public boolean getPotatoS(){
    return potatoS;
}
public void setTomatoS(boolean input){
    tomatoS= input;   
} 

public boolean getTomatoS(){
    return tomatoS;
}

public void setMushroomS(boolean input){
    mushroomS= input;   
} 

public boolean getMushroomS(){
    return mushroomS;
}

}


