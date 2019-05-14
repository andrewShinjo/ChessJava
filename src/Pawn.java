import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece {

	/*** Private member variables ***/
	private Image image;
	private ImageView imageViewer;
	
	/*** Constructor ***/
	public Pawn(Team color, int x, int y) {
		String image = color == Team.WHITE ? "whitePawn.png" : "blackPawn.png";
		
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
	public Image getImage() {
		return this.image;
	}
	
	public ImageView getImageView() {
		return this.imageViewer;
	}
	
	public String getName() {
		return "P";
	}

}
