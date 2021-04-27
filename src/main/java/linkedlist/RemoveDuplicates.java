package linkedlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import linkedlist.LinkedList.ListNode;

public class RemoveDuplicates {

    public static void main(String[] args) throws IOException {
	LinkedList<Integer> ll = new LinkedList<>();
	BufferedReader br = new BufferedReader(new FileReader(
		"C:\\Users\\746310\\eclipse-workspace\\ProgramCreek\\src\\main\\java\\linkedlist\\listdata.txt"));
	while (br.ready()) {
	    ll.add(Integer.parseInt(br.readLine()));
	}
	br.close();
	ll.printListContents();
	removeDuplicates(ll.getHead());

    }

    static ListNode<Integer> removeDuplicates(ListNode<Integer> head) {

	ListNode<Integer> current = head;
	ListNode<Integer> prev = null;

	if (head == null)
	    return null;

	while (current != null) {
	    ListNode<Integer> next = current.next;
	    if (prev != null && prev.value == current.value) {
		while (current.value == prev.value) {
		    current = current.next;
		    if (current == null)
			break;
		}
		prev.next = current;
		prev = current;
		if (current != null)
		    current = current.next;

	    } else {
		prev = current;
		current = next;
	    }

	}
	ListNode<Integer> temp = head;
	while (temp != null) {
	    System.out.print(temp.value + ", ");
	    temp = temp.next;
	}
	return head;

    }

}
