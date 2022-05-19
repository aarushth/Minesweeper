import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Buffer {
	
	private static Color BLACKTRANSPARENT = new Color(0, 0, 0, 127);
	private static Color ORANGETRANSPARENT = new Color(255, 165, 0, 127);
	private boolean gameOver = false;
	public void drawToScreen(Graphics g, Tile[][] board, int posX, int posY, int flags, int squareSize) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 900);
		g.setColor(Color.BLACK);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j].getShow()){
					g.setColor(Color.GREEN);
					g.fillRect((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
				}else if(board[i][j].getNum() == 10) {
					g.setColor(Color.RED);
					g.drawString("B", (i*squareSize)+20, (j*squareSize)+20);
				}else {
					if(board[i][j].getNum() !=0){
						g.setColor(Color.BLACK);
						g.drawString("" + board[i][j].getNum(), (i*squareSize)+20, (j*squareSize)+20);
					}
				}
				if(board[i][j].getFlag()){
					g.setColor(Color.RED);
					g.fillOval((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
				}
				if(gameOver){
					if(board[i][j].getNum() == 10){
						g.setColor(ORANGETRANSPARENT);
						g.fillOval((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
					}else if(board[i][j].getFlag()){
						g.setColor(Color.BLACK);
						g.drawString("X", (i*squareSize)+20, (j*squareSize)+20);
					}
				}
			}
		}
		g.setColor(BLACKTRANSPARENT);
		g.fillRect((posX*squareSize)+5, (posY*squareSize)+5, squareSize, squareSize);
		g.setColor(Color.RED);
		g.fillOval((25*squareSize)+5, (25*squareSize)+5, squareSize, squareSize);
		g.setColor(Color.BLACK);
		g.drawString("" + flags, (25*squareSize)+20, (25*squareSize)+20);
		if(gameOver){
			g.setColor(Color.blue);
			g.setFont(new Font("Areil", Font.PLAIN, 50));
			g.drawString("Game Over", 200, 350);
			g.setFont(new Font("Areil", Font.PLAIN, 30));
			g.drawString("Press Enter to replay", 190, 420);
			gameOver = false;
		}
	}
	public void gameOver(){
		gameOver = true;
	}
	
}
