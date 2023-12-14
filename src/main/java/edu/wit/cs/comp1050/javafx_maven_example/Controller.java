package edu.wit.cs.comp1050.javafx_maven_example;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.net.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.beans.value.ChangeListener;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Controller implements Initializable {

	@FXML
	private Button quitbtn;
	@FXML
	private Button playbtn;
	@FXML
	private Button optionbtn;
	@FXML
	private AnchorPane scenePane;
	private Stage stage;
	@FXML
	private Slider volumeSlider;
	private Scene scene;
	private Parent root;
	@FXML
	private ImageView myimage;
	private static MediaPlayer mp;
	private Media me;

	Image myImage = new Image("C:\\Users\\Thomas Do\\git\\ArkanoidProject\\Pictures\\space (1).png");

	private int menuIndex = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		File path = new File("C:\\Users\\Thomas Do\\git\\ArkanoidProject\\Muisc\\new new.mp4");
		me = new Media(path.toURI().toString());
		mp = new MediaPlayer(me);
		if (menuIndex == 0) {
			mp.play();
		}

		menuIndex++;

		myimage.setImage(myImage);

	}

	public static void setVolume(double volume) {
		mp.setVolume(volume);
	}

	public void quitAction() {
		System.out.println("Quit");

		stage = (Stage) scenePane.getScene().getWindow();
		stage.close();

	}

	@FXML
	private void switchScenePlay(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
//		stage.setScene(scene);

		quitAction();

	}

	@FXML
	private void switchSceneOption(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("OptionScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		mp.pause();
		stage.show();

	}

	public Stage getStage() {
		return stage;
	}

}
