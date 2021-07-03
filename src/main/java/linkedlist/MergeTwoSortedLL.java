package linkedlist;

import linkedlist.LinkedList.ListNode;

public class MergeTwoSortedLL {

    public static void main(String[] args) {
	LinkedList<Integer> ll1 = new LinkedList<>();
	LinkedList<Integer> ll2 = new LinkedList<>();
	int a1[] = { 5, 10, 15, 40 };
	int a2[] = { 2, 3, 20 };

	LinkedList<Integer> ll3 = new LinkedList<>();
	for (int a : a1)
	    ll1.add(a);
	for (int a : a2)
	    ll2.add(a);

	ll1.printListContents();
	ll2.printListContents();

	ListNode<Integer> p1 = ll1.getHead();
	ListNode<Integer> p2 = ll2.getHead();
	while (p1 != null && p2 != null) {
	    if (p1.value < p2.value) {
		ll3.add(p1.value);
		p1 = p1.getNext();
	    } else {
		ll3.add(p2.value);
		p2 = p2.getNext();
	    }

	}

	while (p2 != null) {
	    ll3.add(p2.value);
	    p2 = p2.getNext();
	}
	while (p1 != null) {
	    ll3.add(p1.value);
	    p1 = p1.getNext();
	}
	ll3.printListContents();

	ListNode<Integer> mergeHead = mergeLists(ll1.getHead(), ll2.getHead());
	while (mergeHead != null) {
	    System.out.println(mergeHead.value);
	    mergeHead = mergeHead.next;
	}
	System.out.println("==================================");

	ll1.printListContents();
	ll2.printListContents();

	mergeHead = mergeTwoLists(ll1.getHead(), ll2.getHead());
	while (mergeHead != null) {
	    System.out.println(mergeHead.value);
	    mergeHead = mergeHead.next;
	}

    }

    static ListNode<Integer> mergeLists(ListNode<Integer> head1, ListNode<Integer> head2) {

	ListNode<Integer> head = null;
	if (head1.value < head2.value) {
	    head = head1;
	    head1 = head1.next;
	} else {
	    head = head2;
	    head2 = head2.next;
	}

	ListNode<Integer> tail = head;

	while (head1 != null && head2 != null) {
	    if (head1.value < head2.value) {
		tail.next = head1;
		head1 = head1.next;
	    } else {
		tail.next = head2;
		head2 = head2.next;
	    }
	    tail = tail.next;
	}

	while (head2 != null) {
	    tail.next = head2;
	    head2 = head2.next;
	    tail = tail.next;
	}

	while (head1 != null) {
	    tail.next = head1;
	    head1 = head1.next;
	    tail = tail.next;
	}

	return head;

    }

    public static ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
	ListNode<Integer> l3 = null;
	ListNode<Integer> headL3 = null;
	ListNode<Integer> start1 = l1;
	ListNode<Integer> start2 = l2;
	while (start1 != null && start2 != null) {
	    if (start1.value < start2.value) {
		if (headL3 == null) {
		    headL3 = new ListNode<Integer>(start1.value);
		    l3 = headL3;
		} else {
		    l3.next = new ListNode<Integer>(start1.value);
		    l3 = l3.next;
		}
		start1 = start1.next;
	    } else {
		if (headL3 == null) {
		    headL3 = new ListNode<Integer>(start2.value);
		    l3 = headL3;
		} else {
		    l3.next = new ListNode<Integer>(start2.value);
		    l3 = l3.next;
		}
		start2 = start2.next;
	    }

	}

	if (start1 == null && start2 == null)
	    return headL3;

	if (start1 == null) {
	    while (start2 != null) {
		l3.next = new ListNode<Integer>(start2.value);
		start2 = start2.next;
		l3 = l3.next;
	    }
	}

	if (start2 == null) {
	    while (start1 != null) {
		l3.next = new ListNode<Integer>(start1.value);
		start1 = start1.next;
		l3 = l3.next;
	    }
	}

	return headL3;

    }

}
