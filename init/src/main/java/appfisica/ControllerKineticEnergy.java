package appfisica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerKineticEnergy implements Initializable {

    // BASICS
    @FXML
    private ScrollPane scrollPaneContent;
    @FXML
    private VBox vBoxContentScroll;
    @FXML
    private Button goBack;
    @FXML
    private Button calcular;

    // TEXTFIELD
    @FXML
    TextField ingresarMasa;
    @FXML
    TextField ingresarVelocidad;

    // CHOICE BOX
    String[] unidadesDisponiblesMasa = { "Kilogramos(Kg)", "Gramos(g)" };
    String[] unidadesDisponiblesVelocidad = { "Kilometro/Hora(km/h)", "Metro/Segundo(m/s)" };
    @FXML
    ChoiceBox<String> choiceBoxMasa;
    @FXML
    ChoiceBox<String> choiceBoxVelocidad;

    @FXML
    Label energiaCineticaCalculo;

    // INFORMACION
    @FXML
    Label title;
    @FXML
    Label parrafo1Definicion;
    @FXML
    ImageView energiaCineticaFormula;
    @FXML
    Label parrafo2DescripcionRelacion;
    @FXML
    Label tituloTeorema;
    @FXML
    Label teoremaEnergiaTrabajo;
    @FXML
    ImageView teoremaFormulas;
    @FXML
    Label tituloEjemplo;
    @FXML
    Label ej1;
    @FXML
    ImageView solucion1GuiaVisual;
    @FXML
    ImageView solucionEjemplo1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // CARGAR NODOS/ARCHIVOS
        title.setText("Energía Cinética");

        // ENERGIA
        parrafo1Definicion.setText(leerArchivoTexto("P1definicionEnergiaCinetica.txt"));
        energiaCineticaFormula.setImage(new Image(App.class.getResourceAsStream("EnergiaCineticaFormula.jpg")));
        parrafo2DescripcionRelacion.setText(leerArchivoTexto("P2OpcionalDescripcionRelacion.txt"));

        // TEOREMA
        tituloTeorema.setText("Teorema de trabajo-energía");
        teoremaEnergiaTrabajo.setText(leerArchivoTexto("P3Teorema.txt"));
        teoremaFormulas.setImage(new Image(App.class.getResourceAsStream("FormulasTeoremaEnergia.png")));
        tituloEjemplo.setText("Ejemplo.");
        ej1.setText(leerArchivoTexto("EJ2teoremaDeTrabajoEnergia.txt"));
        solucion1GuiaVisual.setImage(new Image(App.class.getResourceAsStream("ImagenGuiaSolucion1.png")));
        solucionEjemplo1.setImage(new Image(App.class.getResourceAsStream("SolucionEjemplo1.png")));

        // ESTABLECER OPCIONES CHOICEBOX
        choiceBoxMasa.getItems().addAll(unidadesDisponiblesMasa);
        choiceBoxVelocidad.getItems().addAll(unidadesDisponiblesVelocidad);

        // BASICS
        vBoxContentScroll.setPrefHeight(2000);
        vBoxContentScroll.setPadding(new Insets(10));
        scrollPaneContent.autosize();

        // AJUSTAR A TAMAÑO NECESARIO
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

    // CARGAR ESCENA DE MENU
    public void goBack() throws IOException {
        App.setRoot("startMenu");
        App.scene.getStylesheets().clear();
        // SE REESTABLECE EL STYLE.
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }

    // CALCULOS
    public void realizarOperaciones() {
        Double velocidad = 0.0;
        Double masa = 0.0;

        try {
            velocidad = Double.parseDouble(ingresarVelocidad.getText());
            masa = Double.parseDouble(ingresarMasa.getText());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al ingresar valores");
            alert.setContentText("Por favor, ingrese valores numéricos válidos.");
            alert.showAndWait();
        }
        if (choiceBoxMasa.getValue().equals("Gramos(g)")) {
            masa = masa * 1000;
        }
        if (choiceBoxVelocidad.getValue().equals("Kilometro/Hora(km/h)")) {
            velocidad = velocidad * 3.6;
        }
        double resultadoNumerico = (1.0 / 2.0) * masa * velocidad * velocidad;
        DecimalFormat df = new DecimalFormat("#.##"); 
        String resultado = df.format(resultadoNumerico);
        energiaCineticaCalculo.setText(resultado);
    }
}
