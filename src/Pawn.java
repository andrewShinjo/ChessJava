import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	/*** Private member variables ***/
	
	/*** Constructor ***/
	public Pawn(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whitePawn.png" : "blackPawn.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		return "P";
	}

}
