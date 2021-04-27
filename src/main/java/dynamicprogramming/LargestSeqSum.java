package dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://www.youtube.com/watch?v=2MmGzdiKR9Y
 * 
 * @author 746310
 *
 */
public class LargestSeqSum {

    /**
     * O(n)
     * 
     * @param a
     * @param size
     * @return
     */
    static int maxSubArraySum(int a[], int size) {
	int max_so_far = a[0];
	int curr_max = a[0];

	for (int i = 1; i < size; i++) {
	    // The statement below basically tells you whether you should start the new
	    // subsequence at a[i] or extend the previous one. You start a new only if the
	    // new one at a[i] is bigger that than the previous running sum.
	    curr_max = Math.max(a[i], curr_max + a[i]);
	    max_so_far = Math.max(max_so_far, curr_max);
	}
	return max_so_far;
    }

    /**
     * This one is O(n^2)
     * 
     * @param a
     * @param size
     * @return
     */
    static int maxSubBruteForce(int a[], int size) {
	int max = Integer.MIN_VALUE;
	int left = 0;
	int right = 0;
	for (int i = 0; i < size; i++) {
	    int sum = 0;
	    for (int j = i; j < size; j++) {
		sum += a[j];
		if (sum > max) {
		    max = sum;
		    left = i;
		    right = j;
		}
	    }
	}

	System.out.println(left + " " + right);

	return max;
    }

    /* Driver program to test maxSubArraySum */
    public static void main(String[] args) {
	int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
	int n = a.length;
	int max_sum = maxSubArraySum(a, n);
	System.out.println("Maximum contiguous sum optimal is " + max_sum);
	max_sum = maxSubBruteForce(a, n);
	System.out.println("Maximum contiguous brute force is " + max_sum);

    }

}
