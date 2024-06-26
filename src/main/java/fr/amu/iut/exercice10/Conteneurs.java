package fr.amu.iut.exercice10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class Conteneurs extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("exercice10/ConteneursView.fxml"));
            stage.setTitle("Fenetre Logiciel");

            Scene scene1 = new Scene(root, 1200, 800);
            stage.setScene(scene1);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}