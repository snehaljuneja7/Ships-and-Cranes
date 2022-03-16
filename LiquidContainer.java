public class LiquidContainer extends Container {
	private int sway;

	public LiquidContainer(String ID, int weight, int height, int sway) {
		super(ID, weight, height);
		this.sway = sway;
	}

	public int getSway() {
		return this.sway;
	}
	// ID 2
}
