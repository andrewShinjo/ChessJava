import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece{

	/*** Private member variables ***/
	
	/*** Constructor ***/
	public Queen(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteQueen.png" : "blackQueen.png";
		
		imageView = new ImageView(image);	
		
		imageView.setFitHeight(80);
		imageView.setFitWidth(80);
        imageView.setX(x);
        imageView.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WQ";
		return "BQ";
	}

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		int dx = new_row - old_row;
		int dy = new_col - old_col;
		if((Math.abs(dx) == Math.abs(dy)) || dx == 0 || dy == 0) 
			return true;
		return false;
		
	}
	

}
