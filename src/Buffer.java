import java.awt.Graphics;

public class Buffer {
	
	public void drawToScreen(Graphics g, Tile[][] board, int posX, int posY, int squareSize) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j].getNum() == 10) {
					g.drawString("B", (i*squareSize)+20, (j*squareSize)+20);
				}else {
					g.drawString("" + board[i][j].getNum(), (i*squareSize)+20, (j*squareSize)+20);
				}
			}
		}
		g.fillRect((posX*squareSize)+5, (posY*squareSize)+5, squareSize, squareSize);
	}
}
