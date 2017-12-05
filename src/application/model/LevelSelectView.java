package application.model;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LevelSelectView {

	Parent root;
	public Scene levelSelectScene;

	public LevelSelectView(Parent root) throws IOException {
		this.root = root;
		this.levelSelectScene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
	}

}
