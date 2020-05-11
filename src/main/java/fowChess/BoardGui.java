/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowChess;

/**
 *
 * @author Thomas Wolf
 */
public class BoardGui {
    static void printBoard(Board board){
        boolean whitesTurn = board.isWhiteNext();
        Piece[][] tiles = board.getTiles();
        int x = tiles.length;
        int y = tiles[0].length;
        
        if(x != y || x <= 0){
            System.out.println("Error, the board is not square. x ="+x+", y="+y+"\n");
            return;
        }
//        System.out.println(" __________________________________________________ ");
//        System.out.println("+                                                  +");
        if(whitesTurn)
            System.out.println("|                White's Turn                      |");
        else
            System.out.println("|                Black's Turn                      |");
        System.out.println("+__________________________________________________+");
        System.out.println("+                                                  +");
        for(int i = 0; i < x; i++){
            System.out.print("| ");
            for(int j = 0; j < y; j++){
                Piece thispiece = tiles[i][j];
                
                if(thispiece != null){
                    System.out.print("["+thispiece.getName().substring(0, 4)+"]");
                }else{
                    //System.out.print("[ "+i+" "+j+"]");
                    System.out.print("[    ]");
                }
            }
            System.out.println(" |");
        }
        System.out.println("+__________________________________________________+");
        
    }
}
