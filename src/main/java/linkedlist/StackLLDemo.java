package linkedlist;

public class StackLLDemo {

    public static void main(String[] args) {
	StackLinkedListBased<Integer> stackll = new StackLinkedListBased<>();
	for (int i = 1; i < 10; i++)
	    stackll.push(i);
	String contents = stackll.printContents();
	System.out.println(contents);

	for (int i = 0; i < 5; i++) {
	    stackll.pop();
	    System.out.println(stackll.printContents());
	}

    }

}
