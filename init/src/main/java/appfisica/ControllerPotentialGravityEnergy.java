package appfisica;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerPotentialGravityEnergy implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button goBack;
    @FXML
    private Button calcular;

    @FXML
    ImageView imagen1;
    @FXML
    ImageView imagen2;

    @FXML
    private ScrollPane scrollPaneContent;

    @FXML
    private VBox vBoxContentScroll;
    @FXML
    TextField masaTextField;

    @FXML
    TextField alturaTextField;

    // CHOICE BOX
    String[] unidadesDisponiblesMasa = { "Kilogramos(Kg)", "Gramos(g)" };
    String[] unidadesDisponiblesAltura = { "Kilometro(km)", "Metro(m)" };
    @FXML
    ChoiceBox<String> choiceBoxMasa;
    @FXML
    ChoiceBox<String> choiceBoxAltura;
    @FXML
    private Label resultadoLabel;

    @FXML
    private Label contentLabel1 = new Label();

    ArrayList<Label> contentLabels = new ArrayList<Label>();

    public void initialize(URL arg0, ResourceBundle arg1) {

        Label title = new Label("Energía Potencial Gravitatoria");
        String contenidoS = leerArchivoTexto("gravitycont.txt");
        contentLabel1.setText(contenidoS);
        contentLabels.add(title);
        contentLabels.add(contentLabel1);
        contentLabel1.setWrapText(true);
        title.setWrapText(true);
        vBoxContentScroll.getChildren().setAll(contentLabels);

        imagen1.setImage(new Image(App.class.getResourceAsStream("energiaEjemploGRAV.PNG")));
        imagen2.setImage(new Image(App.class.getResourceAsStream("ejemploGravedad.PNG")));

        // ESTABLECER OPCIONES CHOICEBOX
        choiceBoxMasa.getItems().addAll(unidadesDisponiblesMasa);

        choiceBoxAltura.getItems().addAll(unidadesDisponiblesAltura);

    }

    private String leerArchivoTexto(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(App.class.getResourceAsStream(nombreArchivo)))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }



    @FXML
    private void calEnergyGravity() {
        Double masa = 0.0;
        Double Altura = 0.0;

        try {

            masa = Double.parseDouble(masaTextField.getText());

            Altura = Double.parseDouble(alturaTextField.getText());

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al ingresar valores");
            alert.setContentText("Por favor, ingrese valores numéricos válidos.");
            alert.showAndWait();
        }

        // CONVERSIONES
        if (choiceBoxMasa.getValue() == null) {

        } else {
            String masaunidad = choiceBoxMasa.getValue().toString();
            if (masaunidad.equals("Gramos(g)")) {
                masa = masa * (1 / 1000);
            }
        }
        
        if (choiceBoxAltura.getValue() == null) {

        } else {
            String alturaUnidad = choiceBoxAltura.getValue().toString();
            if (alturaUnidad.equals("Kilometro(km)")) {
                Altura = Altura * 1000;
            }
        }

        double resulEnergyGrav = (9.8) * masa * Altura;

        DecimalFormat df = new DecimalFormat("#.##");

        resultadoLabel.setText(String.valueOf(df.format(resulEnergyGrav)) + " J");

    }

    // CARGAR ESCENA DE MENU
    public void goBack() throws IOException {
        App.setRoot("potentialEnergyScene");
        App.scene.getStylesheets().clear();
        // SE REESTABLECE EL STYLE.
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }

}
