package arraystr;

import java.util.Arrays;

/**
 * This is a two step process Compute the transpose and do an intgerchange.
 * {@link https://leetcode.com/problems/rotate-image/}
 * 
 * @author 746310
 *
 */
public class ImageArrRotation {

    public static void main(String[] args) {
	int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	System.out.println("Original matrix");
	for (int row = 0; row < a.length; row++)
	    System.out.println(Arrays.toString(a[row]));

	// do the transpose

	System.out.println("transpose matrix");
	for (int row = 0; row < a.length; row++) {
	    for (int col = row; col < a[0].length; col++) {
		if (row != col) {
		    int temp = a[row][col];
		    a[row][col] = a[col][row];
		    a[col][row] = temp;
		}
	    }
	}
	for (int row = 0; row < a.length; row++)
	    System.out.println(Arrays.toString(a[row]));

	System.out.println("rotated matrix");
	for (int row = 0; row < a.length; row++) {
	    int low = 0;
	    int high = a[row].length - 1;
	    while (low < high) {
		int temp = a[row][low];
		a[row][low] = a[row][high];
		a[row][high] = temp;
		low++;
		high--;
	    }
	}

	for (int row = 0; row < a.length; row++)
	    System.out.println(Arrays.toString(a[row]));

    }

}
