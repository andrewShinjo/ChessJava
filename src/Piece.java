import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {

	protected Image image;
	protected ImageView imageViewer;
	protected Team team;
	
	public abstract void move();
	public abstract String getName();
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return imageViewer;
	}
	
	public Team getTeam() {
		return team;
	}
	
}
