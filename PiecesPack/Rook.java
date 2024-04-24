package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Rook extends BasePiece{

    public Rook(Color color) {
        //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
        //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
        //it sets the Unicode character for a white piece ('unicode'). 
        super(color, color == Color.BLACK ? '\u265C' : '\u2656');
    }

    /**
     *  It checks if the move is either horizontal (same row, different column) or 
     * vertical (different row, same column). If the move is valid, it returns true; 
     * otherwise, it returns false.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        // Rook can move horizontally or vertically
        return (fromRow == toRow && fromCol != toCol) || (fromRow != toRow && fromCol == toCol);
    }
}