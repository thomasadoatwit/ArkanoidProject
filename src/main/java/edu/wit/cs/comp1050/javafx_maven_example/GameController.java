package edu.wit.cs.comp1050.javafx_maven_example;

import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class GameController extends Application {

	public static void main(String[] args) {
		System.out.println(args);
		launch(args);
	}

	// make it a class level variable
	public static final int rows = 3;
	public static final int cols = 10;
	public static final int width = 75;
	public static final int height = 35;
	private Rectangle paddle;
	private Circle B;
	private Pane root;
	private boolean isPaused;
	public Blocks block;;
	private ArrayList<Blocks> blocklist;
	// ball speed,position and size
	int diameter = 10;
	double posX = (800 - 5) / 2;
	double posY = 520;
	double speedX = 2.5;
	double speedY = 2.5;

	public void start(@SuppressWarnings("exports") Stage primaryStage) {
		root = new Pane();
		// ArrayList<Blocks>block = new
		// ArrayList<>();
		// this.block=block;
		blocklist = new ArrayList<>();
		for (int r = 0; r < rows; r++) {

			for (int c = 0; c < cols; c++) {

				double x = c * (Blocks.width + 5);
				double y = r * (Blocks.height + 5);
				Color colors = Colors();
				// block.add(new Blocks(x,y, colors));
				// block=new Blocks(x,y, colors);
				Blocks block = new Blocks(x, y, colors);
				root.getChildren().add(block);
				blocklist.add(block);

			}

		}
//root.getChildren().addAll(block);

		// paddle
		paddle = new Rectangle(100, 20, Color.WHITE);
		paddle.setFill(Color.BLUE);
		paddle.setStroke(Color.DARKBLUE);
		double positionY = (530);
		double positionX = (800 - 100) / 2;
		root.getChildren().add(paddle);
		Text text = new Text(40, 0, "test");
		Scene scene = new Scene(root, 800, 600);
		// ball
		B = new Circle(diameter);
		B.setStroke(Color.BLACK);
		B.setFill(Color.GREY);
		root.getChildren().add(B);
		// starting position of paddle
		paddle.setY(positionY);
		paddle.setX(positionX);
		// Title
		primaryStage.setTitle("Into the abyss");
		primaryStage.setScene(scene);
		primaryStage.show();
		paddle.requestFocus();
		// keyaction to check which key the user has inputed and move correspondingly
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SPACE) {
				isPaused = !isPaused;
			}
		});
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.CONFIRMATION);
		a.setOnCloseRequest(event -> {
			if (a.getResult() == ButtonType.FINISH) {

			}

		});

		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case DOWN:
				paddle.setY(paddle.getY() + 0);
				break;
			case UP:
				paddle.setY(paddle.getY() - 0);
				break;

			case LEFT:
				if (paddle.getX() >= 0) {
					paddle.setX(paddle.getX() - 20);
					break;
				}
			case RIGHT:
				if (paddle.getX() <= scene.getWidth() - 100) {
					paddle.setX(paddle.getX() + 20);
				}
				break;
			default:
				break;

			}

		});
		// handle moving animation and stop animation
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (!isPaused) {

					move();
					colision();
					B.setCenterX(posX);
					System.out.println(posX);
					System.out.println(B.getCenterX());
					B.setCenterY(posY);
					System.out.println(B.getCenterY());
				}
			}
		}.start();
	}

//*responsible for the speed of the ball and the borders it his 

	public void move() {

		posX = posX + speedX;
		posY = posY + speedY;

		if (posY >= 590) {
			speedY = -speedY;
			System.out.println("posY exceed");
			// isPaused = !isPaused;
			Alert a = new Alert(AlertType.NONE);
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("GET GOOD");
			a.show();
		}
		if (posY < 0) {
			speedY = -speedY;
		}
		if (posX >= 790) {
			speedX = -speedX;
		}
		if (posX < 0) {
			speedX = -speedX;
		}

	}

	public void colision() {

		if (B.getBoundsInParent().intersects(paddle.getBoundsInParent())) {

			speedY = -Math.abs(speedY);

		}
		if (B.getBoundsInParent().intersects(root.getBoundsInParent())) {
			speedY *= 1.0001;
			speedX *= 1.0001;
		}
		// Blocks[] blockArray = ((Collection<Blocks>) block).toArray(new Blocks[0]);
		for (Blocks block : blocklist)
			if (B.getBoundsInParent().intersects(block.getBoundsInParent())) {
				// speedY=-speedY;
				speedX = -speedX;
				root.getChildren().remove(block);
				blocklist.remove(block);

				block.setVisible(false);
			}

	}

	private Color Colors() {

		return Color.color(Math.random(), Math.random(), Math.random());

	}

}
