package PiecesPack;

/**
 * The `BasePiece` class represents a basic chess piece with a position and a name.
 * It serves as the base class for specific types of chess pieces.
 */

public class BasePiece {
    private int row; // row of the piece
    private int col; // column of the piece
    private String pieceName; // identifier of the piece



    /**
     * Constructs a new BasePiece with the given initial position and name.
     *
     * @param row The initial row of the piece.
     * @param col The initial column of the piece.
     * @param pieceName The identifier/name of the piece.
     */


    public BasePiece(int row, int col, String pieceName){ // constructor for a piece
        this.row = row;
        this.col = col;
        this.pieceName = pieceName;

    }

    /**
     * Sets the current row of the piece.
     *
     * @return None
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * Sets the current column of the piece.
     *
     * @return None
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * Retrieves the current row of the piece.
     *
     * @return The current row of the piece.
     */
    public int getRow(){ // getter for the row of the piece

        return this.row;
    }

    /**
     * Retrieves the current column of the piece.
     *
     * @return The current column of the piece.
     */
    public int getCol(){ // getter for the column of the piece
        return this.col;
    }

    /**
     * Retrieves the name/identifier of the piece.
     *
     * @return The name/identifier of the piece.
     */
    public String getName(){ // gets the piece name which is also the identifier for the piece on the board

        return this.pieceName;
    }

    /**
     * 
     * Calculates the column to move the piece to given a char input from the user
     * 
     * @param colChar the char that the user inputs 
     * @return the integer associated with the grid converted from the char the user input
     */
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


    /**
     *  Just does a simple conversion to the actual position on the board given a user's input
     * 
     * 
     * @param row row integer that the user inputs 
     * @return the integer once converted to actual position on board
     */
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

}  
