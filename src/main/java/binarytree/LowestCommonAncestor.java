package binarytree;

import binarytree.BinaryTree.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 3, 1, 5, 0, 2, 4, 6 };
	for (Integer i : arr)
	    bt.insert(i);

	System.out.println(findLCA(bt.getRoot(), 2, 6));

    }

    private static Node<Integer> findLCA(Node<Integer> node, int n1, int n2) {
	// Base case
	if (node == null)
	    return null;

	// If either n1 or n2 matches with root's key, report
	// the presence by returning root (Note that if a key is
	// ancestor of other, then the ancestor key becomes LCA
	if (node.key == n1 || node.key == n2)
	    return node;

	// Look for keys in left and right subtrees
	Node<Integer> left_lca = findLCA(node.left, n1, n2);
	Node<Integer> right_lca = findLCA(node.right, n1, n2);

	// If both of the above calls return Non-NULL, then one key
	// is present in once subtree and other is present in other,
	// So this node is the LCA
	if (left_lca != null && right_lca != null)
	    return node;

	// Otherwise check if left subtree or right subtree is LCA
	return (left_lca != null) ? left_lca : right_lca;
    }

}
