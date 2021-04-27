package dynamicprogramming;

public class MaxSubArraySum {

    public static void main(String[] args) {
	int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	int ans = maxSubArray(nums);
	System.out.println(ans);
	System.out.println(maxSubArraySum(nums, nums.length));

    }

    private static int maxSubArray(int[] nums) {
	int n = nums.length;
	int[] dpArr = new int[n];
	int max = Integer.MIN_VALUE;
	int index1 = 0;
	int index2 = 0;

	for (int i = 0; i < n; i++) {
	    for (int j = i; j < n; j++) {
		if (i == 0) {
		    if (j == 0)
			dpArr[j] = nums[i];
		    else
			dpArr[j] = dpArr[j - 1] + nums[j];
		} else {
		    dpArr[j] = dpArr[j] - nums[i - 1];
		}
		if (dpArr[j] > max) {
		    max = dpArr[j];
		    index1 = i;
		    index2 = j;
		}

	    }
	}

	System.out.println(index1 + "," + index2);
	int ans = 0;
	for (int i = index1; i <= index2; i++)
	    ans += nums[i];
	return ans;

    }

    /**
     * Kadane's algorithm
     * 
     * @param a
     * @param size
     * @return
     */
    static int maxSubArraySum(int a[], int size) {
	int max = a[0];
	int curr_max = a[0];

	for (int i = 1; i < size; i++) {
	    curr_max = Math.max(a[i], curr_max + a[i]);
	    max = Math.max(max, curr_max);
	}
	return max;
    }

}
