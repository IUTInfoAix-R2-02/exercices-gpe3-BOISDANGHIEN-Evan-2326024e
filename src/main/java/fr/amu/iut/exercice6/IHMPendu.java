package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private GridPane gridPane;
    private Label label_image;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.gridPane = new GridPane();
        this.borderPane = new BorderPane();
        this.textField = new TextField();
        this.label = new Label(motChoisi);
        this.label_vie = new Label("Nombre de vie : 7");
        Dico d1=new Dico();
        String motJeu=d1.getMot();
        ArrayList<Character> listeLettreMot= new ArrayList<>();
        listeLettreMot=initialise_liste_mot(listeLettreMot,motJeu);
        ArrayList<Character> listeLettreEssaye= new ArrayList<>();
        ArrayList<Character> listeLettreEssayeBonneLettre= new ArrayList<>();
        String nouveauMot=initialise_mot_choisi(motJeu);
        this.label_image=new Label();
        this.label=new Label(nouveauMot);
        gridPane.addRow(0,label_vie);
        gridPane.addRow(1,label_image);
        gridPane.setAlignment(Pos.CENTER);
        borderPane.setBottom(textField);
        borderPane.setCenter(label);
        borderPane.setTop(gridPane);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(0), Insets.EMPTY)));
        this.scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        ArrayList<Character> finalListeLettreMot = listeLettreMot;
        if(vie==7){
            ImageView vie=new ImageView("exercice6/pendu7.png");
            label_image.setGraphic(vie);
        }
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case ENTER:
                    if(vie==0){
                        label.setText("Perdu... Dommage !");
                        break;
                    }
                    if(listeLettreEssayeBonneLettre.size()==finalListeLettreMot.size()){
                        label.setText("Bravo tu as gagné !!");
                        break;
                    }
                    if(textField.getText().length()>1){
                        System.out.println("Trop long mettez juste une lettre");
                        break;
                    }
                    else{
                        if(vie==0){
                            label.setText("Tu as perdu.. Dommage !");
                        }
                        if(listeLettreEssayeBonneLettre.size()==finalListeLettreMot.size()){
                            label.setText("Tu a gagné bravo ! Il te restait ce nombre de vie :"+vie);
                        }
                        lettre_selec = textField.getText().charAt(0);
                        initialiste_liste_essai(listeLettreEssaye, lettre_selec);
                        System.out.println(listeLettreEssaye);
                        System.out.println(listeLettreEssayeBonneLettre);
                        System.out.println(finalListeLettreMot);
                        Essai_Joueur_analyse(listeLettreEssayeBonneLettre, finalListeLettreMot, lettre_selec);
                        affichage_changement(finalListeLettreMot, listeLettreEssayeBonneLettre);
                        break;
                    }
            }
        });
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

    public void initialiste_liste_essai(ArrayList<Character> listeLettreEssaye, char tentative){
        for(int j=0;j<listeLettreEssaye.size();j++) {
            if( Objects.equals(listeLettreEssaye.get(j), tentative)) {
                listeLettreEssaye.remove(j);
            }
        }
        listeLettreEssaye.add(tentative);
    }

    public void Essai_Joueur_analyse(ArrayList<Character> listeLettreEssayeBonneLettre,ArrayList<Character> listeLettreMot,char lettre_selec){
        boolean b1=false;
        for (Character character : listeLettreMot) {
            if (Objects.equals(character, lettre_selec)) {
                listeLettreEssayeBonneLettre.add(lettre_selec);
                b1 = true;
            }
        }
        if(!b1){
            vie=vie-1;
        }
        if(vie==6){
            ImageView vie=new ImageView("exercice6/pendu6.png");
            label_image.setGraphic(vie);
        }
        if(vie==5){
            ImageView vie=new ImageView("exercice6/pendu5.png");
            label_image.setGraphic(vie);
        }
        if(vie==4){
            ImageView vie=new ImageView("exercice6/pendu4.png");
            label_image.setGraphic(vie);
        }
        if(vie==3){
            ImageView vie=new ImageView("exercice6/pendu3.png");
            label_image.setGraphic(vie);
        }
        if(vie==2){
            ImageView vie=new ImageView("exercice6/pendu2.png");
            label_image.setGraphic(vie);
        }
        if(vie==1){
            ImageView vie=new ImageView("exercice6/pendu1.png");
            label_image.setGraphic(vie);
        }
        if(vie==0){
            ImageView vie=new ImageView("exercice6/pendu0.png");
            label_image.setGraphic(vie);
        }
        if(listeLettreEssayeBonneLettre.size()==finalListeLettreMot.size()){
            ImageView vie=new ImageView("exercice6/penduWin.png");
            label_image.setGraphic(vie);
        }

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

    public String initialise_mot_choisi(String motChoisi){
        String nouveau_string = "";
        for(int i=0;i<motChoisi.length();i++) {
            nouveau_string=nouveau_string.concat("#");
        }
        return nouveau_string;
    }

    public void affiche_mot_choisi(String motChoisi,char c){
        motChoisi.replace('#',c);
    }


    public void affichage_changement(ArrayList<Character> listeLettreMot,ArrayList<Character> listeLettreEssayeBonneLettre){
        boolean test;
        String s="";
        for (Character value : listeLettreMot) {
            test = false;
            for (Character character : listeLettreEssayeBonneLettre) {
                if (Objects.equals(value, character) && !test) {
                    s = s + value;
                    test = true;
                }
            }
            if (!test) {
                s = s + "#";
            }
        }
        label.setText(s);
        label_vie.setText("Nombre de vie :"+vie);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
