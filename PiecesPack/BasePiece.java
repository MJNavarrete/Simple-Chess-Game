package PiecesPack;

public class BasePiece {
    private int row;
    private int col;
    private String pieceName;


    public BasePiece(int row, int col, String pieceName){
        this.row = 0;
        this.col = 0;
        this.pieceName = "Test";

    }

    public int getRow(){

        return this.row;
    }

    public int getCol(){

        return this.col;
    }

    public String getName(){

        return this.pieceName;
    }


}  
