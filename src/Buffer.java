import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

public class Buffer {
	
	private static Color BLACKTRANSPARENT = new Color(0, 0, 0, 127);
	private static Color ORANGETRANSPARENT = new Color(255, 165, 0, 127);
	private static Color LIGHTGREEN = new Color(0, 165, 0, 255);
	private static HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
	static{
		colors.put(1, Color.BLUE);
		colors.put(2, Color.GREEN);
		colors.put(3, Color.RED);
		colors.put(4, Color.MAGENTA);
		colors.put(5, Color.ORANGE);
		colors.put(6, Color.PINK);
		colors.put(7, Color.CYAN);
		colors.put(8, Color.GRAY);
	}
	private boolean gameOver = false;
	private boolean didWin = false;
	public void drawToScreen(Graphics g, Tile[][] board, int posX, int posY, int flags, int squareSize) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 900);
		g.setFont(new Font("Areil", Font.PLAIN,15));
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j].getShow()){
					if((i+j)%2 ==0){
						g.setColor(Color.GREEN);
					}else{
						g.setColor(LIGHTGREEN);
					}
					g.fillRect((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
				}else if(board[i][j].getNum() == 10) {
					g.setColor(Color.BLACK);
					g.drawRect((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
				}else if(board[i][j].getNum() !=0){
						g.setColor(colors.get(board[i][j].getNum()));
						g.drawString("" + board[i][j].getNum(), (i*squareSize)+20, (j*squareSize)+20);
				}
				if(board[i][j].getFlag()){
					g.setColor(Color.RED);
					g.fillOval((i*squareSize)+5, (j*squareSize)+5, squareSize, squareSize);
				}
				if(gameOver && didWin == false){
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
		g.fillOval((25*squareSize)+5, (20*squareSize)+5, squareSize, squareSize);
		g.setColor(Color.BLACK);
		g.drawString("" + flags, (25*squareSize)+5, (22*squareSize)+5);
		if(gameOver){
			g.setColor(Color.blue);
			g.setFont(new Font("Areil", Font.PLAIN, 50));
			if(didWin){
				g.drawString("You Win", 200, 350);
			}else{
				g.drawString("Game Over", 200, 350);
			}
			g.setFont(new Font("Areil", Font.PLAIN, 30));
			g.drawString("Press Enter to replay", 190, 420);
		}
	}
	public void gameOver(boolean dw){
		gameOver = true;
		didWin = dw;
	}
	public void reset(){
		gameOver = false;
		didWin = false;
	}
	
}
