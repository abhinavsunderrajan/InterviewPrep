package arraystr;

import java.util.ArrayList;

public class SubArraySum {

    public static void main(String[] args) {
	int arr[] = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
		154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };

	System.out.println(subarraySum(arr, 468));

    }

    private static ArrayList<Integer> subarraySum(int[] arr, int s) {

	ArrayList<Integer> startEnd = new ArrayList<>();

	int start = 0;
	int end = 0;
	int cumSum = 0;
	while (end < arr.length) {
	    cumSum += arr[end];
	    if (cumSum == s) {
		startEnd.add(start + 1);
		startEnd.add(end + 1);
		return startEnd;
	    } else if (cumSum < s) {
		end++;

	    } else {
		while (cumSum > s && start < arr.length) {
		    cumSum -= arr[start];
		    start++;
		}

		if (cumSum == s) {
		    startEnd.add(start + 1);
		    startEnd.add(end + 1);
		    return startEnd;
		}

		if (start > end)
		    end = start;
		else
		    end++;
	    }

	}

	startEnd.add(-1);
	return startEnd;

    }
}
