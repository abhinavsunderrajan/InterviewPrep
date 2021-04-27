package arraystr;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The longest substring without repeating letters for "abcabcbb" is "abc"
 * 
 * @author 746310
 *
 */
public class LongestNonrepeatSubStr {

    public static void main(String[] args) {
	String test = "abecbacdgbb";
	Set<Character> charSet = new LinkedHashSet<Character>();
	String result = "";
	for (Character c : test.toCharArray()) {
	    if (!charSet.contains(c)) {
		charSet.add(c);
		String charset = getSetStr(charSet);
		if (result.length() < charset.length())
		    result = charset;
	    } else {
		Iterator<Character> it = charSet.iterator();
		while (it.hasNext()) {
		    char itNext = it.next();
		    it.remove();
		    if (itNext == c)
			break;
		}
		charSet.add(c);
	    }

	}

	System.out.println(result);

    }

    private static String getSetStr(Set<Character> charSet) {
	StringBuffer buf = new StringBuffer();
	for (Character c : charSet)
	    buf.append(c);
	return buf.toString();

    }

}
