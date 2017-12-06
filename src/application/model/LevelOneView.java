package application.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import application.controller.PlayerController;
import application.model.LevelMaps;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class LevelOneView {

	/**
	 * Array List of <Platform> objects to keep track of platforms in the map
	 */
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	
	/**
	 * Array List of <Coin> objects to keep track of coins in the map
	 */
	private ArrayList<Coin> coins = new ArrayList<Coin>();
	
	/**
	 * Array List of <Image> objects to keep track of rowdy frames for animation
	 */
	private ArrayList<Image> rowdyFrames = new ArrayList<Image>();
	
	/**
	 * Array List of <BigPowerUp> objects to keep track of the Big Power Ups
	 */
	private ArrayList<BigPowerUp> bigPowerUps = new ArrayList<BigPowerUp>();
	
	/**
	 * Array List of <SmallPowerUp> objects to keep track of the Small Power Ups
	 */
	private ArrayList<SmallPowerUp> smallPowerUps = new ArrayList<SmallPowerUp>();

	/**
	 * Stage, and Scene used throughout the Game View
	 */
	Stage primaryStage;
	Scene scene;
	
	/**
	 * Pane to keep track of platforms, coins, and Rowdy
	 */
	private Pane gameRoot;
	
	/**
	 * Panes to keep track of the UI and Background
	 */
	private Pane uiRoot;
	private Pane backgroudRoot;

	/**
	 * Rowdy Object of the player in the game
	 */
	private Rowdy player;

	/**
	 * The Width of the level
	 */
	private int levelWidth;

	/**
	 * Boolean to identify if we lost the game
	 */
	private boolean gameover = false;

	/**
	 * Text object for displaying current score
	 */
	private Text scoreText = new Text();
	
	/**
	 * Current score 
	 */
	private int score = 0;

	public LevelOneView(Stage primaryStage, Pane backgroundRoot) {
		this.primaryStage = primaryStage;
		this.backgroudRoot = backgroundRoot;
	}

	/**
	 * @return
	 * 
	 * Setter for score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Setter for GameOver Boolean
	 * @return
	 */
	public boolean getGameover() {
		return this.gameover;
	}

	/**
	 * Initializes all platforms, coins, and Rowdy
	 */
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
					Platform platform = new Platform(gameRoot, platformImage, j * 50, i * 50);
					platforms.add(platform);
					break;
				case '2':
					Image coinImage = new Image("/resources/coin.png");
					Coin coin = new Coin(gameRoot, coinImage, j * 50, i * 50);
					coins.add(coin);
					break;
				case '3':
					Image bigPowerUpImage = new Image("/resources/BigPowerUp.png");
					BigPowerUp bigPowerUp = new BigPowerUp(gameRoot,bigPowerUpImage, j*50, i*50);
					bigPowerUps.add(bigPowerUp);
					break;
				case '4':
					Image smallPowerUpImage = new Image("/resources/SmallPowerUp.png");
					SmallPowerUp smallPowerUp = new SmallPowerUp(gameRoot,smallPowerUpImage, j*50, i*50);
					smallPowerUps.add(smallPowerUp);
				}
			}
		}

		createRowdy();

	}

	/**
	 * Creates a Rowdy object and sets starting location
	 */
	private void createRowdy() {

		Image rowdyFrame;

		PlayerController controls = new PlayerController(scene);

		for (int i = 1; i <= 6; i++) {
			rowdyFrame = new Image("/resources/rowdy/rr" + i + ".png");
			rowdyFrames.add(rowdyFrame);

		}

		controls.addListeners();
		player = new Rowdy(gameRoot, rowdyFrames.get(0), 100, Settings.SCENE_HEIGHT - 100, 50, 
							controls, rowdyFrames, platforms);
	}

	/**
	 * Checks for Collision between Rowdy and all the coins in the ArrayList
	 */
	private void collectCoins() {

		for (Coin coin : coins) {
			if (player.collidesWith(coin)) {
				score++;
				coin.setRemovable(true);
			}
		}
	}
	
	/**
	 * Checks to see if a Power Up was triggered
	 */
	private void checkPowerUps() {
		for(BigPowerUp bigPowerUp : bigPowerUps) {
			if(player.collidesWith(bigPowerUp)) {
				player.setBigRowdy(true);
				bigPowerUp.setRemovable(true);
			}
		}
		
		for(SmallPowerUp smallPowerUp : smallPowerUps) {
			if(player.collidesWith(smallPowerUp)) {
				player.setSmallRowdy(true);
				smallPowerUp.setRemovable(true);
			}
		}
	}

	/**
	 * Checks for controls and updates UI
	 */
	public void update() {

		player.processInput();
		player.fall();

		collectCoins();
		checkPowerUps();

		player.updateUI();
		coins.forEach(coin -> coin.updateUI());
		platforms.forEach(platform -> platform.updateUI());
		bigPowerUps.forEach(bigPowerUp -> bigPowerUp.updateUI());
		smallPowerUps.forEach(smallPowerUp -> smallPowerUp.updateUI());

		coins.forEach(sprite -> sprite.checkRemovability());
		bigPowerUps.forEach(sprite -> sprite.checkRemovability());
		smallPowerUps.forEach(sprite -> sprite.checkRemovability());

		removeSprites(coins);
		removeSprites(bigPowerUps);
		removeSprites(smallPowerUps);

		updateScore();

		if (!player.checkBoundaries()) {
			gameover = true;
		}

	}

	/**
	 * Creates Score Layer to display score in UI Root
	 */
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

	/**
	 * Removes all Coins from the list if they are classified removable
	 * @param spriteList
	 */
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

	/**
	 * Updates the score
	 */
	private void updateScore() {

		scoreText.setText("Score: " + score);

	}
	
	/**
	 * Initializes level with objects and scene
	 * @throws Exception
	 */
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
