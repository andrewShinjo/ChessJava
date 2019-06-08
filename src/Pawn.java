import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	/*** Constructor ***/
	public Pawn(Team team, int x, int y) {
		this.team = team;
		hasMoved = false;
		String image = (team == Team.WHITE ? "whitePawn.png" : "blackPawn.png");
		dx = new int[] {-1, 0, 1, 0};
		dy = new int[] {1, 1, 1, 2};
		
		
		imageView = new ImageView(image);	
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
        imageView.setX(x);
        imageView.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WP";
		return "BP";
	}

}

