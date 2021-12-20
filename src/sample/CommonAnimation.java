package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
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
    public static TranslateTransition JumpHero(Node n){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n);
        translate.setDuration(Duration.millis(650));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(30);
        translate.setAutoReverse(true);
        translate.play();
        return translate;
    }
    public static TranslateTransition MoveHero(Node n){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(60);
        translate.setByY(n.getScaleY());
        translate.setAutoReverse(false);
        translate.play();
        return translate;
    }

    public static FadeTransition fade(Node n, double fadeval, double time) {
        //Fade Duration Must be 1500
        //Setting Fades to 1 for Fast Testing
        FadeTransition fadeload = new FadeTransition();
        fadeload.setDuration(Duration.millis(time));
        fadeload.setToValue(fadeval);
        fadeload.setNode(n);
        if(fadeval==0)n.setDisable(true);
        else if(fadeval==1)n.setDisable(false);
        return fadeload;
    }

    public static Timeline delay(double time)
    {
        return new Timeline(new KeyFrame(Duration.millis(time), e -> { }));
    }
}
