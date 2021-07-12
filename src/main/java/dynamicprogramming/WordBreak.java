package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Go through the knapsack channel, he's the best for DP problems. Leetcode 139
 * {@link https://www.youtube.com/watch?v=1U4jQusbeJc}
 * 
 * @author 746310
 *
 */
public class WordBreak {

    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {

	// can the word be broken into substrings such that all substrings are contained
	// in the dictionary
	dictionary.add("ab");
	dictionary.add("cd");
	dictionary.add("ef");

	String word = "abcdef";
	System.out.println(wordBreak(word));

	// is the sub problem already solved
	Map<String, Boolean> memo = new HashMap<>();
	System.out.println(wordBreakMemoization(word, memo));
	System.out.println(wordBreakBottomUp(word));

    }

    /**
     * The unoptimized recursive implementation. The reason why this O(2^n) worst
     * case you have choose whether you break or not to break at all n characters
     * constituting the string.
     * 
     * @param word
     * @return
     */
    public static boolean wordBreak(String word) {
	// if all word prefixes are checked then the whole word can be broken into parts
	// available in dictionary
	if (word.length() == 0)
	    return true;

	// if the prefix is present in the dictionary already we just need to check the
	// balance
	for (String dict : dictionary) {
	    if (word.substring(0, dict.length()).equals(dict) && wordBreak(word.substring(dict.length())))
		return true;

	}

	// there is no prefix available in the entire word hence impossible to break
	return false;

    }

    public static boolean wordBreakMemoization(String word, Map<String, Boolean> memo) {
	// if all word prefixes are checked then the whole word can be broken into parts
	// available in dictionary
	if (word.length() == 0)
	    return true;

	if (memo.containsKey(word))
	    return memo.get(word);

	// if the prefix is present in the dictionary already we just need to check the
	// balance
	for (String dict : dictionary) {
	    if (word.substring(0, dict.length()).equals(dict) && wordBreak(word.substring(dict.length()))) {
		memo.put(word, true);
		return true;
	    }

	}
	memo.put(word, false);
	return false;

    }

    private static boolean wordBreakBottomUp(String word) {
	// the dp array here represents possibility of the substring being present in
	// the dictionary. This includes the empty substring.
	boolean dpArr[] = new boolean[word.length() + 1];
	// empty substring is true
	dpArr[0] = true;
	for (int i = 1; i < dpArr.length; i++) {
	    for (int j = i - 1; j >= 0; j--) {
		if (dpArr[j] && dictionary.contains(word.substring(j, i))) {
		    dpArr[i] = true;
		    break;
		}
	    }

	}

	System.out.println(Arrays.toString(dpArr));
	return dpArr[word.length()];

    }

}
