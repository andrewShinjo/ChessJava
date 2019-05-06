
public class Game {

	private Board board;
	private Piece[] whitePieces;
	private Piece[] blackPieces;
	
	public Game() {
		whitePieces = new Piece[] {
			new Pawn(Team.WHITE, 0, 100),
			new Pawn(Team.WHITE, 100, 100),
			new Pawn(Team.WHITE, 200, 100),
			new Pawn(Team.WHITE, 300, 100),
			new Pawn(Team.WHITE, 400, 100),
			new Pawn(Team.WHITE, 500, 100),
			new Pawn(Team.WHITE, 600, 100),
			new Pawn(Team.WHITE, 700, 100),
			new Rook(Team.WHITE, 0, 0),
			new Knight(Team.WHITE, 100, 0),
			new Bishop(Team.WHITE, 200, 0),
			new Queen(Team.WHITE, 300, 0),
			new King(Team.WHITE, 400, 0),
			new Bishop(Team.WHITE, 500, 0),
			new Knight(Team.WHITE, 600, 0),
			new Rook(Team.WHITE, 700, 0)
		};
		
		blackPieces = new Piece[] {
				new Pawn(Team.BLACK, 0, 600),
				new Pawn(Team.BLACK, 100, 600),
				new Pawn(Team.BLACK, 200, 600),
				new Pawn(Team.BLACK, 300, 600),
				new Pawn(Team.BLACK, 400, 600),
				new Pawn(Team.BLACK, 500, 600),
				new Pawn(Team.BLACK, 600, 600),
				new Pawn(Team.BLACK, 700, 600),
				new Rook(Team.BLACK, 0, 700),
				new Knight(Team.BLACK, 100, 700),
				new Bishop(Team.BLACK, 200, 700),
				new Queen(Team.BLACK, 300, 700),
				new King(Team.BLACK, 400, 700),
				new Bishop(Team.BLACK, 500, 700),
				new Knight(Team.BLACK, 600, 700),
				new Rook(Team.BLACK, 700, 700)	
		};
		
		Board board = new Board();
		
		for(int col = 0; col < board.getCol(); col++) {
			for(int row = 0; row < board.getRow(); row++) {
				
			}
		}
		
	}
}
