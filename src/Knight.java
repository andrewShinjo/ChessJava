import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece {

	private Image image;
	private ImageView imageViewer;
	
	/*** Constructor ***/
	public Knight(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whiteKnight.png" : "blackKnight.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(100);
		imageViewer.setFitWidth(100);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return this.imageViewer;
	}
	
	@Override
	void move() {
		// TODO Auto-generated method stub
		
	}

}
