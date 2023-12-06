package edu.wit.cs.comp1050.javafx_maven_example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;

public class OptionController {
	private Stage stage;
	@FXML
	private Slider volumeSlider;
	private MediaPlayer mp;
	private Media me;
	private Scene scene;
	private Parent root;
	@FXML
	private ImageView optionmenu;
	@FXML
	private Button volumeIcon;

	Image myImage = new Image("C:\\Users\\Thomas Do\\git\\ArkanoidProject\\Pictures\\option.png");

	@FXML
	private void switchSceneMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		Controller.setVolume(mp.getVolume());
		mp.pause();
		stage.show();

	}

	@FXML
	public void initialize() {
		System.out.println("Options");
		File path = new File("C:\\Users\\Thomas Do\\git\\ArkanoidProject\\Muisc\\new new.mp4");
		me = new Media(path.toURI().toString());
		mp = new MediaPlayer(me);
		mp.play();
		volumeSlider.setValue(mp.getVolume() * 100);
		volumeSlider.setMajorTickUnit(25);
		volumeSlider.setMinorTickCount(5);

		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {

				mp.setVolume(volumeSlider.getValue() / 100);

			}
		});

		optionmenu.setImage(myImage);

	}

}
