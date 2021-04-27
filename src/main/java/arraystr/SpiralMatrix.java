package arraystr;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static List<Integer> boundaries = new ArrayList<>();

    // Driver Code
    public static void main(String[] args) {
	int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	spiralOrder(a, 0, a.length, 0, a[0].length);
	System.out.println(boundaries);
    }

    private static void spiralOrder(int[][] a, int rowBegin, int rowEnd, int colBegin, int colEnd) {
	if (colBegin >= colEnd || rowBegin >= rowEnd)
	    return;

	for (int col = colBegin; col < colEnd - 1; col++)
	    boundaries.add(a[rowBegin][col]);

	for (int row = rowBegin; row < rowEnd - 1; row++)
	    boundaries.add(a[row][colEnd - 1]);

	if (colBegin - 1 != colEnd)
	    for (int col = colEnd - 1; col > 0; col--)
		boundaries.add(a[rowEnd - 1][col]);

	if (rowBegin - 1 != rowEnd)
	    for (int row = rowEnd - 1; row > rowBegin; row--)
		boundaries.add(a[row][0]);

	rowBegin++;
	rowEnd--;
	colBegin++;
	colEnd--;
	spiralOrder(a, rowBegin, rowEnd, colBegin, colEnd);

    }
}
