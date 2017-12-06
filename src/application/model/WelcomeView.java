package application.model;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Welcome View: Sets scene for Welcome View
 * @author oscarsanjuan
 *
 */
public class WelcomeView {

	Parent root;
	public Scene welcomeScene;

	public WelcomeView(Parent root) throws IOException {
		this.root = root;
		this.welcomeScene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
	}

}
