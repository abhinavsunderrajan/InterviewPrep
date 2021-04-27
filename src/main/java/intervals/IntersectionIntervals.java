package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Get the intersection of intervals.
 * {@link https://leetcode.com/problems/interval-list-intersections/submissions/}
 * 
 * @author 746310
 *
 */
public class IntersectionIntervals {

    public static void main(String[] args) {
	int[][] firstList = { { 1, 4 }, { 8, 12 }, { 15, 20 } };
	int[][] secondList = { { 3, 9 }, { 11, 13 } };
	int[][] intervals = intervalIntersection(firstList, secondList);
	for (int[] interval : intervals) {
	    System.out.println(Arrays.toString(interval));
	}

    }

    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

	int n1 = firstList.length;
	int n2 = secondList.length;
	List<int[]> intersectionList = new ArrayList<>();
	int index1 = 0;
	int index2 = 0;

	while (index1 < n1 && index2 < n2) {

	    int start1 = firstList[index1][0];
	    int end1 = firstList[index1][1];

	    int start2 = secondList[index2][0];
	    int end2 = secondList[index2][1];

	    // This is the most crucial as pect of the algorithm
	    int start = Math.max(start1, start2);
	    int end = Math.min(end1, end2);

	    if (start <= end) {
		int[] intersection = { start, end };
		intersectionList.add(intersection);
	    }

	    if (end1 < end2)
		index1++;
	    else
		index2++;

	}

	int[][] intervals = new int[intersectionList.size()][];
	int index = 0;
	for (int[] interval : intersectionList) {
	    intervals[index] = interval;
	    index++;
	}

	return intervals;

    }

}
