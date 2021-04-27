package sorting;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=JU767SDMDvA
 * 
 * @author 746310
 *
 */
public class InsertionSort {

    public static void main(String[] args) {
	int arr[] = { 3, 4, 7, 5, 6, 2, 1 };
	insertionSort(arr);
	System.out.println(Arrays.toString(arr));

    }

    private static void insertionSort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (arr[i] < arr[j]) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}

	    }
	}

    }

}
