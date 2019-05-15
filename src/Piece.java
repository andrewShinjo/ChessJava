import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {

	protected Image image;
	protected ImageView imageView;
	protected Team team;
	
	public abstract boolean move(int new_col, int new_row, int old_col, int old_row);
	public abstract String getName();
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return imageView;
	}
	
	public Team getTeam() {
		return team;
	}
	
}
