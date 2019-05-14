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
				new Rook(Team.WHITE, 0, 560),
				new Knight(Team.WHITE, 80, 560),
				new Bishop(Team.WHITE, 160, 560),
				new Queen(Team.WHITE, 240, 560),
				new King(Team.WHITE, 320, 560),
				new Bishop(Team.WHITE, 400, 560),
				new Knight(Team.WHITE, 480, 560),
				new Rook(Team.WHITE, 560, 560),
				new Pawn(Team.WHITE, 0, 480),
				new Pawn(Team.WHITE, 80, 480),
				new Pawn(Team.WHITE, 160, 480),
				new Pawn(Team.WHITE, 240, 480),
				new Pawn(Team.WHITE, 320, 480),
				new Pawn(Team.WHITE, 400, 480),
				new Pawn(Team.WHITE, 480, 480),
				new Pawn(Team.WHITE, 560, 480)
			};
		} else {
			pieces = new Piece[] {
				new Pawn(Team.BLACK, 0, 80),
				new Pawn(Team.BLACK, 80, 80),
				new Pawn(Team.BLACK, 160, 80),
				new Pawn(Team.BLACK, 240, 80),
				new Pawn(Team.BLACK, 320, 80),
				new Pawn(Team.BLACK, 400, 80),
				new Pawn(Team.BLACK, 480, 80),
				new Pawn(Team.BLACK, 560, 80),
				new Rook(Team.BLACK, 0, 0),
				new Knight(Team.BLACK, 80, 0),
				new Bishop(Team.BLACK, 160, 0),
				new Queen(Team.BLACK, 240, 0),
				new King(Team.BLACK, 320, 0),
				new Bishop(Team.BLACK, 400, 0),
				new Knight(Team.BLACK, 480, 0),
				new Rook(Team.BLACK, 560, 0)
				};			
		}
		
	}
	
	/*** Accessor functions ***/
	public Piece[] getPieces() {
		return pieces;
	}
	
}
