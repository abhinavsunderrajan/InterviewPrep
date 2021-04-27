package arraystr;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Same logic as power set
 * 
 * @author 746310
 *
 */
public class GetNearbyStrings {

    private static Map<Character, Set<Character>> nearby = new LinkedHashMap<>();
    private static Random r = new Random(108);

    private static void generateNearBy(String example) {
	for (int i = 0; i < example.length(); i++) {
	    Set<Character> s = new LinkedHashSet<>();
	    char c = example.charAt(i);
	    s.add(c);
	    while (s.size() < 3) {
		char randChar = (char) (r.nextInt(26) + 'a');
		if (randChar == c)
		    continue;
		s.add(randChar);
	    }
	    nearby.put(c, s);
	}
	System.out.println("nearby charachters");
	System.out.println(nearby);
	System.out.println("Suggestions");

    }

    public static void main(String[] args) {
	String example = "we";
	generateNearBy(example);
	System.out.println(getNearbyStrings(example, 0));
    }

    private static List<String> getNearbyStrings(String str, int index) {
	if (str == null)
	    return null;

	List<String> perms = new ArrayList<String>();
	if (index == str.length()) {
	    perms.add("");
	    return perms;
	}

	char c = str.charAt(index);
	Set<Character> nearChars = nearby.get(c);
	List<String> permsRemain = getNearbyStrings(str, index + 1);

	for (String s : permsRemain) {
	    for (Character nearchar : nearChars)
		perms.add(nearchar + s);
	}

	return perms;

    }

}
