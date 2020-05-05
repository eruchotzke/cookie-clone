package Application;

import Model.CakeModel;
import Model.IProducer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller portion of the game.
 */
public class Game implements Initializable {

    /* Model assets */
    private CakeModel model;

    /* Timing assets */
    AnimationTimer timer;
    private long oldTime = -1;

    /* Serialized Assets */
    @FXML
    private Label cakeTotal;

    @FXML
    private Label cakePerSecond;

    @FXML
    private VBox assetBuyers;

    /* Controller Methods */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new CakeModel();

        /* Add buttons into the vbox */
        Button buyCrank = new Button();
        buyCrank.setText("Buy Hand Crank - " + );

        updateGraphics();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(oldTime == -1) oldTime = now; //this should only happen on the first
                double delta = (now - oldTime) / 1000000000.0;
                oldTime = now;
                model.produceCakes(delta);
                updateGraphics();
            }
        };
        timer.start();
    }

    /**
     * Update function for the game's graphics.
     * God method.
     */
    public void updateGraphics(){
        cakeTotal.setText("Credits: " + String.format("%,d", (int)model.getNumCakes()));
        cakePerSecond.setText("Credits per Second: " + String.format("%.2f", model.getCakesPerSecond()));
    }

    /**
     * What to do when the cake button is pressed.
     */
    public void onCakeButtonPress(){
        model.addOneCake();
        updateGraphics();
    }

    /**
     * Purchase a single clicker.
     */
    public void purchaseCrank(){
        IProducer clicker = model.cakeProducers.get(0);

        if(model.getNumCakes() >= clicker.getCost()){
            model.useCakes(clicker.getCost());
            clicker.buyProducer();
        }
    }
}
