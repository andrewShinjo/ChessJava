import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {
	/*** Constructor ***/
	public King(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKing.png" : "blackKing.png";
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		return false;
	}

}
