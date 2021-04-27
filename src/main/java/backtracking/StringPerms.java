package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Two clean implementations of array permute.
 * 
 * @author 746310
 *
 */
public class StringPerms {

    public static void main(String args[]) {

	String str = "ABC";
	List<String> perms = recursive(str);
	System.out.println(perms);
	System.out.println("=======================");
	permutation(str);

    }

    private static List<String> recursive(String str) {

	List<String> perms = new ArrayList<>();
	if (str.length() == 0) {
	    perms.add("");
	    return perms;

	}

	for (int i = 0; i < str.length(); i++) {
	    String charAt = str.charAt(i) + "";
	    String remain = str.substring(0, i) + str.substring(i + 1);
	    List<String> permRemain = recursive(remain);
	    for (String rem : permRemain)
		perms.add(charAt + rem);
	}
	return perms;

    }

    private static void permutation(String input) {
	permutation("", input);
    }

    private static void permutation(String perm, String word) {
	if (word.isEmpty()) {
	    System.out.println(perm + word);

	} else {
	    for (int i = 0; i < word.length(); i++) {
		permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
	    }
	}

    }

}
