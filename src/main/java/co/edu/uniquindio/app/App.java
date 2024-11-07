package co.edu.uniquindio.app;

import co.edu.uniquindio.controllers.PantallaCargaController;
import javafx.stage.Stage;

import javafx.application.Application;

public class App extends Application{

    public void start(Stage stage) {
        PantallaCargaController pantallaCarga = new PantallaCargaController();
        pantallaCarga.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


