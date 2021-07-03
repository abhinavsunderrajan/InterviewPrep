package binarytree;

import binarytree.BinaryTree.Node;

public class IsBinarySearchTree {

    private static Node<Integer> prev;

    public static void main(String args[]) {

	int arr[] = { 8, 3, 10, 1, 6, 9, 14 };
	BinaryTree<Integer> bt = new BinaryTree<>();
	for (Integer i : arr)
	    bt.insert(i);

	bt.traverseAndPrintBFS();
	System.out.println(isBST(bt.getRoot(), null, null));

    }

    /**
     * See tushar roys video to understand
     * {@linkplain https://www.youtube.com/watch?v=MILxfAbIhrE} Here you are
     * assuming null as infinity.
     * 
     * @param testNode
     * @param left
     * @param right
     * @return
     */
    static boolean isBST(Node<Integer> testNode, Node<Integer> left, Node<Integer> right) {
	// Base condition
	if (testNode == null)
	    return true;

	// if left node exist then check it has
	// correct data or not i.e. left node's data
	// should be less than root's data
	if (left != null && testNode.val <= left.val)
	    return false;

	// if right node exist then check it has
	// correct data or not i.e. right node's data
	// should be greater than root's data
	if (right != null && testNode.val >= right.val)
	    return false;

	// check recursively for every node.
	return isBST(testNode.left, left, testNode) && isBST(testNode.right, testNode, right);
    }

}
