package dynamicprogramming;

import java.util.Arrays;

/**
 * Edit distance between two strings. We can insert delete, replace one
 * character at a time.
 * 
 * @author 746310
 *
 */
public class LevenshtienDistance {

    public static void main(String[] args) {
	String s1 = "chingu";
	String s2 = "gangu";

	// create a table of s1.length*s2.length where each cell represents the minimum
	// edit distance between the substrings.

	// Note you also consider empty strings.
	int[][] distanceArr = new int[s1.length() + 1][s2.length() + 1];

	// Transform filled string to a empty string involves deleting characters.
	for (int i = 0; i < s1.length() + 1; i++)
	    distanceArr[i][0] = i;

	// transform empty string to filled string involves adding characters.
	for (int i = 0; i < s2.length() + 1; i++)
	    distanceArr[0][i] = i;

//	for (int i = 0; i < s1.length() + 1; i++)
//	    System.out.println(Arrays.toString(distanceArr[i]));

	// Each value is the minimum distance between (row-1,col), (row, col-1), (row-1,
	// col-1)
	for (int row = 1; row < s1.length() + 1; row++) {
	    for (int col = 1; col < s2.length() + 1; col++) {
		int numEdits = Math.min(distanceArr[row - 1][col],
			Math.min(distanceArr[row][col - 1], distanceArr[row - 1][col - 1]));
		String sub1 = s1.substring(0, row);
		String sub2 = s2.substring(0, col);
		if (sub1.substring(sub1.length() - 1).equals(sub2.substring(sub2.length() - 1)))
		    distanceArr[row][col] = numEdits;
		else
		    distanceArr[row][col] = numEdits + 1;

	    }
	}

	for (int i = 0; i < s1.length() + 1; i++)
	    System.out.println(Arrays.toString(distanceArr[i]));

	System.out.println(
		"Number of edits to transform " + s1 + " to " + s2 + " " + distanceArr[s1.length()][s2.length()]);

    }

}
