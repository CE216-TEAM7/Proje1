package com.example.ce216proje1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GUI implements Initializable {
    @FXML
    public ChoiceBox<String> myChoiceBox;

    public String[]language={"Turkish","English","French","Italian","Swedish","German","Modern Greek"};

    public static void displayManual() {

    }

    public static void displaySearchResults() {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(language);
    }
}
