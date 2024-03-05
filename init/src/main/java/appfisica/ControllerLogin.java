package appfisica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;

public class ControllerLogin implements Initializable{

    @FXML
    AnchorPane fondo;


    @FXML
    Button kineticEnergy;
    @FXML
    Button potentialEnergy;
    @FXML
    Button mechanicalEnergy;
    @FXML
    Button exit;
    @FXML
    VBox kineticBox;
    @FXML
    VBox potentialBox;
    @FXML
    VBox mechanicalBox;
    @FXML
    VBox exitBox;  

    @FXML
    Label title;

      

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Image image = new Image(App.class.getResourceAsStream("fondoStart.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        fondo.setBackground(background);


        title.getStyleClass().add("my_label");
        kineticEnergy.getStyleClass().add("custom-button");
        potentialEnergy.getStyleClass().add("custom-button");
        mechanicalEnergy.getStyleClass().add("custom-button");
        exit.getStyleClass().add("custom-button");
        
    }

    public void changeSceneKineticEnergy() throws IOException{
        App.setRoot("kineticEnergyScene");
        App.scene.getStylesheets().clear();
        App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
    }

    public void changeScenePotentialEnergy() throws IOException{
        App.setRoot("potentialEnergyScene");
        App.scene.getStylesheets().clear();
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }

    public void changeSceneMechanicalEnergy() throws IOException{
        App.setRoot("mechanicalEnergyScene");
        App.scene.getStylesheets().clear();
        //App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
    }


    public void exitApp( ) throws IOException{
        System.exit(0);
    }
}
