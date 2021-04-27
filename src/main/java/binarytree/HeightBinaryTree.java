package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binarytree.BinaryTree.Node;

public class HeightBinaryTree {

    public static void main(String args[]) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 1, 2, 3, 4, 5 };
	for (Integer i : arr)
	    bt.insert(i);
	bt.traverseAndPrintBFS();
	System.out.println("");
	int height = computeHeight(bt.getRoot());
	System.out.println(height);

	System.out.println(bottomView(bt.getRoot()));

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

    private static ArrayList<Integer> bottomView(Node root) {
	ArrayList<Integer> bottoms = new ArrayList<Integer>();
	Queue<Node> q = new LinkedList<Node>();

	if (root != null)
	    q.add(root);
	while (!q.isEmpty()) {
	    Node node = q.poll();
	    Node left = node.left;
	    Node right = node.right;
	    if (node != null) {
		if (node.left != null)
		    q.add(node.left);
		if (node.right != null)
		    q.add(node.right);
		if (node.left == null && node.right == null)
		    bottoms.add((Integer) node.key);
	    }
	}

	return bottoms;
    }

}
