import BoardPack.boardClass;
import PiecesPack.BasePiece;


public class testMain {
    
    public static void main (String[] args)
    {
        
        boardClass gameBoard = new boardClass();
        gameBoard.displayBoard();

        BasePiece testPiece = new BasePiece(0,0,null);

        int testRow = testPiece.getRow();
        int testCol = testPiece.getCol();
        String testName = testPiece.getName();

        gameBoard.setPiece(testRow, testCol, testName);

        gameBoard.displayBoard();

        gameBoard.movePiece(testCol, testCol, 7, 7, testName);

        gameBoard.displayBoard();

    }
}
