package trie;

import java.util.Arrays;
import java.util.HashSet;

/**
 * {@link https://leetcode.com/problems/longest-word-in-dictionary/}
 * 
 * @author 746310
 *
 */
public class LongestWordInDictt {

    public static void main(String args[]) {
	String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
	TrieNode root = new TrieNode();
	for (String word : words) {
	    insert(word, root);
	}

	for (String word : words) {

	}
	System.out.println(longestWord(words));

    }

    /**
     * Insert operation is O(n)
     * 
     * @param word
     * @param root
     */
    private static void insert(String word, TrieNode root) {
	TrieNode start = root;
	for (int i = 0; i < word.length(); i++) {
	    Character c = word.charAt(i);
	    if (start.getChildren().containsKey(c)) {
		start = start.getChildren().get(c);
	    } else {
		TrieNode child = new TrieNode();
		start.getChildren().put(c, child);
		start = child;
	    }
	}

	start.setWordEnd(true);
    }

    /**
     * nlog(n)
     * 
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
	Arrays.sort(words);
	HashSet<String> set = new HashSet<>();
	String candidate = null;

	for (String word : words) {
	    if (candidate != null) {
		if (set.contains(word.substring(0, word.length() - 1))) {
		    if (word.length() > candidate.length())
			candidate = word;
		}
	    } else {
		candidate = word;
	    }

	    set.add(word);
	}

	return candidate;

    }

}
