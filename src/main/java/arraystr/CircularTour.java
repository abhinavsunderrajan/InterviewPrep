package arraystr;

public class CircularTour {

    public static void main(String args[]) {

	int petrol[] = { 55, 52, 33, 100 };
	int distance[] = { 77, 61, 40, 69 };
	int start = tourNaiveSolution(petrol, distance);
	System.out.println(start);
	start = tourOOfN(petrol, distance);
	System.out.println(start);

    }

    private static int tourOOfN(int[] petrol, int[] distance) {
	int surplus = 0;
	int deficit = 0;
	int start = 0;
	for (int i = 0; i < petrol.length; i++) {
	    surplus += petrol[i] - distance[i];
	    if (surplus < 0) {
		deficit += surplus;
		surplus = 0;
		start = i + 1;
	    }

	}

	return surplus + deficit > 0 ? start : -1;

    }

    /**
     * This is o(n^2)
     * 
     * @param petrol
     * @param distance
     * @return
     */
    private static int tourNaiveSolution(int petrol[], int distance[]) {
	for (int i = 0; i < petrol.length; i++) {
	    boolean solutionFound = true;
	    int j = i;
	    int petrolCarry = 0;
	    for (int count = 0; count < petrol.length; count++) {
		if (j > petrol.length - 1)
		    j = 0;

		petrolCarry = petrol[j] - distance[j] + petrolCarry;
		if (petrolCarry < 0) {
		    solutionFound = false;
		    break;
		}
		j++;
	    }
	    if (solutionFound)
		return i;

	}
	return -1;

    }

}
