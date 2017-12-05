package application.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.Main;
import application.controller.LevelOneController;
import application.controller.PlayerController;
import application.model.LevelMaps;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class LevelOneView {

	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private ArrayList<Coin> coins = new ArrayList<Coin>();
	private ArrayList<Image> rowdyFrames = new ArrayList<Image>();

	Stage primaryStage;
	Scene scene;
	private Pane gameRoot;
	private Pane uiRoot;
	private Pane backgroudRoot;

	private Rowdy player;

	private int levelWidth;

	private boolean gameover = false;

	private Text scoreText = new Text();
	private int score = 0;

	public LevelOneView(Stage primaryStage, Pane backgroundRoot) {
		this.primaryStage = primaryStage;
		this.backgroudRoot = backgroundRoot;
	}

	public int getScore() {
		return this.score;
	}

	public boolean getGameover() {
		return this.gameover;
	}

	private void initContent() {

		levelWidth = LevelMaps.LEVEL1[0].length() * 50;

		for (int i = 0; i < LevelMaps.LEVEL1.length; i++) {
			String line = LevelMaps.LEVEL1[i];
			for (int j = 0; j < line.length(); j++) {
				switch (line.charAt(j)) {
				case '0':
					break;
				case '1':
					Image platformImage = new Image("/resources/platform.png");
					Platform platform = new Platform(gameRoot, platformImage, j * 50, i * 50, 50, 50);
					platforms.add(platform);
					break;
				case '2':
					Image coinImage = new Image("/resources/coin.png");
					Coin coin = new Coin(gameRoot, coinImage, j * 50, i * 50, 50, 50);
					coins.add(coin);
					break;
				}
			}
		}

		createRowdy();

	}

	private void createRowdy() {

		Image rowdyFrame;

		PlayerController controls = new PlayerController(scene);

		for (int i = 1; i <= 6; i++) {
			rowdyFrame = new Image("/resources/rowdy/rr" + i + ".png");
			rowdyFrames.add(rowdyFrame);

		}

		controls.addListeners();
		player = new Rowdy(gameRoot, rowdyFrames.get(0), 100, Settings.SCENE_HEIGHT - 100, 50, 50, 5, controls,
				rowdyFrames, platforms);
	}

	private void collectCoins() {

		for (Coin coin : coins) {
			if (player.collidesWith(coin)) {
				score++;
				coin.setRemovable(true);
			}
		}
	}

	public void update() {

		player.processInput();
		player.fall();

		collectCoins();

		player.updateUI();
		coins.forEach(coin -> coin.updateUI());
		platforms.forEach(platform -> platform.updateUI());

		coins.forEach(sprite -> sprite.checkRemovability());

		removeSprites(coins);

		updateScore();

		if (!player.checkBoundaries()) {
			gameover = true;
		}

	}

	private void createScoreLayer() {

		scoreText.setFont(new Font("Comic Sans MS", 50));
		scoreText.setStroke(Color.BLACK);
		scoreText.setFill(Color.BLACK);

		uiRoot.getChildren().add(scoreText);

		double x = (Settings.SCENE_WIDTH - 400);
		scoreText.relocate(x, 0);
		scoreText.setText("Score: 0");

		scoreText.setBoundsType(TextBoundsType.VISUAL);

	}

	private void removeSprites(List<? extends Sprite> spriteList) {
		Iterator<? extends Sprite> iter = spriteList.iterator();
		while (iter.hasNext()) {
			Sprite sprite = iter.next();

			if (sprite.isRemovable()) {

				// remove from layer
				sprite.removeFromLayer();

				// remove from list
				iter.remove();
			}
		}
	}

	private void updateScore() {

		scoreText.setText("Score: " + score);

	}

	public void initLevel() throws Exception {

		Group root = new Group();

		gameRoot = new Pane();
		uiRoot = new Pane();

		root.getChildren().add(backgroudRoot);
		root.getChildren().add(gameRoot);
		root.getChildren().add(uiRoot);

		createScoreLayer();

		scene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.show();

		initContent();
	}

}
