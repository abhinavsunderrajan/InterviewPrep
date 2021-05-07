package arraystr;

import java.util.Arrays;
import java.util.Random;

/**
 * Second facebook failure :(
 * 
 * Sample k numbers from a integer array without replacement. Numbers are
 * unique.
 * 
 * @author 746310
 *
 */
public class RandomSamplingWithoutReplacement {
    private static Random random = new Random();

    public static void main(String[] args) {
	int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	System.out.println(Arrays.toString(sampleK(nums, 5)));
	System.out.println(Arrays.toString(nums));
    }

    private static int[] sampleK(int nums[], int k) {

	int ret[] = new int[k];
	int n = nums.length;
	int index = 0;
	while (index < k) {
	    int randIndex = random.nextInt(n);
	    ret[index] = nums[randIndex];
	    int temp = nums[randIndex];
	    nums[randIndex] = nums[n - 1];
	    nums[n - 1] = temp;
	    n--;
	    index++;
	}

	return ret;

    }

}
