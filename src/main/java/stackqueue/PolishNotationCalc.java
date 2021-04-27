package stackqueue;

import java.util.Stack;

public class PolishNotationCalc {

    /**
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
     * (4 + (13 / 5)) -> 6
     * 
     * @param args
     */
    public static void main(String[] args) {
	Stack<String> stack = new Stack<String>();
	String operators = "+*/-";
	String[] expression = { "4", "13", "5", "/", "+" };
	for (String str : expression) {
	    if (operators.contains(str)) {
		int val2 = Integer.valueOf(stack.pop());
		int val1 = Integer.valueOf(stack.pop());
		switch (str.charAt(0)) {
		case '+':
		    stack.push(String.valueOf(val1 + val2));
		    break;
		case '-':
		    stack.push(String.valueOf(val1 - val2));
		    break;
		case '*':
		    stack.push(String.valueOf(val1 * val2));
		    break;
		default:
		    stack.push(String.valueOf(val1 / val2));
		    break;
		}

	    } else {
		stack.push(str);
	    }
	}

	System.out.println(stack.pop());

    }

}
