import javafx.scene.paint.Color;

public class Board {

	private static final int COL = 8;
	private static final int ROW = 8;
	private static final int SIDE = 100;
	
	private static final Tile[][] chessBoard = new Tile[COL][ROW];
	
	public Board() {
		
		for(int col = 0; col < COL; col++) {
			for(int row = 0; row < ROW; row++) {
				
				chessBoard[col][row] = new Tile();
				
				chessBoard[col][row].setX(row * SIDE);
				chessBoard[col][row].setY(col * SIDE);
				chessBoard[col][row].setWidth(SIDE);
				chessBoard[col][row].setHeight(SIDE);
				
				Color green = Color.rgb(0,  128,  43);
				Color color = ((col + row) % 2 == 0) ? Color.GRAY : green;			
				chessBoard[col][row].setFill(color);
			}		
		}
	}
	
	public Tile getBoard(int col, int row) {
		return chessBoard[col][row];
	}
	
	public int getCol() {
		return this.COL;
	}
	
	public int getRow() {
		return this.ROW;
	}
}
