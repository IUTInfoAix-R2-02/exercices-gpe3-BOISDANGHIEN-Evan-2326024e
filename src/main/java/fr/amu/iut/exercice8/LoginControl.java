package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    TextField txt=new TextField();

    @FXML
    TextField pwd=new TextField();

    @FXML
    Button ok=new Button("ok");

    @FXML
    Button cancel=new Button("cancel");
    @FXML
    private void okClicked() {
        System.out.println(txt.getText());
        System.out.println(pwd.getText());
    }

    @FXML
    private void cancelClicked() {
        txt.clear();
        pwd.clear();
    }
}