package slidingwindow;

/**
 * Notice that sliding windows follow similar patterns of constructing a ruuning
 * sum or sequence.
 * 
 * @author 746310
 *
 */
public class LongestSubString {

    public static void main(String[] args) {
	System.out.println(lengthLongest("pwwkewza"));

    }

    private static int lengthLongest(String s) {
	String runString = "";
	String longest = "";

	for (int i = 0; i < s.length(); i++) {

	    if (i == 0) {
		runString = runString + s.charAt(i);
		continue;
	    }
	    if (runString.contains(s.charAt(i) + "")) {
		int index = 0;

		for (int j = 0; j < runString.length(); j++) {
		    if (runString.charAt(j) == s.charAt(i)) {
			index = j;
			break;
		    }
		}

		if (runString.length() > longest.length())
		    longest = runString;

		runString = runString.substring(index + 1);
	    }
	    runString = runString + s.charAt(i);
	}

	System.out.println(longest + " " + runString);

	return Math.max(longest.length(), runString.length());

    }

}
