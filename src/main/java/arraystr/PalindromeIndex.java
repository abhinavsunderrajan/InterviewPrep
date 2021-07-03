package arraystr;

/**
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * 
 * @author 746310
 *
 */
public class PalindromeIndex {

    public static void main(String[] args) {
	String s = "axca";
	System.out.println(palindromeIndex(s));

    }

    static int palindromeIndex2(String s) {
	int l = s.length();
	int i, j, a, b;
	for (i = 0, j = l - 1; i < l; i++, j--) {
	    if (s.charAt(i) != s.charAt(j))
		break;
	}
	if (i > j)
	    return -1;

	for (a = i + 1, b = j; a < j && b > i + 1; a++, b--) {
	    if (s.charAt(a) != s.charAt(b))
		return j;
	}
	return i;
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
