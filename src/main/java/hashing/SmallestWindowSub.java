package hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSub {

    public static void main(String[] args) {
	String ret = smallestWindow("whoopiepiesmakemyscalegroan", "roam");
	System.out.println(ret);

    }

    /**
     * Use the two pointer methodology for solving this
     * 
     * @param s
     * @param p
     * @return
     */
    public static String smallestWindow(String s, String p) {
	if (s.length() < p.length())
	    return "-1";

	int left = 0;
	int right = left + p.length();

	Map<Character, Integer> patMap = new HashMap<>();
	for (Character c : p.toCharArray())
	    patMap.put(c, patMap.getOrDefault(c, 0) + 1);

	if (!containsPattern(s, patMap))
	    return "-1";

	String minWindow = "-1";

	while (right < s.length() || left <= s.length() - p.length()) {
	    String subsString = s.substring(left, right);
	    if (containsPattern(subsString, patMap)) {
		if (minWindow.equals("-1") || minWindow.length() > subsString.length())
		    minWindow = subsString;
		left++;
	    } else {
		if (right < s.length())
		    right++;
		else
		    left++;
	    }

	}
	System.out.println(left + "," + right);
	return minWindow;
    }

    private static boolean containsPattern(String subsString, Map<Character, Integer> patMap) {

	Map<Character, Integer> subMap = new HashMap<>();
	for (Character c : subsString.toCharArray())
	    subMap.put(c, subMap.getOrDefault(c, 0) + 1);

	for (Character c : patMap.keySet()) {
	    if (!subMap.containsKey(c) || patMap.get(c) > subMap.get(c))
		return false;
	}

	return true;
    }

}
