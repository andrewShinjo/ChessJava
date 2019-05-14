import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece {
	/*** Constructor ***/
	public Bishop(Team team, int x, int y) {
		this.team = team;
		String image = team == Team.WHITE ? "whiteBishop.png" : "blackBishop.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	
	public String getName() {
		if(team == Team.WHITE)
			return "WB";
		return "BB";
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
