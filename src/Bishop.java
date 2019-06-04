import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece {
	/*** Constructor ***/
	public Bishop(Team team, int x, int y) {
		this.team = team;
		hasMoved = false;
		String image = team == Team.WHITE ? "whiteBishop.png" : "blackBishop.png";
		this.dx = new int[] {-1, -1, 1, 1};
		this.dy = new int[] {-1, 1, -1, 1};
		
		imageView = new ImageView(image);	
		
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
        imageView.setX(x);
        imageView.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WB";
		return "BB";
	}

	


}
