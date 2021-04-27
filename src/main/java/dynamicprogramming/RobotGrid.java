package dynamicprogramming;

/**
 * Robot memoization
 * 
 * @author 746310
 *
 */
public class RobotGrid {

    private static final int GRID_SIZE = 5;

    public static void main(String[] args) {
	int cache[][] = new int[GRID_SIZE][GRID_SIZE];
	System.out.println(numOfWays(0, 0, cache));

    }

    private static int numOfWays(int row, int col, int cache[][]) {
	if (row == GRID_SIZE || col == GRID_SIZE)
	    return 1;
	else {
	    if (cache[row][col] > 0) {
		return cache[row][col];
	    } else {
		int result = numOfWays(row + 1, col, cache) + numOfWays(row, col + 1, cache);
		cache[row][col] = result;
		return result;

	    }
	}

    }

}
