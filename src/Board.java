import javafx.scene.paint.Color;

public class Board {
	private Tile[][] chessBoard;
	
	
	private static final int COL = 8;
	private static final int ROW = 8;
	private static final int SIDE = 20;
	
	public Board() {
		chessBoard = new Tile[COL][ROW];
		
		for(int col = 0; col < COL; col++) {
			for(int row = 0; row < ROW; row++) {
				 chessBoard[col][row].setX(col * SIDE);
				 chessBoard[col][row].setY(row * SIDE);
				 chessBoard[col][row].setWidth(SIDE);
				 chessBoard[col][row].setHeight(SIDE);
				 if((col % 2 == 0 && row % 2 == 0) || (col % 2 == 1 && row % 2 == 1)) {
					 chessBoard[col][row].setFill(Color.BLACK);
				 } else {
					 chessBoard[col][row].setFill(Color.WHITE);
 				 }
			}		
		}
	}
	
	public Tile getBoard(int row, int col) {
		return chessBoard[row][col];
	}
	
	public int getCol() {
		return this.COL;
	}
	
	public int getRow() {
		return this.ROW;
	}
}
