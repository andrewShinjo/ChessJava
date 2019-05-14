import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece {
	
	/*** Private variables */
	private Image image;
	private ImageView imageViewer;
	
	public Rook(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whiteRook.png" : "blackRook.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
	    imageViewer.setX(x);
	    imageViewer.setY(y);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	/*** Accessor functions ***/
	public String getName() {
		return "R";
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public ImageView getImageView() {
		return this.imageViewer;
	}
}
