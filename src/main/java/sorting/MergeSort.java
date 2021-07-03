package sorting;

import java.util.Arrays;

/**
 * Based on Abdul Bari's lecture
 * 
 * @author 746310
 *
 */
public class MergeSort {

    public static void main(String[] args) {
	int arr[] = { 9, 3, 7, 5, 6, 4, 8, 2 };
	mergeSort(arr, 0, arr.length - 1);
	System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergeSort(arr, low, mid);
	    mergeSort(arr, mid + 1, high);
	    mergeTwoArrays(arr, low, mid, high);
	    System.out.println(low + ", " + high);
	    System.out.println(Arrays.toString(arr));
	}

    }

    private static void mergeTwoArrays(int arr[], int low, int mid, int high) {

	int arr1[] = Arrays.copyOfRange(arr, low, mid + 1);
	int arr2[] = Arrays.copyOfRange(arr, mid + 1, high + 1);
	int index1 = 0;
	int index2 = 0;
	int index3 = low;

	while (index1 < arr1.length && index2 < arr2.length) {
	    if (arr1[index1] < arr2[index2])
		arr[index3++] = arr1[index1++];
	    else
		arr[index3++] = arr2[index2++];

	}

	while (index2 < arr2.length)
	    arr[index3++] = arr2[index2++];

	while (index1 < arr1.length)
	    arr[index3++] = arr1[index1++];

    }

}
