package linkedlist;

/**
 * {@link https://www.codingninjas.com/codestudio/guided-paths/interview-guide-for-product-based-companies/content/111308/offering/1279694}
 * 
 * @author 746310
 *
 */
public class ReArrangeLinkedList {

    private static class Node {
	Node next;
	int val;

	Node(int val) {
	    this.val = val;
	}

	public String toString() {
	    return val + "";
	}
    }

    private static Node rearrangeOddEven(Node head) {
	Node odd = head;
	Node even = head.next;

	// start position of second list
	Node temp = even;

	while (odd.next != null) {
	    if (even.next == null) {
		break;
	    }
	    odd.next = odd.next.next;
	    odd = odd.next;
	    even.next = even.next.next;
	    even = even.next;
	}
	odd.next = temp;
	return head;
    }

    private static void reorderList(Node head) {

	if (head == null || head.next == null)
	    return;

	Node slow = head;
	Node fast = head;
	Node prev = null;
	while (fast != null) {
	    if (fast.next == null)
		break;
	    fast = fast.next.next;
	    prev = slow;
	    slow = slow.next;
	}
	prev.next = null;
	slow = reverse(slow);
	merge(head, slow);

    }

    private static void merge(Node l1, Node l2) {

	while (l1 != null) {
	    Node l1Next = l1.next;
	    Node l2Next = l2.next;
	    l1.next = l2;
	    if (l1Next == null)
		break;

	    l2.next = l1Next;
	    l1 = l1Next;
	    l2 = l2Next;

	}

    }

    private static Node reverse(Node node) {

	Node prev = null;
	Node curr = node;
	while (curr != null) {
	    Node next = curr.next;
	    curr.next = prev;
	    prev = curr;
	    curr = next;
	}

	return prev;

    }

    private static void printlist(Node node) {
	while (node != null) {
	    System.out.print(node.val + "->");
	    node = node.next;
	}
	System.out.println("NULL");
    }

    public static void main(String args[]) {
	Node head = new Node(1);
	Node curr = head;
	for (int i = 2; i <= 7; i++) {
	    curr.next = new Node(i);
	    curr = curr.next;
	}
	printlist(head);
	rearrangeOddEven(head);
	printlist(head);
	reorderList(head);
	printlist(head);
    }

}
