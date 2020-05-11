/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fowChess;

import java.util.LinkedList;

/**
 *
 * @author Thomas Wolf
 */
public class Board {
    int N; // size of board, always square
    Piece[][] tiles; // the board itself
    boolean whiteNext;
    
    Board()
    {
         // size of board, always square    
        
        
        //init board with pieces
        
        tiles = standard();
        whiteNext = true;
//        BoardGui.printBoard(tiles);
//        int a = 1;
//        int b = 3;
//        Piece thisPiece = tiles[a][b];
//        LinkedList<Move> theirMoves = thisPiece.getMoves();
//        Move thisMove = theirMoves.get(1);
//        int c = a + thisMove.getY();
//        int d = b + thisMove.getX();
//        if(make_move(a,b,c,d)){
//            System.out.println("\n");
//            BoardGui.printBoard(tiles);
//        }
        
             
    }
    boolean make_move(int x1, int y1, int x2, int y2){
        Piece a = tiles[x1][y1];
        Piece b = tiles[x2][y2];
        //simple error checks
        if(a == null | 
                x1 < 0 | x1 >= N |
                x2 < 0 | x2 >= N |
                y1 < 0 | y1 >= N |
                y2 < 0 | y2 >= N ) 
        {
            System.out.println("error, invalid move request recieved\n "
                    + "x1="+x1+", y1="+y1+", x2="+x2+", y2="+y2+"\n");
            return false;
        }
        // a isn't null at this point
        if(b != null)
            if(a.getTeam() == b.getTeam())
                return false;
        
        tiles[x1][y1] = null;
        tiles[x2][y2] = a;
        return true;        
    }
    boolean make_move(int [] move){
        int x1 = move[0];
        int y1 = move[1];
        int x2 = move[2];
        int y2 = move[3];
        return make_move(x1, y1, x2, y2);      
    }
    Piece[][] standard()
    {
        N = 8;
        tiles = new Piece[N][N];
        //make Pawns
        Piece pawnW = new Piece("Pawn", 0);
        Piece pawnB = new Piece("Pawn", 1);

        //Set pawn moves
        LinkedList<Move> pawnWmoves = new LinkedList<>();
        LinkedList<Move> pawnBmoves = new LinkedList<>();

        Move move_forward_W = new Move(0, 1, false);
        Move first_move_W = new Move(0, 2, false);
        pawnWmoves.add(move_forward_W);
        pawnWmoves.add(first_move_W);

        Move move_forward_B = new Move(0, -1, false);
        Move first_move_B = new Move(0, -2, false);
        pawnBmoves.add(move_forward_B);
        pawnBmoves.add(first_move_B);

        pawnW.setMoves(pawnWmoves);
        pawnB.setMoves(pawnBmoves);
        
        for(int i = 0; i < N; i++){
            //set pawn position
            tiles[1][i] = pawnW;
            tiles[6][i] = pawnB;
        }
        
        Piece RookW = new Piece("Rook", 0);
        Piece RookB = new Piece("Rook", 1);
        
        tiles[0][0] = RookW;
        tiles[0][7] = RookW;
        tiles[7][0] = RookB;
        tiles[7][7] = RookB;
        
        Piece KnightW = new Piece("Knight", 0);
        Piece KnightB = new Piece("Knight", 1);
        
        tiles[0][1] = KnightW;
        tiles[0][6] = KnightW;
        tiles[7][1] = KnightB;
        tiles[7][6] = KnightB;
        
        Piece BishopW = new Piece("Bishop", 0);
        Piece BishopB = new Piece("Bishop", 1);
        
        tiles[0][2] = BishopW;
        tiles[0][5] = BishopW;
        tiles[7][2] = BishopB;
        tiles[7][5] = BishopB;
        
        Piece QueenW = new Piece("Queen", 0);
        Piece QueenB = new Piece("Queen", 1);
        Piece KingW = new Piece("King", 0);
        Piece KingB = new Piece("King", 1);
        
        tiles[0][3] = QueenW;
        tiles[0][4] = KingW;
        tiles[7][3] = QueenB;
        tiles[7][4] = KingB;
        
        
        
        return tiles;
    }
    boolean isWhiteNext(){
        return whiteNext;
    }
    void toggleTurn(){
        whiteNext = !whiteNext;
    }
    
    public Piece[][] getTiles() {
        return tiles;
    }

    public void setTiles(Piece[][] tiles) {
        this.tiles = tiles;
    }
    
}
