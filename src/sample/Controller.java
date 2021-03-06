package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import static sample.CommonAnimation.*;
import static sample.CommonAnimation.runTranslateTransition;

public class Controller implements Initializable,Runnable, Serializable {

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
    private Label txt;
    @FXML
    private Rectangle rect;
    @FXML
    private Button respawn;
    @FXML
    private Button norespawn;
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
    private ImageView C6;
    @FXML
    private ImageView C7;
    @FXML
    private ImageView C8;
    @FXML
    private ImageView C9;

    @FXML
    private ImageView PausedGame;
    @FXML
    private ImageView ResumeIcon;

    @FXML
    private ImageView Knife;
    @FXML
    private ImageView StaticKnife;
    @FXML
    private ImageView StaticBomb;
    @FXML
    private ImageView Bomb;
    @FXML
    private ImageView Pause;
    @FXML
    private ImageView end;
    @FXML
    private ImageView exit;

    @FXML
    private ImageView Uprock;
    @FXML
    private ImageView cloud1;
    @FXML
    private ImageView cloud2;
    @FXML
    private ImageView cloud3;
    @FXML
    private ImageView cloud4;
    @FXML
    private Text Taps;
    @FXML
    private ImageView GameBackground;

    @FXML
    private ImageView Orc;
    @FXML
    private ImageView Orc2;
    @FXML
    private ImageView Orc3;

    @FXML
    private Label CoinCount;
    @FXML
    private ImageView Chest;
    @FXML
    private ImageView OpenChest;

    static Hero h = new Hero(0,0);
    Thread t2;
    int PlayerTaps = Player.getPlayer().getTaps();



    ArrayList<ImageView> Islands = new ArrayList<>();       //ArrayList storing Islands in imageview format
    ArrayList<ImageView> CoinsList = new ArrayList<>();     //ArrayList storing Coins in imageview format
    ArrayList<ImageView> OrcList = new ArrayList<>();

    Group g = new Group();

    //Coin objects generated
    Coin c1 = new Coin();
    Coin c2 = new Coin();
    Coin c3 = new Coin();
    Coin c4 = new Coin();
    Coin c5 = new Coin();
    Coin c6 = new Coin();
    Coin c7 = new Coin();
    Coin c8 = new Coin();
    Coin c9 = new Coin();

    Orcs o1 = new Orcs(0,0);
    Orcs o2 = new Orcs(0,0);
    Orcs o3 = new Orcs(0,0);



    //Islands object generated
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

    public Controller() throws IOException {
    }


