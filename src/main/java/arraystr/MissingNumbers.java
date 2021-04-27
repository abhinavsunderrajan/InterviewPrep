package arraystr;

import java.util.ArrayList;
import java.util.List;

/**
 * Missing numbers solution without extra space and O(n) time.
 * {@link https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/}
 * 
 * @author 746310
 *
 */
public class MissingNumbers {

    public static void main(String[] args) {
	int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
	System.out.println(missingNumbers(nums));
    }

    /**
     * Make use of the fact that numbers are between 1 and n. Convert indices from 0
     * through to n-1.convert to 0 index that's why say 4 corresponds to index 3
     * also do not change the number at the index just change the sign at it. So
     * that you know what exists in the seconds pass.
     * 
     * @param nums
     * @return
     */
    private static List<Integer> missingNumbers(int nums[]) {
	List<Integer> missingNumbers = new ArrayList<Integer>();
	for (int i = 0; i < nums.length; i++) {

	    int index = Math.abs(nums[i]) - 1;
	    if (nums[index] < 0) {
		continue;
	    }
	    nums[index] = -nums[index];
	}
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] >= 0) {
		missingNumbers.add(i + 1);
	    }
	}
	return missingNumbers;

    }

}
