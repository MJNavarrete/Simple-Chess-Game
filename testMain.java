import BoardPack.boardClass;
import PiecesPack.BasePiece;


public class testMain {
    
    public static void main (String[] args)
    {
        
        boardClass gameBoard = new boardClass(); // makes a new instance of the board
        gameBoard.displayBoard(); // displays the board to make sure it works

        BasePiece testPiece = new BasePiece(0,0,null); // makes a new base piece and sets name

        int testRow = testPiece.getRow(); // gets row of piece
        int testCol = testPiece.getCol(); // gets col of piece
        String testName = testPiece.getName(); // gets name of piece

        gameBoard.setPiece(testRow, testCol, testName); // sets the position of the piece to [0][0]

        gameBoard.displayBoard(); // displays board to show that the piece was added

        gameBoard.movePiece(testCol, testCol, 7, 7, testName); // moves the piece, from old to new

        gameBoard.displayBoard(); // displays the board again

    }
}
