import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece {

	/*** Constructor ***/
	public Knight(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteKnight.png" : "blackKnight.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WN";
		return "BN";
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
