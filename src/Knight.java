import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece {

	/*** Constructor ***/
	public Knight(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKnight.png" : "blackKnight.png";
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
