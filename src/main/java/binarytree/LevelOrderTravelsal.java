package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.BinaryTree.Node;

/**
 * Print each level line by line. Notice this technique of having two queues.
 * 
 * @author 746310
 *
 */
public class LevelOrderTravelsal {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 3, 1, 5, 0, 2, 4, 6 };
	for (Integer i : arr)
	    bt.insert(i);

	bt.traverseAndPrintBFS();
	System.out.println("\n===============");
	printLevelByLevel(bt.getRoot());
	System.out.println("================");
	zigZagLevel(bt.getRoot());

    }

    private static void printLevelByLevel(Node<Integer> root) {

	Queue<Node<Integer>> q = new LinkedList<>();
	q.add(root);

	while (!q.isEmpty()) {

	    Queue<Node<Integer>> temp = new LinkedList<>();
	    StringBuffer bf = new StringBuffer();

	    while (!q.isEmpty()) {
		Node<Integer> node = q.poll();
		bf.append(node.key + " ");
		if (node.left != null && node.left.key != null)
		    temp.add(node.left);
		if (node.right != null && node.right.key != null)
		    temp.add(node.right);
	    }
	    System.out.println(bf.toString());
	    q = temp;

	}

    }

    private static void zigZagLevel(Node<Integer> root) {

	Queue<Node<Integer>> q = new LinkedList<>();
	q.add(root);
	int count = 0;
	while (!q.isEmpty()) {

	    Queue<Node<Integer>> temp = new LinkedList<>();
	    StringBuffer bf = new StringBuffer();

	    while (!q.isEmpty()) {
		Node<Integer> node = q.poll();
		bf.append(node.key + " ");
		if (node.left != null && node.left.key != null)
		    temp.add(node.left);
		if (node.right != null && node.right.key != null)
		    temp.add(node.right);

	    }
	    if (count % 2 == 1)
		bf.reverse();
	    System.out.println(bf.toString().trim());
	    q = temp;
	    count++;
	}

    }

}
