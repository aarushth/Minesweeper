public class Tile {
	
	private boolean show;
	private int num;
	public Tile(boolean s, int n) {
		show = s;
		num = n;
	}
	public boolean getShow() {
		return show;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setShow(boolean s) {
		show = s;
	}
}
