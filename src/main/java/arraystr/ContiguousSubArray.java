package arraystr;

import java.util.Arrays;

public class ContiguousSubArray {

    public static void main(String[] args) {
	int arr[] = { 3, 4, 1, 6, 2 };
	System.out.println(Arrays.toString(countSubarrays(arr)));

    }

    private static void reverseArr(int[] rev) {
	int low = 0;
	int high = rev.length - 1;
	while (low < high) {
	    int temp = rev[low];
	    rev[low] = rev[high];
	    rev[high] = temp;
	    low++;
	    high--;
	}
    }

    private static int[] countSubarrays(int[] arr) {
	int rev[] = Arrays.copyOfRange(arr, 0, arr.length);
	reverseArr(rev);

	int max = Integer.MIN_VALUE;
	int maxI = -1;
	int counts[] = new int[arr.length];

	int maxRev = Integer.MIN_VALUE;
	int maxIRev = -1;
	int countsRev[] = new int[arr.length];

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] > max) {
		max = arr[i];
		maxI = i;
		counts[i] = i;
	    } else {
		for (int j = i - 1; j > maxI; j--) {
		    if (arr[j] < arr[i])
			counts[i]++;
		    else
			break;
		}
	    }

	    if (rev[i] > maxRev) {
		maxRev = rev[i];
		maxIRev = i;
		countsRev[i] = i;
	    } else {
		for (int j = i - 1; j > maxIRev; j--) {
		    if (rev[j] < rev[i])
			countsRev[i]++;
		    else
			break;
		}
	    }
	}
	int low = 0;
	int high = counts.length - 1;
	while (high >= 0) {
	    counts[low] += countsRev[high] + 1;
	    low++;
	    high--;
	}

	return counts;

    }
}
