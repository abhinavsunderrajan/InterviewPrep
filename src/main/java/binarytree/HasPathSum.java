package binarytree;

import binarytree.BinaryTree.Node;

public class HasPathSum {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
	for (Integer i : arr)
	    bt.insert(i);
	bt.traverseAndPrintDFS(bt.getRoot());
	System.out.println(hasPathSum(bt.getRoot(), 22));

    }

    private static boolean hasPathSum(Node<Integer> root, int targetSum) {
	/* return true if we run out of tree and sum==0 */
	if (root == null) {
	    return (targetSum == 0);
	} else {
	    boolean ans = false;
	    int subSum = targetSum - root.val;

	    /* If we reach a leaf node and sum becomes 0 then return true */
	    if (subSum == 0 && root.left == null && root.right == null)
		return true;

	    /* otherwise check both subtrees */
	    if (root.left != null)
		ans = ans || hasPathSum(root.left, subSum);
	    if (root.right != null)
		ans = ans || hasPathSum(root.right, subSum);

	    return ans;
	}

    }
}