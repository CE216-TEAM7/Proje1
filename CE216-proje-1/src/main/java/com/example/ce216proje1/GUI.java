package com.example.ce216proje1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GUI implements Initializable {
    @FXML
    public ChoiceBox<String> myChoiceBox;
    @FXML
    public Label myLabel;
    @FXML
    public Button myButton;

    public String[]language={"Turkish","English","French","Italian","Swedish","German","Modern Greek"};
    public String mainLanguage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(language);
    }
    public String getLanguage()
    {
        mainLanguage = myChoiceBox.getValue();
        this.mainLanguage = mainLanguage;
        return mainLanguage;
    }

    public static void displayManual() {

    }

    public void displaySearchResults(ActionEvent event) {
        myLabel.setText(getLanguage());

    }

    public static void displayAddWordForm() {

    }

    public static void displayEditWordForm() {

    }

    public static void displayDeleteWordConfirmation() {

    }

    public static void displaySynonyms() {

    }

    public static void createGUI() {

    }


}
