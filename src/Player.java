import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Player {
	/*** Private member variables ***/
	private Team team;
	private Piece[] pieces = new Piece[16];
	
	public Player(Team team) {
		
		this.team = team;
		
		if(team == Team.WHITE) {
			pieces = new Piece[] {
				new Pawn(Team.WHITE, 0, 600),
				new Pawn(Team.WHITE, 100, 600),
				new Pawn(Team.WHITE, 200, 600),
				new Pawn(Team.WHITE, 300, 600),
				new Pawn(Team.WHITE, 400, 600),
				new Pawn(Team.WHITE, 500, 600),
				new Pawn(Team.WHITE, 600, 600),
				new Pawn(Team.WHITE, 700, 600),
				new Rook(Team.WHITE, 0, 700),
				new Knight(Team.WHITE, 100, 700),
				new Bishop(Team.WHITE, 200, 700),
				new Queen(Team.WHITE, 300, 700),
				new King(Team.WHITE, 400, 700),
				new Bishop(Team.WHITE, 500, 700),
				new Knight(Team.WHITE, 600, 700),
				new Rook(Team.WHITE, 700, 700)	
			};
		} else {
			pieces = new Piece[] {
				new Pawn(Team.BLACK, 0, 100),
				new Pawn(Team.BLACK, 100, 100),
				new Pawn(Team.BLACK, 200, 100),
				new Pawn(Team.BLACK, 300, 100),
				new Pawn(Team.BLACK, 400, 100),
				new Pawn(Team.BLACK, 500, 100),
				new Pawn(Team.BLACK, 600, 100),
				new Pawn(Team.BLACK, 700, 100),
				new Rook(Team.BLACK, 0, 0),
				new Knight(Team.BLACK, 100, 0),
				new Bishop(Team.BLACK, 200, 0),
				new Queen(Team.BLACK, 300, 0),
				new King(Team.BLACK, 400, 0),
				new Bishop(Team.BLACK, 500, 0),
				new Knight(Team.BLACK, 600, 0),
				new Rook(Team.BLACK, 700, 0)
				};			
		}
		
	}
	
	/*** Accessor functions ***/
	public Piece[] getPieces() {
		return pieces;
	}
	
}
