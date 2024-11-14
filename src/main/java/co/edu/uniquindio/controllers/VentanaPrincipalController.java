package co.edu.uniquindio.controllers;

import java.io.IOException;
import java.net.URL;
import co.edu.uniquindio.app.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VentanaPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane principalPane;

    @FXML
    private VBox btnCotizantes;

    @FXML
    private VBox btnEmbargados;

    @FXML
    private VBox btnAgregados;

    @FXML
    private BorderPane centerPane;

    @FXML
    private Button btnAyuda;

    @FXML
    void irAgregadosEvent(MouseEvent event) {
        cambiarVentana("VentanaAgregados");
        principalPane.setRight(null);
        centerPane.setBottom(null);
    }

    @FXML
    void irAyudaEvent(ActionEvent event) {
    }

    @FXML
    void irCotizantesEvent(MouseEvent event) {
        cambiarVentana("VentanaCotizantes");
        principalPane.setRight(null);
        centerPane.setBottom(null);

    }

    @FXML
    void irEmbargadosEvent(MouseEvent event) {
        cambiarVentana("VentanaEmbargados");
        principalPane.setRight(null);
        centerPane.setBottom(null);

    }

    @FXML
    void initialize() {

    }

    public void cambiarVentana(String fxmlname) {
        try {
            Node nodo = App.loadFXML(fxmlname);
            setCenter(nodo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cambiarRight(String fxmlname) {
        try {
            Node nodo = App.loadFXML(fxmlname);
            setRight(nodo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cambiarDown(String fxmlname) {
        try {
            Node nodo = App.loadFXML(fxmlname);
            setDown(nodo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCenter(Node node) {
        centerPane.setCenter(node);
    }

    public void setRight(Node node) {
        principalPane.setRight(node);
    }

    public void setDown(Node node) {
        centerPane.setBottom(node);
    }
}

