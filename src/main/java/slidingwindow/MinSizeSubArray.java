package slidingwindow;

import java.util.Arrays;

/**
 * {@link https://leetcode.com/problems/minimum-size-subarray-sum/submissions/}
 * 
 * This is a two pinter technique, the running sum is a pointer of sorts and
 * notice that both pointers start at the very beginning.
 * 
 * @author 746310
 *
 */
public class MinSizeSubArray {

    public static void main(String[] args) {
	int[] nums = { 2, 3, 1, 2, 4, 3 };
	System.out.println(minSubArrayLen(7, nums));

	int[] nums2 = { 1, 2, 3, 7, 5 };
	int[] indices = maxSubArrayLen(12, nums2);
	System.out.println(Arrays.toString(indices));
    }

    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a contiguous subarray of which the sum is
     * greater than or equal to target. If there is no such subarray, return 0
     * instead.
     * 
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int target, int[] nums) {

	int left = 0;
	int runSum = 0;
	int minSub = nums.length + 1;

	for (int i = 0; i < nums.length; i++) {
	    runSum += nums[i];
	    while (runSum >= target) {
		// System.out.println(left + " " + i + " " + runSum);
		minSub = Math.min(minSub, i + 1 - left);
		runSum = runSum - nums[left];
		left++;
	    }
	}
	if (minSub == nums.length + 1)
	    return 0;
	return minSub;

    }

    private static int[] maxSubArrayLen(int target, int[] nums) {
	int low = 0;
	int runSum = 0;
	int indices[] = new int[2];
	int n = nums.length;
	int indexDiff = 0;

	for (int i = 0; i < n; i++) {
	    runSum += nums[i];
	    while (runSum > target) {
		runSum -= nums[low];
		if (runSum == target) {
		    int diff = (i - low);
		    if (diff > indexDiff) {
			indexDiff = diff;
			indices[0] = low;
			indices[1] = i;
		    }
		}
		low++;
	    }

	}
	return indices;

    }

}
