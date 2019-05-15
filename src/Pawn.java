import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	/*** Private member variables ***/
	private boolean hasMoved;
	
	/*** Constructor ***/
	public Pawn(Team team, int x, int y) {
		this.team = team;
		this.hasMoved = false;
	
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
		int dx = new_row - old_row;
		if(team == team.WHITE) {
			int dy = old_col - new_col;
			if(dy == 1 && dx == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			int dy = new_col - old_col;
			if(dy == 1 && dx == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

}
