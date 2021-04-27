package stackqueue;

import java.util.Stack;

/**
 * Problem statement.
 * {@link https://www.hackerrank.com/challenges/largest-rectangle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues}
 * The improved solution is based on this youtube video.
 * {@link https://www.youtube.com/watch?v=lsQTYlCiU6c} This explanation is
 * actually better {@link https://www.youtube.com/watch?v=zx5Sw9130L0}
 * 
 * @author 746310
 *
 */
public class LargestRectangle {

    public static void main(String[] args) {
	int h[] = { 8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116 };
	long largestPlot = largestRectangleSlow(h);
	System.out.println(largestPlot);
	largestPlot = largestRectangle(h);
	System.out.println(largestPlot);
    }

    static long largestRectangle(int[] h) {
	Stack<Integer> heightStack = new Stack<>();
	Stack<Integer> posStack = new Stack<>();
	long max = 0;

	for (int i = 0; i < h.length; i++) {
	    int lastwidth = Integer.MAX_VALUE;
	    while (!heightStack.isEmpty() && heightStack.peek() > h[i]) {
		lastwidth = posStack.peek();
		int width = i - posStack.pop();
		int height = heightStack.pop();
		long area = (long) width * height;
		if (area > max)
		    max = area;
	    }

	    if (heightStack.isEmpty() || heightStack.peek() < h[i]) {
		heightStack.push(h[i]);
		posStack.push(Math.min(lastwidth, i));
	    }
	}

	return max;
    }

    /**
     * O(n^2) solution times out.
     * 
     * @param h
     * @return
     */
    static long largestRectangleSlow(int[] h) {
	long max = 0;
	for (int i = 0; i < h.length; i++) {
	    int minBuilding = h[i];
	    int count = 1;
	    for (int j = i; j < h.length; j++) {
		if (h[j] < minBuilding)
		    minBuilding = h[j];
		long size = ((long) minBuilding) * (count);
		if (size > max)
		    max = size;
		// System.out.println(i + " " + j + " " + minBuilding + " " + size);
		count++;
	    }

	}

	return max;

    }

}
