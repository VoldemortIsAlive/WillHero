package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Orcs extends GameObjects {
    @FXML
    private ImageView OrcDisplay;

    public Orcs(double X, double Y) {
        super(X, Y);
    }

    public void setOrcPhoto(ImageView orcPhoto) {
        OrcDisplay = orcPhoto;
    }

    public ImageView getOrcPhoto() {
        return OrcDisplay;
    }
    public void setOrc(ImageView orc) {
        OrcDisplay = orc;
    }
    public void Add(ArrayList<ImageView> OrcList){
        OrcList.add(OrcDisplay);
    }



    @Override
    public void Collison(Hero h) {
        if(this.getOrcPhoto().getBoundsInParent().intersects(h.getHeroPhoto().getBoundsInParent())){
            System.out.println("yes collision");
        }
    }
}
