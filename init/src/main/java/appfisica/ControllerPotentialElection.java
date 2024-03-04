package appfisica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ControllerPotentialElection implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    Button EnergiaPotencialGravitatoria;
    @FXML
    Button EnergiaPotencialElastica;

    @FXML
    Button Retroceder;

    @FXML
    VBox gravitBox;
    @FXML
    VBox ElasticBox;

    @FXML
    VBox lastBox;


    public void initialize(URL arg0, ResourceBundle arg1) {


        EnergiaPotencialGravitatoria.getStyleClass().add("custom-button");
        EnergiaPotencialElastica.getStyleClass().add("custom-button");
        Retroceder.getStyleClass().add("custom-button");
    }

    public void changePotentialGravity() throws IOException{
        App.setRoot("PotentialGravityEnergyScene");
        App.scene.getStylesheets().clear();
        //App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
    }






}
