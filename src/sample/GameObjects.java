package sample;

import java.io.Serializable;

public abstract class GameObjects implements Serializable {
    private float[] position;
    private String color;

    public GameObjects(float x,float y){

    }
    public abstract boolean OnCollide(GameObjects Hero);
}
