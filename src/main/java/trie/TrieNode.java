package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private boolean isWordEnd;
    private Map<Character, TrieNode> children;

    public TrieNode() {
	children = new HashMap<>();
    }

    public boolean isWordEnd() {
	return isWordEnd;
    }

    public void setWordEnd(boolean isWordEnd) {
	this.isWordEnd = isWordEnd;
    }

    public Map<Character, TrieNode> getChildren() {
	return children;
    }

    @Override
    public String toString() {
	return children.keySet().toString();
    }

}
