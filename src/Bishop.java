import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece {
	private Image image;
	private ImageView imageViewer;
	
	/*** Constructor ***/
	public Bishop(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whiteBishop.png" : "blackBishop.png";
		
		imageViewer = new ImageView(image);	
		
		imageViewer.setFitHeight(80);
		imageViewer.setFitWidth(80);
        imageViewer.setX(x);
        imageViewer.setY(y);
	}
	
	/*** Accessor functions ***/
	public ImageView getImageView() {
		return this.imageViewer;
	}
	
	public String getName() {
		return "B";
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
