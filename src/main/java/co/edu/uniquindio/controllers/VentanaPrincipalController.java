package co.edu.uniquindio.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;

public class VentanaPrincipalController {
    private boolean bloqueando = false;

    @FXML
    private VBox sidebar;
    @FXML
    private ImageView iconoView;
    @FXML
    private Button botonBloqueo;
    private Timeline expandir;
    private Timeline contraer;

    public void start(Stage stage) {
        try {
            URL fxmlLocation = getClass().getResource("/fxmls/PantallaPrincipal.fxml");
            if (fxmlLocation == null) {
                throw new IOException("FXML file not found.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            loader.setController(this);
            Parent root = loader.load();

            URL iconLocation = getClass().getResource("/co/edu/uniquindio/resources/images/icon.png");
            if (iconLocation == null) {
                throw new IOException("Icon image not found.");
            }

            Image icon = new Image(iconLocation.toString());
            stage.getIcons().add(icon);

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/resources/styles/estilos.css").toExternalForm());
            stage.setTitle("UI!");
            stage.setScene(scene);
            stage.show();

            initialize();
        } catch (IOException e) {
            System.err.println("Failed to load FXML file or icon image.");
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        expandir = new Timeline(
                new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 200))
        );

        contraer = new Timeline(
                new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 0))
        );

        sidebar.getStyleClass().add("sidebar");
        botonBloqueo.getStyleClass().add("button-icon");

        sidebar.setOnMouseEntered(event -> expandir.play());
        sidebar.setOnMouseExited(event -> contraer.play());
    }

    @FXML
    void bloquearAnima(ActionEvent event) {
        bloqueando = !bloqueando;
        if (bloqueando) {
            expandir.stop();
            contraer.stop();
            sidebar.setOnMouseEntered(null);
            sidebar.setOnMouseExited(null);
        } else {
            sidebar.setOnMouseEntered(e -> expandir.play());
            sidebar.setOnMouseExited(e -> contraer.play());
        }
    }
}