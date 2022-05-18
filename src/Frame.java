import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Frame extends JFrame{
	public interface ActionListener{
		public void onKeyEvent(Direction d);
		public void onEnterEvent();
		public void onSpaceEvent();
	}
	public interface EventListener{
		public void onPaintEvent(Graphics g);
	}
	
	private EventListener evtListener;
	private ActionListener listener;
	private Canvas c;
	
	public Frame(EventListener e, ActionListener a) {
		evtListener = e;
		listener = a;
		
		setTitle("Minesweeper");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		c = new Canvas() {
			public void paint (Graphics g){
				evtListener.onPaintEvent(g);
			}
		};

		add(c);

		
		addKeyListener(new KeyListener());
	}
	
private class KeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			
			if(keyCode == event.VK_ENTER) {
				listener.onEnterEvent();
			}else if(keyCode == event.VK_SPACE) {
				listener.onSpaceEvent();
			}else if(keyCode == event.VK_UP) {
				listener.onKeyEvent(Direction.UP);
			}else if( keyCode == event.VK_RIGHT){
				listener.onKeyEvent(Direction.RIGHT);
			}else if(keyCode == event.VK_DOWN){
				listener.onKeyEvent(Direction.DOWN);
			}else if(keyCode == event.VK_LEFT){
				listener.onKeyEvent(Direction.LEFT);
			}
			
		}
	}

public void updateFrame() {
	// TODO Auto-generated method stub
	c.repaint();
}
}
