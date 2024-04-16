package PiecesPack;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

 /**
  * BasePiece an abstract class due to the use of abstract method isValidMove being 
  * different for each piece (subclass)
  */
public abstract class BasePiece {
    //Added new variables for tracking the color and the symbol of the pieces in
    //order to correctly represent them on the board
    private final Color color;
    private final char symbol;

    /**
     * Constructor setting the piece's color and symbol. The symbol is the ascii representation
     * of the piece which is decided in the subclass of the piece.
     * @param color
     * @param symbol
     */
    public BasePiece(Color color, char symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    /**
     * This method returns a JLabel that visually represents the chess piece. It sets the text 
     * of the label to the Unicode symbol of the piece and sets the foreground color and font 
     * to make it visually distinguishable on the board.
     * @return
     */
    public JLabel getPieceRepresentation() {
        JLabel label = new JLabel(Character.toString(symbol));
        label.setForeground(color);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        return label;
    }

    /**
     * Abstract method called to check if a piece's move is valid according to it's own rules.
     * Determined by the position of the piece on the board and where the piece is moving to; The
     * parameters of this function are self explanitory.
     * @param board 
     * @param fromRow
     * @param fromCol
     * @param toRow
     * @param toCol
     * @return
     */
    public abstract boolean isValidMove(BasePiece[][] board, int fromRow, int fromCol, int toRow, int toCol);
    
    /**
     * accessor for the color of the piece. Returns the color.
     * @return
     */
    public Color getColor() {
        return color;
    }
}

    //Below is the code no longer used for our updated game (Delete if you want to)

    /**
     * 
     * Calculates the column to move the piece to given a char input from the user
     * 
     * @param colChar the char that the user inputs 
     * @return the integer associated with the grid converted from the char the user input
     
    public int calcCol(char colChar){
        int finalCol = 0;
        switch (colChar){

            case 'a':
                finalCol = 0;
                break;

            case 'b':
                finalCol = 1;
                break;
            
            case 'c':
                finalCol = 2;
                break;

            case 'd':
                finalCol = 3;
                break;

            case 'e':
                finalCol = 4;
                break;

            case 'f':
                finalCol = 5;
                break;

            case 'g':
                finalCol = 6;
                break;

            case 'h':
                finalCol = 7;
                break;

            default:
                break;
        }

        return finalCol;

    }
    */


    /**
     *  Just does a simple conversion to the actual position on the board given a user's input
     * 
     * 
     * @param row row integer that the user inputs 
     * @return the integer once converted to actual position on board
    public int calcRow(int row){
        int finalRow = 0;
        switch (row){

            case 1:
                finalRow = 7;
                break;

            case 2:
                finalRow = 6;
                break;
            
            case 3:
                finalRow = 5;
                break;

            case 4:
                finalRow = 4;
                break;

            case 5:
                finalRow = 3;
                break;

            case 6:
                finalRow = 2;
                break;

            case 7:
                finalRow = 1;
                break;

            case 8:
                finalRow = 0;
                break;

            default:
                break;
        }

        return finalRow;


    }
    */ 
