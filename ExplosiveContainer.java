public class ExplosiveContainer extends Container {
	private int explosive;

	public ExplosiveContainer(String ID, int weight, int height, int explosive) {
		super(ID, weight, height);
		this.explosive = explosive;
	}

	public int getExplosive() {
		return this.explosive;
	}
	// ID 4
}
