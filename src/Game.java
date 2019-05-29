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
	private double x_final;
	private double y_final;

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
		printBoard();
		
		//move pieces
		for(int i = 0; i < 32; i++) {
			/*** Piece functionality on MOUSE_PRESSED ***/
			/*********************************************************
			 * MouseEvent.MOUSE_PRESSED
			 * Get x, y coordinates of mouse upon mouse being pressed.
			 * Get x, y coordinates of piece upon mouse being pressed.
			 * x0mouse = x-coordinate of mouse.
			 * y0mouse = y-coordinate of mouse.
			 * x0piece = x-coordinate of piece clicked.
			 * y0-piece = y-coordinate of piece clicked.
			*********************************************************/
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
			/************************************************************
			 * MouseEvent.MOUSE_DRAGGED
			 * Calculate displacement in x,y dir from x0mouse, y0mouse
			 * to x,y coordinate mouse is being dragged to.
			 * Calculate new position by adding original x-pos w/
			 * displacement in x dir and original y-pos w/ displacement
			 * in y dir.
			 * Set image location of piece as new x, y pos calculated.
			 * dx = displacement between x0mouse and x-pos of mouse as it
			 * is dragged.
			 * dy = displacement between y0mouse and y-pos of mouse as it
			 * is dragged.
			 * x0piece = x-coordinate of piece clicked.
			 * y0-piece = y-coordinate of piece clicked.
			************************************************************/
			imageView.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				dx = t.getSceneX() - x0mouse;
				dy = t.getSceneY() - y0mouse;
				x_final = x0piece + dx;
				y_final = y0piece + dy;
				imageView.setX(x_final);
				imageView.setY(y_final);
				}
			});
			/*** Piece functionality on MOUSE_RELEASED ***/
			/************************************************************
			 * MouseEvent.MOUSE_RELEASED
			 * Convert initial x-pos, y-pos into corresponding column and
			 * row on the chess board.
			 * Convert x_final, y_final into corresponding column and 
			 * row on the chess board.
			 * Test whether move is legal when mouse released.
			************************************************************/
			imageView.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent t) {		
					int old_row = (int) Math.rint(x0piece / 80);
					int old_col = (int) Math.rint(y0piece / 80);
					int new_row = (int) Math.rint(x_final / 80);
					int new_col = (int) Math.rint(y_final / 80);
					
					// Piece can only move if placed on a tile on the chess board.
					if( new_col >= 0 && new_col < 8 && new_row >= 0 && new_row < 8 
					&& isLegalMove(board.getTile(old_col, old_row).getPiece(), new_col, new_row, old_col, old_row)==true) {
						// If piece placed on same time, reset it back to same position.
						if(board.getTile(new_col, new_row).getPiece() == board.getTile(old_col, old_row).getPiece()) {
							imageView.setY(old_col * 80);
							imageView.setX(old_row * 80);
						} else if(board.getTile(new_col, new_row).isOccupied() == true) {
							// If piece moved to a tile occupied by friendly piece,
							// reset piece back to the original position.
							if(board.getTile(old_col,  old_row).getPiece().getTeam() ==
							   board.getTile(new_col,  new_row).getPiece().getTeam()) {
								imageView.setY(old_col * 80);
								imageView.setX(old_row * 80);
							// If piece moved to a tile occupied by enemy piece,
							// 1. remove image of the enemy piece from JavaFX (set it to null)
							// 2. remove enemy piece from tile in board class.
							// 3. insert piece that was moved into the new tile in board class.
							// 4. remove piece moved from initial tile it was on in tile in the board class.
							// set image location of piece that was moved to new tile location in JavaFX.	
							} else if(board.getTile(old_col,  old_row).getPiece().getTeam() !=
							board.getTile(new_col,  new_row).getPiece().getTeam())	{
								board.getTile(new_col, new_row).getPiece().getImageView().setImage(null);
								board.getTile(new_col, new_row).removePiece();
								board.getTile(new_col, new_row).insertPiece(board.getTile(old_col, old_row).getPiece());
								board.getTile(new_col, new_row).getPiece().moved();
								board.getTile(old_col, old_row).removePiece();
								imageView.setY(new_col * 80);
								imageView.setX(new_row * 80);
							}
						// If piece moved to unoccupied tile,
						// 1. insert piece into new tile in board class.
						// 2. remove piece from original tile in board class.
						// 3. set image location of piece that was moved to new tile loc in JavaFX.	
						} else if(board.getTile(new_col, new_row).isOccupied() == false) {
							
							// Special case: test if king can castle
							if(canKingCastle(board.getTile(old_col,  old_row).getPiece())==true &&
							new_col == 7 && new_row == 6) {
								board.getTile(7,7).getPiece().getImageView().setY(7*80);
								board.getTile(7, 7).getPiece().getImageView().setX(5 * 80);
								board.getTile(7, 6).insertPiece(board.getTile(old_col,  old_row).getPiece());
								board.getTile(7, 6).getPiece().moved();
								board.getTile(7, 4).removePiece();
								board.getTile(7, 5).insertPiece(board.getTile(7, 7).getPiece());
								board.getTile(7, 5).getPiece().moved();
								board.getTile(7, 7).removePiece();
								imageView.setY(new_col*80);
								imageView.setX(new_row*80);
							} else {
								board.getTile(new_col,  new_row).insertPiece(board.getTile(old_col,  old_row).getPiece());
								board.getTile(new_col,  new_row).getPiece().moved();
								board.getTile(old_col, old_row).removePiece();
								imageView.setY(new_col * 80);
								imageView.setX(new_row * 80);
							}
						  }
						// If piece not placed somewhere on board,
						// reset piece back to original location.
					} else {
						imageView.setX(x0piece);
						imageView.setY(y0piece);
					}				
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
	/*******************************
	 * input: none -> output: void
	 * Prints drawing of board class
	 * on console, like the one below,
	 *  to compare w/ JavaFX graphics.
	[BR][BN][BB][BQ][BK][BB][BN][BR]
	[BP][BP][BP][BP][BP][BP][BP][BP]
	[  ][  ][  ][  ][  ][  ][  ][  ]
	[  ][  ][  ][  ][  ][  ][  ][  ]
	[  ][  ][  ][  ][  ][  ][  ][  ]
	[  ][  ][  ][  ][  ][  ][  ][  ]
	[WP][WP][WP][WP][WP][WP][WP][WP]
	[WR][WN][WB][WQ][WK][WB][WN][WR]
	*******************************/
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
	
	private boolean isLegalMove(Piece piece, int new_col, int new_row, int old_col, int old_row) {
		int dx = new_row - old_row;
		int dy = new_col - old_col;
		
		if(piece.move(new_col, new_row, old_col, old_row)) {
			//Pawn's rule
			if(piece instanceof Pawn) {
				if(dx==0) {
					if(board.getTile(new_col, old_row).isOccupied()) {
						return false;
					}
					return true;
				} else if(dx != 0 && board.getTile(new_col, new_row).getPiece() != null) {
					if(board.getTile(new_col, new_row).getPiece().getTeam() !=
							board.getTile(old_col, old_row).getPiece().getTeam()) {
						return true;
					}
				}
				return false;
			}
			//Rook's rule
			if(piece instanceof Rook) {
				if(Math.abs(dx) > 0) {
					if(dx > 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col, old_row - i).isOccupied()) {
								return false;
							}
						}
					}
				} else if(Math.abs(dy) > 0) {
					if(dy > 0) {
						for(int i = 1; i < Math.abs(dy); i++) {
							if(board.getTile(old_col + i, old_row).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dy); i++) {
							if(board.getTile(old_col - i, old_row).isOccupied()) {
								return false;
							}
						}
					}
				}
			}
			//Queen's rule
			if(piece instanceof Queen) {
				if(Math.abs(dx) > 0 && dy == 0) {
					if(dx > 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col, old_row - i).isOccupied()) {
								return false;
							}
						}
						return true;
					}
				} else if(Math.abs(dy) > 0 && dx == 0) {
					if(dy > 0) {
						for(int i = 1; i < Math.abs(dy); i++) {
							if(board.getTile(old_col + i, old_row).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dy); i++) {
							if(board.getTile(old_col - i, old_row).isOccupied()) {
								return false;
							}
						}
						return true;
					}
				} else if(Math.abs(dy) > 0 && Math.abs(dx) > 0) {
					if(dx > 0 && dy > 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col + i, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else if(dx > 0 && dy < 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col - i, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else if (dx < 0 && dy < 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col -i, old_row - i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col + i, old_row - i).isOccupied()) {
								return false;
							}
						}
						return true;
					}
				}
				return false;
			}
			//Bishop's rule
			if(piece instanceof Bishop) {
				if(Math.abs(dy) > 0 && Math.abs(dx) > 0) {
					if(dx > 0 && dy > 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col + i, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else if(dx > 0 && dy < 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col - i, old_row + i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else if (dx < 0 && dy < 0) {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col -i, old_row - i).isOccupied()) {
								return false;
							}
						}
						return true;
					} else {
						for(int i = 1; i < Math.abs(dx); i++) {
							if(board.getTile(old_col + i, old_row - i).isOccupied()) {
								return false;
							}
						}
						return true;
					}
				}
				return false;
			}
			
			// King's rule
			if(piece instanceof King) {
				if(Math.abs(dx)==2 && canKingCastle(piece)==false ) {
					return false;
				}
			}
			
			return true;
			
			
		}
		
		return false;
		
	}
	
	private boolean canKingCastle(Piece piece) {
		if(piece instanceof King) {
			// White castle short
			if(piece.hasMoved()==false && piece.getTeam() == Team.WHITE && ! board.getTile(7, 5).isOccupied() && ! board.getTile(7, 6).isOccupied() &&
		    board.getTile(7, 7).getPiece().hasMoved() == false) {
				System.out.println("HELLO");
				return true;
			}
		}
		return false;
	}
	
}