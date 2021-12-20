package sample;

import java.io.Serializable;

public abstract class GameObjects implements Serializable {
    private float x;
    private float y;
    private String color;

    public GameObjects(float x,float y){
        this.x = x;
        this.y= y;

    }
    public abstract boolean OnCollide(GameObjects Hero);
}
