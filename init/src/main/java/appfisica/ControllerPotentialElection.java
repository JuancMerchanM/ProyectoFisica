package appfisica;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ControllerPotentialElection implements Initializable {


    @FXML
    AnchorPane fondoPotencia;

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
        fondoPotencia.getStyleClass().add("fondoPotencia");
    }

    public void changePotentialGravedad() throws IOException{
        App.setRoot("PotentialGravityEnergyScene");
        App.scene.getStylesheets().clear();
        //App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
    }
    public void changePotentialElastic() throws IOException{
        App.setRoot("potentialElasticEnergy");
        App.scene.getStylesheets().clear();
        App.scene.getStylesheets().add(App.class.getResource("energiaCineticaStyle.css").toExternalForm());
    }

    // CARGAR ESCENA DE MENU
    public void goBack() throws IOException {
        App.setRoot("startMenu");
        App.scene.getStylesheets().clear();
        // SE REESTABLECE EL STYLE.
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }






}
