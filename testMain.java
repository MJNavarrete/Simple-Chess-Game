/*
import BoardPack.boardClass;
import PiecesPack.BasePiece;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * The `testMain` class contains the main method to test the chess board and pieces functionality.
 */
/*
public class testMain {

    /**Creation of two player initialized to corresponding letters
    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    private Player currentPlayer = player1;
    /**
     * The main method creates instances of the board and pieces, sets up the board, moves a piece, and displays the board.
     *
     * @param args Command-line arguments (unused).
     */
    /*
    public static void main (String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        boolean flag = false;
        ArrayList<BasePiece> pieces = new ArrayList<BasePiece>();

        boardClass gameBoard = new boardClass(); // makes a new instance of the board

        BasePiece testPiece = new BasePiece(0,0,"J"); // makes a new base piece and sets name

        pieces.add(testPiece);

        int testRow = testPiece.getRow(); // gets row of piece
        int testCol = testPiece.getCol(); // gets col of piece
        String testName = testPiece.getName(); // gets name of piece

        gameBoard.setPiece(testRow, testCol, testName); // sets the position of the piece to [0][0]

        gameBoard.displayBoard(); // displays board to show that the piece was added


        do{

            int prevRow = testPiece.getRow();
            int prevCol = testPiece.getCol();

            System.out.println("Please input a move for the piece to do or type x0 to quit: ");
            String userIn = scnr.next();
            // String newMove = scnr.next();

            if(userIn.charAt(0) == 'x')
            {
                flag = true;
            }

            char rowChar = userIn.charAt(1);
            char colChar = userIn.charAt(0);

            int rowInt = Character.getNumericValue(rowChar);
            char usableCol = Character.toLowerCase(colChar);

            int finalCol = testPiece.calcCol(usableCol);
            int finalRow = testPiece.calcRow(rowInt);


            gameBoard.movePiece(prevRow, prevCol, finalRow, finalCol, testName); // moves the piece, from old to new

            testPiece.setRow(finalRow);
            testPiece.setCol(finalCol);
        

            gameBoard.displayBoard(); // displays the board again

        } while(flag != true);




        scnr.close();

    }
}
*/