package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private Label label;//=new Label(toString(couleur)+"choisi "+ toString(nbfois) + " fois.")
    private Pane panneau;
    private HBox bas;
    private BorderPane root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new BorderPane();
        this.panneau=new Pane();
        this.label=new Label();
        this.label.setText("Rouge");
        panneau.setStyle("-fx-background-color: red;");
        this.bleu=new Button("Bleu");
        this.rouge=new Button("Rouge");
        this.vert=new Button("Vert");
        this.bas=new HBox(vert,rouge,bleu);

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, eventRouge -> ButonClickRed(eventRouge));
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBleu -> ButonClickBlue(eventBleu));
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, eventVert -> ButonClickGreen(eventVert));
        bas.setAlignment(Pos.CENTER);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);
        Scene scene1 = new Scene(root, 400, 200);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void ButonClickRed(Event event){
        System.out.println("ButonClick");
            String couleur="Rouge";
            nbRouge+=1;
            label.setText(couleur+" choisi "+nbRouge+" fois.");
            panneau.setStyle("-fx-background-color: red;");
    }

    private void ButonClickBlue(Event event){
        String couleur="Bleu";
        nbBleu+=1;
        label.setText(couleur+" choisi "+nbBleu+" fois.");
        panneau.setStyle("-fx-background-color: blue;");
    }

    private void ButonClickGreen(Event event){
        String couleur="Vert";
        nbVert+=1;
        label.setText(couleur+" choisi "+nbVert+" fois.");
        panneau.setStyle("-fx-background-color: green;");
    }
}

