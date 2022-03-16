public class RefrigeratedContainer extends Container {
	private int power;

	public RefrigeratedContainer(String ID, int weight, int height, int power) {
		super(ID, weight, height);
		this.power = power;
	}

	public int getPower() {
		return this.power;
	}
	// ID 3
}