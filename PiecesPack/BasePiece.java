package PiecesPack;

public class BasePiece {
    private int row; // row of the piece
    private int col; // column of the piece
    private String pieceName; // identifier of the piece


    public BasePiece(int row, int col, String pieceName){ // constructor for a piece
        this.row = 0;
        this.col = 0;
        this.pieceName = "Test";

    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getRow(){ // getter for the row of the piece

        return this.row;
    }

    public int getCol(){ // getter for the column of the piece
        return this.col;
    }

    public String getName(){ // gets the piece name which is also the identifier for the piece on the board

        return this.pieceName;
    }


}  
