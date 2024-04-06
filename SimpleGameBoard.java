import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleGameBoard {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    private final JPanel[][] gameBoardSquares = new JPanel[ROWS][COLS];
    private JPanel selectedPiece = null;
    private String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGameBoard().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Game Board with Multiple Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(ROWS, COLS));
        frame.setSize(500, 500);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JPanel panel = new JPanel();
                panel.setBackground((i + j) % 2 == 0 ? Color.CYAN : Color.WHITE);
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

    private void setupGamePieces() {
        //White               King      Queen     wrook    bishop    knight     pawn
        // String[] test = ["\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659"];

        //Black
        // String[] test2 = ["\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"];

        
        String[] wbackrow = {"\u2656", "\u2658", "\u2657", "\u2654", "\u2655",  "\u2657", "\u2658","\u2656"};
        String[] wfrontrow = {"\u2659", "\u2659", "\u2659", "\u2659","\u2659", "\u2659", "\u2659", "\u2659"};

        String[] bbackrow = {"\u265C","\u265E","\u265D","\u265A","\u265B","\u265D","\u265E","\u265C"};
        String[] bfrontrow = {"\u265F","\u265F","\u265F","\u265F","\u265F","\u265F","\u265F","\u265F"};



        for(int i = 0; i < COLS; i++){


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

            else {
                for(int j = 0; j < wbackrow.length; j++){
                    gameBoardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));

                }

            }


            // for(int x = 0; x < ROWS; x++)
            // {
            //     gameBoardSquares[i][x].setBorder(BorderFactory.createLineBorder(Color.RED));

            // }

            board[i] = new String[] {"", "" , "", "", "", "" , "", ""};

        }
    }

    private void handleMouseClick(JPanel clickedPanel) {
        Color pieceColor = ((LineBorder)clickedPanel.getBorder()).getLineColor();

        if(pieceColor == Color.RED && selectedPiece == null){
            return;

        }
        
            if(selectedPiece == null){
                clickedPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                selectedPiece = clickedPanel;
                
            } else{
                movePiece(selectedPiece, clickedPanel);
                selectedPiece = null;

            }
            
        

            return;
       

    }

    // private int[] findPanelPosition(JPanel panel) {
    //     for (int i = 0; i < ROWS; i++) {
    //         for (int j = 0; j < COLS; j++) {
    //             if (gameBoardSquares[i][j] == panel) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return new int[]{-1, -1}; // Not found
    // }


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
