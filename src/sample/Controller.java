package sample;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static sample.CommonAnimation.*;
import static sample.CommonAnimation.runTranslateTransition;

public class Controller implements Initializable,Runnable{
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
    private ImageView C1;
    @FXML
    private ImageView C2;
    @FXML
    private ImageView C3;
    @FXML
    private ImageView C4;
    @FXML
    private ImageView C5;

    @FXML
    private ImageView Knife;
    @FXML
    private ImageView StaticKnife;

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
    @FXML
    private Label CoinCount;
    @FXML
    private ImageView Chest;
    @FXML
    private ImageView OpenChest;

    Hero h = new Hero(0,0);
    int velocity = 0;
    Thread t2;
    boolean flag = false;

    ArrayList<ImageView> Islands = new ArrayList<>();
    ArrayList<ImageView> CoinsList = new ArrayList<>();
    ArrayList<Islands> IslandsCoded = new ArrayList<>();
    Coin c1 = new Coin();
    Coin c2 = new Coin();
    Coin c3 = new Coin();
    Coin c4 = new Coin();
    Coin c5 = new Coin();
    Islands i1 = new Islands(0,0);
    Islands i2 = new Islands(0,0);
    Islands i3 = new Islands(0,0);
    Islands i4 = new Islands(0,0);
    Islands i5 = new Islands(0,0);
    Islands i6 = new Islands(0,0);
    Islands i7 = new Islands(0,0);
    Islands i8 = new Islands(0,0);
    Islands i31 = new Islands(0,0);
    Islands i41 = new Islands(0,0);
    Islands i51 = new Islands(0,0);
    Islands i61 = new Islands(0,0);
    Islands i71 = new Islands(0,0);

    TranslateTransition t;
    private void introTransition(double out) {
        runTranslateTransition(Island1, 0, out* 200, 1500).play();
        runTranslateTransition(Island2, 0, out * 175, 1500).play();
        runTranslateTransition(Title, 0, out * -150, 1500).play();
        JumpHero(HeroChar,true);
        JumpHero(StaticKnife,true);
        JumpOrc(Orc2);
        h.setHeroPhoto(HeroChar);
    }

    int PlayerTaps = Player.getPlayer().getTaps();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        c1.setCoin(C1);
        c2.setCoin(C2);
        c3.setCoin(C3);
        c4.setCoin(C4);
        c5.setCoin(C5);

        c1.Add(CoinsList);
        c2.Add(CoinsList);
        c3.Add(CoinsList);
        c4.Add(CoinsList);
        c5.Add(CoinsList);


        i1.setIsland(Island1);
        i2.setIsland(Island2);
        i3.setIsland(Island3);
        i4.setIsland(Island4);
        i5.setIsland(Island5);
        i6.setIsland(Island6);
        i7.setIsland(Island7);
        i8.setIsland(Island8);
        i31.setIsland(Island31);
        i41.setIsland(Island32);
        i51.setIsland(Island51);
        i61.setIsland(Island61);
        i71.setIsland(Island71);

