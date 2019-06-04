
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Tile extends Rectangle {
	/***Member variables***/
	private boolean isOccupied;
	private Piece piece;
	
	/***Constructors***/
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
	
	/*** Accessor functions ***/
	public boolean isOccupied() {
		return this.isOccupied;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	/*** Additional functions ***/
	public void insertPiece(Piece piece) {
		this.piece = piece;
		this.isOccupied = true;
	}
	
	public void removePiece() {
		this.isOccupied = false;
		this.piece = null;
	}
	
}
