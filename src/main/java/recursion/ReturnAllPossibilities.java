package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReturnAllPossibilities {

    public static void main(String[] args) {
	List<String> allPossibilities = returnAllPossibilities("(**()");
	System.out.println(allPossibilities.size());
	Collections.sort(allPossibilities);
	System.out.println(allPossibilities);

    }

    public static List<String> returnAllPossibilities(String str) {

	List<String> all = new ArrayList<>();
	if (str.length() == 0 || !str.contains("*")) {
	    all.add(str);
	    return all;
	}
	char cArr[] = str.toCharArray();
	String remain = str.substring(1);
	List<String> remainCombinations = returnAllPossibilities(remain);

	if (cArr[0] == '*') {
	    for (String comb : remainCombinations) {
		all.add(")" + comb);
		all.add("(" + comb);
		all.add(comb);
	    }

	} else {
	    for (String comb : remainCombinations)
		all.add(cArr[0] + comb);

	}

	return all;

    }

}
