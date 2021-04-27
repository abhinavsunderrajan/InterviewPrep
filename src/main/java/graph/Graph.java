package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Graph representation adjacency list.
 * 
 * @author 746310
 *
 */
class Graph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    Graph(int v) {
	this.V = v;
	adj = new ArrayList<ArrayList<Integer>>(v);
	for (int i = 0; i < v; ++i)
	    adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
	adj.get(v).add(w);
    }

    /**
     * A recursive function used by topologicalSort
     * 
     * @param v
     * @param visited
     * @param stack
     */
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
	// Mark the current node as visited.
	visited[v] = true;
	Integer i;

	// Recur for all the vertices adjacent
	// to thisvertex
	Iterator<Integer> it = adj.get(v).iterator();
	while (it.hasNext()) {
	    i = it.next();
	    if (!visited[i])
		topologicalSortUtil(i, visited, stack);
	}

	// Push current vertex to stack
	// which stores result
	stack.push(v);
    }

    public void topologicalSort() {
	Stack<Integer> stack = new Stack<Integer>();
	boolean visited[] = new boolean[V];

	// Call the recursive helper
	// function to store
	// Topological Sort starting
	// from all vertices one by one
	for (int i = 0; i < V; i++) {
	    if (visited[i] == false)
		topologicalSortUtil(i, visited, stack);
	}

	// Print contents of stack
	while (stack.empty() == false)
	    System.out.print(stack.pop() + " ");
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

	// add the node the to the recursion stack.
	if (recStack[i])
	    return true;
	// if vertex is already visited and not part of recursion stack then no cycle.
	if (visited[i])
	    return false;

	visited[i] = true;
	recStack[i] = true;

	List<Integer> children = adj.get(i);

	for (Integer c : children)
	    if (isCyclicUtil(c, visited, recStack))
		return true;

	recStack[i] = false;

	return false;
    }

    public boolean isCyclic() {

// Mark all the vertices as not visited and
// not part of recursion stack
	boolean[] visited = new boolean[V];
	boolean[] recStack = new boolean[V];

// Call the recursive helper function to
// detect cycle in different DFS trees
	for (int i = 0; i < V; i++)
	    if (isCyclicUtil(i, visited, recStack))
		return true;

	return false;
    }

}