package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class King extends BasePiece{
    //private String color;

    public King(Color color) {
        super(color, color == Color.BLACK ? '\u265A' : '\u2654');
    }

    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);

        // King can move 1 square in any direction
        return (diffRow == 1 && diffCol == 0) || (diffRow == 0 && diffCol == 1) || (diffRow == 1 && diffCol == 1);
    }
}