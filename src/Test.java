import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
// Simple Hello World JavaFX program
public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
 
    // JavaFX entry point
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//btnPlay is button "Play" to start a game
        String play = "Play";
        Button btnPlay = new Button();
        btnPlay.setText(play);
        
        //btnPlay gives user a brand new chessboard to start
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//create new Board object
            	Board chessBoard = new Board();
            	
            	//Pane layout
            	Pane secondaryLayout = new Pane();

            	//Position for all the pieces
                Pawn whitePawn = new Pawn(Team.WHITE, 0, 0);
                
            	//creating chessBoard
            	for(int col = 0; col < chessBoard.getCol(); col++) {
        			for(int row = 0; row < chessBoard.getRow(); row++) {
        				 secondaryLayout.getChildren().add(chessBoard.getBoard(col,row));
        			}		
        		}
            	
            	secondaryLayout.getChildren().add(whitePawn.getImageView());
                
            	//Second scene shown
                Scene secondScene = new Scene(secondaryLayout, 200, 200);

                Stage secondStage = new Stage();
                secondStage.setTitle("Chess");
                secondStage.setScene(secondScene);
                
                //Set position of second window, related to primary window.
                secondStage.setX(primaryStage.getX() + 250);
                secondStage.setY(primaryStage.getY() + 100);
 
                secondStage.show();
            }
        });
        
        //Button Option
        String option = "Option";
        Button btnOption = new Button();
        btnOption.setText(option);
        
        // A layout container for UI controls
        BorderPane root = new BorderPane();
        
        //Grid Pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.add(btnPlay, 1, 0);
        grid.add(btnOption, 1, 1);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
        
        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);
 
        // primaryStage is the main top level window created by platform
        primaryStage.setTitle(play);
        primaryStage.setTitle(option);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}