package arraystr;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
	int arr1[] = { 1, 3, 5, 7, 9, 11 };
	int arr2[] = { 2, 4, 6, 8 };
	int arr3[] = new int[arr1.length + arr2.length];

	int index1 = 0;
	int index2 = 0;
	int index3 = 0;

	while (index1 < arr1.length && index2 < arr2.length) {
	    if (arr1[index1] < arr2[index2]) {
		arr3[index3++] = arr1[index1++];
	    } else {
		arr3[index3++] = arr2[index2++];
	    }

	}

	while (index2 < arr2.length) {
	    arr3[index3++] = arr2[index2++];
	}

	while (index1 < arr1.length) {
	    arr3[index3++] = arr1[index1++];
	}

	System.out.println(Arrays.toString(arr1));
	System.out.println(Arrays.toString(arr2));
	System.out.println(Arrays.toString(arr3));
    }

}
