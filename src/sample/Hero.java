package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Hero extends GameObjects{
    @FXML
    private ImageView HeroPhoto;
    Hero(double x,double y){
        super(x,y);
    }

    @Override
    public void Collison(Hero h) {
    }

    public void setHeroPhoto(ImageView heroPhoto) {
        HeroPhoto = heroPhoto;
    }

    public ImageView getHeroPhoto() {
        return HeroPhoto;
    }


}
