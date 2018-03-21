public class GameBoard{
    public int[][] board;
    public Player redPlayer;
    public Player blackPlayer;
    public Player currentPlayer;

    public static final int rows = 6;
    public static final int cols = 7;
    public static final int winCon = 4;
    public static final int numTiles = 42;

    GameBoard(final int[][] board){
        this.board = board;
        this.redPlayer = new Player(2, Player.PlayerColor.RED);
        this.blackPlayer = new Player(1, Player.PlayerColor.BLACK);
        this.currentPlayer = redPlayer;
    }

    public static GameBoard createNewBoard() {
        int[][] newBoard = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newBoard[i][j] = 0;
            }
        }
        return new GameBoard(newBoard);
    }

    public static void printBoard(GameBoard gameBoard){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(gameBoard.board[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public void makeMove(){

    }

    public Player.PlayerColor getPlayerColor(Player player){
        return player.playerColor;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(){
        if(this.currentPlayer.playerColor.isRed()){
            this.currentPlayer = blackPlayer;
        }
        else{
            this.currentPlayer = redPlayer;
        }
    }

    public boolean checkForWin(int row, int col, Player player){
        int count = 0;
        //Check Horizontal
        for(int i = 0; i < cols; i++){
            if(board[row][i] == player.playerColor.getPlayerKey()){
                count++;
            }
            else{
                count = 0;
            }
            if(count >= winCon){
                return true;
            }
        }

        //Check Vertical
        for(int i = 0; i < rows; i++){
            if(board[i][col] == player.playerColor.getPlayerKey()){
                count++;
            }
            else{
                count = 0;
            }
            if(count >= winCon){
                return true;
            }
        }
        //Check Diagonal from Lower Left
        for (int i=3; i<rows; i++){
            for (int j=0; j<cols-3; j++){
                if (board[i][j] == player.playerColor.getPlayerKey() &&
                    board[i-1][j+1] == player.playerColor.getPlayerKey() &&
                    board[i-2][j+2] == player.playerColor.getPlayerKey() &&
                    this.board[i-3][j+3] == player.playerColor.getPlayerKey()) {
                    return true;
                }
            }
        }
        //Check Diagonal from Upper Left
        for (int i=3; i<rows; i++){
            for (int j=3; j<cols; j++) {
                if (board[i][j] == player.playerColor.getPlayerKey() &&
                    board[i - 1][j - 1] == player.playerColor.getPlayerKey() &&
                    board[i - 2][j - 2] == player.playerColor.getPlayerKey() &&
                    board[i - 3][j - 3] == player.playerColor.getPlayerKey()){

                    return true;
                }
            }
        }
        return false;
    }
}
