package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 207
 * 
 * @author 746310
 *
 */
public class CourseSchedule {

    private static Map<Integer, List<Integer>> adjacencyList = new HashMap<>();;

    public static void main(String[] args) {
	int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
	getAdjacencyList(prerequisites);
	System.out.println(adjacencyList);
	System.out.println(isCyclic());

    }

    private static boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recStack) {
	// Mark the current node as visited and
	// part of recursion stack
	if (recStack[vertex])
	    return true;

	// if vertex is already visited and not part of recursion stack then no cycle.
	if (visited[vertex])
	    return false;

	visited[vertex] = true;
	recStack[vertex] = true;

	for (int dest : adjacencyList.get(vertex)) {
	    if (adjacencyList.containsKey(dest)) {
		if (isCyclicUtil(dest, visited, recStack))
		    return true;
	    }

	}

	recStack[vertex] = false;
	return false;
    }

    /**
     * Returns true if the graph contains a cycle, else false. This function is a
     * variation of DFS().
     * 
     * @return true if graph is
     */
    private static boolean isCyclic() {

	boolean[] visited = new boolean[adjacencyList.size()];
	boolean[] recStack = new boolean[adjacencyList.size()];

	// Call the recursive helper function to
	// detect cycle in different DFS trees
	for (int vertex : adjacencyList.keySet()) {
	    if (isCyclicUtil(vertex, visited, recStack))
		return true;
	}

	return false;
    }

    private static void getAdjacencyList(int[][] prerequisites) {

	for (int[] course : prerequisites) {
	    if (adjacencyList.containsKey(course[1]))
		adjacencyList.get(course[1]).add(course[0]);
	    else {
		List<Integer> arr = new ArrayList<>();
		arr.add(course[0]);
		adjacencyList.put(course[1], arr);
	    }
	}
    }

}
