package org.com.facialrecognition;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.File;

public class GUIApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reconhecimento Facial e Emoções");

        FileChooser fileChooser = new FileChooser();
        Button uploadButton = new Button("Upload Imagem");
        uploadButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                System.out.println("Imagem selecionada: " + file.getAbsolutePath());
            }
        });

        VBox layout = new VBox(10, uploadButton);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}