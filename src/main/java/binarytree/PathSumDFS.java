package binarytree;

import java.util.ArrayList;
import java.util.List;

import binarytree.BinaryTree.Node;

/**
 * Nice application of DFS also notice how new lists are created at each
 * recursive call. This is a very useful pattern question.
 * {@link https://leetcode.com/problems/path-sum-ii/submissions/}
 * {@link https://www.youtube.com/watch?v=3B5gnrwRmOA}
 * 
 * @author 746310
 *
 */
public class PathSumDFS {

    public static void main(String[] args) {
	BinaryTree<Integer> bt = new BinaryTree<>();
	Integer[] arr = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
	for (Integer i : arr)
	    bt.insert(i);

	int target = 22;
	System.out.println(pathSum(bt.getRoot(), target));

    }

    private static List<List<Integer>> pathSum(Node<Integer> root, int targetSum) {
	List<List<Integer>> paths = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	dfs(root, targetSum, path, paths);
	return paths;

    }

    private static void dfs(Node<Integer> root, int targetSum, List<Integer> path, List<List<Integer>> paths) {

	if (root == null || root.key == null) {
	    return;
	}

	path.add(root.key);
	if (root.key == targetSum && (root.left == null || root.left.key == null)
		&& (root.right == null || root.right.key == null)) {
	    paths.add(path);
	    return;
	}

	// create a new path object every recursion call by adding adding the previous
	// path.
	dfs(root.left, (targetSum - root.key), new ArrayList<Integer>(path), paths);
	dfs(root.right, (targetSum - root.key), new ArrayList<Integer>(path), paths);

    }

}
