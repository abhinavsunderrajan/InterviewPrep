package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
	int nums[] = { -2, 0, 0, 2, 2 };
	System.out.println(threeSum(nums, 0));

    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {

	Arrays.sort(nums);
	List<List<Integer>> ret = new ArrayList<>();
	for (int i = 0; i < nums.length - 2; i++) {

	    int low = i + 1;
	    int high = nums.length - 1;
	    while (low < high) {
		List<Integer> ls = new ArrayList<>();
		if (nums[i] + nums[low] + nums[high] == target) {
		    ls.add(nums[i]);
		    ls.add(nums[low]);
		    ls.add(nums[high]);
		    ret.add(ls);
		    low++;
		    high--;
		} else if (nums[i] + nums[low] + nums[high] < target) {
		    low++;
		} else {
		    high--;
		}
	    }

	}

	return ret;
    }

}
