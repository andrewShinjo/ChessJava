import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece {
	
	/*** Private variables */

	
	public Rook(Team team, int x, int y) {
		this.team = team;
		hasMoved=false;
		String image = team == Team.WHITE ? "whiteRook.png" : "blackRook.png";
		dx = new int[] {-1, 0, 0, 1};
		dy = new int[] {0, -1, 1, 0};
		
		imageView = new ImageView(image);	
		
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
	    imageView.setX(x);
	    imageView.setY(y);
	}

	/*** Accessor functions ***/
	public String getName() {
		if(team == Team.WHITE)
			return "WR";
		return "BR";
	}

}
