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

public class ControllerPotentialElastic implements Initializable {

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
    TextField ingresarConstante;
    @FXML
    TextField ingresarDeformacionResorte;
    @FXML
    TextField ingresarFuerza;
    @FXML
    TextField ingresarDeformacionResorteK;


    // CHOICE BOX
    String[] unidadesDisponiblesConstante = { "Newtons/metro(N/m)" };
    String[] unidadesDisponiblesFuerza = { "Newton(N)", "Libra(lb)" };
    String[] unidadesDisponiblesDistancia = { "Kilometro(km)", "Metro(m)" };
    @FXML
    ChoiceBox<String> choiceBoxConstante;
    @FXML
    ChoiceBox<String> choiceBoxDeformacionResorte;
    @FXML
    ChoiceBox<String> choiceBoxFuerza;
    @FXML
    ChoiceBox<String> choiceBoxDeformacionResorteK;

    @FXML
    Label energiaPotencialElastica;
    @FXML
    Label constanteResorte;

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


        //RVIEW INFORMACION
        // ESTABLECER OPCIONES CHOICEBOX
        choiceBoxConstante.getItems().addAll(unidadesDisponiblesConstante);
        choiceBoxDeformacionResorte.getItems().addAll(unidadesDisponiblesDistancia);
        choiceBoxDeformacionResorteK.getItems().addAll(unidadesDisponiblesDistancia);
        choiceBoxFuerza.getItems().addAll(unidadesDisponiblesFuerza);

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
        Double constante = 0.0;
        Double deformacionResorte = 0.0;
        Double fuerza = 0.0;
        Double deformacionResorteK = 0.0;
        try {
            constante = Double.parseDouble(ingresarConstante.getText());
            deformacionResorte = Double.parseDouble(ingresarDeformacionResorte.getText());
            fuerza = Double.parseDouble(ingresarFuerza.getText());
            deformacionResorteK = Double.parseDouble(ingresarDeformacionResorteK.getText());

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al ingresar valores");
            alert.setContentText("Por favor, ingrese valores numéricos válidos.");
            alert.showAndWait();
        }
        //CONVERSIONES
        if (choiceBoxDeformacionResorte.getValue().equals("Kilometro(km)")) {
            deformacionResorte = deformacionResorte * 1000;
        }
        if (choiceBoxDeformacionResorteK.getValue().equals("Kilometro(km)")) {
            deformacionResorteK = deformacionResorteK * 1000;
        }
        if (choiceBoxFuerza.getValue().equals("Libra(lb)")){
            fuerza = fuerza * 4.44822;
        }

        double resultadoNumericoEnergiaElastica = (0.5) * constante * deformacionResorte * deformacionResorte;
        double resultadoNumericoConstante = fuerza * deformacionResorteK;

        DecimalFormat df = new DecimalFormat("#.##"); 
        String resultadoEnergiaElastica = df.format(resultadoNumericoEnergiaElastica);
        String resultadoConstante = df.format(resultadoNumericoConstante);
        energiaPotencialElastica.setText(resultadoEnergiaElastica + " J");
        constanteResorte.setText(resultadoConstante + " N/m");
    }
}
