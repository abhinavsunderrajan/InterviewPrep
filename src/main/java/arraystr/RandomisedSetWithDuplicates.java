package arraystr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * (
 * {@link https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/}
 * All operations should be O(1)
 * 
 * @author 746310
 *
 */
public class RandomisedSetWithDuplicates {
    private Map<Integer, HashSet<Integer>> map;
    private int size;
    private int arr[];
    private Random r;

    /** Initialize your data structure here. */
    public RandomisedSetWithDuplicates() {
	arr = new int[10];
	map = new HashMap<>();
	r = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
	arr[size] = val;
	if (map.containsKey(val)) {
	    map.get(val).add(size);
	    size++;
	    return false;
	} else {
	    HashSet<Integer> indexArr = new HashSet<>();
	    indexArr.add(size);
	    map.put(val, indexArr);
	    size++;
	    return true;
	}

    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
	if (!map.containsKey(val)) {
	    return false;
	} else {
	    HashSet<Integer> indices = map.get(val);
	    int firstIndex = indices.iterator().next();
	    indices.remove(firstIndex);
	    if (indices.size() == 0)
		map.remove(val);

	    arr[firstIndex] = arr[size - 1];
	    if (map.containsKey(arr[firstIndex])) {
		map.get(arr[size - 1]).remove(size - 1);
		map.get(arr[firstIndex]).add(firstIndex);
	    }

	    size--;
	    return true;
	}

    }

    /** Get a random element from the collection. */
    public int getRandom() {
	return arr[r.nextInt(size)];

    }

    public static void main(String args[]) {
	RandomisedSetWithDuplicates rswd = new RandomisedSetWithDuplicates();
	rswd.insert(1);
	rswd.insert(1);
	rswd.insert(9);
	rswd.insert(9);
	System.out.println(rswd.map);
	System.out.println(rswd.getRandom());
	rswd.remove(9);
	System.out.println(rswd.map);

    }
}
