package co.edu.uniquindio.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VentanaEmbargadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnDesembargar;

    @FXML
    private Button btnRecargar;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TableView<?> tablaCotizantes;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colIdentificacion;

    @FXML
    private TableColumn<?, ?> colEdad;

    @FXML
    private TableColumn<?, ?> colEmbargado;

    @FXML
    private TableColumn<?, ?> colTelefono;

    @FXML
    void btnDesembargarEvent(ActionEvent event) {

    }

    @FXML
    void btnEditarEvent(ActionEvent event) {

    }

    @FXML
    void buscarEvent(ActionEvent event) {

    }

    @FXML
    void recargarEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
