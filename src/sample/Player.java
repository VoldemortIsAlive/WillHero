package sample;

import java.io.*;

public class Player implements Serializable {
    //Design pattern: SINGLETON

    private static Player player = null;
    private String name;
    private int taps;
    private int CoinCnt;
    private int highscore;
    private boolean HasKnife = false;
    private boolean HasBomb = false;

    private Player() throws IOException {
        taps = 0;
        CoinCnt = 0;
        highscore = 0;
    }
    public synchronized static Player getPlayer() throws IOException {
        if(player == null) {
            player = new Player();
        }
        return player;
    }
    public void SetKnife(){
        HasKnife = true;
    }
    public void SetBomb(){
        HasBomb = true;
    }
    public boolean GetKnife(){
        return HasKnife;
    }
    public boolean GetBomb(){
        return HasBomb;
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
        return CoinCnt;
    }

    public void addCoins(int Coins) {
        this.CoinCnt += Coins;
    }

    public void SubtractCoins(int Coins) {
        this.CoinCnt -= Coins;   // PLAYER REVIVED
    }

    public int getTaps(){
        return taps;
    }
}