import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece {
	
	/*** Private variables */

	
	public Rook(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteRook.png" : "blackRook.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
	    imageViewer.setX(x);
	    imageViewer.setY(y);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	/*** Accessor functions ***/
	public String getName() {
		return "R";
	}
}
