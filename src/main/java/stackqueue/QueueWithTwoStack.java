package stackqueue;

import java.util.Stack;

public class QueueWithTwoStack {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public static void main(String args[]) {
	QueueWithTwoStack qws = new QueueWithTwoStack();
	for (int i = 1; i < 5; i++)
	    qws.Push(i);
	System.out.println(qws.s1);
	System.out.println(qws.s2);
	int pop = 0;
	while (pop != -1) {
	    pop = qws.Pop();
	    System.out.println(pop);
	}

    }

    /*
     * The method insert to push element into the queue
     */
    void Push(int x) {
	while (!s1.isEmpty()) {
	    s2.add(s1.pop());
	}

	s1.add(x);

	while (!s2.isEmpty()) {
	    s1.add(s2.pop());
	}

    }

    /*
     * The method remove which return the element popped out of the queue
     */
    int Pop() {
	if (s1.isEmpty())
	    return -1;
	else
	    return s1.pop();
    }

}
