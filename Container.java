public abstract class Container {
    private int weight;
    private int height;
    private String ID;

    Container(String ID, int weight, int height){
        this.ID = ID;
        this.weight = weight;
        this.height = height;
    }

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public String getID() {
		return ID;
	}

	@Override
    public String toString() {
        return 
                "ID=" + ID ;
               
    }
}
