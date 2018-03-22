class GameBoard{
    private static int[][] board;
    private static Player redPlayer;
    private static Player blackPlayer;
    static Player currentPlayer;

    static final int rows = 6;
    static final int cols = 7;
    private static final int winCon = 4;

    static int[] row = new int[cols];

    private GameBoard(final int[][] board){
        GameBoard.board = board;
        redPlayer = new Player(2, Player.PlayerColor.RED);
        blackPlayer = new Player(1, Player.PlayerColor.BLACK);
        currentPlayer = redPlayer;
    }

    static GameBoard createNewBoard() {
        int[][] newBoard = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newBoard[i][j] = 0;
            }
        }
        for(int i = 0; i<row.length;i++){
            row[i] = 5;
        }
        return new GameBoard(newBoard);
    }

    static void makeMove(final int rowID, final int colID, final Player.PlayerColor playerColor){
        GameGUI.tilePanels[rowID][colID].changeColor(rowID,colID,playerColor);
        board[rowID][colID] = currentPlayer.playerKey;
        if(checkForWin(rowID,colID,currentPlayer)){
            //GAME IS OVER
            System.out.println("CONGRATULATIONS! " + currentPlayer.toString() + " PLAYER IS THE WINNER");
            System.exit(0);
        }
        else{
            row[colID]--;
            setCurrentPlayer();
        }
    }

    private static void setCurrentPlayer(){
        if(currentPlayer.playerColor.isRed()){
            currentPlayer = GameBoard.blackPlayer;
        }
        else{
            currentPlayer = GameBoard.redPlayer;
        }
    }

    private static boolean checkForWin(int row, int col, Player player){
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
                    board[i-3][j+3] == player.playerColor.getPlayerKey()) {
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
