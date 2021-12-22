package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.CommonAnimation.*;
import static sample.CommonAnimation.runTranslateTransition;

public class Controller implements Initializable {
    @FXML
    private ImageView Title;
    @FXML
    private ImageView HeroChar;
    @FXML
    private ImageView Island1;
    @FXML
    private ImageView Island2;
    @FXML
    private ImageView Island3;
    @FXML
    private ImageView Island4;
    @FXML
    private ImageView Island5;
    @FXML
    private ImageView Island6;
    @FXML
    private ImageView Island7;
    @FXML
    private ImageView Island8;
    @FXML
    private ImageView Island31;
    @FXML
    private ImageView Island41;
    @FXML
    private ImageView Island51;
    @FXML
    private ImageView Island61;
    @FXML
    private ImageView Island71;
    @FXML
    private ImageView Island81;
    @FXML
    private ImageView Island32;

    @FXML
    private ImageView Uprock;
    @FXML
    private ImageView Cloud;
    @FXML
    private Text Taps;
    @FXML
    private ImageView GameBackground;
    @FXML
    private ImageView Orc2;


    Orcs o = new Orcs(0,0);
    Hero h = new Hero(0,0);
    Islands isle1 = new Islands(0,0);

    ArrayList<Integer> IslandPositions = new ArrayList<>();


    TranslateTransition t;
    private void introTransition(double out) {
        //Duration to be 1500
        //Setting Duration to 1 for fast Testing

        runTranslateTransition(Island1, 0, out* 200, 1500).play();
        runTranslateTransition(Island2, 0, out * 175, 1500).play();
        runTranslateTransition(Title, 0, out * -150, 1500).play();
        t = JumpHero(HeroChar,true);
        StoreCoord();
        JumpOrc(Orc2);
        h.setHeroPhoto(HeroChar);
    }

    public void StoreCoord(){
        IslandPositions.add(0,102);
        IslandPositions.add(1,302);
        IslandPositions.add(2,404);
        IslandPositions.add(3,604);
        IslandPositions.add(4,727);
        IslandPositions.add(5,919);
        IslandPositions.add(6,1028);
        IslandPositions.add(7,1275);
    }
    public void PrintCoord(){
        for(int i=0;i<IslandPositions.size();i++){
            System.out.println(IslandPositions.get(i));
        }
    }

    int PlayerTaps = Player.getPlayer().getTaps();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            introTransition(-1);
        }));
        new SequentialTransition(CommonAnimation.delay(1000),intro).play();
    }

//    public void CheckHero(){
//        if(HeroChar.layoutXProperty().intValue()>(IslandPositions.get(1)) && (HeroChar.layoutXProperty().intValue()<(IslandPositions.get(2)))){
//            JumpHero(HeroChar,false);
//            runTranslateTransition(HeroChar,0,1000,1500).play();
//        }
//    }


    public void Move(MouseEvent mouseEvent) {
        PlayerTaps++;
        Taps.setText(String.valueOf(PlayerTaps));
        Timeline intro2 = new Timeline(new KeyFrame(Duration.millis(25), e -> {
            Timeline textupdate = new Timeline(new KeyFrame(Duration.millis(1),b->{
                PlayerTaps++;
            }));
            MoveHero(HeroChar);
            //CheckHero();
            if(HeroChar.getBoundsInParent().intersects(Orc2.getBoundsInParent())){
                runTranslateTransition(Orc2,300,Orc2.getScaleY(),1500).play();
            }
        }));
        new SequentialTransition(CommonAnimation.delay(100),intro2).play();
        if(PlayerTaps==1){
            runTranslateTransition(Title, 0, -150, 1500).play();
        }
        for(int i=0;i<IslandPositions.size();i++){
            int temp = IslandPositions.get(i)-100;
            IslandPositions.remove(i);
            IslandPositions.add(i,temp);
        }
        BackgroundMovement();
    }
    public void UpdateScreenTaps(int t){

    }
    public void BackgroundMovement(){
        runTranslateTransition(Island1,-200,0,1500).play();
        runTranslateTransition(Island2,-200,0,1500).play();
        runTranslateTransition(Island3,-200,Orc2.getScaleY(),1500).play();
        runTranslateTransition(Island4,-200,0,1500).play();
        runTranslateTransition(Island5,-200,0,1500).play();
        runTranslateTransition(Island6,-200,0,1500).play();
        runTranslateTransition(Island7,-200,0,1500).play();
        runTranslateTransition(Island8,-200,0,1500).play();
        runTranslateTransition(Island31,-200,0,1500).play();
        runTranslateTransition(Island41,-200,0,1500).play();
        runTranslateTransition(Island51,-200,0,1500).play();
        runTranslateTransition(Island61,-200,0,1500).play();
        runTranslateTransition(Island71,-200,0,1500).play();
        runTranslateTransition(Island81,-200,0,1500).play();
        runTranslateTransition(Island32,-200,0,1500).play();
        runTranslateTransition(Cloud,-200,0,1500).play();
        runTranslateTransition(Uprock,-200,0,1500).play();

        runTranslateTransition(Orc2,-100,0,1500).play();
        PrintCoord();
//        ManualChanging();
//        PrintCoord();
    }

}
