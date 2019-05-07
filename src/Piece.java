import javafx.scene.image.ImageView;

public abstract class Piece {

	private ImageView imageView;
	
	abstract void move();
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return this.imageView;
	}
}
