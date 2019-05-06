
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Tile extends Rectangle {
	private boolean isOccupied;
	
	private Piece piece;
	
	public Tile(int x, int y, int w, int h, Color c) {
		this.isOccupied = false;
		setX(x);
		setY(y);
		setWidth(w);
    	setHeight(h);
    	setFill(c);
	}
	
	public Tile(int x, int y, int w, int h, Color c, Piece piece) {
		this.isOccupied = true;
		this.piece = piece;
		setX(x);
		setY(y);
		setWidth(w);
    	setHeight(h);
    	setFill(c);
	}
	
	public boolean isOccupied() {
		return this.isOccupied;
	}
	
}
