import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	
	/*** Constructor ***/
	public Pawn(Team team, int x, int y) {
		this.team = team;
		hasMoved = false;
	
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
		int dy = new_col - old_col;
		if(team == team.WHITE) {
			if(dy == -1 && dx == 0) {
				hasMoved=true;
				return true;
			} else if(dy==-2 && dx==0 && hasMoved==false) {
				hasMoved=true;
				return true;
			} else if(dy==-1 && (dx==-1 || dx==1)) 
				return true;
				return false;
			} else {
			if(dy == 1 && dx == 0) {
				hasMoved=true;
				return true;
			} else if(dy==2 && dx==0 && hasMoved==false) {
				hasMoved=true;
				return true;
			} else if(dy==1 && (dx==-1 || dx==1)) 
				return true;
				return false;
		}
	}
}

