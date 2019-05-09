import javafx.scene.image.ImageView;

public abstract class Piece {

	private ImageView imageView;
	public Team team;
	
	public abstract void move();
	public abstract String getName();
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return this.imageView;
	}
	
	public Team getTeam() {
		return this.team;
	}
	
}
