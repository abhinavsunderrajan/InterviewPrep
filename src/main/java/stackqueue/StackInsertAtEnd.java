package stackqueue;

import java.util.Stack;

public class StackInsertAtEnd {

    public static void main(String[] args) {
	Stack<Integer> s = new Stack<>();
	for (int i = 0; i < 6; i++)
	    insertAtEnd(i, s);
	while (!s.isEmpty())
	    System.out.println(s.pop());

    }

    private static void insertAtEnd(int i, Stack<Integer> s) {
	if (s.isEmpty())
	    s.push(i);
	else {
	    Integer temp = s.pop();
	    insertAtEnd(i, s);
	    s.push(temp);

	}

    }

}
