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
        this.row = 0;
        this.col = 0;
        this.pieceName = "Test";

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


}  
