package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytree.BinaryTree.Node;

/**
 * https://www.geeksforgeeks.org/averages-levels-binary-tree/
 * 
 * @author 746310
 *
 */
public class AverageOfLevels {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 3, 1, 5, 0, 2, 4, 6 };
	for (Integer i : arr)
	    bt.insert(i);
	bt.traverseAndPrintBFS();
	System.out.println("");
	System.out.println(averageOfLevels(bt.getRoot()));

    }

    private static List<Double> averageOfLevels(Node<Integer> root) {

	List<Double> avgList = new ArrayList<>();
	Queue<Node<Integer>> q = new LinkedList<>();
	q.add(root);
	int sum = 0, count = 0;

	while (!q.isEmpty()) {

	    // Compute sum of nodes and
	    // count of nodes in current
	    // level.
	    sum = 0;
	    count = 0;
	    Queue<Node<Integer>> temp = new LinkedList<>();
	    while (!q.isEmpty()) {
		Node<Integer> n = q.poll();
		sum += n.val;
		count++;
		if (n.left != null && n.left.val != null)
		    temp.add(n.left);
		if (n.right != null && n.right.val != null)
		    temp.add(n.right);
	    }
	    q = temp;
	    avgList.add(sum * 1.0 / count);
	}

	return avgList;

    }

}
