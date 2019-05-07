import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Player {
	/*** Private member variables ***/
	private Team team;
	private Piece[] pieces = new Piece[16];
	
	private double x0mouse;
	private double y0mouse;
	private double x0piece;
	private double y0piece;
	
	public Player(Team team) {
		
		this.team = team;
		
		if(team == Team.WHITE) {
			pieces = new Piece[] {
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
		} else {
			pieces = new Piece[] {
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
		}
		
		for(int i = 0; i < 8; i++) {
			ImageView imageView = pieces[i].getImageView();
			imageView.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent t) {
		        	x0mouse = t.getSceneX();
		        	y0mouse = t.getSceneY();
		        	x0piece = imageView.getX();
		        	y0piece = imageView.getY();	
		        }
			});
			
			imageView.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
		    	@Override
		    	public void handle(MouseEvent t) {
		    		double dx = t.getSceneX() - x0mouse;
		    		double dy = t.getSceneY() - y0mouse;
		    		double new_dx = x0piece + dx;
		    		double new_dy = y0piece + dy;
		    		imageView.setX(new_dx);
		    		imageView.setY(new_dy);
		    	}
			});
			
			imageView.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
		    	@Override
		    	public void handle(MouseEvent t) {
		    		int roundX = ((int) Math.round(imageView.getX() / 100) * 100) + 6;
		    		int roundY = ((int) Math.round(imageView.getY() / 100) * 100) + 6;
		    		int x0 = (int) (x0piece - 6) / 100;
		    		int y0 = (int) (y0piece - 6) / 100;
		    		int xf = (roundX - 6) / 100;
		    		int yf = (roundY - 6) / 100;
		    		
		    		if(board.getTile(y0, x0).getPiece().move(x0, y0, xf, yf) == true 
		    				&& xf >= 0 && xf <= 7 && yf >= 0 && yf <= 7)
		    		{
		    			// legal move to occupied tile
			    		if(board.getTile(yf, xf).isOccupied()) 
			    		{
			    			// if occupied tile has friendly piece, don't allow move
			    			if(board.getTile(yf, xf).getPiece().getPlayer().getColor() == board.getTile(y0, x0).getPiece().getPlayer().getColor())
			    			{
			    				System.out.println("team");
			    				imageView.setX(x0piece);
			    				imageView.setY(y0piece);
			    			} 
			    			// if occupied tile has enemy piece
			    			else
			    			{

			    				imageview[yf][xf].setImage(imageview[y][x].getImage());
			    				imageview[y][x].setImage(blank);
			    				board.getTile(yf, xf).setPiece(board.getTile(y, x).getPiece());
				    			board.getTile(y, x).setPiece(new BlankPiece());
				    			imageview[y][x].setX(roundX);
				    			imageview[y][x].setY(roundY);			 	
			    			}
			    		}
			    		// legal move to unoccupied tile
			    		else
			    		{
			    			System.out.println("269 not occupied");
			    			System.out.println(board.getTile(yf, xf).isOccupied());
			    			board.getTile(yf, xf).setPiece(board.getTile(y, x).getPiece());
			    			board.getTile(y, x).setPiece(new BlankPiece());
			    			imageview[yf][xf].setImage(imageview[y][x].getImage());
			    			imageview[y][x].setImage(blank);
			    			imageview[y][x].setX(roundX);
			    			imageview[y][x].setY(roundY);
			    		}
		    		}
		    		else 
		    		{
		    			System.out.println(board.getTile(y,x).getPiece());
		    			System.out.println("illegal move");
		    			imageview[y][x].setX(x0piece);
		    			imageview[y][x].setY(y0piece);
		    		}   		
		    	}
			});
			
		}
		
	}
	
	/*** Accessor functions ***/
	public Piece[] getPieces() {
		return pieces;
	}
	
}