    //Opening/Intro transition
    private void introTransition(double out) {
        runTranslateTransition(Title, 0, out * -150, 1500).play();
        //JumpHero(HeroChar,true);
        PathAnimateStraightNormal(HeroChar,60).play();
        PathAnimateStraight(Orc).play();
        PathAnimateStraight(Orc2).play();
        PathAnimateStraight(Orc3).play();
        h.setHeroPhoto(HeroChar);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        c1.setCoin(C1);
        c2.setCoin(C2);
        c3.setCoin(C3);
        c4.setCoin(C4);
        c5.setCoin(C5);
        c6.setCoin(C6);
        c7.setCoin(C7);
        c8.setCoin(C8);
        c9.setCoin(C9);

        c1.Add(CoinsList);
        c2.Add(CoinsList);
        c3.Add(CoinsList);
        c4.Add(CoinsList);
        c5.Add(CoinsList);
        c6.Add(CoinsList);
        c7.Add(CoinsList);
        c8.Add(CoinsList);
        c9.Add(CoinsList);

        o1.setOrc(Orc);
        o1.Add(OrcList);
        o2.setOrc(Orc2);
        o2.Add(OrcList);
        o3.setOrc(Orc3);
        o3.Add(OrcList);


        i1.setIsland(Island1);
        i2.setIsland(Island2);
        i3.setIsland(Island3);
        i4.setIsland(Island4);
        i5.setIsland(Island5);
        i6.setIsland(Island6);
        i7.setIsland(Island7);
        i8.setIsland(Island8);
        i31.setIsland(Island31);
        i41.setIsland(Island41);
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
        i41.Add(Islands);
        i51.Add(Islands);
        i61.Add(Islands);
        i71.Add(Islands);
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            introTransition(-1);
        }));
        new SequentialTransition(CommonAnimation.delay(1000),intro).play();
        CollisionOrc.start();
        CollisionChest.start();     //AnimationTimer for chest collision tracker
        AboveOrNot.start();         //AnimationTimer for Above Island checker
        AboveOrNot_Orc.start();     //AnimationTimer for Above Island Orc checker
        CoinsCheck.start();         //AnimationTimer for Coin Collision tracker

    }

    AnimationTimer CollisionOrc = new AnimationTimer() {
        @Override
        public void handle(long l){
            double MaxX = HeroChar.getBoundsInParent().getMaxX();
            double MinY = HeroChar.getBoundsInParent().getMaxY();
            for(int i=0;i<OrcList.size();i++) {
                 if (MaxX >= OrcList.get(i).getBoundsInParent().getMinX() && MaxX<OrcList.get(i).getBoundsInParent().getMaxX()) {
                    //OrcRight(OrcList.get(i),OrcList.get(i).getBoundsInParent().getCenterX(),OrcList.get(i).getBoundsInParent().getCenterY()).play();
                    runTranslateTransition(OrcList.get(i), 20,0,1000).play();
//                    for(int j=0;j<Islands.size();j++){
//                        if(OrcList.get(i).getBoundsInParent().getCenterX()>Islands.get(j).getBoundsInParent().getMaxX() && OrcList.get(i).getBoundsInParent().getCenterX()<Islands.get(j+1).getBoundsInParent().getMinX()){
//                            System.out.println("yes");
//                            runTranslateTransition(OrcList.get(i),0,100,800).play();
//                            FallOrc(OrcList.get(i));
//
//                        }
//                    }
                }
            }
        }
    };

    //AnimationTimer for chest collision tracker
    AnimationTimer CollisionChest = new AnimationTimer(){
        @Override
        public void handle(long l) {
            double center = HeroChar.getBoundsInParent().getCenterX();
            double centreY = HeroChar.getBoundsInParent().getCenterY();
            double StartCoord = Chest.getBoundsInParent().getMinX();
            double EndCoord = Chest.getBoundsInParent().getMaxX();
            double CoinCoord = C1.getBoundsInParent().getCenterX();



            if(center>StartCoord && center<EndCoord){
                fadeOut(Chest, 1.0).play();
                fadeIn(OpenChest, 1.0).play();
                //StaticKnife.setOpacity(1);
                try {
                    Player.getPlayer().SetKnife();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    //AnimationTimer for Coin Collision tracker
    AnimationTimer CoinsCheck = new AnimationTimer() {
        @Override
        public void handle(long l) {
            double center = HeroChar.getBoundsInParent().getCenterX();
            Iterator it = CoinsList.iterator();
            while(it.hasNext()){
                ImageView target = (ImageView) it.next();
                if (center >= target.getBoundsInParent().getCenterX()-1 && center <= target.getBoundsInParent().getCenterX()+1) {
                    fadeOut(target,1.0).play();
                    try {
                        Player.getPlayer().addCoins(1);
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        CoinCount.setText(String.valueOf(Player.getPlayer().getCoinsPossessed()));
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
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
            double MinY = HeroChar.getBoundsInParent().getMinY();
            double maxY = HeroChar.getBoundsInParent().getMaxY();
            for(int i=0;i<Islands.size();i++){
                //centreY<=165
                if(center>Islands.get(i).getBoundsInParent().getMaxX() && center<Islands.get(i+1).getBoundsInParent().getMinX()
                        && !t2.isAlive() && centreY<=153.5625){
                    runTranslateTransition(HeroChar,0,750,1500).play();         //FALL HERO

                    FadeTransition fader0 = new FadeTransition(Duration.millis(1200),txt);
                    FadeTransition fader = new FadeTransition(Duration.millis(1200),rect);
                    FadeTransition fader2 = new FadeTransition(Duration.millis(1200),respawn);
                    FadeTransition fader3 = new FadeTransition(Duration.millis(1200),norespawn);

                    fader0.setFromValue(0);
                    fader0.setToValue(1);
                    fader.setFromValue(0);
                    fader.setToValue(1);
                    fader2.setFromValue(0);
                    fader2.setToValue(1);
                    fader3.setFromValue(0);
                    fader3.setToValue(1);
                    fader0.play();
                    fader.play();
                    fader2.play();
                    fader3.play();
                    System.out.println("hello");
                }
                //FIXING BOUNCE
                if(HeroChar.getBoundsInParent().intersects(Islands.get(i).getBoundsInParent())){
                    PathAnimateStraight(HeroChar).play();
                    //System.out.println("just touched");
                }

            }
        }
    };

    AnimationTimer AboveOrNot_Orc = new AnimationTimer() {
        @Override
        public void handle(long l) {
            for(int i=0;i<OrcList.size();i++) {
                for(int j=0;j<Islands.size();j++){
                        double centerX = OrcList.get(i).getBoundsInParent().getCenterX();
                        double centerY = OrcList.get(i).getBoundsInParent().getCenterY();
                        //centerX>Islands.get(j).getBoundsInParent().getMinX() && centerX<Islands.get(j).getBoundsInParent().getMaxX();
//                        if (OrcList.get(i).getBoundsInParent().intersects(Islands.get(j).getBoundsInParent())) {
//                            PathAnimateStraight(OrcList.get(i)).play();
//                        }
                        if (centerX > Islands.get(j).getBoundsInParent().getMaxX() && centerX < Islands.get(j+1).getBoundsInParent().getMinX()
                                && !t2.isAlive() && centerY <= 153.5625) {
                            runTranslateTransition(OrcList.get(i), 0, 750, 400).play();
                            fadeOut(OrcList.get(i),200.0 ).play();
                            OrcList.get(i).setOpacity(0);
                        }

                }
            }
        }
    };

    public void Move(MouseEvent mouseEvent) throws InterruptedException, IOException {
        //Knife.setOpacity(0);
        PlayerTaps++;
        if(PlayerTaps==1){
            CoinCount.setText("0");
            runTranslateTransition(Title, 0, -150, 1500).play();
        }
        Taps.setText(String.valueOf(PlayerTaps));
        Player.getPlayer().setHighscore(PlayerTaps);

        MoveHero(HeroChar);


        t2 = new Thread(new Runnable(){public void run(){

            try {
                if(Player.getPlayer().GetKnife()){
                    Knife.setOpacity(1);
                    PathAnimateArc(Knife,HeroChar.getBoundsInParent().getMaxX(),HeroChar.getBoundsInParent().getMaxY()).play();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(Player.getPlayer().GetBomb()){
                    Bomb.setOpacity(1);
                    PathAnimateStraight(Bomb).play();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            runTranslateTransition(Island1,-220,0,2000).play();
            runTranslateTransition(Island2,-220,0,2000).play();
            runTranslateTransition(Chest,-220,0,2000).play();
            runTranslateTransition(OpenChest,-220,0,2000).play();

            runTranslateTransition(cloud1,-220,0,2000).play();
            runTranslateTransition(cloud2,-220,0,2000).play();
            runTranslateTransition(cloud3,-220,0,2000).play();
            runTranslateTransition(cloud4,-220,0,2000).play();

            runTranslateTransition(Orc,-220,0,2000).play();
            runTranslateTransition(Orc2,-220,0,2000).play();
            runTranslateTransition(Orc3,-220,0,2000).play();

            runTranslateTransition(C1,-220,0,2000).play();
            runTranslateTransition(C2,-220,0,2000).play();
            runTranslateTransition(C3,-220,0,2000).play();
            runTranslateTransition(C4,-220,0,2000).play();
            runTranslateTransition(C5,-220,0,2000).play();
            runTranslateTransition(C6,-220,0,2000).play();
            runTranslateTransition(C7,-220,0,2000).play();
            runTranslateTransition(C8,-220,0,2000).play();
            runTranslateTransition(C9,-220,0,2000).play();

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
    private Stage s;
    private Parent p;
    private Scene sc;

    public void FallOrc(ImageView img){
        runTranslateTransition(img,-200,250,800).play();
    }

    public void SwitchToSettings(MouseEvent mouseEvent) throws IOException {
        this.s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("Settings.fxml"));
        this.s.setTitle("Settings Page");
        this.s.setScene(new Scene(root, 500,300));
        this.s.show();
    }
    public void Pause(MouseEvent mouseEvent) throws IOException{
        fadeIn(PausedGame,100.0).play();
        fadeIn(ResumeIcon,100.0).play();
    }
    public void Resume(MouseEvent mouseEvent) throws IOException{
        PausedGame.setOpacity(0);
        ResumeIcon.setOpacity(0);
    }

    public void Respawn() throws IOException {
        if(Player.getPlayer().getCoinsPossessed()>1) {
            FadeTransition fader = new FadeTransition(Duration.millis(100), rect);
            FadeTransition fader2 = new FadeTransition(Duration.millis(100), respawn);
            FadeTransition fader3 = new FadeTransition(Duration.millis(100), norespawn);
            fader.setFromValue(1);
            fader.setToValue(0);
            fader2.setFromValue(1);
            fader2.setToValue(0);
            fader3.setFromValue(1);
            fader3.setToValue(0);
            fader.play();
            fader2.play();
            fader3.play();
        }
    }
    public void NoRespawn(MouseEvent mouseEvent) throws IOException{
        this.s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("EndGame.fxml"));
        this.s.setTitle("EndGame Page");
        this.s.setScene(new Scene(root, 650,300));
        this.s.show();
    }
    @Override
    public void run() {

    }
}
