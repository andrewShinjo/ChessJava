import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
//    	Stage message = new Stage();
//    	message.setTitle("Chess board");
//    	message.show();
    	
    	//btnPlay is button "Play" to start a game
        String play = "Play";
        Button btnPlay = new Button();
        btnPlay.setText(play);
        
        //btnPlay gives user a brand new chessboard to start
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Rectangle r = new Rectangle();
            	r.setX(20);
            	r.setY(20);
            	r.setWidth(50);
            	r.setHeight(50);
            	
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(r);
                
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
        
        String option = "Option";
        Button btnOption = new Button();
        btnOption.setText(option);
        
 
        // A layout container for UI controls
        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        
        //Grid Pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.add(btnPlay, 1, 0);
        grid.add(btnOption, 1, 1);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
//        vBox.getChildren().addAll(btnPlay, btnOption);
        
        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);
 
        // primaryStage is the main top level window created by platform
        primaryStage.setTitle(play);
        primaryStage.setTitle(option);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}