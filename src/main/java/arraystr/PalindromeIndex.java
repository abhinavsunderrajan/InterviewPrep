package arraystr;

/**
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * 
 * @author 746310
 *
 */
public class PalindromeIndex {

    public static void main(String[] args) {
	String s = "axcca";
	System.out.println(palindromeIndex(s));
	System.out.println(palindromeIndexFast(s));

    }

    static int palindromeIndexFast(String s) {
	char[] arr = s.toCharArray();
	int low = 0;
	int high = arr.length - 1;
	while (low < high) {
	    if (arr[low] == arr[high]) {
		low++;
		high--;
	    } else {
		String sub1 = s.substring(low, high);
		if (isPalin(sub1))
		    return (high);
		else
		    return (low);
	    }
	}

	return -1;

    }

    /**
     * Remove each element and check if substring is a palindrome. This is slow.
     * 
     * @param s
     * @return
     */
    static int palindromeIndex(String s) {

	if (s.length() == 1 || isPalin(s))
	    return -1;

	if (s.length() == 2 && !isPalin(s))
	    return 0;

	for (int i = 0; i < s.length(); i++) {
	    String sub = s.substring(0, i) + s.substring(i + 1);
	    // System.out.println(sub);
	    if (isPalin(sub))
		return i;

	}

	return -1;

    }

    private static boolean isPalin(String sub) {
	if (sub.length() == 1)
	    return true;
	char[] arr = sub.toCharArray();
	int low = 0;
	int high = sub.length() - 1;
	while (low < high) {
	    if (arr[low] != arr[high])
		return false;
	    low++;
	    high--;

	}
	return true;
    }

}
