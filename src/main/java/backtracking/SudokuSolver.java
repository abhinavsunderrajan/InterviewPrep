package backtracking;

import java.util.Arrays;

public class SudokuSolver {

    private static final int N = 9;

    public static void main(String[] args) {
	int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
		{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

	solver(grid, 0, 0);

	for (int row = 0; row < N; row++)
	    System.out.println(Arrays.toString(grid[row]));

    }

    private static boolean solver(int[][] grid, int row, int col) {

	/*
	 * if we have reached the 8th row and 9th column (0 indexed matrix) , we are
	 * returning true to avoid further backtracking
	 */
	if (row >= N - 1 && col == N)
	    return true;

	// Check if column value becomes 9 ,
	// we move to next row
	// and column start from 0
	if (col == N) {
	    row++;
	    col = 0;
	}

	// Check if the current position
	// of the grid already
	// contains value >0, we iterate
	// for next column
	if (grid[row][col] != 0)
	    return solver(grid, row, col + 1);

	for (int num = 1; num <= 9; num++) {

	    // Check if it is safe to place
	    // the num (1-9) in the
	    // given row ,col ->we move to next column
	    if (isValid(grid, row, col, num)) {

		/*
		 * assigning the num in the current (row,col) position of the grid and assuming
		 * our assined num in the position is correct
		 */
		grid[row][col] = num;

		// Checking for next
		// possibility with next column
		if (solver(grid, row, col + 1))
		    return true;
	    }
	    /*
	     * removing the assigned num , since our assumption was wrong , and we go for
	     * next assumption with diff num value
	     */
	    grid[row][col] = 0;
	}
	return false;

    }

    private static boolean isValid(int[][] grid, int row, int col, int num) {
	// Check if we find the same num
	// in the similar row , we
	// return false
	for (int x = 0; x < N; x++)
	    if (grid[row][x] == num)
		return false;

	// Check if we find the same num
	// in the similar column ,
	// we return false
	for (int x = 0; x < N; x++)
	    if (grid[x][col] == num)
		return false;

	// Check if we find the same num
	// in the particular 3*3
	// matrix, we return false
	int startRow = row - row % 3, startCol = col - col % 3;
	for (int i = 0; i < 3; i++)
	    for (int j = 0; j < 3; j++)
		if (grid[i + startRow][j + startCol] == num)
		    return false;

	return true;
    }

}
