import java.util.Random;


public class Board {
	private Tile[][] board;
	private int currentPosX;
	private int currentPosY;
	private int size;
	private boolean isGameOver;
	private int flags;
	
	public Board(int size) {
		board = new Tile[size][size];
		this.size = size;
		initializeBoard();
	}
	public void initializeBoard() {
		flags = 100;
		currentPosX = (size-1)/2;
		currentPosY = (size-1)/2;
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
					for(int l = Math.max(i-1, 0); l <= i+1 && l < size; l++) {
						for(int m = Math.max(j-1, 0); m <= j+1 && m < size; m++) {
							if(board[l][m] != null && board[l][m].getNum() == 10) {
								fin++;
							}
						}
					}
					board[i][j] = new Tile(true, fin);
					if(board[i][j].getNum() == 0 && i < size/2 && j < size/2 ){
						currentPosX = i;
						currentPosY = j;
					}
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
		if(!board[currentPosX][currentPosY].getFlag()){
			flags++;
			board[currentPosX][currentPosY].setShow(false);
			if(board[currentPosX][currentPosY].getNum() == 10){
				isGameOver = true;
				return true;
			}else if(board[currentPosX][currentPosY].getNum() == 0){
				digAround(currentPosX, currentPosY);
			}
			return false;
		}
		return false;
	}

	private void digAround(int x, int y){
		for(int i = Math.max(x-1, 0); i <= x+1 && i < size; i++){
			for(int j = Math.max(y-1, 0); j <= y+1 && j < size; j++){
				
				if(board[i][j].getNum() == 0 && board[i][j].getShow() == true){
					board[i][j].setShow(false);
					digAround(i, j);
				}else{
					board[i][j].setShow(false);
				}
				board[i][j].setFlag(false);
			}
		}
	}

	public boolean isGameOver(){
		return isGameOver;
	}

	public void flag(){
		if(board[currentPosX][currentPosY].getShow()){
			if(board[currentPosX][currentPosY].getFlag()){
				flags++;
				board[currentPosX][currentPosY].setFlag(false);
			}else{
				flags--;
				board[currentPosX][currentPosY].setFlag(true);
			}
		}

	}
	public int getFlags(){
		return flags;
	}
}
