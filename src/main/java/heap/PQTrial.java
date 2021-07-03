package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQTrial {

    public static void main(String[] args) {
	Queue<Integer> pq = new PriorityQueue<>();
	int arr[] = { 12, 4, 76, 98, 2, 5, 6, 0, -65, 234 };

	System.out.println(Arrays.toString(arr));
	for (int num : arr)
	    pq.add(num);

	System.out.println(pq);
	for (int num : pq)
	    System.out.print(num + " ");

    }

}
