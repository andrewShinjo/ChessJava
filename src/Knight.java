import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece {

	/*** Constructor ***/
	public Knight(Team team, int x, int y) {
		this.team = team;
		hasMoved = false;
		String image = team == Team.WHITE ? "whiteKnight.png" : "blackKnight.png";
		dx = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
		dy = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
		
		imageView = new ImageView(image);	
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
        imageView.setX(x);
        imageView.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WN";
		return "BN";
	}


	

}
