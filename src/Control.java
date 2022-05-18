import java.awt.Graphics;

public class Control implements Frame.ActionListener, Frame.EventListener{
	private Frame frame;
	private Buffer buffer;
	private Board board;
	public Control() {
		buffer = new Buffer();
		board = new Board(5);
		frame = new Frame(this, this);
	} 
	@Override
	public void onPaintEvent(Graphics g) {
		buffer.drawToScreen(g, board.getBoard());
	}
	@Override
	public void onKeyEvent(Direction d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onEnterEvent() {
		// TODO Auto-generated method stub
		frame.updateFrame();
	}
	@Override
	public void onSpaceEvent() {
		// TODO Auto-generated method stub
		
	}
	
}
