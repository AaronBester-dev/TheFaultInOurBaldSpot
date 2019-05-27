/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AaronPackage;

import javax.swing.JLabel;

/**
 *
 * @author aaron.bester708
 */
public class AaronLevel {
    
     public static void main(String args[]) {
    
         
         
         
        }
    public static void intializeGrid(){
        int levelHeight = 0;
        int levelWidth;
        int screenHeight;
        int screenWidth;
        String levelGrid [][] = new String [54][36];
        JLabel pictureGrid[][] = new JLabel [54][36] ;        
        
        for(levelHeight = 0; levelHeight <= 36; levelHeight++) {
           for(levelWidth = 0; levelWidth <= 54; levelWidth++) {
        levelGrid[levelWidth][levelHeight] = "A";
           pictureGrid[levelWidth][levelHeight] = new JLabel();
            
        
            
           
    }
    }
        
        
    } 
     
    public static void readLevelFile(){
        
    }
    
    }
    
    
    

