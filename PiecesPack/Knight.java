package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Knight extends BasePiece{
    //private String color;

    public Knight(Color color) {
        super(color, color == Color.BLACK ? '\u265E' : '\u2658');
    }

    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);
        return (diffRow == 2 && diffCol == 1) || (diffRow == 1 && diffCol == 2);
    }
}