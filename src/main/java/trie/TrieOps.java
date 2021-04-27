package trie;

public class TrieOps {

    public static void main(String[] args) {
	String strings[] = { "abc", "abgl", "cdf", "abcd", "lmn" };
	TrieNode root = new TrieNode();
	// average complexity is num_string* length_of_words
	insertWords(root, strings);

	System.out.println(root);
	System.out.println("========== Prefix search ==========");
	String prefixArr[] = { "ab", "lo" };
	for (String prefix : prefixArr) {
	    System.out.println(prefixBasedSearch(prefix, root));
	}

	System.out.println("========== Whole word search ==========");
	String words[] = { "lmn", "ab", "cdf", "gh" };
	for (String word : words)
	    System.out.println(wholeWordSearch(word, root));

	System.out.println("============= delete words =====");
	String[] wordsDel = { "abc", "lmn", "abgl" };
	for (String word : wordsDel)
	    System.out.println(delete(word, root));
    }

    private static void insertWords(TrieNode root, String strings[]) {
	for (String str : strings) {
	    TrieNode start = root;
	    for (int i = 0; i < str.length(); i++) {
		if (!start.getChildren().containsKey(str.charAt(i))) {
		    TrieNode child = new TrieNode();
		    start.getChildren().put(str.charAt(i), child);
		    start = child;
		} else {
		    start = start.getChildren().get(str.charAt(i));
		}

	    }

	    start.setWordEnd(true);

	}
    }

    /**
     * Time complexity is O(n) where n is the length of the word.
     * 
     * @param prefix
     * @param root
     * @return
     */
    private static boolean prefixBasedSearch(String prefix, TrieNode root) {
	TrieNode start = root;
	for (int i = 0; i < prefix.length(); i++) {
	    if (!start.getChildren().containsKey(prefix.charAt(i)))
		return false;
	    else
		start = start.getChildren().get(prefix.charAt(i));
	}
	return true;

    }

    private static boolean wholeWordSearch(String word, TrieNode root) {
	TrieNode start = root;
	for (int i = 0; i < word.length(); i++) {
	    if (!start.getChildren().containsKey(word.charAt(i)))
		return false;
	    else
		start = start.getChildren().get(word.charAt(i));
	}

	return start.isWordEnd();
    }

    /**
     * Delete word from trie.
     */
    public static boolean delete(String word, TrieNode root) {
	return delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private static boolean delete(TrieNode current, String word, int index) {
	if (index == word.length()) {
	    // when end of word is reached only delete if currrent.endOfWord is true.
	    if (!current.isWordEnd()) {
		return false;
	    }
	    current.setWordEnd(false);
	    // if current has no other mapping then return true
	    return current.getChildren().size() == 0;
	}
	char ch = word.charAt(index);
	TrieNode node = current.getChildren().get(ch);
	if (node == null) {
	    return false;
	}
	boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

	// if true is returned then delete the mapping of character and trienode
	// reference from map.
	if (shouldDeleteCurrentNode) {
	    current.getChildren().remove(ch);
	    // return true if no mappings are left in the map.
	    return current.getChildren().size() == 0;
	}
	return false;
    }

}
