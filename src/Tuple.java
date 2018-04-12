
public class Tuple<Integer, Integer1> {

	private int l;
	private int r;

	public Tuple(int l, int r) {
		this.l = l;
		this.r = r;
	}

	public int sommeTuple() {
		return l + r;
	}

	public boolean isSpare() {
		if (l + r == 10 && l != 10) {
			return true;
		}
		return false;
	}
	
	public boolean isStrike() {
		if (l + r == 10 && l == 10) {
			return true;
		}
		return false;
	}

	public int getL() {
		return l;
	}

	public int getR() {
		return r;
	}

	public void setL(int l) {
		this.l = l;
	}

	public void setR(int r) {
		this.r = r;
	}

}
