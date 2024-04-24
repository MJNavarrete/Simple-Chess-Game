package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Queen extends BasePiece{
    
    public Queen(Color color) {
        //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
        //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
        //it sets the Unicode character for a white piece ('unicode').
        super(color, color == Color.BLACK ? '\u265B' : '\u2655');
    }

    /** 
     * A queen can move like a rook (horizontally or vertically) or a bishop (diagonally), so the method 
     * checks if the absolute differences are 0, between rows and columns, for horizontal or vertical moves and equal
     * for diagonal moves. If the move is valid, it returns true; otherwise, it returns false.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);

        // Queen can move like a rook or a bishop
        return (diffRow == 0 || diffCol == 0 || diffRow == diffCol);
    }

}