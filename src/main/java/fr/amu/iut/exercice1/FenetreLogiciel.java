package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fenetre Logiciel");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        VBox V1=new VBox();
        Label l1=new Label("Name :");
        Label l2=new Label("Email :");
        Label l3=new Label("Password :");
        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();
        Button b1 = new Button("Submit");
        Button b2 = new Button("Cancel");
        grid.addRow(0,l1,t1);
        grid.addRow(1,l2,t2);
        grid.addRow(2,l3,t3);
        grid.addRow(4,b1,b2);
        GridPane grid2 = new GridPane();
        Menu menu1 = new Menu("File");
        MenuItem menuItem1 = new MenuItem("New");
        MenuItem menuItem2 = new MenuItem("Open");
        MenuItem menuItem3 = new MenuItem("Save");
        MenuItem menuItem4 = new MenuItem("Close");
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        menu1.getItems().add(menuItem4);
        MenuBar menuBar = new MenuBar();
        Menu menu2 = new Menu("Edit");
        MenuItem menuItem12 = new MenuItem("Cut");
        MenuItem menuItem23= new MenuItem("Copy");
        MenuItem menuItem34 = new MenuItem("Paste");
        menu2.getItems().add(menuItem12);
        menu2.getItems().add(menuItem23);
        menu2.getItems().add(menuItem34);
        Menu menu3 = new Menu("Help");
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        grid2.addRow(0,menuBar);
        Label L4=new Label("Ceci est un label de bas de page");
        L4.setAlignment(Pos.CENTER);
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        Label l5=new Label("Boutons : ");
        Button b3 = new Button("Bouton 1");
        Button b4 = new Button("Bouton 2");
        Button b5 = new Button("Bouton 3");
        grid3.addRow(0,l5);
        grid3.addRow(1,b3);
        grid3.addRow(2,b4);
        grid3.addRow(3,b5);
        GridPane grid4 = new GridPane();
        grid4.addRow(0,L4);
        grid4.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid3.setHgap(10);
        grid3.setVgap(10);
        Separator separatorHor = new Separator(Orientation.HORIZONTAL);
        Separator separatorVer = new Separator(Orientation.VERTICAL);
        Separator separatorHor2 = new Separator(Orientation.HORIZONTAL);
        Separator separatorVer2 = new Separator(Orientation.VERTICAL);
        HBox H1=new HBox(grid3,separatorVer);
        VBox H2=new VBox(grid2,separatorHor2);
        VBox H3=new VBox(separatorHor,grid4);
        BorderPane border1=new BorderPane();
        border1.setTop(menuBar);
        border1.setLeft(H1);
        border1.setCenter(grid);
        border1.setBottom(H3);
        Scene scene1 = new Scene(border1, 1200, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}

