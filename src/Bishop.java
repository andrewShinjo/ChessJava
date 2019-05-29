import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece {
	/*** Constructor ***/
	public Bishop(Team team, int x, int y) {
		this.team = team;
		hasMoved = false;
		String image = team == Team.WHITE ? "whiteBishop.png" : "blackBishop.png";
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		int dx = new_col - old_col;
		int dy = new_row - old_row;
		if(Math.abs(dx) == Math.abs(dy)) 
			return true;
		return false;
	}
	


}
