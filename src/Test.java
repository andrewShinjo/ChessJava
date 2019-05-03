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
    	//btnPlay is button "Play" to start a game
        String play = "Play";
        Button btnPlay = new Button();
        btnPlay.setText(play);
        
        //btnPlay gives user a brand new chessboard to start
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Board board = new Board();
            	
            	Tile r = new Tile();            	
            	r.setOnMouseClicked(new EventHandler<MouseEvent>() 
        		{
        			@Override
        			public void handle(MouseEvent event) {
        				// TODO Auto-generated method stub
        				if(r.isOccupied()) {
        					System.out.println("is Occupied");
        				} else {
        					System.out.println("not occupied");
        				}
        			}
        		});
            	
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().addAll(r, board);
                
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
        
        Image queen = new Image("king.jpg");
        ImageView queenView = new ImageView(queen);
        
        // A layout container for UI controls
        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        
        HBox hBox = new HBox();
        hBox.getChildren().add(queenView);
        
        //Grid Pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.add(btnPlay, 1, 0);
        grid.add(btnOption, 1, 1);
        grid.setAlignment(Pos.CENTER);
        root.setCenter(grid);
        root.setLeft(hBox);
        
        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);
 
        // primaryStage is the main top level window created by platform
        primaryStage.setTitle(play);
        primaryStage.setTitle(option);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}