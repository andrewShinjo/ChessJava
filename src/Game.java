
public class Game {

	private Board board;
	private Player whitePlayer;
	private Player blackPlayer;
	
	public Game() {
		
		whitePlayer = new Player(Team.WHITE);
		blackPlayer = new Player(Team.BLACK);
		
		board = new Board();
		
		for( int row = 0; row < board.getRow(); row++ ) {
			board.getTile(0,  row).insertPiece(whitePlayer.getPieces()[row]);
			board.getTile(1, row).insertPiece(whitePlayer.getPieces()[row + 8]);
			board.getTile(6,  row).insertPiece(blackPlayer.getPieces()[row]);
			board.getTile(7, row).insertPiece(blackPlayer.getPieces()[row + 8]);
		}	
	}
	
	/*** Accessor functions ***/
	public Board getBoard() {
		return this.board;
	}
}

