package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Bishop extends BasePiece{
    
    //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
    //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
    //it sets the Unicode character for a white piece ('unicode').
    public Bishop(Color color) {
        super(color, color == Color.BLACK ? '\u265D' : '\u2657');
    }

    /**
     * Method calculates the absolute difference in rows and columns between the starting and 
     * destination positions and checks if the absolute differences are equal (indicating a diagonal move). 
     * If the move is valid, it returns true; otherwise, it returns false.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);
        return diffRow == diffCol;
    }
}