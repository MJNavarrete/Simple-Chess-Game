package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class King extends BasePiece{
    
    public King(Color color) {
        //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
        //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
        //it sets the Unicode character for a white piece ('unicode').
        super(color, color == Color.BLACK ? '\u265A' : '\u2654');
    }

    /**
     * A king can move one square in any direction, so the method checks if the differences are 
     * 1 or 0. If the move is valid, it returns true; otherwise, it returns false.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);

        // King can move 1 square in any direction
        return (diffRow == 1 && diffCol == 0) || (diffRow == 0 && diffCol == 1) || (diffRow == 1 && diffCol == 1);
    }
}