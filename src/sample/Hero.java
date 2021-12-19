package sample;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import static sample.CommonAnimation.runTranslateTransition;

public class Hero extends GameObjects{
    Hero(float x,float y){
        super(x,y);
    }
    @Override
    public boolean OnCollide(GameObjects Hero){
        return false;
    }
    public void MoveForward(Node n){
        runTranslateTransition(n,5,0,800);
    }

}
