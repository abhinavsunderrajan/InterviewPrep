package arraystr;

import java.util.HashMap;
import java.util.Map;

public class StringAnangram {

    public static void main(String[] args) {
	String a = "forgeeksgeeksa";
	String b = "geeksforgeeks;";
	System.out.println(isAnagram(a, b));
	System.out.println(isAnagramBit(a, b));

    }

    private static boolean isAnagramBit(String a, String b) {

	if (a.length() != b.length())
	    return false;

	int countA[] = new int[128];
	int countB[] = new int[128];

	for (char c : a.toCharArray())
	    countA[c]++;

	for (char c : b.toCharArray())
	    countB[c]++;

	for (int i = 0; i < 128; i++)
	    if (countA[i] != countB[i])
		return false;
	return true;

    }

    private static boolean isAnagram(String a, String b) {
	if (a.length() != b.length())
	    return false;

	Map<Character, Integer> charSet = new HashMap<>();
	for (char c : a.toCharArray()) {
	    if (charSet.containsKey(c)) {
		int count = charSet.get(c);
		charSet.put(c, count + 1);
	    } else {
		charSet.put(c, 1);
	    }
	}

	for (char c : b.toCharArray()) {
	    if (!charSet.containsKey(c))
		return false;
	    int count = charSet.get(c);
	    if (count == 0)
		return false;
	    charSet.put(c, count - 1);
	}

	for (char c : charSet.keySet())
	    if (charSet.get(c) != 0)
		return false;
	return true;

    }

}
