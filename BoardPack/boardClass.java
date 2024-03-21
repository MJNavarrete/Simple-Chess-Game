package BoardPack;

import java.lang.String;

// import PiecesPack.BasePiece;

// import javax.print.attribute.standard.Sides;

/**
 * The `boardClass` class represents the chessboard and its operations.
 * It provides methods to initialize the board, display it, set a piece on the board,
 * and move a piece from one position to another.
 */
public class boardClass {
    private final int SIZE = 8;
    private String[][] grid;
    
    /**
     * Initializes the chess board with '#' characters representing empty squares.
     */
    public boardClass(){ // Sets up the board with hashtags for initial board display

        grid = new String[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                grid[i][j] = "#";

            }

        }

    }

    /**
     * Displays the current state of the chess board.
     * The rows are labeled with numbers, and columns are labeled with letters.
     */
    public void displayBoard() { // displays the board
        System.out.print("  ");
        for (char letter = 'a'; letter <= 'h'; letter++) {
            System.out.print(letter + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            
            int rowNumber = SIZE - i; // Decrementing row number
            System.out.print(rowNumber + " ");

            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    /**
     * Sets the specified piece at the given position on the board.
     *
     * @param row The row index of the position.
     * @param col The column index of the position.
     * @param name The name or symbol of the piece to be set.
     */
    public void setPiece(int row, int col, String name){ // Sets the position of a piece and the name in the board

        grid[row][col] = name;

    }

    /**
     * Moves a piece from its old position to a new position on the board.
     * The piece at the old position is removed ('#'), and the new position is updated with the piece's name.
     *
     * @param oldRow The row index of the old position.
     * @param oldCol The column index of the old position.
     * @param newRow The row index of the new position.
     * @param newCol The column index of the new position.
     * @param pieceName The name or symbol of the piece being moved.
     */
    public void movePiece(int oldRow, int oldCol, int newRow, int newCol, String pieceName){ // moves the piece on the board and deletes the old position off the board

        grid[oldRow][oldCol] = "#";
        grid[newRow][newCol] = pieceName;


    }

    // public BasePiece locatePieceAt(BasePiece[] arr, int col, int row){

    //     for(BasePiece piece : arr)
    //     {
    //         if(piece.getCol() == col && piece.getRow() == row)
    //         {
    //             return piece;

    //         }

    //     }



    // }



    /**
     * The main method creates an instance of `boardClass` and displays the initial state of the board.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args)
    {


        boardClass gameBoard = new boardClass();
        gameBoard.displayBoard();

    }

}

// Make the method to move a piece to a spot and erase the existence of it in the original spot