package binarytree;

import binarytree.BinaryTree.Node;

public class BinaryTreeBalanced {

    public static void main(String args[]) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 26, 54, 8, 90, 97, 69, 60, 77, 35, 7, 31, 89, 17, 47, 69, 77, 54, 62, 55, 67, 47, 67, 50, 81,
		97, 18, 21, 8, 22, 16, 38, 100, 90, 95, 27, 13, null, 21, 33, 81, 29, 79, 32, 9, 93, 27, 44, 10, 61, 82,
		64, 51, 49, 93, 71, 16, 78, 59, 43, 47, 6, 92, 45, 14, 84, 36, 91, 16, 35, 5, 58, 87, 50, null, 76, 75,
		84 };
	for (Integer i : arr)
	    bt.insert(i);
	bt.traverseAndPrintBFS();
	System.out.println("");
	System.out.println(isBalanced(bt.getRoot()));

    }

    private static boolean isBalanced(Node root) {
	int heightLeft = computeHeight(root.left);
	int heightRight = computeHeight(root.right);
	int diff = Math.abs(heightLeft - heightRight);
	System.out.println(diff);

	if (diff > 1)
	    return false;
	else
	    return true;

    }

    private static int computeHeight(Node node) {
	if (node == null || node.key == null)
	    return 0;
	else {
	    int hLeft = 1 + computeHeight(node.left);
	    int hRight = 1 + computeHeight(node.right);
	    return Math.max(hLeft, hRight);

	}
    }

}
