import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {
		
	/*** Constructor ***/
	public King(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKing.png" : "blackKing.png";
		hasMoved = false;
		
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

	@Override
	public boolean move(int new_col, int new_row, int old_col, int old_row) {
		// TODO Auto-generated method stub
		int dy = new_col - old_col;
		int dx = new_row - old_row;
		if((Math.abs(dx) == 1 && dy == 0)|| (Math.abs(dy) == 1 && dx == 0) 
				|| (Math.abs(dy) == 1 && Math.abs(dx) == 1) ||
				Math.abs(dx)==2 || Math.abs(dx)==3 )
			return true;
		return false;
	}

}
