public class Player {
    final int playerKey;
    final PlayerColor playerColor;

    Player(int playerKey, final PlayerColor playerColor){
        this.playerKey = playerKey;
        this.playerColor = playerColor;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    @Override
    public String toString() {
        if(getPlayerColor() == PlayerColor.RED){
            return "RED";
        }
        else{
            return "BLACK";
        }
    }

    public enum PlayerColor{
        RED {
            @Override
            public boolean isRed() {
                return true;
            }

            @Override
            public boolean isBlack() {
                return false;
            }

            @Override
            public int getPlayerKey() {
                return 2;
            }
        },
        BLACK {
            @Override
            public boolean isRed() {
                return false;
            }

            @Override
            public boolean isBlack() {
                return true;
            }

            @Override
            public int getPlayerKey() {
                return 1;
            }
        };

        public abstract boolean isRed();
        public abstract boolean isBlack();
        public abstract int getPlayerKey();
    }
}
