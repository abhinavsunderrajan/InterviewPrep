package searching;

public class BinarySearch {

    public static void main(String[] args) {
	int arr[] = { 1, 3 };
	System.out.println(binarysearch(arr, arr.length - 1, 3));

    }

    private static int binarysearch(int arr[], int n, int k) {
	return search(arr, k, 0, n);
    }

    private static int search(int[] arr, int k, int low, int high) {
	if (low > high)
	    return -1;

	int mid = (low + high) / 2;
	if (arr[mid] == k)
	    return mid;
	else if (arr[mid] > k)
	    return search(arr, k, low, mid - 1);
	else
	    return search(arr, k, mid + 1, high);
    }

}
