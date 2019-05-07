import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {

	private Image image;
	private ImageView imageViewer;
	
	/*** Constructor ***/
	public King(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whiteKing.png" : "blackKing.png";
		
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
