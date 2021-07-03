package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import binarytree.BinaryTree.Node;

/**
 * Right side view using the two queue trick and the
 * 
 * {@link https://leetcode.com/problems/binary-tree-right-side-view/submissions/}
 * 
 * @author 746310
 *
 */
public class RightSideViewBT {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 3, 1, 5, 0, 2, 4, 6 };
	for (Integer i : arr)
	    bt.insert(i);

	System.out.println(rightSideView(bt.getRoot()));

    }

    private static List<Integer> rightSideView(Node<Integer> root) {

	List<Integer> retList = new ArrayList<>();
	if (root == null)
	    return retList;

	Queue<Node<Integer>> q = new LinkedList<>();
	q.add(root);

	while (!q.isEmpty()) {

	    Queue<Node<Integer>> temp = new LinkedList<>();
	    Stack<Integer> stack = new Stack<>();
	    while (!q.isEmpty()) {
		Node<Integer> node = q.poll();
		stack.add(node.val);

		if (node.left != null)
		    temp.add(node.left);
		if (node.right != null)
		    temp.add(node.right);
	    }

	    retList.add(stack.pop());
	    q = temp;

	}
	return retList;

    }

}
