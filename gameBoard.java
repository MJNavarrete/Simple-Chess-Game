//All of the needed packages for use in the gameboard are here. Some of these are .*, which means 
//that all of the contents of the package are imported but not all of them are used. This however 
//was present in the example code so I'll just leave it

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import PiecesPack.BasePiece;
import PiecesPack.Bishop;
import PiecesPack.King;
import PiecesPack.Pawn;
import PiecesPack.Queen;
import PiecesPack.Rook;
import PiecesPack.Knight;


/**
 * Class for the game board. 
 * Name for the class is the same as the coding example and don't need to change it.
 */
public class gameBoard {

    // Private variables that are used in the methods of the function
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private final JPanel[][] gameBoardSquares = new JPanel[ROWS][COLS];
    private BasePiece[][] board = new BasePiece[ROWS][COLS];
    private JPanel selectedSquare = null;

    /**
     * Main function that is used to call an instance of the game board.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new gameBoard().ChessGame());
    }

    /**
     * Calls the methods to create and show the GUI of the board and initialize the board
     * with pieces.
     */
    public void ChessGame() {
        initializeBoard();
        createAndShowGUI();
    }

    /**
     * Initializes the board with pieces in their starting positions
     */
    public void initializeBoard() {
        board[0][0] = new Rook(Color.BLACK);
        board[0][1] = new Knight(Color.BLACK);
        board[0][2] = new Bishop(Color.BLACK);
        board[0][3] = new Queen(Color.BLACK);
        board[0][4] = new King(Color.BLACK);
        board[0][5] = new Bishop(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[0][7] = new Rook(Color.BLACK);

        board[7][0] = new Rook(Color.WHITE);
        board[7][1] = new Knight(Color.WHITE);
        board[7][2] = new Bishop(Color.WHITE);
        board[7][3] = new Queen(Color.WHITE);
        board[7][4] = new King(Color.WHITE);
        board[7][5] = new Bishop(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);

         //for loop to initialize pawns to starting positions
        for (int col = 0; col < COLS; col++) {
            board[1][col] = new Pawn(Color.BLACK);
            board[6][col] = new Pawn(Color.WHITE);
        }

        // Fill the rest of the board with empty spaces
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = null;
            }
        }
    }

    /**
     * The main method for setting up the game board, 
     * adding the panels to the gameboard JPanel 2d-array and setting it all visible.
     */
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(ROWS, COLS));
    
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel square = new JPanel();
                square.setBackground((row + col) % 2 == 0 ? Color.CYAN : Color.GRAY);
                square.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
                // Add the piece representation (ASCII Piece symbol) to the square if 
                //there is a piece at that position.
                if (board[row][col] != null) {
                    square.add(board[row][col].getPieceRepresentation());
                }
    
                square.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleSquareClick(square);
                    }
                });
                gameBoardSquares[row][col] = square;
                frame.add(square);
            }
        }
    
        frame.pack();
        frame.setVisible(true);
    }



     /**
     * Handle mouse click method to handle when the user clicks on the board.
     *
     * @param clickedPanel The panel that was clicked
     */
    public void handleSquareClick(JPanel square) {
        if (selectedSquare == null) {
            selectedSquare = square;
        } else {
            // Check if the clicked square is the same as the selected square
            if (square == selectedSquare) {
                return; // Do nothing if the same square is clicked again
            }
    
            // Perform the move
            int fromRow = getRow(selectedSquare);
            int fromCol = getCol(selectedSquare);
            int toRow = getRow(square);
            int toCol = getCol(square);

    
                // Check if the move is valid
            if (isValidMove(fromRow, fromCol, toRow, toCol)) {
                // Move the piece visually
                JLabel pieceLabel = (JLabel) selectedSquare.getComponent(0);
                square.removeAll();
                square.add(pieceLabel);
                selectedSquare.removeAll();
                selectedSquare.add(new JLabel()); // Empty the selected square
                selectedSquare.repaint();
                square.repaint();

                // Move the piece in the board array
                BasePiece piece = board[fromRow][fromCol];
                board[fromRow][fromCol] = null;
                board[toRow][toCol] = piece;
            }
            else {
                // Show a message for invalid move
                JOptionPane.showMessageDialog(null, "Invalid Move! Please try again.");
            }

            selectedSquare = null;
        }
    }
    
    /**
     * This method iterates over the gameBoardSquares array to find the row index of the square 
     * JPanel. It checks each element of the array to see if it matches the square parameter. If 
     * a match is found, it returns the row index. If no match is found, it returns -1.
     * @param square
     * @return
     */
    public int getRow(JPanel square) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <COLS; col++) {
                if (gameBoardSquares[row][col] == square) {
                    return row;
                }
            }
        }
        return -1;
    }

    /**
     * This method is similar to getRow, but it returns the column index of the square JPanel 
     * instead. It iterates over the array and checks each element for a match with the square 
     * parameter. If a match is found, it returns the column index. If no match is found, it returns -1.
     * @param square
     * @return
     */
    public int getCol(JPanel square) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (gameBoardSquares[row][col] == square) {
                    return col;
                }
            }
        }
        return -1;
    }

    /**
     * Checks if the move of a piece is valid.
     */
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        BasePiece piece = board[fromRow][fromCol];
        if (piece == null) {
            return false; // No piece at the starting position
        }

        // Check if the destination is within the board bounds
        if (toRow < 0 || toRow >= board.length || toCol < 0 || toCol >= board[0].length) {
            return false;
        }

        // Check if there's a piece of the same color at the destination
        BasePiece destinationPiece = board[toRow][toCol];
        if (destinationPiece != null && destinationPiece.getColor() == piece.getColor()) {
            return false;
        }

        // Check if the move is valid according to the piece's rules
        return piece.isValidMove(board, fromRow, fromCol, toRow, toCol);
    }
}