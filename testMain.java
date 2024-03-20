import BoardPack.boardClass;
import PiecesPack.BasePiece;
import java.util.Scanner;


/**
 * The `testMain` class contains the main method to test the chess board and pieces functionality.
 */

public class testMain {
    /**
     * The main method creates instances of the board and pieces, sets up the board, moves a piece, and displays the board.
     *
     * @param args Command-line arguments (unused).
     */
    
    public static void main (String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        boolean flag = false;

        boardClass gameBoard = new boardClass(); // makes a new instance of the board

        BasePiece testPiece = new BasePiece(0,0,"Jeff"); // makes a new base piece and sets name

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

            char rowChar = userIn.charAt(1);
            char colChar = userIn.charAt(0);

            int rowInt = Character.getNumericValue(rowChar);
            char usableCol = Character.toLowerCase(colChar);

        

        int finalCol = 0;
        
        switch (usableCol){

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

            case 'x':
                flag = true;

            default:
                break;



        }

        gameBoard.movePiece(prevRow, prevCol, rowInt, finalCol, testName); // moves the piece, from old to new

        testPiece.setRow(rowInt);
        testPiece.setCol(finalCol);
        

        gameBoard.displayBoard(); // displays the board again

        } while(flag != true);




        scnr.close();

    }
}

// TODO: