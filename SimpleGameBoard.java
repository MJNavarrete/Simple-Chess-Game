//All of the needed packages for use in the gameboard are here. Some of these are .*, which means that all of the contents of the package are imported but not all of them are used. This however was present in the example code so I'll just leave it
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import PiecesPack.BasePiece;
import BoardPack.boardClass;
import java.lang.String;


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
    private boardClass gameBoard = new boardClass();

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
     * Method to add all of the piece to the board on top of the panels within the board.
     * Unicode is there to represent the chess pieces.
     */
    private void setupGamePieces() {

        //White               King      Queen     wrook    bishop    knight     pawn
        // String[] test = ["\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659"];

        //Black
        // String[] test2 = ["\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"];

        // Preset back and front rows for the black and white pieces
        String[] wbackrow = {"\u2656", "\u2658", "\u2657", "\u2654", "\u2655",  "\u2657", "\u2658","\u2656"};
        String[] wfrontrow = {"\u2659", "\u2659", "\u2659", "\u2659","\u2659", "\u2659", "\u2659", "\u2659"};

        String[] bbackrow = {"\u265C","\u265E","\u265D","\u265A","\u265B","\u265D","\u265E","\u265C"};
        String[] bfrontrow = {"\u265F","\u265F","\u265F","\u265F","\u265F","\u265F","\u265F","\u265F"};


        // For loop that will iterate through the rows and each time it hits a significant row value, it will stop and loop through each col and replace the section there with unicode for a game piece
        for(int i = 0; i < ROWS; i++){

            // Signifies the first row of the board in terms of the array, which is the furthest row form the white player
            if(i == 0){
                for(int j = 0; j < bbackrow.length; j++){
                board[i][j] = bbackrow[j];
                JLabel square = new JLabel(bbackrow[j]);
                square.setFont(new Font("Serif", Font.BOLD, 32)); // Make the piece characters bigger
                square.setHorizontalAlignment(JLabel.CENTER);
                square.setVerticalAlignment(JLabel.CENTER);

                gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                gameBoardSquares[i][j].add(square);


                switch(j){

                    case 0:
                        BasePiece testPiece0 = new BasePiece(i,j,"BR"); // Makes a new pawn and sets it to current location matching GUI
                        String testName0 = testPiece0.getName();
                        gameBoard.setPiece(i, j, testName0);
                        break;

                    case 1:
                        BasePiece testPiece1 = new BasePiece(i,j,"BH"); // Makes a new pawn and sets it to current location matching GUI
                        String testName1 = testPiece1.getName();
                        gameBoard.setPiece(i, j, testName1);
                        break;

                    case 2:
                        BasePiece testPiece2 = new BasePiece(i,j,"BB"); // Makes a new pawn and sets it to current location matching GUI
                        String testName2 = testPiece2.getName();
                        gameBoard.setPiece(i, j, testName2);
                        break;

                    case 3: 
                        BasePiece testPiece3 = new BasePiece(i,j,"BQ"); // Makes a new pawn and sets it to current location matching GUI
                        String testName3 = testPiece3.getName();
                        gameBoard.setPiece(i, j, testName3);
                        break;

                    case 4:
                        BasePiece testPiece4 = new BasePiece(i,j,"BK"); // Makes a new pawn and sets it to current location matching GUI
                        String testName4 = testPiece4.getName();
                        gameBoard.setPiece(i, j, testName4);
                        break;

                    case 5:
                        BasePiece testPiece5 = new BasePiece(i,j,"BB"); // Makes a new pawn and sets it to current location matching GUI
                        String testName5 = testPiece5.getName();
                        gameBoard.setPiece(i, j, testName5);
                        break;

                    case 6:

                        BasePiece testPiece6 = new BasePiece(i,j,"BH"); // Makes a new pawn and sets it to current location matching GUI
                        String testName6 = testPiece6.getName();
                        gameBoard.setPiece(i, j, testName6);
                        break;

                    case 7:
                        BasePiece testPiece7 = new BasePiece(i,j,"BR"); // Makes a new pawn and sets it to current location matching GUI
                        String testName7 = testPiece7.getName();
                        gameBoard.setPiece(i, j, testName7);
                        break;

                    default:
                        break;
                
                    }
                }
            }

            // Signifies the front row of the black player side 
            else if(i == 1){
                for(int j = 0; j < bfrontrow.length; j++){
                    board[i][j] = bfrontrow[j];
                    JLabel square = new JLabel(bfrontrow[j]);
                    square.setFont(new Font("Serif", Font.BOLD, 32)); // Make the piece characters bigger
                    square.setHorizontalAlignment(JLabel.CENTER);
                    square.setVerticalAlignment(JLabel.CENTER);
    
                    gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    gameBoardSquares[i][j].add(square);

                    BasePiece testPiece = new BasePiece(i,j,"BP"); // Makes a new pawn and sets it to current location matching GUI
                    String testName = testPiece.getName();
                    gameBoard.setPiece(i, j, testName);

                }       
            }

            // Signifies the front row for the white player
            else if(i == 6){
                for(int j = 0; j < wfrontrow.length; j++){
                    board[i][j] = wfrontrow[j];
                    JLabel square = new JLabel(wfrontrow[j]);
                    square.setFont(new Font("Serif", Font.BOLD, 32)); // Make the piece characters bigger
                    square.setHorizontalAlignment(JLabel.CENTER);
                    square.setVerticalAlignment(JLabel.CENTER);
    
                    gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    gameBoardSquares[i][j].add(square);

                    BasePiece testPiece = new BasePiece(i,j,"WP"); // Makes a new pawn and sets it to current location matching GUI
                    String testName = testPiece.getName();
                    gameBoard.setPiece(i, j, testName);
                }       
            }

            // Signifies the back row for the white player
            else if(i == 7){
                for(int j = 0; j < wbackrow.length; j++){
                    board[i][j] = wbackrow[j];
                    JLabel square = new JLabel(wbackrow[j]);
                    square.setFont(new Font("Serif", Font.BOLD, 32)); // Make the piece characters bigger
                    square.setHorizontalAlignment(JLabel.CENTER);
                    square.setVerticalAlignment(JLabel.CENTER);
    
                    gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    gameBoardSquares[i][j].add(square);

                    switch(j){

                        case 0:
                            BasePiece testPiece0 = new BasePiece(i,j,"WR"); // Makes a new pawn and sets it to current location matching GUI
                            String testName0 = testPiece0.getName();
                            gameBoard.setPiece(i, j, testName0);
                            break;
    
                        case 1:
                            BasePiece testPiece1 = new BasePiece(i,j,"WH"); // Makes a new pawn and sets it to current location matching GUI
                            String testName1 = testPiece1.getName();
                            gameBoard.setPiece(i, j, testName1);
                            break;
    
                        case 2:
                            BasePiece testPiece2 = new BasePiece(i,j,"WB"); // Makes a new pawn and sets it to current location matching GUI
                            String testName2 = testPiece2.getName();
                            gameBoard.setPiece(i, j, testName2);
                            break;
    
                        case 3: 
                            BasePiece testPiece3 = new BasePiece(i,j,"WQ"); // Makes a new pawn and sets it to current location matching GUI
                            String testName3 = testPiece3.getName();
                            gameBoard.setPiece(i, j, testName3);
                            break;
    
                        case 4:
                            BasePiece testPiece4 = new BasePiece(i,j,"WK"); // Makes a new pawn and sets it to current location matching GUI
                            String testName4 = testPiece4.getName();
                            gameBoard.setPiece(i, j, testName4);
                            break;
    
                        case 5:
                            BasePiece testPiece5 = new BasePiece(i,j,"WB"); // Makes a new pawn and sets it to current location matching GUI
                            String testName5 = testPiece5.getName();
                            gameBoard.setPiece(i, j, testName5);
                            break;
    
                        case 6:
    
                            BasePiece testPiece6 = new BasePiece(i,j,"WH"); // Makes a new pawn and sets it to current location matching GUI
                            String testName6 = testPiece6.getName();
                            gameBoard.setPiece(i, j, testName6);
                            break;
    
                        case 7:
                            BasePiece testPiece7 = new BasePiece(i,j,"WR"); // Makes a new pawn and sets it to current location matching GUI
                            String testName7 = testPiece7.getName();
                            gameBoard.setPiece(i, j, testName7);
                            break;
    
                        default:
                            break;
                    
                    }
                }       
            }

            // Sets the borders of the blank spaces to red for the handleMouseClick method
            else {
                for(int j = 0; j < wbackrow.length; j++){
                    gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));

                }
            }
            //sets the other rows in the board to black "" Strings
            board[i] = new String[] {"", "" , "", "", "", "" , "", ""};
        }

        gameBoard.displayBoard();
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