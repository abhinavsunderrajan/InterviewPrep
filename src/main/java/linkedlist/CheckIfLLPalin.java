package linkedlist;

import java.util.Stack;

import linkedlist.LinkedList.ListNode;

public class CheckIfLLPalin {

    public static void main(String[] args) {
	LinkedList<Character> ll = new LinkedList<Character>();
	ll.add('a');
	ll.add('b');
	ll.add('c');
	// ll.add('d');
	ll.add('c');
	ll.add('b');
	ll.add('a');
	ll.printListContents();
	System.out.println(checkPalin(ll));
	System.out.println(isPalindrome(ll));

    }

    public static boolean isPalindrome(LinkedList<Character> ll) {
	ListNode<Character> ptr1 = ll.getHead();
	ListNode<Character> ptr2 = ll.getHead();
	ListNode<Character> prev = null;
	while (ptr2 != null && ptr2.next != null) {
	    ptr1 = ptr1.next;
	    ptr2 = ptr2.next.next;
	    prev = ptr1;
	}
	// Indicates odd num of elements hence exclude the middle

	if (ptr2 != null) {
	    prev = ptr1;
	    ptr1 = ptr1.next;
	}

	ListNode<Character> current = ptr1;

	while (current != null) {
	    ListNode<Character> next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;

	}

	ll.printListContents();

	ListNode<Character> mid = ptr1;
	ListNode<Character> start = ll.getHead();

	while (ptr1 != null) {
	    if (start.value != mid.value)
		return false;
	    start = start.next;
	    mid = mid.next;
	}

	return true;

    }

    private static boolean checkPalin(LinkedList<Character> ll) {
	Stack<Character> stack = new Stack<>();
	ListNode<Character> start = ll.getHead();
	while (start != null) {
	    stack.push(start.value);
	    start = start.next;
	}

	start = ll.getHead();

	while (!stack.isEmpty()) {
	    if (stack.pop() != start.value)
		return false;
	    start = start.next;
	}

	return true;
    }

    private static ListNode<Character> getMiddle(LinkedList<Character> ll) {
	ListNode<Character> p1 = ll.getHead();
	ListNode<Character> p2 = ll.getHead();
	while (p2 != null && p2.next != null) {
	    p1 = p1.next;
	    p2 = p2.next.next;
	}

	return p1;

    }

}
