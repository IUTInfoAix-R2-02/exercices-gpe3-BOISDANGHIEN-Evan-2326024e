package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        Slider slider = new Slider();
        Slider slider1 = new Slider();
        slider.setShowTickLabels(true);
        slider1.setShowTickLabels(true);
        slider1.setMax(212);

        slider1.valueProperty().bindBidirectional(slider.valueProperty());



        VBox panneauCelsius = new VBox(30,slider);
        VBox panneauFahrenheit = new VBox(30,slider1);

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}