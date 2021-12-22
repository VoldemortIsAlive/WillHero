package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Islands extends GameObjects {
    @FXML
    private ImageView Island;

    public Islands(double X, double Y) {
        super(X, Y);
    }

    @Override
    public void Collison(Hero h) {
        System.out.println("");
    }

    public void setPosX() {
        this.X = Island.getX();
    }

    public void setPosY() {
        this.Y = Island.getY();
    }

    @Override
    public double getPosX() {
        return Island.getX();
    }

    @Override
    public double getPosY() {
        return Island.getY();
    }

    public void setIsland(ImageView island) {
        Island = island;
    }

    public ImageView getIsland() {
        return Island;
    }
}
