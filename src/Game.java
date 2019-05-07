import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Game {
	/*** Private member variables ***/
	private Board board;
	private Piece[] allPieces;
	private Player whitePlayer;
	private Player blackPlayer;
	
	/*** Additional variables for MOUSE_PRESSED, MOUSE_DRAGGED, and MOUSE_RELEASED functionalities ***/
	private double x0mouse;
	private double y0mouse;
	private double x0piece;
	private double y0piece;

	/*** Constructor ***/
	public Game() {
		whitePlayer = new Player(Team.WHITE);
		blackPlayer = new Player(Team.BLACK);
		board = new Board();
		allPieces = new Piece[32];
		for(int i = 0; i < 16; i ++) {
			allPieces[i] = whitePlayer.getPieces()[i];
			allPieces[i+16] = blackPlayer.getPieces()[i];
		}
		
		
		for( int row = 0; row < board.getRow(); row++ ) {
			board.getTile(0,  row).insertPiece(whitePlayer.getPieces()[row]);
			board.getTile(1, row).insertPiece(whitePlayer.getPieces()[row + 8]);
			board.getTile(6,  row).insertPiece(blackPlayer.getPieces()[row]);
			board.getTile(7, row).insertPiece(blackPlayer.getPieces()[row + 8]);
		}	
		
		for(int i = 0; i < 32; i++) {
			/*** Piece functionality on MOUSE_PRESSED ***/
			ImageView imageView = allPieces[i].getImageView();
			imageView.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				public void handle(MouseEvent t) {
				x0mouse = t.getSceneX();
				y0mouse = t.getSceneY();
				x0piece = imageView.getX();
				y0piece = imageView.getY();	
				}
			});
			/*** Piece functionality on MOUSE_DRAGGED ***/	
			imageView.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				double dx = t.getSceneX() - x0mouse;
				double dy = t.getSceneY() - y0mouse;
				double new_dx = x0piece + dx;
				double new_dy = y0piece + dy;
				imageView.setX(new_dx);
				imageView.setY(new_dy);
				}
			});
			/*** Piece functionality on MOUSE_RELEASED ***/
			imageView.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent t) {
				
				}
			});
		}
	}

	/*** Accessor functions ***/
	public Board getBoard() {
		return board;
	}


	/*** Additional functions ***/


}

