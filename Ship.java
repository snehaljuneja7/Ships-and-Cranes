import java.util.*;

public class Ship {

	private int powerOutput;
	private int noOfStacks;
	private int riskTol;
	private int swayTol;
	private int noOfContainers;
	private int maxWeight;
	private int maxHeight;
	private int stackLimit;
	private LinkedList<Container> containers[];

	public Ship(int powerOutput, int noOfStacks, int riskTol, int swayTol, int noOfContainers, int maxWeight,
			int maxHeight, int stackLimit) {
		this.powerOutput = powerOutput;
		this.noOfStacks = noOfStacks;
		this.riskTol = riskTol;
		this.swayTol = swayTol;
		this.noOfContainers = noOfContainers; // Max no of containers it can take
		this.maxWeight = maxWeight;
		this.maxHeight = maxHeight; // Height of each Stack
		this.stackLimit = stackLimit;// max no of containers in a stack 
		this.containers = new LinkedList[noOfStacks];
		
	}

	public int getPowerOutput() {
		return powerOutput;
	}

	public int getNoOfStacks() {
		return noOfStacks;
	}

	public int getRiskTol() {
		return riskTol;
	}

	public int getSwayTol() {
		return swayTol;
	}

	public int getNoOfContainers() {
		return noOfContainers;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}
	
	

	public int getStackLimit() {
		return stackLimit;
	}

	public void setStackLimit(int stackLimit) {
		this.stackLimit = stackLimit;
	}

	public LinkedList<Container>[] getStack() {
		return containers;
	}

	public void setStack(LinkedList<Container>[] containers) {
		this.containers = containers;
	}
}
