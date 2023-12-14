package edu.wit.cs.comp1050.javafx_maven_example;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class App extends Application {

	private static Scene scene;
	public static Parent root;

	@Override
	public void start(Stage stage) throws IOException {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			stage.setTitle("Into The Abyss");
			stage.setScene(new Scene(root, 800, 600));

			stage.show();
			stage.setOnCloseRequest(event -> quit(stage));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void quit(Stage stage) {

		stage.close();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
