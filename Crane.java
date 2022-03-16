import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Crane {
	private Ship ship;
	private ArrayList<Container> allCont;
	
	Crane(Ship ship, ArrayList<Container> allCont) {
		this.ship = ship;
		this.allCont = allCont;
	}

	public boolean stackContainer() {
		// no stacking possible if number of input container greater than max number of
		// containers ship can take
		boolean stackingPossible = true;
		if (this.allCont.size() > ship.getNoOfContainers()) {
			stackingPossible = false;
			System.out.println("Max no of containers allowed in the ship constraint fails");
			return stackingPossible;
		}

		int wt = 0;
		int po = 0;
		int to = 0;
		int ex = 0;
		int sw = 0;
		int index;
		int[] sz = new int[ship.getNoOfStacks()];
		int[] ht = new int[ship.getNoOfStacks()];
		int[] contAbove = new int[ship.getNoOfStacks()];
		Collections.sort(allCont, new SortByID());
		for (int i = 0; i < ship.getNoOfStacks(); i++) {
			ship.getStack()[i] = new LinkedList<Container>();
			for(int j=0; j< ship.getStackLimit(); j++) {
				ship.getStack()[i].add(null);
			}
		}
		
		for (int i = 0; i < allCont.size(); i++) {
			if (allCont.get(i).getID().charAt(0) == '3') {
				RefrigeratedContainer r = (RefrigeratedContainer) allCont.get(i);
				po += r.getPower();
			}
			if (allCont.get(i).getID().charAt(0) == '5') {
				ToxicContainer t = (ToxicContainer) allCont.get(i);
				to += t.getToxicity();
			}
			if (allCont.get(i).getID().charAt(0) == '4') {
				ExplosiveContainer e = (ExplosiveContainer) allCont.get(i);
				ex += e.getExplosive();
			}
			if (allCont.get(i).getID().charAt(0) == '2') {
				LiquidContainer l = (LiquidContainer) allCont.get(i);
				sw += l.getSway();

			}
		}

		if (po > ship.getPowerOutput()) {
			stackingPossible = false;
			System.out.println("Max power output of the ship constraint fails");
			return stackingPossible;
		}
			

		// combined tol of both toxic and explosive containers to be less than risktol
		// of the ship
		if ((to + ex) > ship.getRiskTol()) {
			stackingPossible = false;
			System.out.println("Max risk tolerance of the ship constraint fails");
			return stackingPossible;
		}
			

		if (sw > ship.getSwayTol()){
			stackingPossible = false;
			System.out.println("Max sway tolerance of the ship constraint fails");
			return stackingPossible;
		}

		for (int i = 0; i < allCont.size(); i++) {
			wt += allCont.get(i).getWeight();
			// checking max weight > wt of all the containers
			if (wt <= ship.getMaxWeight()) {
				// first type of containers to go in are heavy
				if (allCont.get(i).getID().charAt(0) == '1') {
					// if ship.getNoOfStacks() == 4 and containers array size is 5 then last
					// container will go into the first stacking
					sz[i % (ship.getNoOfStacks())] ++;
					index = sz[i % (ship.getNoOfStacks())];
					ship.getStack()[i % (ship.getNoOfStacks())].set(index-1, allCont.get(i));
					// noting height of each stacking and comparing with max height of stack in ship
					ht[i % (ship.getNoOfStacks())] += allCont.get(i).getHeight();
					
					if ((ht[i % (ship.getNoOfStacks())] > ship.getMaxHeight()) || (sz[i % (ship.getNoOfStacks())] > ship.getStackLimit())) {
						stackingPossible = false;
						System.out.println("Max permitted height of the stack in a ship is exceeded");
						return stackingPossible;
					}
				}
				// if after stacking heavy containers, space is left for other containers both
				// weight wise and height wise
				else if ((ship.getStack()[i % (ship.getNoOfStacks())].size() <= ship.getNoOfStacks())
						&& (allCont.get(i).getHeight() <= (ship.getMaxHeight() - ht[i % (ship.getNoOfStacks())])) && ((ship.getStackLimit() - sz[i % (ship.getNoOfStacks())]) > 0)) {
					sz[i % (ship.getNoOfStacks())]++;
					index = sz[i % (ship.getNoOfStacks())];
					ship.getStack()[i % (ship.getNoOfStacks())].set(index-1, allCont.get(i));
					// checking how many weak containers are present at top of another weak
					// container
					if (allCont.get(i).getID().charAt(0) == '6') {
						contAbove[i % (ship.getNoOfStacks())]++;
					}
					ht[i % (ship.getNoOfStacks())] += allCont.get(i).getHeight();
					
				} else{ //if no space left for any other container weight or height wise
					stackingPossible = false;
					System.out.println("All containers cannot be stacked either because of weight/height");
					return stackingPossible;
				}
			} else { //weight of containers exceeds max weight allowed by ship
				stackingPossible = false;
				System.out.println("Max allowed weight in a ship is exceeded");
				return stackingPossible;
			}
		}

		// if more than 1 weak container at top of another weak container stacking not
		// possible
		for (int i = 0; i < ship.getNoOfStacks(); i++) {
			if (contAbove[i] > 2) {
				stackingPossible = false;
				System.out.println("More than 1 container upon a weak container in a ship is not permitted");
				return stackingPossible;
			}
		}
		

		return stackingPossible;
	}

	public LinkedList<Container>[] stackContainersByPriority(boolean isPossible, char priority) {
		
		if(isPossible == true)
			return ship.getStack();
		else {
			ArrayList<Container> prList = new ArrayList<>();
			for(int i=0; i < this.allCont.size(); i++) {
				if(this.allCont.get(i).getID().charAt(0) == priority)
					prList.add(this.allCont.get(i));
			}
			this.allCont = prList;
		
			isPossible = this.stackContainer();
			
			if(isPossible == false) {
				return null;
			}
				
			else {
				return ship.getStack();
			}
			
		}
	}

	public Ship getShip() {
		return ship;
	}

	public ArrayList<Container> getAllCont() {
		return allCont;
	}


}
