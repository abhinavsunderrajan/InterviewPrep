package binarytree;

import binarytree.BinaryTree.Node;

/**
 * Similar to the height of a binary tree.
 * 
 * @author 746310
 *
 */
public class MaxPathSum {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 4, -2, 3, 4, null, 5, 6, null, 3 };
	for (Integer i : arr)
	    bt.insert(i);

	bt.traverseAndPrintBFS();
	System.out.println("");

	int maxSum = getSum(bt.getRoot());
	System.out.println(maxSum);

    }

    private static int getSum(Node<Integer> node) {
	if (node == null || node.val == null)
	    return 0;

	int leftSum = node.val + getSum(node.left);
	int rightSum = node.val + getSum(node.right);
	return Math.max(leftSum, rightSum);
    }

}
