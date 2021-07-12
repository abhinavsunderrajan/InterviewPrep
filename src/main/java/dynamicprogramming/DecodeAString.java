package dynamicprogramming;

import java.util.Arrays;

/**
 * Knapsack (channel) and Back to Back SWE are two of the best for dynamic
 * programming. Number of ways to decode a numeric string into upper-case
 * alphabets. {@link https://www.youtube.com/watch?v=W4rYz-kd-cY}
 * 
 * @author 746310
 *
 */
public class DecodeAString {

    public static void main(String[] args) {
	// can be decoded as BBF, BZ or VF
	String str = "21212";
	System.out.println(numOfWaysBottomUp(str));
	System.out.println(numOfWaysRecursive(str, str.length() - 1));

    }

    private static int numOfWaysRecursive(String str, int i) {
	if (i == 0) {
	    if (str.charAt(0) == '0')
		return 0;
	    else
		return 1;
	}

	if (i == -1)
	    return 1;

	if (str.charAt(i) == '0') {
	    if (Integer.parseInt(str.charAt(i - 1) + "") > 2)
		return 0;
	    else
		numOfWaysRecursive(str, i - 2);
	}

	int twoDigit = Integer.parseInt(str.charAt(i - 1) + "" + str.charAt(i));
	if (twoDigit <= 26)
	    return numOfWaysRecursive(str, i - 1) + numOfWaysRecursive(str, i - 2);
	else
	    return numOfWaysRecursive(str, i - 1);
    }

    private static int numOfWaysBottomUp(String str) {
	if (str.charAt(0) == '0')
	    return 0;

	// each element of the dp array represents the number of ways to decode a string
	// of length index
	int[] dp = new int[str.length() + 1];
	// 0 length string can be decoded in 1 way i.e. do nothing.
	dp[0] = 1;
	dp[1] = 1;

	for (int i = 2; i <= str.length(); i++) {
	    int oneDigit = Integer.parseInt(str.charAt(i - 1) + "");
	    boolean isZero = true;
	    if (oneDigit > 0) {
		dp[i] += dp[i - 1];
		isZero = false;

	    }

	    int twoDigit = Integer.parseInt(str.charAt(i - 2) + "" + str.charAt(i - 1));
	    if (twoDigit >= 10 && twoDigit <= 26)
		dp[i] += dp[i - 2];
	    else {
		if (isZero)
		    return 0;
	    }
	}
	System.out.println(Arrays.toString(dp));
	return dp[str.length()];
    }

}
