package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Knight extends BasePiece{
    
    //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
    //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
    //it sets the Unicode character for a white piece ('unicode').
    public Knight(Color color) {
        super(color, color == Color.BLACK ? '\u265E' : '\u2658');
    }

    /**
     * This method calculates the absolute difference in rows and columns between the starting 
     * position (fromRow, fromCol) and the destination position (toRow, toCol). If the difference 
     * is either (2,1) or (1,2), then the move is considered valid for a knight piece, and the 
     * method returns true; otherwise, it returns false.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);
        return (diffRow == 2 && diffCol == 1) || (diffRow == 1 && diffCol == 2);
    }
}