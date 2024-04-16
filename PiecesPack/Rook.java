package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Rook extends BasePiece{
    //private String color;

    public Rook(Color color) {
        super(color, color == Color.BLACK ? '\u265C' : '\u2656');
    }

    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        // Rook can move horizontally or vertically
        return (fromRow == toRow && fromCol != toCol) || (fromRow != toRow && fromCol == toCol);
    }
}