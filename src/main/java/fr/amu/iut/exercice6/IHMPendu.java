package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class IHMPendu extends Application {
    private Pane pane;
    private HBox hbox;
    private BorderPane borderPane;
    private Button button;
    private TextField textField;
    private Label label;
    private Scene scene;
    private int vie=7;
    private char lettre_selec;
    private boolean lettre_selec_bool=false;
    private Label label_vie;
    private String motChoisi;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Dico d1=new Dico();
        this.borderPane = new BorderPane();
        this.textField = new TextField();
        this.label = new Label(motChoisi);
        this.label_vie = new Label("Nombre de vie : 7");
        borderPane.setBottom(textField);
        borderPane.setCenter(label);
        borderPane.setTop(label_vie);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(0), Insets.EMPTY)));
        String motJeu=d1.getMot();
        ArrayList<Character> listeLettreMot= new ArrayList<>();
        listeLettreMot=initialise_liste_mot(listeLettreMot,motJeu);
        ArrayList<Character> listeLettreEssaye= new ArrayList<>();
        RecupEssaiJoueur();
        if(lettre_selec_bool){
            Essai_Joueur_analyse(listeLettreEssaye,listeLettreMot,lettre_selec);
        }
        RecupEssaiJoueur();

        // A completer
        this.scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public ArrayList<Character> initialise_liste_mot(ArrayList<Character> listeLettreMot, String motJeu) {
        for(int i=0;i<motJeu.length();i++) {
            listeLettreMot.add(motJeu.charAt(i));
        }
        return listeLettreMot;
    };

    public ArrayList<Character> initialiste_liste_essai(ArrayList<Character> listeLettreEssaye,char tentative){
        for(int j=0;j<listeLettreEssaye.size();j++) {
            if( Objects.equals(listeLettreEssaye.get(j), tentative)) {
                listeLettreEssaye.remove(j);
            }
            listeLettreEssaye.add(tentative);

        }
        return listeLettreEssaye;
    }

    public void RecupEssaiJoueur(){
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case ENTER:
                    if(textField.getText().length()>1){
                        System.out.println("Trop long mettez juste une lettre");
                    }
                    else{
                        lettre_selec = textField.getText().charAt(0);
                        lettre_selec_bool=true;
                    }
            }
        });
    }

    public void initialise_mot_choisi(String motChoisi){
        String nouveau_string = "";
        for(int i=0;i<motChoisi.length();i++) {
            nouveau_string=nouveau_string.concat("#");
        }
    }

    public void affiche_mot_choisi(String motChoisi,char c){
        motChoisi.replace('#',c);
    }

    public void Essai_Joueur_analyse(ArrayList<Character> listeLettreEssaye,ArrayList<Character> listeLettreMot,char lettre_selec){
        for(int i=0;i<listeLettreEssaye.size();i++) {
            if(Objects.equals(listeLettreEssaye.get(i), lettre_selec)) {
                break;
            }
            else{
                listeLettreEssaye.add(lettre_selec);
                vie=vie-1;
                this.label_vie.setText("Nombre e vie : "+vie);
                for(int j=0;j<listeLettreMot.size();j++) {
                    if(Objects.equals(listeLettreMot.get(j), lettre_selec)) {

                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
