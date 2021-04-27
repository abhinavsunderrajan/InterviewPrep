package binarytree;

import binarytree.BinaryTree.Node;

public class IsBinarySearchTree {

    public static void main(String args[]) {

	int arr[] = { 8, 3, 10, 1, 6, 9, 14 };
	BinaryTree<Integer> bt = new BinaryTree<>();
	for (Integer i : arr)
	    bt.insert(i);

	bt.traverseAndPrintBFS();
	System.out.println(isBST(bt.getRoot(), null, null));

    }

    static boolean isBST(Node<Integer> root, Node<Integer> l, Node<Integer> r) {
	// Base condition
	if (root == null)
	    return true;

	// if left node exist then check it has
	// correct data or not i.e. left node's data
	// should be less than root's data
	if (l != null && root.key <= l.key)
	    return false;

	// if right node exist then check it has
	// correct data or not i.e. right node's data
	// should be greater than root's data
	if (r != null && root.key >= r.key)
	    return false;

	// check recursively for every node.
	return isBST(root.left, l, root) && isBST(root.right, root, r);
    }

}
