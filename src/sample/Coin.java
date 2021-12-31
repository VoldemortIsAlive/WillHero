package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Coin {
    @FXML
    private ImageView CoinDisplay;
    public void setCoin(ImageView coinDisplay) {
        CoinDisplay = coinDisplay;
    }
    public void Add(ArrayList<ImageView> CoinList){
        CoinList.add(CoinDisplay);
    }
}
