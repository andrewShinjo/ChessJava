import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	/*** Private member variables ***/
	
	/*** Constructor ***/
	public Pawn(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whitePawn.png" : "blackPawn.png";
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		return false;
	}

}
