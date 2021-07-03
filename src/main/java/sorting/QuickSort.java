package sorting;

import java.util.Arrays;

/**
 * {@link https://www.youtube.com/watch?v=7h1s2SojIRw&t=324s}
 * 
 * @author 746310
 *
 */
public class QuickSort {

    public static void main(String[] args) {
	int arr[] = { 10, 16, 8, 12, 15, 5, 3, 9, 1, Integer.MAX_VALUE };
	quickSort(arr, 0, arr.length - 1);
	System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
	if (low < high) {
	    int partitionIndex = partition(arr, low, high);
	    quickSort(arr, low, partitionIndex);
	    quickSort(arr, partitionIndex + 1, high);
	}

    }

    /**
     * The partitioning procedure. Increment i until you find an element greater
     * than pivot. Decrement j until you find and element smaller than or equal
     * pivot. Then interchange arr[i] and arr[j].
     * 
     * Exchange the element in the newly found pivot position with that of the
     * element in the old pivot position before returning the new pivot position.
     * 
     * @param arr
     * @param low
     * @param high
     * @return the new pivot position which is j.
     * 
     */
    private static int partition(int[] arr, int low, int high) {
	int pivot = arr[low];
	int i = low;
	int j = high;
	while (i < j) {

	    do {
		i++;
	    } while (arr[i] <= pivot);

	    do {
		j--;
	    } while (arr[j] > pivot);

	    if (i < j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	    }

	}

	int temp = arr[low];
	arr[low] = arr[j];
	arr[j] = temp;

	return j;
    }

}
