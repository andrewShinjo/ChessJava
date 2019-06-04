import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {
		
	/*** Constructor ***/
	public King(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKing.png" : "blackKing.png";
		hasMoved = false;
		dx = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		dy = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
		
		imageView = new ImageView(image);	
		
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
        imageView.setX(x);
        imageView.setY(y);
	}
	
	/*** Accessor functions ***/
	public String getName() {
		if(team == Team.WHITE)
			return "WK";
		
		return "BK";
	}
	
	/*** Mutator functions ***/
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}


}
