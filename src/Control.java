import java.awt.Graphics;

public class Control implements Frame.ActionListener, Frame.EventListener{
	private Frame frame;
	private Buffer buffer;
	private Board board;
	public Control() {
		buffer = new Buffer();
		board = new Board(24);
		frame = new Frame(this, this);
		
		
	} 
	@Override
	public void onPaintEvent(Graphics g) {
		buffer.drawToScreen(g, board.getBoard(), board.getPosX(), board.getPosY(), board.getFlags(), 30);
	}
	@Override
	public void onKeyEvent(Direction d) {
		if(!board.isGameOver()){
			board.updatePos(d);
			frame.updateFrame();
		}
	}
	@Override
	public void onEnterEvent() {
		if(board.isGameOver()){
			board.initializeBoard();
			buffer.reset();
		}else{
			if(board.flag()){
				buffer.gameOver(true);
			}
		}
		frame.updateFrame();
	}
	@Override
	public void onSpaceEvent() {
		if(!board.isGameOver()){
			if(board.dig()){
				buffer.gameOver(false);
			}
			frame.updateFrame();
		}
	}
	
}
