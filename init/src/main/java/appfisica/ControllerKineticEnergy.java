package appfisica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerKineticEnergy implements Initializable{

    @FXML
    private ScrollPane scrollPaneContent;
    @FXML
    private VBox vBoxContentScroll;
    @FXML
    private Button goBack;
    

    //INFORMACION
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
        //CARGAR NODOS/ARCHIVOS
        title.setText("Energía Cinética");
        
        parrafo1Definicion.setText(leerArchivoTexto("P1definicionEnergiaCinetica.txt"));
        energiaCineticaFormula.setImage(new Image(App.class.getResourceAsStream("EnergiaCineticaFormula.jpg")));
        parrafo2DescripcionRelacion.setText(leerArchivoTexto("P2OpcionalDescripcionRelacion.txt"));
        
        tituloTeorema.setText("Teorema de trabajo-energía");
        teoremaEnergiaTrabajo.setText(leerArchivoTexto("P3Teorema.txt"));
        teoremaFormulas.setImage(new Image(App.class.getResourceAsStream("FormulasTeoremaEnergia.png")));
        tituloEjemplo.setText("Ejemplo.");
        ej1.setText(leerArchivoTexto("EJ2teoremaDeTrabajoEnergia.txt"));
        solucion1GuiaVisual.setImage(new Image(App.class.getResourceAsStream("ImagenGuiaSolucion1.png")));
        solucionEjemplo1.setImage(new Image(App.class.getResourceAsStream("SolucionEjemplo1.png")));
        

        vBoxContentScroll.setPrefHeight(2000);
        vBoxContentScroll.setPadding(new Insets(10));
        scrollPaneContent.autosize();

        //AJUSTAR A TAMAÑO NECESARIO
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

    public void goBack() throws IOException{
        App.setRoot("startMenu");
        App.scene.getStylesheets().clear();
        App.scene.getStylesheets().add(App.class.getResource("styleMenuStart.css").toExternalForm());
    }
}
