//All of the needed packages for use in the gameboard are here. Some of these are .*, which means 
//that all of the contents of the package are imported but not all of them are used. This however 
//was present in the example code so I'll just leave it

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import BoardPack.boardClass;
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
public class SimpleGameBoard {

    // Private variables that are used in the methods of the function
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private final JPanel[][] gameBoardSquares = new JPanel[ROWS][COLS];
    private JPanel selectedPiece = null;
    private String[][] board = new String[ROWS][COLS];

    /**
     * Main function that is used to call an instance of the game board.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGameBoard().createAndShowGUI());
    }

    /**
     * The main method for setting up the game board, 
     * adding the panels to the gameboard JPanel 2d-array and setting it all visible.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Game Board with Multiple Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(ROWS, COLS));
        frame.setSize(500, 500);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JPanel panel = new JPanel();
                panel.setBackground((i + j) % 2 == 0 ? Color.CYAN : Color.WHITE); //Change cyan and white to different colors for different board colors
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleMouseClick(panel);
                    }
                });
                gameBoardSquares[i][j] = panel;
                frame.add(panel);
            }
        }

        setupGamePieces();

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The setupGamePieces() method creates Piece objects for each piece on the board and adds them 
     * to the appropriate squares using the addPieceToSquare() method.
     */
    private void setupGamePieces() {

            // Add pawns
            for (int i = 0; i < COLS; i++) {
                addPieceToSquare(new Pawn(1, i,"Black", "Pawn"), 1, i);
                addPieceToSquare(new Pawn(6, i, "White", "Pawn"), 6, i);
            }
    
            // Add other pieces
            addPieceToSquare(new Rook(0, 0, "Black", "Rook"), 0, 0);
            addPieceToSquare(new Rook(0, 7, "Black", "Rook"), 0, 7);
            addPieceToSquare(new Rook(7, 0, "White", "Rook"), 7, 0);
            addPieceToSquare(new Rook(7, 7, "White", "Rook"), 7, 7);
            addPieceToSquare(new Knight(0, 1, "Black", "Knight"), 0, 1);
            addPieceToSquare(new Knight(0, 6, "Black", "Knight"), 0, 6);
            addPieceToSquare(new Knight(7, 1, "White", "Knight"), 7, 1);
            addPieceToSquare(new Knight(7, 6, "White", "Knight"), 7, 6);
            addPieceToSquare(new Bishop(0, 2, "Black", "Bishop"), 0, 2);
            addPieceToSquare(new Bishop(0, 5, "Black", "Bishop"), 0, 5);
            addPieceToSquare(new Bishop(7, 2, "White", "Bishop"), 7, 2);
            addPieceToSquare(new Bishop(7, 5, "White", "Bishop"), 7, 5);
            addPieceToSquare(new Queen(0, 3, "Black", "Queen"), 0, 3);
            addPieceToSquare(new Queen(7, 3, "White", "Queen"), 7, 3);
            addPieceToSquare(new King(0, 4, "Black", "King"), 0, 4);
            addPieceToSquare(new King(7, 4, "White", "King"), 7, 4);

    }

    /**
     * he addPieceToSquare() method now takes a Piece object as an argument and displays the corresponding 
     * Unicode character for the piece using the getPieceUnicode() method.
     * @param piece
     * @param row
     * @param col
     */
    private void addPieceToSquare(BasePiece piece, int row, int col) {
        JLabel pieceLabel = new JLabel(getPieceUnicode(piece.getName(), piece.getColor()));
        pieceLabel.setFont(new Font("Serif", Font.PLAIN, 50)); // Set font size as needed
        JPanel square = gameBoardSquares[row][col];
        square.add(pieceLabel);
    }

    /**
     * This method checks the color of the pawns and assigns dthe correct unicode representation for it to
     * be displayed on the board by using the addPieceToSquare() method.
     * @param type
     * @param color
     * @return
     */
    private String getPieceUnicode(String type, String color) {
        // Add more cases for different piece types and colors
        switch (type) {
            case "Pawn":
                return color.equals("Black") ? "\u265F" : "\u2659";
            case "Rook":
                return color.equals("Black") ? "\u265C" : "\u2656";
            case "Knight":
                return color.equals("Black") ? "\u265E" : "\u2658";
            case "Bishop":
                return color.equals("Black") ? "\u265D" : "\u2657";
            case "Queen":
                return color.equals("Black") ? "\u265B" : "\u2655";
            case "King":
                return color.equals("Black") ? "\u265A" : "\u2654";
            // Add cases for other piece types
            default:
                return "";
        }
    }

     /**
     * Handle mouse click method to handle when the user clicks on the board.
     *
     * @param clickedPanel The panel that was clicked
     */
    private void handleMouseClick(JPanel clickedPanel) {
        Color pieceColor = ((LineBorder)clickedPanel.getBorder()).getLineColor();

        // If the border that the user clicks on in not one of the borders representing the piece colors and the space is null, then it doesn't allow the move.
        if(pieceColor == Color.RED && selectedPiece == null){
            return;

        }
        
        // if the selected piece is null, then we set the border of the selected square to blue to signify selection and then we set the selected piece to the clicked panel
        if(selectedPiece == null){
            clickedPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            selectedPiece = clickedPanel;
                
        // If the selected piece is already selected, then we call the move piece method and set the selected piece back to null for future use.
        } else{
            movePiece(selectedPiece, clickedPanel);
            selectedPiece = null;

        } 
        return;
    }

    /**
     * Method to actually move the unicode pieces on the board. Takes in a from and a to panel so that we can remove everything from the 'from' panel and move it to the 'to' panel.
     *
     * @param from The panel to move the piece from
     * @param to   The panel to move the piece to
     */
    private void movePiece(JPanel from, JPanel to) {
        JLabel piece = (JLabel) from.getComponent(0);
        from.setBorder(BorderFactory.createLineBorder(Color.RED));
        from.removeAll();
        to.removeAll();
        to.add(piece);
        to.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        from.revalidate();
        to.revalidate();
        from.repaint();
        to.repaint();
    }
}