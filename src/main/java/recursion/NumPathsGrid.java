package recursion;

/**
 * Find the number of paths for the grid of size rows*cols. From the origin to
 * the bottom. Can move to the right and bottom alone.
 * 
 * @author 746310
 *
 */
public class NumPathsGrid {

    public static void main(String[] args) {
	int num_rows = 5;
	int num_cols = 5;
	int numOfWays = findNumPaths(0, 0, num_rows, num_cols);
	System.out.println(numOfWays);

    }

    private static int findNumPaths(int row, int col, int num_rows, int num_cols) {
	if (num_rows == 1 || num_cols == 1)
	    return 1;
	if (num_rows == 1 || num_cols == 1)
	    return 1;

	if (row == num_rows - 1 || col == num_cols - 1)
	    return 1;

	return findNumPaths(row + 1, col, num_rows, num_cols) + findNumPaths(row, col + 1, num_rows, num_cols);

    }

}
