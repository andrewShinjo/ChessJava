
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Tile extends Rectangle {
	private boolean isOccupied;
	
	public Tile() {
		this.isOccupied = false;
//		setX(100);
//		setY(100);
		setWidth(20);
    	setHeight(20);
    	setFill(Color.WHITE);
	}
	
	public boolean isOccupied() {
		return this.isOccupied;
	}
}
