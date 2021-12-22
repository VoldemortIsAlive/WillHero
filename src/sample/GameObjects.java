package sample;

import java.io.Serializable;

public abstract class GameObjects implements Serializable {
    protected double X;
    protected double Y;

    public GameObjects(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public double getPosX() {
        return X;
    }
    public double getPosY() {
        return Y;
    }

    public abstract void Collison(Hero h);
}
