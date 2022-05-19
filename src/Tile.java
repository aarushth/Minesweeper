public class Tile {
	
	private boolean show;
	private int num;
	private boolean isFlag;
	public Tile(boolean s, int n) {
		show = s;
		num = n;
		isFlag = false;
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

	public boolean getFlag(){
		return isFlag;
	}

	public void setFlag(boolean set){
		isFlag = set;
	}
}
