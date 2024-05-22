package fr.amu.iut.exercice9;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        CustomButton customButton = new CustomButton();
        root.setCenter(customButton);
        Scene scene = new Scene(root, 400, 400);

        Duration duration = Duration.millis(1500);
        TranslateTransition transition1 = new TranslateTransition(duration, customButton);
        transition1.setByX(150);
        transition1.setByY(-150);
        //transition1.setAutoReverse(true);
        //transition1.setCycleCount(2);
        TranslateTransition transition2 = new TranslateTransition(duration, customButton);
        transition2.setByX(-300);
        transition2.setByY(0);
        TranslateTransition transition3 = new TranslateTransition(duration, customButton);
        transition3.setByX(0);
        transition3.setByY(300);
        TranslateTransition transition4 = new TranslateTransition(duration, customButton);
        transition4.setByX(300);
        transition4.setByY(0);
        TranslateTransition transition5 = new TranslateTransition(duration, customButton);
        transition5.setByX(0);
        transition5.setByY(-300);
        TranslateTransition transition6 = new TranslateTransition(duration, customButton);
        transition6.setByX(-150);
        transition6.setByY(150);


        SequentialTransition st = new SequentialTransition(transition1, transition2, transition3, transition4, transition5);
        SequentialTransition st2 = new SequentialTransition(transition3, transition2, transition5, transition4,transition6);
        SequentialTransition st3 = new SequentialTransition(st,st2);

        customButton.setOnMousePressed(mouseEvent -> st3.play());

        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}