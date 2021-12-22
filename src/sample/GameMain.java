package sample;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameMain extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WillHero.fxml"));
        primaryStage.setTitle("Will Hero");
        Image icon = new Image("C:\\Users\\Shantanu\\Desktop\\WillHero\\src\\Assets\\GameIcon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root,680,339));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);
    }

}
