import java.nio.file.FileAlreadyExistsException;
import java.util.Random;


public class Board {
	private Tile[][] board;
	private int currentPosX;
	private int currentPosY;
	private int size;
	private boolean isGameOver;
	
	public Board(int size) {
		board = new Tile[size][size];
		this.size = size;
		initializeBoard();
	}
	public void initializeBoard() {
		currentPosX = 0;
		currentPosY = 0;
		isGameOver = false;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = null;
			}
		}
		Random r = new Random();
		int x;
		int y;
		for(int i = 0; i < 100; i++) {
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
					for(int l = -1; l < 2; l++) {
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
	public void updatePos(Direction direction){
		switch (direction){
			case UP:
				currentPosY-=1;
				break;
			case DOWN:
				currentPosY+=1;
				break;
			case LEFT:
				currentPosX-=1;
				break;
			case RIGHT:
				currentPosX+=1;
				break;
		}
		if(currentPosX < 0){
			currentPosX = 0;
		}else if(currentPosX >= size){
			currentPosX = size-1;
		}
		if(currentPosY < 0){
			currentPosY = 0;
		}else if(currentPosY >= size){
			currentPosY = size-1;
		}
	}

	public int getPosX(){
		return currentPosX;
	}
	public int getPosY(){
		return currentPosY;
	}
	public boolean dig(){
		board[currentPosX][currentPosY].setShow(false);
		if(board[currentPosX][currentPosY].getNum() == 10){
			isGameOver = true;
			return true;
		}else if(board[currentPosX][currentPosY].getNum() == 0){
			digAround(currentPosX, currentPosY);
		}
		return false;
	}

	private void digAround(int x, int y){
		for(int i = -1; i < 2; i++){
			for(int j = -1; j < 2; j++){
				try{
					if(board[x+i][y+j].getNum() == 0 && board[x+i][y+j].getShow() == true){
						board[x+i][y+j].setShow(false);
						digAround(x+i, y+j);
					}else{
						board[x+i][y+j].setShow(false);
					}
					
				}catch(Exception nullPointerException){}
			}
		}
	}
	public boolean isGameOver(){
		return isGameOver;
	}
}
