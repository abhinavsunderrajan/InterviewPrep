package dynamicprogramming;

import java.util.Arrays;

/**
 * Number of ways to decode a numeric string into uppercase alphabets.
 * 
 * @author 746310
 *
 */
public class DecodeAString {

    public static void main(String[] args) {
	// can be decoded as BBF, BZ or VF
	String str = "22612";
	System.out.println(numOfWaysBottomUp(str));
	System.out.println(numOfWaysTopDown(str));

    }

    private static int numOfWaysTopDown(String s) {

	int[] dp = new int[s.length()];
	Arrays.fill(dp, -1);

	return numDecodings(s, 0, dp);
    }

    public static int numDecodings(String s, int decodePointer, int[] dp) {
	if (decodePointer >= s.length()) {
	    return 1; // "" is a valid decomposition
	}

	// Subproblem already solved and has a value
	if (dp[decodePointer] > -1) {
	    return dp[decodePointer];
	}

	int totalDecompositions = 0;
	for (int i = 1; i <= 2; i++) {
	    if (decodePointer + i <= s.length()) {
		String snippet = s.substring(decodePointer, decodePointer + i);

		if (isValid(snippet)) {
		    totalDecompositions += numDecodings(s, decodePointer + i, dp);
		}
	    }
	}

	// Record subproblem answer to decompositions from (decodePointer)...(s.length -
	// 1)
	dp[decodePointer] = totalDecompositions;

	return dp[decodePointer];
    }

    private static boolean isValid(String s) {
	if (s.length() == 0 || s.charAt(0) == '0') {
	    return false;
	}

	int value = Integer.parseInt(s);

	return value >= 1 && value <= 26;
    }

    private static int numOfWaysBottomUp(String str) {
	if (str.charAt(0) == 0)
	    return 0;

	// each element of the dp array represents the number of ways to decode a string
	// of length index
	int[] dp = new int[str.length() + 1];
	// 0 length string can be decoded in 1 way i.e. do nothing.
	dp[0] = 1;
	dp[1] = 1;

	for (int i = 2; i <= str.length(); i++) {
	    int oneDigit = Integer.parseInt(str.charAt(i - 1) + "");
	    if (oneDigit > 0)
		dp[i] = dp[i - 1] + 1;

	    int twoDigit = Integer.parseInt(str.charAt(i - 2) + "" + str.charAt(i - 1));
	    if (twoDigit >= 10 && twoDigit <= 26)
		dp[i] = dp[i - 1] + 1;
	}

	return dp[str.length()];
    }

}
