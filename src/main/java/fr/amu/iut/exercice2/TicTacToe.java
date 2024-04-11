package fr.amu.iut.exercice2;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.util.Random;

public class TicTacToe extends Application {

    public Node tirage(){
        Random random = new Random();
        int nb=random.nextInt(3);
        ImageView croix=new ImageView("exercice2/Croix.png");
        ImageView vide=new ImageView("exercice2/Vide.png");
        ImageView rond=new ImageView("exercice2/Rond.png");
        if(nb==0){
            return croix;
        }
        if(nb==1){
            return rond;
        }
        else if(nb==2){
            return vide;
        }
        return null;
    }

    @Override
    public void start(Stage primaryStage) {

        // LIGNE DU HAUT
        primaryStage.setTitle("TicTacToe");

        Label l_hg= new Label();
        Label l_hm= new Label();
        Label l_hd= new Label();
        Label l_mg= new Label();
        Label l_mm= new Label();
        Label l_md= new Label();
        Label l_bg= new Label();
        Label l_bm= new Label();
        Label l_bd= new Label();

        GridPane grid = new GridPane();

        l_hg.setGraphic(this.tirage());
        l_hm.setGraphic(this.tirage());
        l_hd.setGraphic(this.tirage());
        l_mg.setGraphic(this.tirage());
        l_mm.setGraphic(this.tirage());
        l_md.setGraphic(this.tirage());
        l_bg.setGraphic(this.tirage());
        l_bm.setGraphic(this.tirage());
        l_bd.setGraphic(this.tirage());

        grid.add(l_hg, 0, 0);
        grid.add(l_hm, 1, 0);
        grid.add(l_hd, 2, 0);
        grid.add(l_mg, 0, 1);
        grid.add(l_mm, 1, 1);
        grid.add(l_md, 2, 1);
        grid.add(l_bg, 0, 2);
        grid.add(l_bm, 1, 2);
        grid.add(l_bd, 2, 2);



        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

