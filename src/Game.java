
public class Game {

	private Board board;
	private Piece[] whitePieces;
	private Piece[] blackPieces;
	
	public Game() {
		blackPieces = new Piece[] {
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
		
		whitePieces = new Piece[] {
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
		
		board = new Board();
		
		for( int row = 0; row < board.getRow(); row++ ) {
			board.getTile(0,  row).insertPiece(whitePieces[row]);
			board.getTile(1, row).insertPiece(whitePieces[row + 8]);
			board.getTile(6,  row).insertPiece(blackPieces[row]);
			board.getTile(7, row).insertPiece(blackPieces[row + 8]);
		}	
	}
	
	/*** Accessor functions ***/
	public Board getBoard() {
		return this.board;
	}
}
