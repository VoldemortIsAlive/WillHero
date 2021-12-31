package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CommonAnimation {
    public static TranslateTransition runTranslateTransition(Node n, double x, double y, double duration) {
        TranslateTransition load = new TranslateTransition();
        load.setByX(x);
        load.setByY(y);
        load.setNode(n);
        load.setDuration(Duration.millis(duration));
        return load;
    }
    public static TranslateTransition JumpHero(Node n,boolean bool){
        TranslateTransition translate = new TranslateTransition();
        if(bool == true){
            //750
            translate.setNode(n);
            translate.setDuration(Duration.millis(850));
            translate.setCycleCount(TranslateTransition.INDEFINITE);
            translate.setByY(38);
            translate.setAutoReverse(true);
            translate.play();
        }
        return translate;
    }
    public static TranslateTransition JumpOrc(Node n){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(20);
        translate.setAutoReverse(true);
        translate.play();
        return translate;
    }
    public static TranslateTransition MoveHero(Node n){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(0);
        translate.setByY(n.getScaleY());
        translate.setAutoReverse(false);
        translate.play();
        return translate;
    }
    public static void fadeOut(ImageView img){
        FadeTransition fader = new FadeTransition(Duration.millis(1) , img);
        fader.setFromValue(1);
        fader.setToValue(0);
        fader.play();
    }
    public static FadeTransition fadeIn(ImageView img){
        FadeTransition fader = new FadeTransition(Duration.millis(1) , img);
        fader.setFromValue(0);
        fader.setToValue(1);
        return fader;
    }

    public static Timeline delay(double time)
    {
        return new Timeline(new KeyFrame(Duration.millis(time), e -> { }));
    }
}
