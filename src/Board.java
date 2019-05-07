import javafx.scene.paint.Color;

public class Board {

	private static final int COL = 8;
	private static final int ROW = 8;
	private static final int SIDE = 100;
	
	private static final Tile[][] chessBoard = new Tile[COL][ROW];
	
	public Board() {
		
		for(int col = 0; col < COL; col++) {
			for(int row = 0; row < ROW; row++) {
				
				Color tileColor = ((col + row) % 2 == 0) ? Color.WHITE : Color.GRAY;	
				chessBoard[col][row] = new Tile(row*SIDE, col*SIDE, SIDE, SIDE, tileColor);
			}		
		}
	}
	
	public Tile getTile(int col, int row) {
		return chessBoard[col][row];
	}
	
	public int getCol() {
		return COL;
	}
	
	public int getRow() {
		return ROW;
	}
}
