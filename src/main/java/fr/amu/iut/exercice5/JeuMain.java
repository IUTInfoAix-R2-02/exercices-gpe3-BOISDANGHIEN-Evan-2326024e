package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    List<Obstacle> listeObstacles = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        Obstacle obstacle = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        obstacle2.setX(100);
        obstacle2.setY(200);
        obstacle2.setWidth(100);
        obstacle2.setHeight(70);
        obstacle.setX(300);
        obstacle.setY(300);
        obstacle.setWidth(50);
        obstacle.setHeight(50);

        listeObstacles.add(obstacle);
        listeObstacles.add(obstacle2);
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacle);
        jeu.getChildren().add(obstacle2);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double ancienXJ1=j1.getLayoutX();
            double ancienYJ1=j1.getLayoutY();
            double ancienXJ2=j2.getLayoutX();
            double ancienYJ2=j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;

                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;

                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;

                case Q:
                    j2.deplacerAGauche();
                    break;

            }
            if (j1.estEnCollision(j2)){
                Platform.exit();
            }
            for(int k=0;k<listeObstacles.size();k++){
                if(j1.EstEnCollisionMur(listeObstacles.get(k))) {
                    System.out.println("Erreur");
                    j1.setLayoutX(ancienXJ1);
                    j1.setLayoutY(ancienYJ1);
                }
                if(j2.EstEnCollisionMur(listeObstacles.get(k))) {
                    System.out.println("Erreur");
                    j2.setLayoutX(ancienXJ2);
                    j2.setLayoutY(ancienYJ2);
                }
            }
        });
    }


}
