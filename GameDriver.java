import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args){
        GameBoard gameBoard = GameBoard.createNewBoard();
        //GameGUI newGui = new GameGUI();
        Scanner input = new Scanner(System.in);
        int[] row = new int[gameBoard.cols];
        int redNum = gameBoard.redPlayer.playerKey;
        int blackNum = gameBoard.blackPlayer.playerKey;

        for(int i = 0; i < gameBoard.cols; i++){
            row[i] = 5;
        }

        GameBoard.printBoard(gameBoard);
        for(int i = 0; i < GameBoard.numTiles; i++) {
            int move = input.nextInt() - 1;

            if(move < 0 || move > 6){
                i--;
                continue;
            }

            if(row[move] == -1){
                System.out.println("That Column is filled, try again");
                continue;
            }

            if(gameBoard.currentPlayer.playerColor == Player.PlayerColor.RED){
                gameBoard.board[row[move]][move] = redNum;
            }
            else{
                gameBoard.board[row[move]][move] = blackNum;
            }

            //Check for Connect4
            if(i >= 6) {
                if (gameBoard.checkForWin(row[move], move, gameBoard.currentPlayer)) {
                    System.out.println("CONGRATULATIONS! " + gameBoard.currentPlayer.toString() + " PLAYER IS THE WINNER");
                    GameBoard.printBoard(gameBoard);
                    System.exit(0);
                }
            }
            row[move]--;
            gameBoard.setCurrentPlayer();
            GameBoard.printBoard(gameBoard);

        }
    }
}
