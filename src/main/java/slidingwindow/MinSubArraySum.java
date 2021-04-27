package slidingwindow;

public class MinSubArraySum {

    /**
     * Consider using a running sum for this kind of sub array sum problems.
     * 
     * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
     * 
     * @param args
     */
    public static void main(String[] args) {
	int[] nums = { 2, 3, 1, 2, 4, 3 };
	System.out.println(minSubArrayLen(7, nums));

    }

    private static int minSubArrayLen(int target, int[] nums) {

	int left = 0;
	int runSum = 0;
	int minSub = nums.length + 1;

	for (int i = 0; i < nums.length; i++) {
	    runSum += nums[i];
	    while (runSum >= target) {
		// System.out.println(left+" "+i+" "+runSum);
		minSub = Math.min(minSub, i + 1 - left);
		runSum = runSum - nums[left];
		left++;
	    }
	}
	if (minSub == nums.length + 1)
	    return 0;
	return minSub;

    }

}
