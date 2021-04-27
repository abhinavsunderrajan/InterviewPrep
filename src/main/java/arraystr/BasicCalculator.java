package arraystr;

import java.util.Stack;

/**
 * Assume string is valid and contains no white spaces.
 * 
 * @author 746310
 *
 */
public class BasicCalculator {

    public static void main(String[] args) {
	String expression = "(1-2)";
	Stack<String> stack = new Stack<String>();

	String operators = "*-+/";
	String closeParanthesis = ")}]";

	StringBuffer bf = new StringBuffer();
	for (Character c : expression.toCharArray()) {
	    if (c >= '0' && c <= '9')
		bf.append(String.valueOf(c));
	    if (operators.contains(String.valueOf(c))) {
		stack.push(bf.toString());
		bf = new StringBuffer();
		stack.push(String.valueOf(c));
	    }

	    if (closeParanthesis.contains(String.valueOf(c))) {
		if (bf.length() > 0) {
		    stack.push(bf.toString());
		    bf = new StringBuffer();
		}

		int val2 = Integer.valueOf(stack.pop());
		String operator = stack.pop();
		int val1 = Integer.valueOf(stack.pop());
		switch (operator.charAt(0)) {
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

	    }

	}
	System.out.println(stack.pop());

    }

}
