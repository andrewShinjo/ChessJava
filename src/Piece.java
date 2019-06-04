import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {

	/*** Member variables ***/
	protected Image image;
	protected ImageView imageView;
	protected Team team;
	protected boolean hasMoved;
	protected int[] dx;
	protected int[] dy;
	
	/*** Abstract functions ***/
	public abstract String getName();
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return imageView;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public boolean hasMoved() {
		return hasMoved;
	}
	
	public int[] getdx() {
		return dx;
	}
	
	public int[] getdy() {
		return dy;
	}
	
	/*** Mutator function ***/
	public void moved() {
		hasMoved=true;
	}
	
	
	
}
