import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece{

	/*** Private member variables ***/
	
	/*** Constructor ***/
	public Queen(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteQueen.png" : "blackQueen.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		return "Q";
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
