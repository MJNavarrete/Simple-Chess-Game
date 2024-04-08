
//All of the needed packages for use in the gameboard are here. Some of these are .*, which means that all of the contents of the package are imported but not all of them are used. This however was present in the example code so I'll just leave it
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Class for the game board. Name for the class is the same as the coding example and don't need to change it.
public class SimpleGameBoard {

    // Private variables that are used in the methods of the function
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private final JPanel[][] gameBoardSquares = new JPanel[ROWS][COLS];
    private JPanel selectedPiece = null;
    private String[][] board = new String[ROWS][COLS];

    // Main function that is used to call an instance of the game board
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGameBoard().createAndShowGUI());
    }

    // The main method for setting up the game board, adding the panels to the gameboard JPanel 2d-array and setting it all visible.
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


    // Method to add all of the piece to the board on top of the panels within the board.
    // Unicode is there to represent the chess pieces
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
    }

    // Handle mouse click method to handle when the user clicks on the board.
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

    // Method to actually mvoe the unicode pieces on the board. Takes in a from and a to panel so that we can remove everything from the 'from' panel and move it to the 'to' panel
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
