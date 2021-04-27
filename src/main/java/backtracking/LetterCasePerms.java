package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Similar to String permutation. Here you just need to permute on the letter
 * cases. No change in order.
 * 
 * @author 746310
 *
 */
public class LetterCasePerms {

    public static void main(String[] args) {
	List<String> casePerms = letterCasePermutation("a25xf");
	System.out.println(casePerms.size());
	System.out.println(casePerms);

    }

    private static List<String> letterCasePermutation(String s) {
	List<String> perms = new ArrayList<>();
	if (s.length() == 0) {
	    perms.add("");
	    return perms;
	}

	char c = s.charAt(0);
	int ascii = (int) c;
	String remain = s.substring(1);
	List<String> permsRemain = letterCasePermutation(remain);
	for (String rem : permsRemain) {
	    if (ascii >= 97 && ascii <= 122) {
		int u = ascii - 32;
		String s1 = (char) u + rem;
		perms.add(s1);
	    }

	    String s2 = c + rem;
	    perms.add(s2);

	}

	return perms;

    }

}
