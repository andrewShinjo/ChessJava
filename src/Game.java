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
	private double dx;
	private double dy;
	private double new_dx;
	private double new_dy;

	/*** Constructor ***/
	public Game() {
		//creating two team players
		whitePlayer = new Player(Team.WHITE);
		blackPlayer = new Player(Team.BLACK);
		board = new Board();
		allPieces = new Piece[32];
		
		//inserting all pieces for two sides
		for(int i = 0; i < 16; i ++) {
			allPieces[i] = whitePlayer.getPieces()[i];
			allPieces[i+16] = blackPlayer.getPieces()[i];
		}
		
		for( int row = 0; row < board.getRow(); row++ ) {
			board.getTile(0,  row).insertPiece(blackPlayer.getPieces()[row+8]);
			board.getTile(1, row).insertPiece(blackPlayer.getPieces()[row]);
			board.getTile(6,  row).insertPiece(whitePlayer.getPieces()[row + 8]);
			board.getTile(7, row).insertPiece(whitePlayer.getPieces()[row]);
		}	
		
//		for( int row = 0; row < board.getRow(); row++ ) {
//			System.out.println(board.getTile(0,  row).getPiece().getTeam());
//			System.out.println(board.getTile(1, row).getPiece().getTeam());
//			System.out.println(board.getTile(1, row).getPiece().getTeam());
//			System.out.println(board.getTile(7, row).getPiece().getTeam());
//		}	

		
		printBoard();
		
		//move pieces
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
				dx = t.getSceneX() - x0mouse;
				dy = t.getSceneY() - y0mouse;
				new_dx = x0piece + dx;
				new_dy = y0piece + dy;
				imageView.setX(new_dx);
				imageView.setY(new_dy);
				}
			});
			/*** Piece functionality on MOUSE_RELEASED ***/
			imageView.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent t) {
					
					int old_row = (int) Math.rint(x0piece / 80);
					int old_col = (int) Math.rint(y0piece / 80);
					System.out.println("old_row " + old_row + " old_col " + old_col);
					int new_row = (int) Math.rint(new_dx / 80);
					int new_col = (int) Math.rint(new_dy / 80);
					System.out.println("new_row " + new_row + " new_col " + new_col);
					
					// If piece is placed on the board, allow piece to move
					if( new_col >= 0 && new_col < 8 && new_row >= 0 && new_row < 8) {
						if(board.getTile(new_col, new_row).getPiece() == board.getTile(old_col, old_row).getPiece()) {
							imageView.setY(old_col * 80);
							imageView.setX(old_row * 80);
						} else if(board.getTile(new_col, new_row).isOccupied() == true &&
						  board.getTile(new_col,  new_row).getPiece().getTeam() ==
						  board.getTile(old_col, old_row).getPiece().getTeam()) {
							System.out.println("Friendly piece occupied");
							imageView.setY(old_col * 80);
							imageView.setX(old_row * 80);
						} else if(board.getTile(new_col, new_row).isOccupied() == true &&
						  board.getTile(new_col,  new_row).getPiece().getTeam() !=
						  board.getTile(old_col, old_row).getPiece().getTeam()) {
							System.out.println("Enemy piece occupied");
							board.getTile(new_col, new_row).getPiece().getImageView().setImage(null);
							board.getTile(new_col, new_row).removePiece();
							board.getTile(new_col, new_row).insertPiece(board.getTile(old_col, old_row).getPiece());
							board.getTile(old_col, old_row).removePiece();
							imageView.setY(new_col * 80);
							imageView.setX(new_row * 80);
						}
						  else if(board.getTile(new_col, new_row).getPiece() == null) {
							board.getTile(new_col,  new_row).insertPiece(board.getTile(old_col,  old_row).getPiece());
							board.getTile(old_col, old_row).removePiece();
							System.out.println(board.getTile(old_col, old_row).isOccupied());
							System.out.println("Old col = " +old_col + " Old row = " +old_row);
							imageView.setY(new_col * 80);
							imageView.setX(new_row * 80);
						}
					} else {
						imageView.setX(x0piece);
						imageView.setY(y0piece);
					}
					
					// If board is taken, bring piece to the current tile
					printBoard();
					
					
				}
			});
		}
	}

	/*** Accessor functions ***/
	public Board getBoard() {
		return board;
	}


	/*** Additional functions ***/

	public void printBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Piece piece = board.getTile(i,  j).getPiece();
				if(piece != null) {
					System.out.print("[" + board.getTile(i, j).getPiece().getName()+"]");
				} else {
					System.out.print("[  ]");
				}
			}
			System.out.println();
		}
	}

}

