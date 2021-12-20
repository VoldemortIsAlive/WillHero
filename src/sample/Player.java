package sample;
public class Player {
    //Design pattern: SINGLETON
    private static Player player = null;
    private String name;
    private int CoinsPossessed;
    private int highscore;

    private Player() {
        CoinsPossessed = 0;
        highscore = 0;
    }


    public synchronized static Player getPlayer() {
        if(player == null) {
            player = new Player();
        }
        return player;
    }
    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoinsPossessed() {
        return CoinsPossessed;
    }

    public void addCoins(int Coins) {
        this.CoinsPossessed += Coins;
    }

    public void SubtractCoins(int Coins) {
        this.CoinsPossessed -= Coins;   // PLAYER REVIVED
    }
}