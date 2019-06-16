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
public class character {
private String iteam;
private String skin;
private int speed;
private Boolean potatoI;
private Boolean tomatoI;
private Boolean mushroomI;
private Boolean potatoS;
private Boolean tomatoS;
private Boolean mushroomS;

public character(){
 iteam = "";
 skin = "braydenNude.png";
 speed = 20;
 potatoI = false;
 tomatoI = false;
 mushroomI = false;
 potatoS = false;
 tomatoS = false;
 mushroomS = false; 

    if (potatoI = true) {
iteam = "potatoBox.png";
    }
    if (tomatoI = true) {
iteam = "tomatoBox.png";
    }
    if (mushroomI = true) {
iteam = "mushroomBox.png";
    }
    if (tomatoS = true) {
iteam = "potatoBox.png";
    }
    if (mushroomS = true) {
iteam = "potatoBox.png";
    }
    if (potatoS = true) {
iteam = "potatoBox.png";
    }
}
public String getItemCode(){
    return iteam;
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
public boolean getPotatoS(){
    return potatoS;
}
public void setPotatoS(boolean input){
     potatoS = input;
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





