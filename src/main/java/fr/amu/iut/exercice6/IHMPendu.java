package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    private GridPane gridPaneBouton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.gridPane = new GridPane();
        this.borderPane = new BorderPane();
        this.textField = new TextField();
        this.label = new Label(motChoisi);
        this.label_vie = new Label("Nombre de vie : 7");
        this.gridPaneBouton=new GridPane();
        Dico d1=new Dico();
        String motJeu=d1.getMot();
        ArrayList<Character> listeLettreMot= new ArrayList<>();
        listeLettreMot=initialise_liste_mot(listeLettreMot,motJeu);
        ArrayList<Character> listeLettreEssaye= new ArrayList<>();
        ArrayList<Character> listeLettreEssayeBonneLettre= new ArrayList<>();
        String nouveauMot=initialise_mot_choisi(motJeu);
        this.label_image=new Label();
        this.label=new Label(nouveauMot);
        gridPaneBouton.setAlignment(Pos.CENTER);
        gridPane.addRow(0,label_vie);
        gridPane.addRow(1,label_image);
        gridPane.setAlignment(Pos.CENTER);
        borderPane.setBottom(gridPaneBouton);
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
        Button a=new Button("a");
        Button b=new Button("b");
        Button c=new Button("c");
        Button d=new Button("d");
        Button e=new Button("e");
        Button f=new Button("f");
        Button g=new Button("g");
        Button h=new Button("h");
        Button i=new Button("i");
        Button j=new Button("j");
        Button k=new Button("k");
        Button l=new Button("l");
        Button m=new Button("m");
        Button n=new Button("n");
        Button o=new Button("o");
        Button p=new Button("p");
        Button q=new Button("q");
        Button r=new Button("r");
        Button s=new Button("s");
        Button t=new Button("t");
        Button u=new Button("u");
        Button v=new Button("v");
        Button w=new Button("w");
        Button x=new Button("x");
        Button y=new Button("y");
        Button z=new Button("z");
        gridPaneBouton.addRow(0,a,b,c,d,e,f,g);
        gridPaneBouton.addRow(1,h,i,j,k,l,m,n,o,p,q,r);
        gridPaneBouton.addRow(2,s,t,u,v,w,x,y,z);
        a.addEventHandler(MouseEvent.MOUSE_CLICKED, eventA -> Event1(eventA,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, eventB -> Event1(eventB,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, eventC -> Event1(eventC,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        d.addEventHandler(MouseEvent.MOUSE_CLICKED, eventD -> Event1(eventD,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        e.addEventHandler(MouseEvent.MOUSE_CLICKED, eventE -> Event1(eventE,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        f.addEventHandler(MouseEvent.MOUSE_CLICKED, eventF -> Event1(eventF,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        g.addEventHandler(MouseEvent.MOUSE_CLICKED, eventG -> Event1(eventG,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        h.addEventHandler(MouseEvent.MOUSE_CLICKED, eventH -> Event1(eventH,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        i.addEventHandler(MouseEvent.MOUSE_CLICKED, eventI -> Event1(eventI,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        j.addEventHandler(MouseEvent.MOUSE_CLICKED, eventJ -> Event1(eventJ,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        k.addEventHandler(MouseEvent.MOUSE_CLICKED, eventK -> Event1(eventK,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, eventL -> Event1(eventL,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        m.addEventHandler(MouseEvent.MOUSE_CLICKED, eventM -> Event1(eventM,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        n.addEventHandler(MouseEvent.MOUSE_CLICKED, eventN -> Event1(eventN,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        o.addEventHandler(MouseEvent.MOUSE_CLICKED, eventO -> Event1(eventO,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        p.addEventHandler(MouseEvent.MOUSE_CLICKED, eventP -> Event1(eventP,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        q.addEventHandler(MouseEvent.MOUSE_CLICKED, eventQ -> Event1(eventQ,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        r.addEventHandler(MouseEvent.MOUSE_CLICKED, eventR -> Event1(eventR,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        s.addEventHandler(MouseEvent.MOUSE_CLICKED, eventS -> Event1(eventS,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        t.addEventHandler(MouseEvent.MOUSE_CLICKED, eventT -> Event1(eventT,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        u.addEventHandler(MouseEvent.MOUSE_CLICKED, eventU -> Event1(eventU,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        v.addEventHandler(MouseEvent.MOUSE_CLICKED, eventV -> Event1(eventV,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        w.addEventHandler(MouseEvent.MOUSE_CLICKED, eventW -> Event1(eventW,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        x.addEventHandler(MouseEvent.MOUSE_CLICKED, eventX -> Event1(eventX,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        y.addEventHandler(MouseEvent.MOUSE_CLICKED, eventY -> Event1(eventY,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        z.addEventHandler(MouseEvent.MOUSE_CLICKED, eventZ -> Event1(eventZ,finalListeLettreMot,listeLettreEssayeBonneLettre,listeLettreEssaye));
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();

    }

    public void Event1(Event event,ArrayList<Character> finalListeLettreMot,ArrayList<Character> listeLettreEssayeBonneLettre,ArrayList<Character> listeLettreEssaye){
        Button source = (Button) event.getSource();
        String s=source.getText();
        System.out.println(s);
        if(vie==0){
            label.setText("Perdu... Dommage !");
        }
        if(listeLettreEssayeBonneLettre.size()==finalListeLettreMot.size()){
            label.setText("Bravo tu as gagné !!");
        }
        if(textField.getText().length()>1){
            System.out.println("Trop long mettez juste une lettre");
        }
        else{
            if(vie==0){
                label.setText("Tu as perdu.. Dommage !");
            }
            if(listeLettreEssayeBonneLettre.size()==finalListeLettreMot.size()){
                label.setText("Tu a gagné bravo ! Il te restait ce nombre de vie :"+vie);
            }
            char a=s.charAt(0);
            lettre_selec = a;
            initialiste_liste_essai(listeLettreEssaye, lettre_selec);
            System.out.println(listeLettreEssaye);
            System.out.println(listeLettreEssayeBonneLettre);
            System.out.println(finalListeLettreMot);
            Essai_Joueur_analyse(listeLettreEssayeBonneLettre, finalListeLettreMot, lettre_selec);
            affichage_changement(finalListeLettreMot, listeLettreEssayeBonneLettre);
        }
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
