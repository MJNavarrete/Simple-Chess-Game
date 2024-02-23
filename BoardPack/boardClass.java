package BoardPack;

import java.lang.String;

// import javax.print.attribute.standard.Sides;

public class boardClass {
    private final int SIZE = 8;
    private String[][] grid;
    
    
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

    public void setPiece(int row, int col, String name){ // Sets the position of a piece and the name in the board

        grid[row][col] = name;

    }

    public void movePiece(int oldRow, int oldCol, int newRow, int newCol, String pieceName){ // moves the piece on the board and deletes the old position off the board

        grid[oldRow][oldCol] = "#";
        grid[newRow][newCol] = pieceName;


    }


    public static void main(String[] args)
    {


        boardClass gameBoard = new boardClass();
        gameBoard.displayBoard();

    }

}

// Make the method to move a piece to a spot and erase the existence of it in the original spot