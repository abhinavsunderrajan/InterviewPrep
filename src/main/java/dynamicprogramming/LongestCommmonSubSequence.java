package dynamicprogramming;

/**
 * {@link https://www.youtube.com/watch?v=sSno9rV8Rhg}
 * 
 * @author 746310
 *
 */
public class LongestCommmonSubSequence {
    private static String s1 = "ABCDGH";
    private static String s2 = "AEDFHR";

    public static void main(String[] args) {
	int cache[][] = new int[s1.length() + 1][s2.length() + 1];
	int longest = lcs(s1.toCharArray(), s2.toCharArray(), cache, 0, 0);
	System.out.println(longest);

    }

    private static int lcs(char[] a, char[] b, int cache[][], int i, int j) {
	if (i == a.length || j == b.length)
	    return 0;
	if (a[i] == b[j]) {
	    if (cache[i + 1][j + 1] > 0)
		return 1 + cache[i + 1][j + 1];
	    else {
		cache[i + 1][j + 1] = lcs(a, b, cache, i + 1, j + 1);
		return 1 + cache[i + 1][j + 1];
	    }

	} else {

	    int res1 = cache[i + 1][j] > 0 ? cache[i + 1][j] : lcs(a, b, cache, i + 1, j);
	    int res2 = cache[i][j + 1] > 0 ? cache[i][j + 1] : lcs(a, b, cache, i, j + 1);

	    cache[i + 1][j] = res1;
	    cache[i][j + 1] = res2;
	    return Math.max(res1, res2);

	}

    }

}
