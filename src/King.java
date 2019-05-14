import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {
	/*** Constructor ***/
	public King(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKing.png" : "blackKing.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	public String getName() {
		return "K";
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
