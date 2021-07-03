package dynamicprogramming;

public class MaxSubArrayProduct {

    public static void main(String[] args) {
	// Kadane algorithm will not work, it will return 3
	int a[] = { -2, 3, -4 };
	System.out.println(maxSubArrayProduct(a));
	System.out.println(findMaxProduct(a));

    }

    /**
     * O(n^2)
     * 
     * @param arr
     * @return
     */
    private static int maxSubArrayProduct(int arr[]) {
	// Initializing result
	int result = arr[0];
	int n = arr.length;

	for (int i = 0; i < n; i++) {
	    int mul = arr[i];
	    // traversing in current subarray
	    for (int j = i + 1; j < n; j++) {
		// updating result every time
		// to keep an eye over the
		// maximum product
		result = Math.max(result, mul);
		mul *= arr[j];
	    }
	    // updating the result for (n-1)th index.
	    result = Math.max(result, mul);
	}
	return result;

    }

    /**
     * O(n) solution The better solution keeps track of both maximum and minimum
     * thus far. Hence if you multiply the next number
     * 
     * @param arr
     * @return
     */
    public static int findMaxProduct(int[] arr) {
	// maintain two variables to store the maximum and minimum product
	// ending at the current index
	int max_ending = 0, min_ending = 0;

	// to store the maximum product subarray found so far
	int max_so_far = 0;

	// traverse the given array
	for (int num : arr) {
	    // you need to keep track of the maximum here because your are updating it in
	    // the next line of the code.
	    int max_ending_prev = max_ending;

	    // update the maximum product ending at the current index
	    max_ending = Integer.max(num, Integer.max(num * max_ending, num * min_ending));

	    // update the minimum product ending at the current index
	    min_ending = Integer.min(num, Integer.min(num * max_ending_prev, num * min_ending));

	    max_so_far = Integer.max(max_so_far, max_ending);
	}

	// return maximum product
	return max_so_far;
    }

}
