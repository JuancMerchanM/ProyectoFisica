package appfisica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
    @FXML
    TextField ingresarFuerza;
    @FXML
    TextField ingresarDistancia;


    // CHOICE BOX
    String[] unidadesDisponiblesMasa = { "Kilogramos(Kg)", "Gramos(g)" };
    String[] unidadesDisponiblesVelocidad = { "Kilometro/Hora(km/h)", "Metro/Segundo(m/s)" };
    String[] unidadesDisponiblesFuerza = { "Newton(N)", "Libra(lb)" };
    String[] unidadesDisponiblesDistancia = { "Kilometro(km)", "Metro(m)" };
    @FXML
    ChoiceBox<String> choiceBoxMasa;
    @FXML
    ChoiceBox<String> choiceBoxVelocidad;
    @FXML
    ChoiceBox<String> choiceBoxFuerza;
    @FXML
    ChoiceBox<String> choiceBoxDistancia;

    @FXML
    Label energiaCinetica;
    @FXML
    Label trabajo;
    @FXML
    Label energiaCineticaCalculo;
    @FXML
    Label trabajoCalculo;
    @FXML
    Label masa;
    @FXML
    Label velocidad;
    @FXML
    Label distancia;
    @FXML
    Label fuerza;

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
        choiceBoxDistancia.getItems().addAll(unidadesDisponiblesDistancia);
        choiceBoxFuerza.getItems().addAll(unidadesDisponiblesFuerza);

        // BASICS
        vBoxContentScroll.setPrefHeight(1550);
        vBoxContentScroll.setPadding(new Insets(5));
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
        Double fuerza = 0.0;
        Double distancia = 0.0;
        try {
            velocidad = Double.parseDouble(ingresarVelocidad.getText());
            masa = Double.parseDouble(ingresarMasa.getText());
            fuerza = Double.parseDouble(ingresarFuerza.getText());
            distancia = Double.parseDouble(ingresarDistancia.getText());

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al ingresar valores");
            alert.setContentText("Por favor, ingrese valores numéricos válidos.");
            alert.showAndWait();
            return;
        }
        //CONVERSIONES
        if (choiceBoxMasa.getValue() == null) {

        } else {
            String unidadMasa = choiceBoxMasa.getValue().toString();
            if (unidadMasa.equals("Gramos(g)")) {
                masa = masa * (1.0/1000.0);
            }
        }
        
        if (choiceBoxVelocidad.getValue() == null) {

        } else {
            String unidadVelocidad = choiceBoxVelocidad.getValue().toString();
            if (unidadVelocidad.equals("Kilometro/Hora(km/h)")) {
                velocidad = velocidad * (1.0/3.6);
            }
        }
        
        if (choiceBoxDistancia.getValue() == null) {

        } else {
            String unidadDistancia = choiceBoxDistancia.getValue().toString();
            if (unidadDistancia.equals("Kilometro(km)")) {
                distancia = distancia * 1000;
            }
        }
        
        if (choiceBoxFuerza.getValue() == null) {

        } else {
            String unidadFuerza = choiceBoxFuerza.getValue().toString();
            if (unidadFuerza.equals("Libra(lb)")) {
                fuerza = fuerza * 4.44822;
            }
        }

        double resultadoNumericoEnergiaK = (0.5) * masa * velocidad * velocidad;
        double resultadoNumericoTrabajo = fuerza * distancia;

        DecimalFormat df = new DecimalFormat("#.##"); 
        String resultadoEnergiaK = df.format(resultadoNumericoEnergiaK);
        String resultadoTrabajo = df.format(resultadoNumericoTrabajo);
        energiaCineticaCalculo.setText(resultadoEnergiaK + " J");
        trabajoCalculo.setText(resultadoTrabajo + " J");

    }
}
