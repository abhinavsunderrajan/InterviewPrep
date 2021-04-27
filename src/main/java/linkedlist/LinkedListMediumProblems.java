package linkedlist;

import linkedlist.LinkedList.ListNode;

/**
 * Read the solution in
 * {@link https://leetcode.com/problems/reverse-linked-list-ii/solution/} and
 * the figure.
 * 
 * @author 746310
 *
 */
public class LinkedListMediumProblems {

    public static void main(String args[]) {
	LinkedList<Integer> ll = new LinkedList<>();
	int a1[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	for (int a : a1)
	    ll.add(a);
	ll.printListContents();
	ListNode<Integer> newHead = reverse(ll.getHead());
	ll.setHead(newHead);
	ll.printListContents();

	// Get back the original one.

	newHead = reverse(ll.getHead());
	ll.setHead(newHead);
	ll.printListContents();
	reverseBetween(ll.getHead(), 2, 6);
	ll.printListContents();
	swapPairs(ll.getHead());
	ll.printListContents();
    }

    private static ListNode<Integer> swapPairs(ListNode<Integer> head) {
	ListNode<Integer> current = head;
	while (current != null && current.next != null) {
	    int cVal = current.getValue();
	    current.setValue(current.next.getValue());
	    current.next.setValue(cVal);
	    current = current.next.next;

	}
	return head;

    }

    /**
     * Reverse the linked list and return the new head.
     * 
     * @param head
     * @return
     */
    private static ListNode<Integer> reverse(ListNode<Integer> head) {
	ListNode<Integer> current = head;
	ListNode<Integer> prev = null;

	while (current != null) {
	    ListNode<Integer> next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}

	return prev;
    }

    /**
     * Reverse the list between left and right only where left<right. Left and right
     * are 1 based indices.
     * 
     * We do the above iteratively and we will achieve what the question asks us to
     * do. Let's look at the steps for the algorithm now.
     * 
     * We need two pointers, prev and cur as in the vanilla reversal.
     * 
     * The prev pointer should be initialized to None initially while cur is
     * initialized to the head of the linked list.
     * 
     * We progress the cur pointer one step at a time and the prev pointer follows
     * it.
     * 
     * We keep progressing the two pointers in this way until the cur pointer
     * reaches the m^{th}m th node from the beginning of the list. This is the point
     * from where we start reversing our linked list.
     * 
     * An important thing to note here is the usage of two additional pointers which
     * we will call as tail and con. The tail pointer points to the m th node from
     * the beginning of the linked list and we call it a tail pointer since this
     * node becomes the tail of the reverse sublist. The con points to the node one
     * before m th node and this connects to the new head of the reversed sublist.
     * 
     * The tail and the con pointers are set once initially and then used in the end
     * to finish the linked list reversal.
     * 
     * Once we reach the m th node, we iteratively reverse the links as explained
     * before using the two pointers. We keep on doing this until we are done
     * reversing the link (next pointer) for the n th node. At that point, the prev
     * pointer would point to the n th node.
     * 
     * We use the con pointer to attach to the prev pointer since the node now
     * pointed to by the prev pointer (the n th node from the beginning) will come
     * in place of the m th node due after the reversal. Similarly, we will make use
     * of the tail pointer to connect to the node next to the prev node i.e. (n+1)th
     * node from the beginning.
     * 
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode<Integer> reverseBetween(ListNode<Integer> head, int m, int n) {
	// Empty list
	if (head == null) {
	    return null;
	}

	// Move the two pointers until they reach the proper starting point
	// in the list.
	ListNode<Integer> cur = head, prev = null;
	while (m > 1) {
	    prev = cur;
	    cur = cur.next;
	    m--;
	    n--;
	}

	// The two pointers that will fix the final connections.
	ListNode<Integer> con = prev, tail = cur;

	// Iteratively reverse the nodes until n becomes 0.
	while (n > 0) {
	    ListNode<Integer> next = cur.next;
	    cur.next = prev;
	    prev = cur;
	    cur = next;
	    n--;
	}

	// Adjust the final connections as explained in the algorithm
	if (con != null) {
	    con.next = prev;
	} else {
	    head = prev;
	}

	tail.next = cur;
	return head;

    }
}
