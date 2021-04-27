package arraystr;

import java.util.Arrays;

/**
 * Sliding window technique.
 * {@link https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1}
 * 
 * @author 746310
 *
 */
public class CountTriplet {

    public static void main(String[] args) {
	int arr[] = { 1, 5, 3, 2 };
	countTriplet(arr, arr.length);

    }

    private static int countTriplet(int arr[], int n) {
	Arrays.sort(arr);

	int count = 0;
	int trial = 1;

	while (trial <= n - 2) {

	    int start = 0;
	    int end = n - trial - 1;
	    while (start < end) {
		if (arr[start] + arr[end] == arr[n - trial]) {
		    count++;
		    start++;
		    end--;
		} else if (arr[start] + arr[end] < arr[n - trial]) {
		    start++;
		} else {
		    end--;
		}

	    }

	    trial++;

	}

	return count;
    }

}
