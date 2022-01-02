package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EndGameController {
    @FXML
    private ImageView Yes;
    @FXML
    private ImageView No;
    private Stage s;
    private Parent p;
    private Scene sc;
    public void SwitchBackToGame(MouseEvent mouseEvent) throws IOException {
        this.s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("WillHero.fxml"));
        this.s.setTitle("WillHero");
        this.s.setScene(new Scene(root, 680,339));
        this.s.show();
    }
    public void EndGame(MouseEvent mouseEvent) throws IOException{
        System.exit(0);
    }
}
