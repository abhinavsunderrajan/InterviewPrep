package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.BinaryTree.Node;

public class LeafCountBinaryTree {

    public static void main(String args[]) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 2, 1, 3, 4, 5 };
	for (Integer i : arr)
	    bt.insert(i);
	bt.traverseAndPrintBFS();
	System.out.println("");
	int height = countLeaves(bt.getRoot());
	System.out.println(height);
	System.out.println("======================");
	System.out.println(getLeafCount(bt.getRoot()));

    }

    private static int getLeafCount(Node node) {
	if (node == null)
	    return 0;
	if ((node.left == null) && (node.right == null))
	    return 1;
	else {
	    int countL = getLeafCount(node.left);
	    System.out.println(node + " " + countL);
	    int countR = getLeafCount(node.right);
	    System.out.println(node + " " + countR);
	    return countL + countR;
	}

    }

    private static int countLeaves(Node node) {
	Queue<Node> queue = new LinkedList<>();
	queue.add(node);

	int count = 0;
	while (!queue.isEmpty()) {

	    Node n = queue.poll();
	    if (n != null) {
		if (n.left != null)
		    queue.add(n.left);
		if (n.right != null)
		    queue.add(n.right);
		if (n.left == null && n.right == null)
		    count++;
	    }

	}
	return count;
    }

}
