package intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Two intervals overlap if the the end of previous interval exceeds begin of
 * current interval.
 * 
 * {@link https://leetcode.com/problems/non-overlapping-intervals/submissions/}
 * 
 * @author 746310
 *
 */
public class NonOverLappingIntervals {

    public static void main(String[] args) {
	int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
	System.out.println(eraseOverlapIntervals(intervals));

    }

    private static int eraseOverlapIntervals(int[][] intervals) {

	Arrays.sort(intervals, new Comparator<int[]>() {
	    public int compare(int[] i1, int[] i2) {
		if (i1[0] != i2[0])
		    return i1[0] - i2[0];
		else
		    return i1[1] - i2[1];

	    }
	});

	for (int[] interval : intervals)
	    System.out.println(Arrays.toString(interval));

	int count = 0;
	int[] prev = intervals[0];
	for (int i = 1; i < intervals.length; i++) {
	    int[] curr = intervals[i];

	    // condition for overlap previous meeting ends after current meeting starts.
	    if (prev[1] > curr[0]) {
		count++;
		if (curr[1] > prev[1])
		    continue;
	    }

	    prev = curr;

	}

	return count;

    }

}
