package dynamicprogramming;

/**
 * Return the minimum number of drops to determine the floor beyond which the
 * eggs will break.
 * 
 * @author 746310
 *
 */
public class EggDropProblems {
    private static final int NUM_EGGS = 2;
    private static int NUM_FLOORS = 36;

    public static void main(String[] args) {
	int memo[][] = new int[NUM_EGGS + 1][NUM_FLOORS + 1];
	for (int i = 0; i <= NUM_EGGS; i++)
	    for (int j = 0; j <= NUM_FLOORS; j++)
		memo[i][j] = -1;
	int eggDrop = minDrops(NUM_EGGS, NUM_FLOORS, memo);

	System.out.println("Minimum number of trials in worst" + " case with " + NUM_EGGS + "  eggs and " + NUM_FLOORS
		+ " floors is " + eggDrop);

    }

    private static int minDrops(int eggs, int totalFloors, int memo[][]) {

	if (totalFloors == 0 || totalFloors == 1) {
	    return totalFloors;
	}
	// you need to start trying all the floors starting from floor zero
	if (eggs == 1) {
	    return totalFloors;
	}

	if (memo[eggs][totalFloors] != -1)
	    return memo[eggs][totalFloors];

	int min = Integer.MAX_VALUE;

	// Consider all droppings from
	// 1st floor to kth floor and
	// return the minimum of these
	// values plus 1.
	for (int currentFloor = 1; currentFloor <= totalFloors; currentFloor++) {
	    int res = Math.max(minDrops(eggs - 1, currentFloor - 1, memo),
		    minDrops(eggs, totalFloors - currentFloor, memo));
	    if (res < min)
		min = res;
	}
	memo[eggs][totalFloors] = min + 1;
	return min + 1;

    }

}
