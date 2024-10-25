package appfisica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerMechanicalEnergy implements Initializable{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ScrollPane scrollPaneContent;

    @FXML
    private VBox vBoxContentScroll;
    @FXML
    private TextField potentialTextField;

    @FXML
    private TextField kineticTextField;

    @FXML
    private Label resultadoLabel;
    @FXML
    private Button lastButton;
    @FXML
    private Button calcular;

    @FXML
    private ImageView imagen1;


    @FXML
    private Label contentLabel1 = new Label();

    ArrayList<Label> contentLabels = new ArrayList<Label>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Label title = new Label("Energía Mecánica");
        String contenidoS = leerArchivoTexto("contenidoMechanical.txt");


        contentLabel1.setText(contenidoS);
        contentLabels.add(title);
        contentLabels.add(contentLabel1);
        contentLabel1.setWrapText(true);
        title.setWrapText(true);
        imagen1.setImage(new Image(App.class.getResourceAsStream("energiaMecanicaEJEM.PNG")));
        vBoxContentScroll.getChildren().setAll(contentLabels);
        //vBoxContentScroll.setPrefHeight(1000);
        //scrollPaneContent.autosize();
    }

    private String leerArchivoTexto(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream(nombreArchivo)))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    // CARGAR ESCENA DE MENU
    public void goBack() throws IOException {
        App.setRoot("startMenu");
        App.scene.getStylesheets().clear();
        // SE REESTABLECE EL STYLE.
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }

    @FXML
    private void calcularEnergiaMecanica() {


        double potential = Double.parseDouble(potentialTextField.getText());
        double kinetic = Double.parseDouble(kineticTextField.getText());

        double mechanical=kinetic + potential;
        resultadoLabel.setText("" + mechanical);


    }

}
