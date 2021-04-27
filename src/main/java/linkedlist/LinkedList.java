package linkedlist;

/**
 * Abhinav's implementation of linked list
 * 
 * @author abhinav.sunderrajan
 *
 * @param <T>
 */
public class LinkedList<T> {

    private ListNode<T> head;
    private int size;

    public static class ListNode<T> {
	ListNode<T> next;
	T value;

	public ListNode(T value) {
	    this.value = value;
	}

	public void setNext(ListNode<T> next) {
	    this.next = next;
	}

	public void setValue(T value) {
	    this.value = value;
	}

	public String toString() {
	    return value.toString();
	}

	public ListNode<T> getNext() {
	    return next;
	}

	public T getValue() {
	    return value;
	}

    }

    /**
     * Append value to the linked list.
     * 
     * @param value
     */
    public void add(T value) {
	ListNode<T> node = new ListNode<T>(value);
	if (size == 0)
	    head = node;
	else {
	    ListNode<T> last = head;
	    while (last.next != null)
		last = last.next;
	    last.next = node;
	}
	size++;

    }

    /**
     * Prints the contents of the linked in the order along with its size.
     */
    public void printListContents() {
	if (size > 0) {
	    StringBuffer buffer = new StringBuffer("[");
	    buffer.append(head.value + ",");
	    ListNode<T> nextNode = head.next;
	    while (nextNode != null) {
		buffer.append(nextNode.value + ",");
		nextNode = nextNode.next;
	    }
	    buffer.replace(buffer.length() - 1, buffer.length(), "]");
	    System.out.println(buffer.toString());

	} else
	    System.out.println("empty list");

    }

    /**
     * Add an element at an index
     * 
     * @param value
     * @param index
     */
    public void insertValueAtIndex(T value, int index) {
	if (index > size)
	    throw new IllegalArgumentException("Insert index cannot be greater than its current size: " + size);

	ListNode<T> node = new ListNode<T>(value);
	if (index == 0)
	    head = node;
	else if (index == size)
	    add(value);
	else {
	    int i = 1;
	    ListNode<T> next = head.next;
	    ListNode<T> prev = head;
	    while (i < index) {
		prev = next;
		next = next.next;
		i++;
	    }
	    prev.next = node;

	}

    }

    /**
     * Delete a node at the specified index.
     * 
     * @param index
     */
    public void delNodeAtIndex(int index) {

	if (index >= size)
	    throw new IllegalArgumentException("Illegal index exception");
	if (index == 0) {
	    // delete head
	    ListNode<T> node = head.next;
	    head = node;
	} else {
	    int i = 1;
	    ListNode<T> next = head.next;
	    ListNode<T> prev = head;
	    while (i < index) {
		prev = next;
		next = next.next;
		i++;
	    }
	    prev.next = next.next;
	}
	size--;

    }

    /**
     * Search if a a value val is present in the linked list
     * 
     * @param head start the recursion at the head
     * @param val  the value that you are searching for.
     * @return
     */
    public boolean search(ListNode<T> head, T val) {
	if (head == null)
	    return false;
	if (head.value.equals(val))
	    return true;
	else
	    return search(head.next, val);

    }

    /**
     * Get the size of the linked list
     * 
     * @return size of list
     */
    public int getSize() {
	return size;
    }

    /**
     * Get the head of the linked list
     * 
     * @return the head of the linked list.
     */
    public ListNode<T> getHead() {
	return head;
    }

    public void setHead(ListNode<T> head) {
	this.head = head;
    }

    public void reverseList() {
	ListNode<T> current = this.head;
	ListNode<T> prev = null;
	while (current != null) {
	    ListNode<T> next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;

	}
	this.head = prev;
    }

}
