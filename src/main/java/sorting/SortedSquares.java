package sorting;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
	int nums[] = { -7, -3, 2, 3, 11 };
	System.out.println(Arrays.toString(sortedSquares(nums)));

    }

    public static int[] sortedSquares(int[] nums) {
	int posIndex = 0;
	for (int num : nums) {
	    if (num >= 0) {
		break;
	    }
	    posIndex++;
	}

	for (int i = 0; i < nums.length; i++)
	    nums[i] = nums[i] * nums[i];

	int[] sorted = merge(nums, posIndex);
	return sorted;

    }

    private static int[] merge(int[] nums, int posIndex) {
	int[] sorted = new int[nums.length];
	int low = posIndex;
	int high = posIndex - 1;
	int index = 0;
	while (low < nums.length && high >= 0) {
	    if (nums[low] < nums[high]) {
		sorted[index++] = nums[low++];
	    } else {
		sorted[index++] = nums[high--];
	    }
	}

	while (low < nums.length) {
	    sorted[index++] = nums[low++];
	}

	while (high >= 0)
	    sorted[index++] = nums[high--];

	return sorted;
    }

}
