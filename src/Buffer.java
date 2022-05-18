import java.awt.Graphics;

public class Buffer {
	
	public void drawToScreen(Graphics g, Tile[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j].getNum() == 10) {
					g.drawString("B", i*20, j*20);
				}else {
					g.drawString("" + board[i][j].getNum(), i*20, j*20);
				}
			}
		}
	}
}
