/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 18JBond
 */
public class SubroutineTest {
    /**
     * @param args the command line arguments
     */
    private static final int totalMineCount = 10;
    private static boolean buttonsAsMines[][] = new boolean[10][10];
    
    public static void main(String[] args) {
        placeMines(); //place the mines 
        //testPlaceMines();
        
           
    }
    
    private static void placeMines(){
        //Initialisation 
        int positionX;
        int positionY;
        int mines = 0;

        while(mines<totalMineCount){
            //Generate a random x and y coordinate
            positionX = (int)(Math.random()*10);
            positionY = (int)(Math.random()*10);
            //if this position does not already have a mine, place a mine there
            if (!buttonsAsMines[positionX][positionY]){
                buttonsAsMines[positionX][positionY] = true;
                //decrement 
                mines += 1;
            }
        }      
    }
    
    
    
    
    private static void testPlaceMines() {
        int numberOfMines = 0;
        for (int i =0; i<buttonsAsMines.length; i++){
            for (int j = 0; j < buttonsAsMines[i].length; j++) {
                System.out.print(buttonsAsMines[i][j] + ", ");
                if (buttonsAsMines[i][j]){
                    numberOfMines += 1;
                }
            }
            System.out.println("");
        }
        System.out.println(numberOfMines);
    }
}
