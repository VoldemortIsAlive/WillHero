package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Orcs extends GameObjects{
    @FXML
    private ImageView OrcPhoto;

    public Orcs(double X, double Y) {
        super(X, Y);
    }

    public void setOrcPhoto(ImageView orcPhoto) {
        OrcPhoto = orcPhoto;
    }

    public ImageView getOrcPhoto() {
        return OrcPhoto;
    }



    @Override
    public void Collison(Hero h) {
        if(this.getOrcPhoto().getBoundsInParent().intersects(h.getHeroPhoto().getBoundsInParent())){
            System.out.println("yes collision");
        }
    }
}
