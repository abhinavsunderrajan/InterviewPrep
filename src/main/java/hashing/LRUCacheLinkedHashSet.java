package hashing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * LRU cache implementation using a LinkedHashSet
 * 
 * @author 746310
 *
 */
public class LRUCacheLinkedHashSet {
    private int capacity;
    private Set<Integer> cache;

    public LRUCacheLinkedHashSet(int capacity) {
	cache = new LinkedHashSet<>(capacity);
	this.capacity = capacity;
    }

    /**
     * This is O(1) time.
     * 
     * @param key
     */
    public void refer(int key) {
	if (get(key) == false)
	    put(key);
    }

    private void put(int key) {

	if (cache.size() == capacity) {
	    int firstKey = cache.iterator().next();
	    cache.remove(firstKey);
	}

	cache.add(key);
    }

    public boolean get(int key) {
	if (!cache.contains(key))
	    return false;
	cache.remove(key);
	cache.add(key);
	return true;
    }

    // displays contents of cache in Reverse Order
    public void display() {
	LinkedList<Integer> list = new LinkedList<>(cache);
	Iterator<Integer> itr = list.descendingIterator();

	while (itr.hasNext())
	    System.out.print(itr.next() + " ");
    }

    public static void main(String[] args) {
	LRUCacheLinkedHashSet ca = new LRUCacheLinkedHashSet(4);
	ca.refer(1);
	ca.refer(2);
	ca.refer(3);
	ca.refer(1);
	ca.refer(4);
	ca.refer(5);
	ca.display();

    }

}
