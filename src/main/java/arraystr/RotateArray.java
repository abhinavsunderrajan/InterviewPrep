package arraystr;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
	int k = 3;
	int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
	int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
	int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };

	System.out.println(Arrays.toString(arr1));
	System.out.println(Arrays.toString(reverseArray(arr1, 0, arr1.length - 1)));
	System.out.println(Arrays.toString(rotateBubbleSort(arr2, k)));
	System.out.println(Arrays.toString(rotateReversal(arr3, k)));

    }

    /**
     * In place O(n*k)
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int[] rotateBubbleSort(int[] arr, int k) {
	for (int i = 0; i < k; i++)
	    for (int j = arr.length - 1; j > 0; j--) {
		int temp = arr[j];
		arr[j] = arr[j - 1];
		arr[j - 1] = temp;
	    }
	return arr;
    }

    /**
     * in place O(n)
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int[] rotateReversal(int[] arr, int k) {
	int[] arr1 = reverseArray(arr, 0, arr.length - k - 1);
	int[] arr2 = reverseArray(arr1, arr.length - k, arr.length - 1);
	int[] arr3 = reverseArray(arr2, 0, arr.length - 1);
	return arr3;
    }

    /**
     * Two pointer method for array reversal between left and right indices.
     * 
     * @param arr
     * @return
     */
    private static int[] reverseArray(int[] arr, int left, int right) {
	int index1 = left;
	int index2 = right;
	while (index2 > index1) {
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	    index1++;
	    index2--;
	}
	return arr;

    }

}
