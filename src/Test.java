import java.util.LinkedList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
 
// Simple Hello World JavaFX program
public class Test extends Application 
{
	
    public static void main(String[] args) 
    {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
    	Game game = new Game();
        Button playButton = new Button("Play");
        
        //playButton gives user a brand new chessboard to start
        playButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
            	Pane secondaryLayout = new Pane();

            	// Drawing chessBoard on JavaFX
            	for(int col = 0; col < 8; col++) 
            	{
        			for(int row = 0; row < 8; row++) 
        			{
        				 secondaryLayout.getChildren().add(game.getBoard().getTile(col,row));
        			}		
        		}
            	
            	for(int row = 0; row < 8; row++) 
            	{
            		secondaryLayout.getChildren().add(game.getBoard().getTile(0,  row).getPiece().getImageView());
            		secondaryLayout.getChildren().add(game.getBoard().getTile(1, row).getPiece().getImageView());
            		secondaryLayout.getChildren().add(game.getBoard().getTile(6,  row).getPiece().getImageView());
            		secondaryLayout.getChildren().add(game.getBoard().getTile(7, row).getPiece().getImageView());
        		}
            	
                Button debugButton = new Button("Debug On");
            	secondaryLayout.getChildren().add(debugButton);
            	//Second scene shown
                Scene secondScene = new Scene(secondaryLayout, 1000, 1600);
                Stage secondStage = new Stage();
                secondStage.setTitle("Chess");
                secondStage.setScene(secondScene);
                
                //Set position of second window, related to primary window.
                secondStage.setX(250);
                secondStage.setY(0);
                secondStage.show();
                
                debugButton.setOnAction(new EventHandler<ActionEvent>() 
                {
                    @Override
                    public void handle(ActionEvent event) 
                    {
                    	String name = (debugButton.getText() == "Debug On" ? "Debug Off" : "Debug On");
                    	debugButton.setText(name);
                    }
                
                });
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
        grid.add(playButton, 1, 0);
        grid.add(btnOption, 1, 1);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
        
        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);
 
        // primaryStage is the main top level window created by platform
        primaryStage.setTitle("Play");
        primaryStage.setTitle(option);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}