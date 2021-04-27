package twopointers;

/**
 * {@link https://leetcode.com/problems/container-with-most-water/}
 * 
 * @author 746310
 *
 */
public class MaximumArea {

    public static void main(String[] args) {
	int[] heights = { 1, 8, 6, 2, 5, 4, 8, 25, 7 };
	System.out.println(maxAreaNaive(heights));
	System.out.println(maxArea(heights));

    }

    private static int maxArea(int[] height) {
	int n = height.length;
	int low = 0;
	int high = n - 1;
	int maxArea = Integer.MIN_VALUE;
	while (low < high) {
	    int area = (high - low) * Math.min(height[low], height[high]);
	    if (area > maxArea) {
		maxArea = area;
	    }

	    if (height[low] < height[high])
		low += 1;

	    else
		high -= 1;

	}

	return maxArea;
    }

    private static int maxAreaNaive(int[] height) {

	int maxArea = Integer.MIN_VALUE;
	for (int i = 0; i < height.length - 1; i++) {
	    for (int j = i + 1; j < height.length; j++) {
		int area = Math.min(height[i], height[j]) * (j - i);
		if (area > maxArea)
		    maxArea = area;
	    }
	}

	return maxArea;

    }
}
