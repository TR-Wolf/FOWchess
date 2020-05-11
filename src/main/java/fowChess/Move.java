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
public class Move {
    private int X;
    private int Y;
    //private boolean collision;
    private boolean takes;
    
    Move(int x, int y, boolean takes) {
        this.X = x;
        this.Y = y;
       // collision = true;
        this.takes = takes;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    public boolean isTakes() {
        return takes;
    }

    public void setTakes(boolean takes) {
        this.takes = takes;
    }
    
    // This is for if a move does not take, and collides?
    // not sure if I need it, commenting out for now.
    
//    public boolean isCollision() {
//        return collision;
//    }
//
//    public void setCollision(boolean collision) {
//        this.collision = collision;
//    }
    
}
