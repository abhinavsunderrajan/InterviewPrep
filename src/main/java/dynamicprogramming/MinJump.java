package dynamicprogramming;

/**
 * https://afteracademy.com/blog/minimum-number-of-jumps-to-reach-end
 * 
 * @author 746310
 *
 */
public class MinJump {

    public static void main(String[] args) {
	int arr[] = { 2, 3, 1, 1, 4 };
	int arr1[] = { 2, 1, 0, 3 };
	int start = 0;
	System.out.println(minJumpHelper(arr, start));
	int cache[] = new int[arr.length];
	System.out.println(minJumpHelperCache(arr, start, cache));
	System.out.println(jump(arr, arr.length));
	System.out.println(minJumps(arr, arr.length));

    }

    private static int minJumpHelper(int[] arr, int start) {

	if (start >= arr.length - 1)
	    return 0;
	if (arr[start] == 0)
	    return 10000;
	else {
	    int numSteps = arr[start];
	    int min = 10000;
	    for (int count = 1; count <= numSteps; count++) {
		if (start + count >= arr.length - 1)
		    return 1;
		int next = 1 + minJumpHelper(arr, (start + count));
		if (next <= min)
		    min = next;

	    }
	    return min;

	}
    }

    private static int minJumpHelperCache(int[] arr, int start, int cache[]) {

	if (start >= arr.length - 1)
	    return 0;
	if (arr[start] == 0)
	    return 10000;
	else {
	    int numSteps = arr[start];
	    int min = 10000;
	    for (int count = 1; count <= numSteps; count++) {
		if (start + count >= arr.length - 1)
		    return 1;
		else {
		    if (cache[start + count] == 0)
			cache[start + count] = minJumpHelperCache(arr, (start + count), cache);
		    int next = 1 + cache[start + count];
		    if (next <= min)
			min = next;
		}

	    }
	    return min;

	}

    }

    private static int jump(int[] nums, int n) {
	int jumps[] = new int[n];
	jumps[0] = 0;
	for (int i = 0; i < n - 1; i++) {
	    int maxJump = nums[i];
	    int numJumps = Math.min(i + maxJump, n - 1);
	    int j = i + 1;
	    while (j <= numJumps) {
		if (jumps[j] > 0)
		    jumps[j] = Math.min(jumps[j], jumps[i] + 1);
		else
		    jumps[j] = jumps[i] + 1;
		j++;
	    }
	}

	return jumps[n - 1];
    }

    private static int minJumps(int[] nums, int n) {
	if (nums[0] == 0)
	    return -1;

	int previous = 0;
	int current = 0;
	int jumps = 0;
	for (int i = 0; i < n; i++) {
	    if (i > previous) {
		jumps = jumps + 1;
		previous = current;
	    }
	    current = Math.max(current, i + nums[i]);
	}

	if (jumps == 0)
	    return -1;
	else
	    return jumps;
    }

}
