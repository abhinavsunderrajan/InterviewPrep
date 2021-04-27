package arraystr;

import java.util.Arrays;

public class SignatureCounts {

    public static void main(String[] args) {
	int arr[] = { 2, 1 };
	int counts[] = findSignatureCounts(arr);
	System.out.println(Arrays.toString(counts));

    }

    private static boolean arrEqual(int a[], int b[]) {
	for (int i = 0; i < a.length; i++) {
	    if (a[i] != b[i])
		return false;
	}

	return true;
    }

    private static int[] findSignatureCounts(int[] arr) {
	int[] b = new int[arr.length];
	int[] ret = new int[arr.length];
	do {
	    for (int i = 0; i < arr.length; i++) {
		int index = arr[i];
		b[index - 1] = arr[i];
		ret[index - 1]++;
	    }
	} while (!arrEqual(arr, b));

	return ret;
    }

}
