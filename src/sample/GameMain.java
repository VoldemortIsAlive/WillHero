package sample;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.CommonAnimation.JumpHero;
import static sample.CommonAnimation.runTranslateTransition;
import static sample.CommonAnimation.MoveHero;

public class GameMain extends Application implements Initializable {

    @FXML
    private ImageView Title;
    @FXML
    private ImageView Hero;
    @FXML
    private ImageView Island1;
    @FXML
    private ImageView Island2;

    @FXML
    private ImageView GameBackground;
    @FXML
    private Button button;







    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WillHero.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 720,480));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    private void introTransition(double out) {
        //Duration to be 1500
        //Setting Duration to 1 for fast Testing
        runTranslateTransition(Island1, 0, out * 200, 1500).play();
        runTranslateTransition(Island2, 0, out * 175, 1500).play();
        runTranslateTransition(Title, 0, out * -150, 1500).play();
        JumpHero(Hero);
        /*
        if (out == 1) {
            CommonAnimation.fade(startButton, 0).play();
            startButton.setDisable(true);
        } else {
            CommonAnimation.fade(startButton, 1).play();
            startButton.setDisable(false);
        }
         */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Timeline intro = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            introTransition(-1);
        }));

        new SequentialTransition(CommonAnimation.delay(1000),intro).play();
    }
    public void MoveHeroForward(ActionEvent actionEvent){
        MoveHero(Hero);
    }


    public static void main(String[] args) {
        launch(args);
    }



}
