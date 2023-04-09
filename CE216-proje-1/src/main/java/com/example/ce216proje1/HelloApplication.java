package com.example.ce216proje1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        Graph graph = new Graph();
        //ENG-TR
        try {
            File file = new File("CE216-proje-1/src/Dictionary/eng-tur.dict");
            Scanner scanner = new Scanner(file);
            String word = null;
            while (scanner.hasNextLine()) {
                ArrayList<String> translation=new ArrayList<>();
                String meaning;
                String line = scanner.nextLine();
                if (!Character.isDigit(line.charAt(0)))
                {
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                }
                else if (Character.isDigit(line.charAt(0)))
                {
                    String[] parts = line.split("/");
                    meaning = parts[0].replaceAll("\\d+\\.", "").trim();
                    String[] meanings = meaning.split(",");
                    for (String m : meanings) {
                        translation.add(m.trim());
                    }
                }
                graph.addWord(word,"English","Turkish",translation);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //ENG-TR VOCABULARY TEST
        System.out.println(graph.getTranslations("death","English","Turkish"));
        System.out.println(graph.getTranslations("öIüm","Turkish","English"));

        //ENG-FRA
        try {
            Scanner scanner = new Scanner(new File("CE216-proje-1/src/Dictionary/eng-fra.dict")); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith("/")) { //Italian word
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph

                        graph.addWord(word, "English", "French", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                } else {
                    String[] parts = line.split("\s");
                    StringBuilder frenchWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {

                        frenchWord.insert(0, parts[i] + " ");
                    }
                    translation.add(frenchWord.toString().trim());
                }


            }
            if (!word.isEmpty()) {
                // Add the last word and translation to the graph after reading the file
                graph.addWord(word, "English", "French", translation);
            }

            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // NUMBER PROBLEM
        //ENG-FRA VOCABULARY TEST
        System.out.println(graph.getTranslations("drug", "English", "French"));
        System.out.println(graph.getTranslations("1. remède","French","English"));

        //ELL-ITA
        try {
            File file = new File("CE216-proje-1/src/Dictionary/ell-ita.dict");
            Scanner scanner = new Scanner(file);
            String word = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith(">")) {
                    if (!word.isEmpty()) {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                        String[] italianWords = parts[1].split(",");
                        ArrayList<String> translation = new ArrayList<>();
                        for (String italianWord : italianWords) {
                            translation.add(italianWord.trim());
                        }
                        graph.addWord(word, "Modern Greek", "Italian", translation);
                    } else {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    }
                } else {
                    String[] parts = line.split("\\s+");
                    StringBuilder italianWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {
                        italianWord.insert(0, parts[i] + " ");
                    }
                    ArrayList<String> translation = new ArrayList<>();
                    translation.add(italianWord.toString().trim()); // Add the Italian translation to the ArrayList
                    graph.addWord(word, "Modern Greek", "Italian", translation); // Add the Italian translation to the existing word in the graph
                    word = "";
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //ELL-ITA VOCABULARY TEST
        System.out.println(graph.getTranslations("Αράλη", "Modern Greek", "Italian"));
        System.out.println(graph.getTranslations("Aral","Italian","Modern Greek"));

        //ELL-SWE
        try {
            File file = new File("CE216-proje-1/src/Dictionary/ell-swe.dict");
            Scanner scanner = new Scanner(file);
            String word = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith(">")) {
                    if (!word.isEmpty()) {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                        String[] swedWords = parts[1].split(",");
                        ArrayList<String> translation = new ArrayList<>();
                        for (String swedWord : swedWords) {
                            translation.add(swedWord.trim());
                        }
                        graph.addWord(word, "Modern Greek", "Swedish", translation);
                    } else {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    }
                } else {
                    String[] parts = line.split("\\s+");
                    StringBuilder swedWords = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {
                        swedWords.insert(0, parts[i] + " ");
                    }
                    ArrayList<String> translation = new ArrayList<>();
                    translation.add(swedWords.toString().trim());
                    graph.addWord(word, "Modern Greek", "Swedish", translation);
                    word = "";
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(graph.getTranslations("Όφις", "Modern Greek", "Swedish"));

        //FRA-TUR
        try {
            Scanner scanner = new Scanner(new File("CE216-proje-1/src/Dictionary/fra-tur.dict")); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith(">")) { //french word
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph
                        graph.addWord(word, "French", "Turkish", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                } else {
                    String[] parts = line.split("\\s");
                    StringBuilder turkishWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {
                        if (parts[i].startsWith("]") || parts[i].startsWith("[")) {
                            break;
                        }
                        turkishWord.insert(0, parts[i] + " ");
                    }
                    translation.add(turkishWord.toString().trim());
                }


            }


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //FRA-ENG
        try {
            Scanner scanner = new Scanner(new File("CE216-proje-1/src/Dictionary/fra-eng.dict")); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith("/")) { //German word
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph

                        graph.addWord(word, "English", "French", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                } else {
                    String[] parts = line.split("\s");
                    StringBuilder frenchWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {

                        frenchWord.insert(0, parts[i] + " ");
                    }
                    translation.add(frenchWord.toString().trim());
                }


            }
            if (!word.isEmpty()) {
                // Add the last word and translation to the graph after reading the file
                graph.addWord(word, "English", "French", translation);
            }

            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(graph.getTranslations("vert", "French", "English"));

        //ITA-ENG
        try {
            Scanner scanner = new Scanner(new File("CE216-proje-1/src/Dictionary/ita-eng.dict")); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith("/")){ //italian word
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph

                        graph.addWord(word, "Italian", "English", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                }
                else {
                    String[] parts = line.split("\s");
                    StringBuilder englishWorld = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {

                        englishWorld.insert(0, parts[i] + " ");
                    }
                    translation.add(englishWorld.toString().trim());
                }


            }
            if (!word.isEmpty()) {
                // Add the last word and translation to the graph after reading the file
                graph.addWord(word, "Italian", "English", translation);
            }

            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //ITA-DEU
        try {
            File file = new File("CE216-proje-1/src/Dictionary/ita-deu.dict");
            Scanner scanner = new Scanner(file);
            String word = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith("/")) {
                    if (!word.isEmpty()) {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                        String[] italianWords = parts[1].split(",");
                        ArrayList<String> translation = new ArrayList<>();
                        for (String italianWord : italianWords) {
                            translation.add(italianWord.trim());
                        }
                        graph.addWord(word, "Italian", "German", translation);
                    } else {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    }
                } else {
                    String[] parts = line.split("\\s+");
                    StringBuilder germanWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {
                        germanWord.insert(0, parts[i] + " ");
                    }
                    ArrayList<String> translation = new ArrayList<>();
                    translation.add(germanWord.toString().trim());
                    graph.addWord(word, "Italian", "German", translation);
                    word = "";
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(graph.getTranslations("Amburgo", "Italian", "German"));

        //GER-ITA
        try {
            Scanner scanner = new Scanner(new File("CE216-proje-1/src/Dictionary/deu-ita.dict")); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith("/")) { //German word
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph

                        graph.addWord(word, "German", "Italian", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                } else {
                    String[] parts = line.split("\s");
                    StringBuilder italianWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {

                        italianWord.insert(0, parts[i] + " ");
                    }
                    translation.add(italianWord.toString().trim());
                }


            }
            if (!word.isEmpty()) {
                // Add the last word and translation to the graph after reading the file
                graph.addWord(word, "German", "Italian", translation);
            }

            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(graph.getTranslations("eins", "German", "Italian"));

        //FRA-SWE
        String pathName = "CE216-proje-1/src/Dictionary/fra-swe.dict";

        try {
            Scanner scanner = new Scanner(new File(pathName)); // Open the text file for reading
            String word = "";
            ArrayList<String> translation = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.endsWith(">")) { //French word - Swedish
                    if (!word.isEmpty()) {
                        // If word is not empty, add the previous word and translation to the graph

                        graph.addWord(word, "French", "Swedish", translation);
                        word = "";
                        translation = new ArrayList<>();
                    }
                    String[] parts = line.split("/");
                    word = parts[0].trim();
                } else {
                    String[] parts = line.split("\s");
                    StringBuilder frenchWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {

                        frenchWord.insert(0, parts[i] + " ");
                    }
                    translation.add(frenchWord.toString().trim());
                }


            }
            if (!word.isEmpty()) {
                // Add the last word and translation to the graph after reading the file
                graph.addWord(word, "French", "Swedish", translation);
            }

            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //FRA-ITA
        try {
            File file = new File("CE216-proje-1/src/Dictionary/fra-ita.dictsrc/fra-ita.dict");
            Scanner scanner = new Scanner(file);
            String word = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith(">")) {
                    if (!word.isEmpty()) {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                        String[] frenchWords = parts[1].split(",");
                        ArrayList<String> translation = new ArrayList<>();
                        for (String frenchWord : frenchWords) {
                            translation.add(frenchWord.trim());
                        }
                        graph.addWord(word, "French", "Italian", translation);
                    } else {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    }
                } else {
                    String[] parts = line.split("\\s+");
                    StringBuilder italianWord = new StringBuilder();
                    for (int i = parts.length - 1; i >= 0; i--) {
                        italianWord.insert(0, parts[i] + " ");
                    }
                    ArrayList<String> translation = new ArrayList<>();
                    translation.add(italianWord.toString().trim());
                    graph.addWord(word, "French", "Italian", translation);
                    word = "";
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(graph.getTranslations("Ain", "French", "Italian"));

        System.out.println(graph.getTranslations("Basse-Bavière", "French", "Swedish"));



        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}