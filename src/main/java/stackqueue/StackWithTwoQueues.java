package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
	StackWithTwoQueues swq = new StackWithTwoQueues();
	for (int i = 1; i < 6; i++)
	    swq.push(i);

	int pop = 0;
	while (pop != -1) {
	    pop = swq.pop();
	    if (pop == -1)
		break;
	    System.out.print(pop + ",");
	}

    }

    void push(int x) {
	q2.add(x);
	while (!q1.isEmpty())
	    q2.add(q1.poll());

	while (!q2.isEmpty())
	    q1.add(q2.poll());
    }

    int pop() {
	if (q1.isEmpty())
	    return -1;
	return q1.poll();
    }

}
