import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.paint.Color;

public class Board {

	private static final int COL = 8;
	private static final int ROW = 8;
	private static final int SIDE = 80;
	private static final int TILES = COL * ROW;
	
	private static final Tile[][] chessBoard = new Tile[COL][ROW];
	
	// Implement a graph inside this board class
	private ArrayList<LinkedList<Tile>> adj;
	private int verticies;
	private int edges;
	
	public Board() {
		verticies = TILES;
		edges=0;
		adj = new ArrayList<>(TILES);
		
		adj.add(0, null);
		for(int i = 1; i <= TILES; i++) {
			adj.add(i, new LinkedList<Tile>());
		}
		
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
	
	public int getSize() {
		return TILES;
	}
}
