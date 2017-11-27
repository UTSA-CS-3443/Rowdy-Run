package gamefx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Power extends Stage {

    private Text text = new Text();


    private boolean correct = false;

    public Power() {

        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);

        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
    }

    public void open() {
       text.setText("Power Up!");
        show();
    }

    public boolean isPower() {
        return correct;
    }
}
