package umccentipede;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UMCCentipedeController implements Initializable {
    
    @FXML private Button pauseButton;
    @FXML private Label timeLabel;
    @FXML private Label levelLabel;
    @FXML private Label lenghtsLabel;
    @FXML private Label goalLabel;
    @FXML private AnchorPane playArea;
    @FXML private Circle playerCircle;
    @FXML private Label startGameLabel;    
    @FXML private Button startButton;
    @FXML private Button settingsButton;
    @FXML private Button highscoresButton;
    @FXML private Button continueButton;
    @FXML private Label UMCentipedeTitleLabel;
    @FXML private ImageView eagleImageView;
    
    boolean startGame = false;
    boolean upDir = false;
    boolean downDir = false;
    boolean leftDir = false;
    boolean rightDir = false;
    boolean keyPress = false;
    boolean quitGame = true;
    
    /*public void movement(boolean up, boolean down, boolean left, boolean right) {
        Double xPos = playerCircle.getCenterX();
        Double yPos = playerCircle.getCenterY();
        
        if(up) 
            playerCircle.setCenterY(yPos--);
        else if(down)
            playerCircle.setCenterY(yPos++);
        else if(left) 
            playerCircle.setCenterX(xPos--);
        else if(right)
            playerCircle.setCenterX(xPos++);
            
    }*/
    
    @FXML void startButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new 
            FXMLLoader(getClass().getResource("UMCCentipede.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
}
    
    @FXML void keyPressed(KeyEvent e) {
        keyPress = true;
        
        if(KeyCode.ENTER == e.getCode()) {
            startGameLabel.setText("");
            startGame = true;
            
            long startTime = System.currentTimeMillis();
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    long elapsedMillis = System.currentTimeMillis() - startTime;
                    timeLabel.setText(Long.toString(elapsedMillis/1000));
                }
            }.start();
        }
                
        if(e.getCode().isArrowKey()) {
            Double xPos = playerCircle.getCenterX();
            Double yPos = playerCircle.getCenterY();
            
            switch (e.getCode()) {
                case LEFT:
                    xPos = playerCircle.getCenterX();
                    long leftTimer = System.currentTimeMillis();
                    
                    new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                    long leftMillis = System.currentTimeMillis() - leftTimer;
                    levelLabel.setText(Long.toString(leftMillis/1000));
                    
                }
            }.start();
                    playerCircle.setCenterX(xPos - leftTimer);
                    break;
                    
                case RIGHT:
                    xPos = playerCircle.getCenterX();
                    long rightTimer = System.currentTimeMillis();
                    
                    new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                    long rightMillis = System.currentTimeMillis() - rightTimer;
                    levelLabel.setText(Long.toString(rightMillis/1000));
                }
            }.start();
                    playerCircle.setCenterX(xPos + rightTimer);
                    break;
                case UP:
                    yPos = playerCircle.getCenterY();
                    long upTimer = System.currentTimeMillis();
                    
                    new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                    long upMillis = System.currentTimeMillis() - upTimer;
                    levelLabel.setText(Long.toString(upMillis/1000));
                }
            }.start();
                    playerCircle.setCenterY(yPos - upTimer);
                    break;
                    
                case DOWN:
                    yPos = playerCircle.getCenterY();
                    long downTimer = System.currentTimeMillis();
                    
                    new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                    long downMillis = System.currentTimeMillis() - downTimer;
                    levelLabel.setText(Long.toString(downMillis/1000));
                }
            }.start();
                    
                    playerCircle.setCenterY(yPos + (downMillis/1000));
                    break;
        }
    }
    
    }
        
    /*@FXML void movement(KeyEvent move) {
        Double xPos = playerCircle.getCenterX();
        Double yPos = playerCircle.getCenterY();
        keyPress = false;
        
        if(upDir) {
            while(keyPress == false) {
            playerCircle.setCenterY(yPos--);
            }
        }
        if(downDir) {
            while(keyPress == false) {
            playerCircle.setCenterY(yPos++);
            }
        }
        if(leftDir) {
            while(keyPress == false) {
            playerCircle.setCenterX(xPos++);
            }
        }
        if(rightDir) {
            while(keyPress == false) {
            playerCircle.setCenterX(xPos--);
            }
        }
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
}
