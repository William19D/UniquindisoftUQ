package co.edu.uniquindio.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox btnClientes;

    @FXML
    private VBox btnDevoluciones;

    @FXML
    private VBox btnInventario;

    @FXML
    private VBox btnReparaciones;

    @FXML
    private VBox btnVender;

    @FXML
    private BorderPane centerPane;

    @FXML
    private BorderPane principalPane;

    @FXML
    void initialize() {
        assert btnClientes != null : "fx:id=\"btnClientes\" was not injected: check your FXML file 'menu.fxml'.";
        assert btnDevoluciones != null : "fx:id=\"btnDevoluciones\" was not injected: check your FXML file 'menu.fxml'.";
        assert btnInventario != null : "fx:id=\"btnInventario\" was not injected: check your FXML file 'menu.fxml'.";
        assert btnReparaciones != null : "fx:id=\"btnReparaciones\" was not injected: check your FXML file 'menu.fxml'.";
        assert btnVender != null : "fx:id=\"btnVender\" was not injected: check your FXML file 'menu.fxml'.";
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'menu.fxml'.";
        assert principalPane != null : "fx:id=\"principalPane\" was not injected: check your FXML file 'menu.fxml'.";

    }

}
