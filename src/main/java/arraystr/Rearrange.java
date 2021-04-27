package arraystr;

import java.util.Arrays;

public class Rearrange {

    public static void main(String[] args) {
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	rearrange(arr, arr.length);
	System.out.println(Arrays.toString(arr));

    }

    public static void rearrange(int arr[], int n) {

	int evenIndex = 0;
	int maxElem = arr[n - 1];
	for (int i = n - 1; i >= n / 2; i--) {
	    if (i == evenIndex) {
		evenIndex += 2;
		continue;
	    }
	    if (evenIndex > n / 2) {
		int oldNum = arr[i] % maxElem;
		int newNum = arr[i] / maxElem;
		arr[evenIndex] = oldNum;
		arr[i] = newNum;
	    } else {
		arr[evenIndex] = maxElem * arr[i] + arr[evenIndex];
	    }

	    evenIndex += 2;
	}

	System.out.println(Arrays.toString(arr));

	int oddIndex = n % 2 == 0 ? n - 1 : n - 2;
	for (int i = n / 2 - 1; i >= 0; i--) {

	    // recover the two numbers
	    if (i % 2 == 0) {
		int newNum = arr[i] / maxElem;
		int oldNum = arr[i] % maxElem;
		arr[i] = newNum;
		arr[oddIndex] = oldNum;
	    } else {

		arr[oddIndex] = arr[i];
	    }

	    oddIndex = oddIndex - 2;
	}

    }

}
