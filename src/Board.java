import java.util.Random;


public class Board {
	private Tile[][] board;
	private int currentPosX;
	private int currentPosY;
	
	public Board(int size) {
		board = new Tile[size][size];
		currentPosX = 0;
		currentPosY = 0;
		initializeBoard(size);
	}
	public void initializeBoard(int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = null;
			}
		}
		Random r = new Random();
		int x;
		int y;
		for(int i = 0; i < 10; i++) {
			x = r.nextInt(size);
			y = r.nextInt(size);
			if(board[x][y] == null) {
				board[x][y] = new Tile(true, 10);
			}else {
				i--;
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(board[i][j] == null) {
					int fin = 0;
					for(int l = -1; i < 2; l++) {
						for(int m = -1;m < 2; m++) {
							boolean breaker = false;
							if(i+l < 0 || i+l >=size) {
								breaker = true;
							}
							if(j+m < 0 || j+m >=size) {
								breaker = true;
							}
							if(!breaker) {
								if(board[i+l][j+m] != null && board[i+l][j+m].getNum() == 10) {
									fin++;
								}
							}
						}
					}
					board[i][j] = new Tile(true, fin);
				}
			}
		}
	}
	
	public Tile[][] getBoard(){
		return board;
	}
}
