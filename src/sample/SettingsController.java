package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Hero.*;

import java.io.*;

public class SettingsController {
    @FXML
    private ImageView SaveIcon;
    @FXML
    private ImageView LoadIcon;
    @FXML
    private ImageView ExitButton;
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

    public static void savegame(){
        try {
            FileOutputStream fileOut = new FileOutputStream("info.ser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(Controller.class);
//            outStream.writeObject(Hero.class);
            outStream.close();
            fileOut.close();
            System.out.println("game is saved");
        }
        catch(IOException i) {
            i.printStackTrace();
        }
    }
    public void loadgame(ActionEvent event){
        try {
            FileInputStream fileIn =new FileInputStream("info.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Controller.h= (Hero) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i) {
            i.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }
    }
//    public static void Main(String[] args){
//        //SettingsController.savegame();
//    }
}
