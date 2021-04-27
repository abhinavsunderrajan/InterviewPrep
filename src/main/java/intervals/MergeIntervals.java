package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * {@link https://leetcode.com/problems/merge-intervals/submissions/} Merge two
 * meetings if possible.
 * 
 * @author 746310
 *
 */
public class MergeIntervals {

    public static void main(String[] args) {
	int[][] intervals = { { 1, 3 }, { 2, 6 }, { 15, 18 }, { 8, 10 } };
	// int[][] intervals = { { 1, 4 }, { 2, 3 } };

	List<int[]> mergedIntervals = merge(intervals);
	for (int[] interval : mergedIntervals) {
	    System.out.println(Arrays.toString(interval));
	}

    }

    private static List<int[]> merge(int[][] intervals) {

	Arrays.sort(intervals, new Comparator<int[]>() {
	    @Override
	    public int compare(int[] o1, int[] o2) {
		return o1[0] - o2[0];
	    }
	});

	int prevStart = -1;
	int prevEnd = -1;
	List<int[]> mergedList = new ArrayList<>();

	for (int[] interval : intervals) {
	    if (prevStart == -1) {
		prevStart = interval[0];
		prevEnd = interval[1];
		mergedList.add(interval);
		continue;
	    }

	    int start = interval[0];
	    int end = interval[1];

	    if (start <= prevEnd) {
		// remove the old interval
		mergedList.remove(mergedList.size() - 1);

		int[] merged = new int[2];
		merged[0] = prevStart;
		// int newEnd = end >= prevEnd ? end : prevEnd;
		int newEnd = Math.max(end, prevEnd);
		merged[1] = newEnd;
		prevEnd = newEnd;
		mergedList.add(merged);
	    } else {
		prevStart = start;
		prevEnd = end;
		mergedList.add(interval);
	    }

	}

	return mergedList;

    }

}
