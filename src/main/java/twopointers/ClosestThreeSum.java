package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestThreeSum {
    public static void main(String[] args) {
	int[] nums = { 1, 1, -1, -1, 3 };
	System.out.println(closestThreeSum(nums, -1));
    }

    private static int closestThreeSum(int[] nums, int target) {
	Arrays.sort(nums);
	List<Integer> ls = new ArrayList<>();
	int min = Integer.MAX_VALUE;
	int ans = 1;
	for (int i = 0; i < nums.length - 2; i++) {
	    int low = i + 1;
	    int high = nums.length - 1;
	    while (low < high) {
		int threeSum = nums[i] + nums[low] + nums[high];
		if (Math.abs(threeSum - target) < min) {
		    min = Math.abs(threeSum - target);
		    ls.clear();
		    ls.add(nums[i]);
		    ls.add(nums[low]);
		    ls.add(nums[high]);
		    ans = threeSum;
		}

		if (threeSum < target)
		    ++low;
		else
		    --high;

	    }

	}
	System.out.println(ls);
	return ans;
    }
}
