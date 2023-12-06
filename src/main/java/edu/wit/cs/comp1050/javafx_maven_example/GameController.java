package edu.wit.cs.comp1050.javafx_maven_example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.*;

public class GameController {

	@FXML
	private ImageView gameview;
	Image myImage = new Image("C:\\Users\\Thomas Do\\git\\ArkanoidProject\\Pictures\\game.png");

	@FXML
	public void initialize() {
		System.out.println("Game");

		gameview.setImage(myImage);
	}

}
