package linkedlist;

import linkedlist.LinkedList.ListNode;

public class RotateLinkedList {

    public static void main(String[] args) {
	LinkedList<Integer> ll1 = new LinkedList<>();
	for (int i = 0; i < 3; i++)
	    ll1.add(i);

	ll1.printListContents();
//	rotateCounterClock(ll1, 4);
//
//	ll1 = new LinkedList<>();
//	for (int i = 10; i < 70; i = i + 10)
//	    ll1.add(i);

	rotateClock(ll1, 4);

    }

    private static void rotateClock(LinkedList<Integer> ll, int k) {
	ListNode<Integer> last = ll.getHead();
	int size = 1;
	while (last.next != null) {
	    last = last.next;
	    size++;
	}

	k = k >= size ? k % size : k;

	ListNode<Integer> k1 = getKthFromLast(ll, k + 1);
	ListNode<Integer> kth = k1.getNext();

	while (last.next != null)
	    last = last.next;

	k1.setNext(null);
	last.setNext(ll.getHead());
	ll.setHead(kth);

	ll.printListContents();

    }

    private static ListNode<Integer> getKthFromLast(LinkedList<Integer> ll1, int k) {
	ListNode<Integer> p1 = ll1.getHead();
	ListNode<Integer> p2;
	int count = 1;
	while (count < k) {
	    p1 = p1.getNext();
	    count++;
	}

	p2 = ll1.getHead();
	while (p1.next != null) {
	    p1 = p1.next;
	    p2 = p2.next;

	}

	return p2;
    }

    private static void rotateCounterClock(LinkedList<Integer> ll1, int k) {
	ListNode<Integer> current = ll1.getHead();
	ListNode<Integer> kth = null;
	int count = 0;
	while (count < k) {
	    kth = current;
	    current = current.next;
	    count++;
	}
	ListNode<Integer> k1 = kth.next;

	ListNode<Integer> last = null;
	while (current != null) {
	    last = current;
	    current = current.next;
	}

	kth.setNext(null);
	last.setNext(ll1.getHead());
	ll1.setHead(k1);
	ll1.printListContents();
    }

}
