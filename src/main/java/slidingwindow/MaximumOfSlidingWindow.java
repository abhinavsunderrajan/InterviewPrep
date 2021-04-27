package slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfSlidingWindow {

    public static void main(String[] args) {
	int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
	System.out.println(Arrays.toString(maxSlidingWindowSlow(nums, 3)));

	printMax(nums, nums.length, 3);
	System.out.println(Arrays.toString(findKMaxElement(nums, 3, nums.length)));

    }

    /**
     * creating the max heap ,to get max element always
     * 
     * @param arr
     * @param k
     * @param n
     * @return
     */
    static int[] findKMaxElement(int[] arr, int k, int n) {
	PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

	int[] res = new int[n - k + 1];
	int i = 0;

	for (; i < k; i++)
	    queue.add(arr[i]);

	// adding the maximum element among first k elements
	res[0] = (queue.peek());

	// removing the first element of the array
	queue.remove(arr[0]);

	for (; i < n; i++) {

	    // adding the new element in the window
	    queue.add(arr[i]);
	    // finding & adding the max element in the
	    // current sliding window
	    res[i - k + 1] = queue.peek();
	    // finally removing the first element from front
	    // end of queue
	    queue.remove(arr[i - k + 1]);
	}

	return res;

// this code is Contributed by Pradeep Mondal P
    }

    // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size k
    static void printMax(int arr[], int n, int k) {

	// Create a Double Ended Queue, Qi
	// that will store indexes of array elements
	// The queue will store indexes of
	// useful elements in every window and it will
	// maintain decreasing order of values
	// from front to rear in Qi, i.e.,
	// arr[Qi.front[]] to arr[Qi.rear()]
	// are sorted in decreasing order
	Deque<Integer> Qi = new LinkedList<Integer>();

	/*
	 * Process first k (or first window) elements of array
	 */
	int i;
	for (i = 0; i < k; ++i) {

	    // For every element, the previous
	    // smaller elements are useless so
	    // remove them from Qi
	    while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
		// Remove from rear
		Qi.removeLast();
	    }

	    // Add new element at rear of queue
	    Qi.addLast(i);
	}

	// Process rest of the elements,
	// i.e., from arr[k] to arr[n-1]
	for (; i < n; ++i) {

	    // The element at the front of the
	    // queue is the largest element of
	    // previous window, so print it
	    System.out.print(arr[Qi.peek()] + " ");

	    // Remove the elements which
	    // are out of this window
	    while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
		Qi.removeFirst();

	    // Remove all elements smaller
	    // than the currently
	    // being added element (remove
	    // useless elements)
	    while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
		Qi.removeLast();

	    // Add current element at the rear of Qi
	    Qi.addLast(i);
	}

	// Print the maximum element of last window
	System.out.print(arr[Qi.peek()]);
    }

    /**
     * Brute force slow. O(n*k)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int[] maxSlidingWindowSlow(int[] nums, int k) {
	int n = nums.length;
	int maxes[] = new int[n - k + 1];

	Queue<Integer> q = new LinkedList<>();
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < k; i++) {
	    q.add(nums[i]);
	    if (nums[i] > max)
		max = nums[i];
	}

	maxes[0] = max;

	int index = 1;
	for (int i = k; i < n; i++) {
	    int out = q.poll();
	    q.add(nums[i]);
	    if (nums[i] > max) {
		max = nums[i];
	    } else {
		max = getMax(q);
	    }

	    maxes[index++] = max;

	}
	return maxes;
    }

    private static int getMax(Queue<Integer> q) {
	int max = Integer.MIN_VALUE;
	for (int val : q) {
	    if (val > max)
		max = val;
	}

	return max;
    }

}
