/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowChess;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Thomas Wolf
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        boolean gameOn = true; // temporary, to be replaced with [in checkmate]
        int i = 0;
        Board theBoard = new Board();
        // the game is 'played' here in main!
        BoardGui.printBoard(theBoard);
        while(gameOn){
            // get move choice from user
            boolean whiteIsNext = theBoard.isWhiteNext();
            int teamc = 1;
            if(whiteIsNext){
                teamc = 0;
            }
            int[] choice = getChoice(teamc, false);
            int[] move_choice = getChoice(teamc, true);
            int[] move = {choice[0], choice[1], choice[0] + move_choice[0], choice[1] + move_choice[1] };
            boolean worked = theBoard.make_move(move);
            if(worked){
                theBoard.toggleTurn();
            
            BoardGui.printBoard(theBoard);
            if(i++ > 5){
                gameOn = false;
            }
            }
        }
    
    }
    
    static int[] getChoice(int team, boolean move){
        Random rand = new Random();
        if(move){
        int rand_int = (rand.nextInt(1) + 2 )*((team*-2)+1);
        int[] choice = {rand_int, 0};
        return choice;
        }
        else{
        int rand_int = rand.nextInt(8);
        
        int[] choice = {team*5 + 1 , rand_int};
        return choice;
        }
    }
    
}
