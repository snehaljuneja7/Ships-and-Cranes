public class ToxicContainer extends Container {
	private int toxcitiy;

	public ToxicContainer(String ID, int weight, int height, int toxicity) {
		super(ID, weight, height);
		this.toxcitiy = toxicity;
	}

	// ID 5
	public int getToxicity() {
		return this.toxcitiy;
	}
}
