package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Bishop extends BasePiece{

    public Bishop(Color color) {
        super(color, color == Color.BLACK ? '\u265D' : '\u2657');
    }

    /**
     * rules of movement for the Bishop.
     */
    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);
        return diffRow == diffCol;
    }
}