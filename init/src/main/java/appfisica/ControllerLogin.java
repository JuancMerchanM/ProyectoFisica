package appfisica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.Initializable;

public class ControllerLogin implements Initializable{
    
    private Stage stage;
    private Scene scene;
    private Parent root;


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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*Image imageButton = new Image(getClass().getResourceAsStream("imageButton.png"), 150, 50, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(
            imageButton,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImageButton);

        kineticBox.setBackground(background);
        potentialBox.setBackground(background);
        mechanicalBox.setBackground(background);
        exitBox.setBackground(background);*/

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
        //App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
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
