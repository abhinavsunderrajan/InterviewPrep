package arraystr;

public class LongestCommonSubStr {

    public static void main(String[] args) {
	String lcsubstr = longestCommonSubstr("ABCDGH", "ACDGHR");
	System.out.println(lcsubstr);
    }

    public static String longestCommonSubstr(String S1, String S2) {

	String longestSubStr = "";
	String small = S1.length() <= S2.length() ? S1 : S2;
	String big = S1.length() > S2.length() ? S1 : S2;

	for (int i = 1; i <= small.length(); i++) {
	    for (int j = 0; j <= small.length() - i; j++) {
		String subStr = small.substring(j, j + i);
		if (big.contains(subStr) && longestSubStr.length() < subStr.length())
		    longestSubStr = subStr;

	    }
	}

	return longestSubStr;

    }

}
