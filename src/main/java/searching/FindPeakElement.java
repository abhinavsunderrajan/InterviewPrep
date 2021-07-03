package searching;

/**
 * Index of peak element using binary search.
 * 
 * @author 746310
 *
 */
public class FindPeakElement {

    public static void main(String[] args) {
	int[] arr = { 1, 2, 4, 6, 3, 2 - 1, -9, -10, 0 };

	// int[] arr = { 1, 3 };
	System.out.println(findPeakUtil(arr, 0, arr.length - 1, arr.length));

    }

    static int findPeakUtil(int arr[], int low, int high, int n) {
	// Find index of middle element
	// (low + high)/2
	int mid = (high + low) / 2;

	// Compare middle element with its
	// Neighbors (if neighbors exist)
	if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
	    return mid;

	// If middle element is not peak
	// and its left neighbor is
	// greater than it, then left half
	// must have a peak element
	else if (mid > 0 && arr[mid - 1] > arr[mid])
	    return findPeakUtil(arr, low, (mid - 1), n);

	// If middle element is not peak
	// and its right neighbor
	// is greater than it, then right
	// half must have a peak
	// element
	else
	    return findPeakUtil(arr, (mid + 1), high, n);
    }

}
