import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece {
	
	/*** Private variables */
	private Image image;
	private ImageView imageViewer;
	
	public Rook(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whiteRook.png" : "blackRook.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(100);
		imageViewer.setFitWidth(100);
	    imageViewer.setX(x);
	    imageViewer.setY(y);
	}
	
	@Override
	void move() {
		// TODO Auto-generated method stub
		
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public ImageView getImageView() {
		return this.imageViewer;
	}
}
