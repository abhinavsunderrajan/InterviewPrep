package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * My implementation of the binary tree.
 * 
 * BFS traversal using queue. DFS traversal using stack i.e. recursion.
 * 
 * @author abhinav.sunderrajan
 *
 */
public class BinaryTree<T> {
    private Node<T> root;

    public static class Node<T> {
	Node<T> left;
	Node<T> right;
	T val;

	Node(T key) {
	    this.val = key;
	}

	@Override
	public String toString() {
	    if (val == null)
		return null;
	    return val.toString();
	}

    }

    /**
     * In order traversal of the binary tree.
     * 
     * @param temp
     */
    public void traverseAndPrintDFS(Node<T> temp) {
	if (temp == null)
	    return;
	System.out.print(temp.val + " ");
	traverseAndPrintDFS(temp.left);
	traverseAndPrintDFS(temp.right);

    }

    /**
     * In order traversal of the binary tree.
     * 
     * @param temp
     */
    public void traverseAndPrintBFS() {
	Queue<Node<T>> q = new LinkedList<>();
	q.add(root);
	while (!q.isEmpty()) {
	    Node<T> node = q.poll();
	    if (node != null) {
		if (node.left != null)
		    q.add(node.left);
		if (node.right != null)
		    q.add(node.right);
	    }
	    System.out.print(node.val + " ");

	}

    }

    /**
     * Function to insert element in binary tree.
     * 
     * @param temp
     * @param key
     */
    public void insert(T key) {
	if (root == null) {
	    root = new Node<T>(key);
	    return;
	}

	Queue<Node<T>> q = new LinkedList<Node<T>>();
	Node<T> temp = root;
	q.add(temp);

	// Do level order traversal until we find
	// an empty place.
	while (!q.isEmpty()) {
	    temp = q.poll();

	    if (temp.left == null) {
		temp.left = new Node<T>(key);
		break;
	    } else
		q.add(temp.left);

	    if (temp.right == null) {
		temp.right = new Node<T>(key);
		break;
	    } else
		q.add(temp.right);
	}
    }

    /**
     * 
     * @param root
     * @param d_node
     */
    void deleteDeepest(Node<T> d_node) {
	Queue<Node<T>> q = new LinkedList<Node<T>>();
	q.add(root);

	// Do level order traversal until last node
	Node<T> temp;
	while (!q.isEmpty()) {
	    temp = q.poll();
	    if (temp.equals(d_node)) {
		temp = null;
		return;
	    }
	    if (temp.right != null) {
		if (temp.right.equals(d_node)) {
		    temp.right = null;
		    return;
		} else
		    q.add(temp.right);
	    }

	    if (temp.left != null) {
		if (temp.left.equals(d_node)) {
		    temp.left = null;
		    return;
		} else
		    q.add(temp.left);
	    }
	}
    }

    /**
     * Function to delete a key the first occurrence and replace that with the right
     * most node in the binary tree.
     * 
     * @param key the key value to be deleted.
     */
    public void deletion(T key) {
	Queue<Node<T>> q = new LinkedList<Node<T>>();
	q.add(root);

	Node<T> rightMostNode = null;
	Node<T> key_node = null;

	// Do level order traversal to find deepest
	// node(temp) and node to be deleted (key_node)
	while (!q.isEmpty()) {
	    rightMostNode = q.poll();

	    if (rightMostNode.val == key)
		key_node = rightMostNode;

	    if (rightMostNode.left != null)
		q.add(rightMostNode.left);

	    if (rightMostNode.right != null)
		q.add(rightMostNode.right);
	}
	if (rightMostNode != null) {
	    T x = rightMostNode.val;
	    deleteDeepest(rightMostNode);
	    key_node.val = x;
	}
    }

    /**
     * Get the root of the binary tree.
     * 
     * @return root of the binary tree.
     */
    public Node<T> getRoot() {
	return root;
    }

}
