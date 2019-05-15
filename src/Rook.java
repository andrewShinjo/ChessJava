import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece {
	
	/*** Private variables */

	
	public Rook(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteRook.png" : "blackRook.png";
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		int dx = new_col - old_col;
		int dy = new_row - old_row;
		
		if(dy == 0 || dx == 0)
			return true;
		return false;
	}
}
