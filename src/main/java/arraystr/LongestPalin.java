package arraystr;

public class LongestPalin {

    public static void main(String[] args) {
	String s = "aaaabbaa";
	System.out.println(isPalin("madam"));
	System.out.println(longestPalin(s));

    }

    private static String longestPalin(String s) {
	int start = 0;
	int maxLength = 1;
	boolean dp[][] = new boolean[s.length()][s.length()];

	for (int i = 0; i < s.length(); ++i)
	    dp[i][i] = true;

	// check for sub-string of length 2.
	for (int i = 0; i < s.length() - 1; ++i) {
	    if (s.charAt(i) == s.charAt(i + 1)) {
		dp[i][i + 1] = true;
		start = i;
		maxLength = 2;
	    }
	}

	// Check for lengths greater than 2.
	// k is length of substring
	for (int k = 3; k <= s.length(); ++k) {

	    // Fix the starting index
	    for (int i = 0; i < s.length() - k + 1; ++i) {
		// Get the ending index of substring from
		// starting index i and length k
		int j = i + k - 1;

		// checking for sub-string from ith index to
		// jth index iff str.charAt(i+1) to
		// str.charAt(j-1) is a palindrome
		if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
		    dp[i][j] = true;

		    if (k > maxLength) {
			start = i;
			maxLength = k;
		    }
		}
	    }
	}
	System.out.print("Longest palindrome substring is; ");
	return s.substring(start, start + maxLength - 1);

    }

    private static boolean isPalin(String s) {
	if (s.length() == 1)
	    return true;

	boolean isPalin = true;
	int i = 0;
	int j = s.length() - 1;
	while (i < j) {
	    if (s.charAt(i) != s.charAt(j)) {
		isPalin = false;
		break;
	    } else {
		i++;
		j--;
	    }
	}
	return isPalin;

    }

}
