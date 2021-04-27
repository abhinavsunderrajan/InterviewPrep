package searching;

/**
 * {@link https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/}
 * The log(n) solution is quite hard to implement in 15 minutes, for me
 * impossible.
 * 
 * @author 746310
 *
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
	int ar1[] = { 1, 3 };
	int ar2[] = { 2 };
	System.out.println(getMedian(ar1, ar2, ar1.length, ar2.length));

    }

    /**
     * This solution is O(m+n)
     * 
     * @param ar1
     * @param ar2
     * @param n
     * @param m
     * @return
     */
    static double getMedian(int ar1[], int ar2[], int n, int m) {
	int medIndex = 0;

	int mid = 0;
	int beforeMid = 0;

	int i = 0;
	int j = 0;
	int last = 0;
	while (i < n && j < m) {
	    if (ar1[i] < ar2[j]) {
		last = ar1[i];
		i++;
	    } else {
		last = ar2[j];
		j++;
	    }

	    if (medIndex == (m + n) / 2 - 1)
		beforeMid = last;

	    if (medIndex == (m + n) / 2)
		mid = last;
	    medIndex++;
	}

	while (i < n) {
	    if (medIndex == (m + n) / 2 - 1)
		beforeMid = ar1[i];

	    if (medIndex == (m + n) / 2)
		mid = ar1[i];
	    medIndex++;
	    i++;
	}

	while (j < n) {
	    if (medIndex == (m + n) / 2 - 1)
		beforeMid = ar2[j];

	    if (medIndex == (m + n) / 2)
		mid = ar2[j];
	    medIndex++;
	    j++;
	}

	if ((m + n) % 2 == 1)
	    return (double) mid;
	else
	    return (mid + beforeMid) / 2.0;

    }
}
