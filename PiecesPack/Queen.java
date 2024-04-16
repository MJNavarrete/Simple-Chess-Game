package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Queen extends BasePiece{
    //private String color;
    public Queen(Color color) {
        super(color, color == Color.BLACK ? '\u265B' : '\u2655');
    }

    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = Math.abs(toRow - fromRow);
        int diffCol = Math.abs(toCol - fromCol);

        // Queen can move like a rook or a bishop
        return (diffRow == 0 || diffCol == 0 || diffRow == diffCol);
    }

}