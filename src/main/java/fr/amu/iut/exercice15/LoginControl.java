package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginControl extends GridPane implements Initializable {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
        createBindings();
    }

    private void createBindings() {
        System.out.println("Creating Bindings...");
        pwd.editableProperty().bind(userId.lengthProperty().greaterThanOrEqualTo(6));


        // Binding pour le bouton cancel cliquable ou non
        cancelBtn.disableProperty().bind(
                Bindings.createBooleanBinding(() -> userId.getText().isEmpty() && pwd.getText().isEmpty(), userId.textProperty(), pwd.textProperty())
                );


        // Binding pour le bouton ok cliquable ou non
        BooleanBinding motDePasseValide = Bindings.createBooleanBinding(() ->
                pwd.getText().length() >= 8 && pwd.getText().matches(".*[A-Z].*") && pwd.getText().matches(".*\\d.*"),pwd.textProperty()
        );
        okBtn.disableProperty().bind(motDePasseValide.not());
    }


    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
        System.out.println("lol");
    }
}