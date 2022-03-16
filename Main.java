import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Ship Details");
		int power, noOfStacks, riskTol, swayTol, noOfContainers, maxWeight, maxHeight, stackLimit;
		System.out.println("Enter maximum weight ship can take (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				maxWeight = in.nextInt();
				if (maxWeight < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter maximum height of stacks (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				maxHeight = in.nextInt();
				if (maxHeight < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter number of stacks in ship (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				noOfStacks = in.nextInt();
				if (noOfStacks <= 0) {
					throw new ValidationException("Enter positive integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter positive integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter maximum number of containers ship can take (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				noOfContainers = in.nextInt();
				if (noOfContainers <= 0) {
					throw new ValidationException("Enter positive integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter positive integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter maximum number of containers a stack can have (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				stackLimit = in.nextInt();
				if (stackLimit < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter power output of ship (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				power = in.nextInt();
				if (power < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter risk tolerance of ship (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				riskTol = in.nextInt();
				if (riskTol < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}
		System.out.println("Enter sway tolerance of ship (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				swayTol = in.nextInt();
				if (swayTol < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}

		Ship ship = new Ship(power, noOfStacks, riskTol, swayTol, noOfContainers, maxWeight, maxHeight, stackLimit);

		System.out.println("Individual Container Details");
		int num = 0;
		System.out.println("Enter number of conatiners (NON-NEGATIVE INTEGER ONLY)");
		while (true) {
			try {
				num = in.nextInt();
				if (num < 0) {
					throw new ValidationException("Enter non negative integer value only");
				}
				break;
			} catch (ValidationException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.print(e + ": ");
				System.out.println("Enter non negative integer value only");
			}
			in.nextLine();
		}

		ArrayList<Container> allCont = new ArrayList<Container>();
		HashSet<String> ID = new HashSet<String>(); //to check duplicate container IDs

		for (int i = 0; i < num; i++) {
			String id;
			int height, weight = 0;
			System.out.println("Enter container ID (It should start with 1, 2, 3, 4, 5 or 6 only)");
			while (true) {
				try {
					id = in.next();
					if (id.charAt(0) != '1' && id.charAt(0) != '2' && id.charAt(0) != '3' && id.charAt(0) != '4'
							&& id.charAt(0) != '5' && id.charAt(0) != '6') {
						throw new ValidationException("Enter number starting with 1, 2, 3, 4, 5 or 6 only");
					}
					if(ID.contains(id)) {
						throw new ValidationException("Container with same ID already exists, enter unique ID number");
					}else {
						ID.add(id);
					}
					break;
				} catch (ValidationException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.print(e + ": ");
					System.out.println("Enter number starting with 1, 2, 3, 4, 5 or 6 only");
				}
				in.nextLine();
			}
			if (id.charAt(0) != '1') {
				System.out.println("Enter weight of container (BETWEEN 1-5 ONLY)");
				while (true) {
					try {

						weight = in.nextInt();
						if (weight < 0 || weight > 5) {
							throw new ValidationException("Enter non negative integer value only");
						}
						break;
					} catch (ValidationException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.print(e + ": ");
						System.out.println("Enter non negative integer value only");
					}
					in.nextLine();
				}
			}
			System.out.println("Enter height of container (NON-NEGATIVE INTEGER ONLY)");
			while (true) {
				try {
					height = in.nextInt();
					if (height < 0) {
						throw new ValidationException("Enter non negative integer value only");
					}
					break;
				} catch (ValidationException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.print(e + ": ");
					System.out.println("Enter non negative integer value only");
				}
				in.nextLine();
			}
			switch (id.charAt(0)) {
			case '1':
				HeavyContainer h = new HeavyContainer(id, height);
				allCont.add(h);
				break;

			case '2':
				int sway;
				System.out.println("Enter sway of container (NON-NEGATIVE INTEGER ONLY)");
				while (true) {
					try {
						sway = in.nextInt();
						if (sway < 0) {
							throw new ValidationException("Enter non negative integer value only");
						}
						break;
					} catch (ValidationException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.print(e + ": ");
						System.out.println("Enter non negative integer value only");
					}
					in.nextLine();
				}
				LiquidContainer l = new LiquidContainer(id, weight, height, sway);
				allCont.add(l);
				break;

			case '3':
				int pow;
				System.out.println("Enter power input of container (NON-NEGATIVE INTEGER ONLY)");
				while (true) {
					try {
						pow = in.nextInt();
						if (pow < 0) {
							throw new ValidationException("Enter non negative integer value only");
						}
						break;
					} catch (ValidationException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.print(e + ": ");
						System.out.println("Enter non negative integer value only");
					}
					in.nextLine();
				}
				RefrigeratedContainer r = new RefrigeratedContainer(id, weight, height, pow);
				allCont.add(r);
				break;

			case '4':
				int expl = 0;
				System.out.println("Enter explosiveness of container (NON-NEGATIVE INTEGER ONLY)");
				while (true) {
					try {
						expl = in.nextInt();
						if (expl < 0) {
							throw new ValidationException("Enter non negative integer value only");
						}
						break;
					} catch (ValidationException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.print(e + ": ");
						System.out.println("Enter non negative integer value only");
					}
					in.nextLine();
				}
				ExplosiveContainer e = new ExplosiveContainer(id, weight, height, expl);
				allCont.add(e);
				break;
			case '5':
				int toxicity;
				System.out.println("Enter toxicity of container (NON-NEGATIVE INTEGER ONLY)");
				while (true) {
					try {
						toxicity = in.nextInt();
						if (toxicity < 0) {
							throw new ValidationException("Enter non negative integer value only");
						}
						break;
					} catch (ValidationException ex) {
						System.out.println(ex);
					} catch (Exception ex) {
						System.out.print(ex + ": ");
						System.out.println("Enter non negative integer value only");
					}
					in.nextLine();
				}
				ToxicContainer t = new ToxicContainer(id, weight, height, toxicity);
				allCont.add(t);
				break;

			case '6':
				WeakContainer w = new WeakContainer(id, weight, height);
				allCont.add(w);
				break;

			}

		}

		try {
			if (allCont.size() == 0) {
				throw new ValidationException("Add atleast 1 container to view stacking");
			} else {
				Crane crane = new Crane(ship, allCont);
				boolean stackingPossible = crane.stackContainer();

				in = new Scanner(System.in);

				LinkedList<Container>[] stacking = null;

				if (stackingPossible == true) {
					System.out.println("Stacking possible");
					for (LinkedList l1 : crane.getShip().getStack()) {
						for (int i = 0; i < l1.size(); i++) {
							Container c = (Container) l1.get(i);
							if (c == null)
								System.out.print(" " + -1);
							else
								System.out.print(" " + c.getID());
						}
						System.out.println();
					}
				}

				else {
					System.out.println("Sorry! Stacking not possible");
					System.out.println("Enter the type of the container which is your topmost priority: ");
					char priority = in.next().charAt(0);
					stacking = crane.stackContainersByPriority(stackingPossible, priority);
					if (stacking != null) {
						ship.setStack(stacking);
						for (LinkedList l1 : crane.getShip().getStack()) {
							for (int i = 0; i < l1.size(); i++) {
								Container c = (Container) l1.get(i);
								if (c == null)
									System.out.print(" " + -1);
								else
									System.out.print(" " + c.getID());
							}
							System.out.println();
						}
						System.out.println(Arrays.toString(stacking));
					} else
						System.out.println("Sorry! Priority containers could also not be stacked");
				}

				if (stacking != null) {
					FileWriter writer = null;
					try {
						writer = new FileWriter("/Users/sarthak/Desktop/sample.txt");
						BufferedWriter br = new BufferedWriter(writer);
						for (LinkedList l1 : crane.getShip().getStack()) {
							for (int i = 0; i < l1.size(); i++) {
								Container c = (Container) l1.get(i);
								if (c == null)
									br.write(" " + -1);
								else
									br.write(" " + c.getID());
							}
							br.newLine();
						}
						br.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					} finally {
						if (writer != null) {
							writer.close();
						}
					}
				}

			}
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		in.close();
	}
}
