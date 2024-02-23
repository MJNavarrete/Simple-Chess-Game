import BoardPack.boardClass;
import PiecesPack.PieceClass;


public class testMain {
    
    public static void main (String[] args)
    {
        
        boardClass gameBoard = new boardClass();
        gameBoard.displayBoard();

        int testRow = testPiece.getRow();
        int testCol = testPiece.getCol();
        String testName = testPiece.getName();

        gameBoard.setPiece(testRow, testCol, testName);

        gameBoard.displayBoard();

    }
}
