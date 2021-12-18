package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int Score;
    private int GamesPlayed;
    private int highScore;

    Player(){
        this.name = name;
        this.Score = Score;
        this.GamesPlayed = GamesPlayed;
        this.highScore = highScore;
    }

    public String getName() {
        return this.name;
    }

    public void setCurrentScore(int CurrentScore) {
        this.Score = CurrentScore;
        highScore=Math.max(highScore,Score);
    }
}
