package combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3] {[1, 2, 3], [1,3,2], [2,1,3],[2,3,1], [3,1,2],[3,2,1]}
 * 
 * @author 746310
 *
 */
public class ListPermutations {

    public static void main(String[] args) {
	Integer[] arr = { 1, 2, 1 };
	List<Integer> list = new ArrayList<>();
	for (int elem : arr)
	    list.add(elem);
	System.out.println(permutations(list));

    }

    private static List<List<Integer>> permutations(List<Integer> ls) {
	List<List<Integer>> perms = new ArrayList<>();
	if (ls.size() == 0) {
	    perms.add(new ArrayList<>());
	    return perms;
	}

	for (int i = 0; i < ls.size(); i++) {
	    List<Integer> remainLs = new ArrayList<>();
	    int elem = ls.get(i);
	    for (int j = 0; j < ls.size(); j++) {
		if (j == i)
		    continue;
		remainLs.add(ls.get(j));
	    }
	    List<List<Integer>> permsRemaining = permutations(remainLs);
	    for (List<Integer> perm : permsRemaining) {
		perm.add(0, elem);
		perms.add(perm);
	    }

	}

	return perms;

    }

}
