package PiecesPack;
//import PiecesPack.BasePiece; (may be needed?)

import java.awt.Color;

public class Pawn extends BasePiece{

    public Pawn(Color color) {
        //ternary operator (condition ? trueValue : falseValue). It checks if the color is Color.BLACK. 
        //If it is, it sets the Unicode character for a black piece ('unicode'); otherwise, 
        //it sets the Unicode character for a white piece ('unicode').
        super(color, color == Color.BLACK ? '\u265F' : '\u2659');
    }

    @Override
    public boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int diffRow = toRow - fromRow;
        int diffCol = Math.abs(toCol - fromCol);
        BasePiece destinationPiece = board[toRow][toCol];

        // White pawns
        if (getColor() == Color.WHITE) {
            if (diffCol == 0 && diffRow == -1 && destinationPiece == null) {
                return true; // Move one square forward if empty
            } else if (fromRow == 6 && diffCol == 0 && diffRow == -2 && board[5][toCol] == null && destinationPiece == null) {
                return true; // Move two squares forward from starting position if both are empty
            } else if (diffCol == 1 && diffRow == -1 && destinationPiece != null && destinationPiece.getColor() != getColor()) {
                return true; // Capture diagonally
            }
        }
        // Black pawns
        else {
            if (diffCol == 0 && diffRow == 1 && destinationPiece == null) {
                return true; // Move one square forward if empty
            } else if (fromRow == 1 && diffCol == 0 && diffRow == 2 && board[2][toCol] == null && destinationPiece == null) {
                return true; // Move two squares forward from starting position if both are empty
            } else if (diffCol == 1 && diffRow == 1 && destinationPiece != null && destinationPiece.getColor() != getColor()) {
                return true; // Capture diagonally
            }
        }

        return false;
    }
 }