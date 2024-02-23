package BoardPack;

import java.lang.String;

import javax.print.attribute.standard.Sides;

public class boardClass {
    private final int SIZE = 8;
    private String[][] grid;
    
    
    public boardClass(){

        grid = new String[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                grid[i][j] = "#";

            }

        }

    }

    public void displayBoard() {
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


    public static void main(String[] args)
    {
        boardClass gameBoard = new boardClass();
        gameBoard.displayBoard();

    }

}
