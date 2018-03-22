import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.YELLOW;

public class GameGUI {
    private final JFrame gameFrame;
    private final JMenuBar gameMenuBar;
    private final JPanel gamePanel;
    private final JPanel buttonPanel;
    static TilePanel[][] tilePanels = new TilePanel[GameBoard.rows][GameBoard.cols];

    private final static Color BLACK = Color.BLACK;

    private final static Dimension GAME_PANEL = new Dimension(800,650);
    private final static Dimension BUTTON_PANEL = new Dimension(800,100);

    GameGUI(){
        this.gameFrame = new JFrame("Connect 4");
        this.gameFrame.setLayout(new BorderLayout());

        this.gameMenuBar = createMenuBar();
        gameFrame.add(this.gameMenuBar,BorderLayout.NORTH);

        this.buttonPanel = createButtonPanel();
        gameFrame.add(this.buttonPanel);

        this.gamePanel = createGamePanel();
        gameFrame.add(this.gamePanel,BorderLayout.SOUTH);

        gameFrame.setSize(800,750);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenuItem exitGameButton = new JMenuItem("Exit");
        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                System.exit(0);
            }
        });

        menuBar.add(exitGameButton);
        return menuBar;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton col1Button = new JButton("COL ONE");
        col1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[0] >= 0){
                    GameBoard.makeMove(GameBoard.row[0],0,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col1Button);

        JButton col2Button = new JButton("COL TWO");
        col2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[1] >= 0){
                    GameBoard.makeMove(GameBoard.row[1],1,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col2Button);

        JButton col3Button = new JButton("COL THREE");
        col3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[2] >= 0){
                    GameBoard.makeMove(GameBoard.row[2],2,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col3Button);

        JButton col4Button = new JButton("COL FOUR");
        col4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[3] >= 0){
                    GameBoard.makeMove(GameBoard.row[3],3,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col4Button);

        JButton col5Button = new JButton("COL FIVE");
        col5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[4] >= 0){
                    GameBoard.makeMove(GameBoard.row[4],4,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col5Button);

        JButton col6Button = new JButton("COL SIX");
        col6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[5] >= 0){
                    GameBoard.makeMove(GameBoard.row[5],5,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col6Button);

        JButton col7Button = new JButton("COL SEVEN");
        col7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameBoard.row[6] >= 0){
                    GameBoard.makeMove(GameBoard.row[6],6,GameBoard.currentPlayer.getPlayerColor());
                }
            }
        });
        buttonPanel.add(col7Button);

        buttonPanel.setPreferredSize(BUTTON_PANEL);
        return buttonPanel;
    }

    private JPanel createGamePanel(){
        JPanel gamePanel = new JPanel(new GridLayout(GameBoard.rows,GameBoard.cols));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        final int borderWidth =1;

        for(int i = 0; i < GameBoard.rows; i++){
            for(int j = 0; j < GameBoard.cols; j++){
                TilePanel tilePanel = new TilePanel(i,j);
                if(i == 0) {
                    if (j == 0) {
                        tilePanel.setBorder(BorderFactory.createLineBorder(YELLOW));
                    } else {
                        tilePanel.setBorder(BorderFactory.createMatteBorder(borderWidth, 0, borderWidth, borderWidth, YELLOW));
                    }
                }
                else{
                    if(j == 0){
                        tilePanel.setBorder(BorderFactory.createMatteBorder(0,borderWidth,borderWidth,borderWidth,YELLOW));
                    }
                    else{
                        tilePanel.setBorder(BorderFactory.createMatteBorder(0,0,borderWidth,borderWidth,YELLOW));
                    }
                }
                tilePanels[i][j] = tilePanel;
                gamePanel.add(tilePanel);
            }
        }

        gamePanel.setVisible(true);
        gamePanel.setPreferredSize(GAME_PANEL);
        return gamePanel;
    }

    public class TilePanel extends JPanel{
        private final int rowID;
        private final int colID;

        TilePanel(final int rowID, final int colID) {
            this.rowID = rowID;
            this.colID = colID;
        }

        protected void changeColor(final int rowID, final int colID, Player.PlayerColor playerColor){
            tilePanels[rowID][colID].setBackground(playerColor.getPlayerColor());
        }
    }
}