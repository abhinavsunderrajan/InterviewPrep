package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Nice example of how to build from the base case to more complex solutions.
 * 
 * @author 746310
 *
 */
public class ParanthesisGen {

    public static void main(String[] args) {
	System.out.println(generateParenthesis(3));

    }

    private static List<String> generateParenthesis(int n) {

	List<String> all = new ArrayList<>();
	if (n == 1) {
	    all.add("()");
	    return all;
	}

	List<String> remain = generateParenthesis(n - 1);
	for (String str : remain) {
	    for (int i = 0; i < str.length(); i++) {
		String s = str.substring(0, i) + "()" + str.substring(i);
		all.add(s);
	    }
	}

	return all;

    }

}
