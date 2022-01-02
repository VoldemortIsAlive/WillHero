package sample;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.util.Duration;

public abstract class CommonAnimation {
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
            translate.setByY(40);
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
    public static FadeTransition fadeOut(ImageView img,Double time){
        FadeTransition fader = new FadeTransition(Duration.millis(time) , img);
        fader.setFromValue(1);
        fader.setToValue(0);
        return fader;
    }
    public static FadeTransition fadeIn(ImageView img,Double time){
        FadeTransition fader = new FadeTransition(Duration.millis(time) , img);
        fader.setFromValue(0);
        fader.setToValue(1);
        return fader;
    }
    public static PathTransition PathAnimateArc(ImageView img,double x,double y) {
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        ArcTo arc = new ArcTo();
        arc.setX(x+100);
        arc.setY(-y-50);
        arc.setRadiusX(50);
        arc.setRadiusY(-20);
        path.getElements().add(arc);
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        return transition;
    }

    public static PathTransition OrcRight(ImageView img,double x,double y){
        Path path = new Path();
        path.getElements().add(new MoveTo(x+10,y+10));
        path.getElements().add(new HLineTo(x+40));
        path.getElements().add(new VLineTo(y+30));
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(250)));
        transition.setPath(path);
        return transition;
    }

    public static PathTransition PathAnimateStraightNormal(ImageView img,double y){
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new VLineTo(-y));
        path.getElements().add(new VLineTo(y));
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1200)));
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setPath(path);
        return transition;
    }

    public static PathTransition PathAnimateStraight(ImageView img){
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new VLineTo(-30));
        path.getElements().add(new VLineTo(30));
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1200)));
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setPath(path);
        return transition;
    }

    public static Timeline delay(double time)
    {
        return new Timeline(new KeyFrame(Duration.millis(time), e -> { }));
    }
}
