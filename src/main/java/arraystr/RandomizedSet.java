package arraystr;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Contains no duplicates.
 * 
 * @author 746310
 *
 */
class RandomizedSet {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> set;
    private int[] arr;
    private int index;
    private Random random;

    public RandomizedSet() {
	set = new HashMap<>();
	arr = new int[100000];
	random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {

	if (set.containsKey(val))
	    return false;
	else {
	    set.put(val, index);
	    arr[index++] = val;
	}
	return true;

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
	if (!set.containsKey(val))
	    return false;
	else {
	    int valIndex = set.get(val);
	    set.remove(val);
	    if (valIndex != index - 1) {
		set.put(arr[index - 1], valIndex);
		int temp = arr[valIndex];
		arr[valIndex] = arr[index - 1];
		arr[index - 1] = temp;
	    }
	    index--;
	    return true;

	}

    }

    /** Get a random element from the set. */
    public int getRandom() {
	int randIndex = random.nextInt(index);
	return arr[randIndex];
    }

    public static void main(String args[]) {
	RandomizedSet rSet = new RandomizedSet();
	rSet.insert(0);
	rSet.remove(0);
	System.out.println(rSet.insert(0));
    }
}