        i1.Add(Islands);
        i2.Add(Islands);
        i3.Add(Islands);
        i4.Add(Islands);
        i5.Add(Islands);
        i6.Add(Islands);
        i7.Add(Islands);
        i8.Add(Islands);
        i31.Add(Islands);
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            introTransition(-1);
        }));
        new SequentialTransition(CommonAnimation.delay(1000),intro).play();
        CollisionChest.start();
        AboveOrNot.start();
        CoinsCheck.start();


    }

    AnimationTimer CollisionOrc = new AnimationTimer() {
        @Override
        public void handle(long l){
            double center = HeroChar.getBoundsInParent().getCenterX();
            double StartCoord = Orc2.getBoundsInParent().getMinX();
            double EndCoord = Orc2.getBoundsInParent().getMaxX();
            if(center>StartCoord && center<EndCoord){
                //code elided
            }
        }
    };

    AnimationTimer CollisionChest = new AnimationTimer(){
        @Override
        public void handle(long l) {
            double center = HeroChar.getBoundsInParent().getCenterX();
            double StartCoord = Chest.getBoundsInParent().getMinX();
            double EndCoord = Chest.getBoundsInParent().getMaxX();
            double CoinCoord = C1.getBoundsInParent().getCenterX();
            if(center>StartCoord && center<EndCoord){
                fadeOut(Chest);
                fadeIn(OpenChest);
                StaticKnife.setOpacity(1);
                Player.getPlayer().SetKnife();
            }
        }
    };
    AnimationTimer CoinsCheck = new AnimationTimer() {
        @Override
        public void handle(long l) {
            double center = HeroChar.getBoundsInParent().getCenterX();
            for(int i=0;i<CoinsList.size();i++) {
                if (center >= CoinsList.get(i).getBoundsInParent().getCenterX()-1 && center <= CoinsList.get(i).getBoundsInParent().getCenterX()+1) {
                    fadeOut(CoinsList.get(i));
                    Player.getPlayer().addCoins(1);
                    CoinCount.setText(String.valueOf(Player.getPlayer().getCoinsPossessed()));
                }
            }
        }
    };
    int count = 0;
    AnimationTimer AboveOrNot = new AnimationTimer() {
        @Override
        public void handle(long l) {
            double center = HeroChar.getBoundsInParent().getCenterX();
            double centreY = HeroChar.getBoundsInParent().getCenterY();
            double maxY = HeroChar.getBoundsInParent().getMaxY();
            for(int i=1;i<Islands.size();i++){
//                System.out.println("CenterY: " + Islands.get(2).getBoundsInParent().getCenterY());
//                System.out.println("Height "+ Islands.get(2).getBoundsInParent().getHeight());
                //centreY<=165
                //(maxY)<Islands.get(i+1).getBoundsInParent().getMinY()+90
                if(center>Islands.get(i).getBoundsInParent().getMaxX() && center<Islands.get(i+1).getBoundsInParent().getMinX()
                        && !t2.isAlive() && centreY<=165 ){
                    //runTranslateTransition(HeroChar,0,750,1500).play();
                    System.out.println("I am between two islands");
                }
            }
        }
    };

    public void Move(MouseEvent mouseEvent) throws InterruptedException {
        //Knife.setOpacity(0);
        PlayerTaps++;
        if(PlayerTaps==1){
            CoinCount.setText("0");
            runTranslateTransition(Title, 0, -150, 1500).play();
        }
        Taps.setText(String.valueOf(PlayerTaps));

        MoveHero(HeroChar);


        t2 = new Thread(new Runnable(){public void run(){

            if(Player.getPlayer().GetKnife()){
                Knife.setOpacity(1);
                runTranslateTransition(Knife,500,0,2000).play();
                Knife.setLayoutX(HeroChar.getBoundsInParent().getCenterX());
            }

            runTranslateTransition(Island1,-220,0,2000).play();
            runTranslateTransition(Island2,-220,0,2000).play();
            runTranslateTransition(Chest,-220,0,2000).play();
            runTranslateTransition(OpenChest,-220,0,2000).play();
            runTranslateTransition(C1,-220,0,2000).play();
            runTranslateTransition(C2,-220,0,2000).play();
            runTranslateTransition(C3,-220,0,2000).play();
            runTranslateTransition(C4,-220,0,2000).play();
            runTranslateTransition(C5,-220,0,2000).play();

            runTranslateTransition(Island3,-220,0,2000).play();
            runTranslateTransition(Island4,-220,0,2000).play();
            runTranslateTransition(Island5,-220,0,2000).play();
            runTranslateTransition(Island6,-220,0,2000).play();
            runTranslateTransition(Island7,-220,0,2000).play();
            runTranslateTransition(Island8,-220,0,2000).play();
            runTranslateTransition(Island31,-220,0,2000).play();
            runTranslateTransition(Island41,-220,0,2000).play();
            runTranslateTransition(Island51,-220,0,2000).play();
            runTranslateTransition(Island61,-220,0,2000).play();
            runTranslateTransition(Island71,-220,0,2000).play();
            runTranslateTransition(Island81,-220,0,2000).play();
            runTranslateTransition(Island32,-220,0,2000).play();

        }});

        t2.start();
        t2.join();
    }


    public void BackgroundMovement(){
        runTranslateTransition(Island1,-200,0,2000).play();
        runTranslateTransition(Island2,-200,0,2000).play();
        runTranslateTransition(Chest,-200,0,2000).play();
        runTranslateTransition(Island3,-200,0,2000).play();
        runTranslateTransition(Orc2,-200,0,2000).play();
        runTranslateTransition(Island4,-200,0,2000).play();
        runTranslateTransition(Island5,-200,0,2000).play();
        runTranslateTransition(Island6,-200,0,2000).play();
        runTranslateTransition(Island7,-200,0,2000).play();
        runTranslateTransition(Island8,-200,0,2000).play();
        runTranslateTransition(Island31,-200,0,2000).play();
        runTranslateTransition(Island41,-200,0,2000).play();
        runTranslateTransition(Island51,-200,0,2000).play();
        runTranslateTransition(Island61,-200,0,2000).play();
        runTranslateTransition(Island71,-200,0,3000).play();
        runTranslateTransition(Island81,-200,0,3000).play();
        runTranslateTransition(Island32,-200,0,3000).play();
    }


    @Override
    public void run() {

    }
}
