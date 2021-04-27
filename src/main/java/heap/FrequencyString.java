package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Intelligent use of priority queue and comparator.
 * 
 * @author 746310
 *
 */
public class FrequencyString {

    public static void main(String[] args) {
	System.out.println(frequencySort("tree"));

    }

    private static String frequencySort(String s) {

	Map<Character, Integer> countMap = new HashMap<>();
	for (char c : s.toCharArray())
	    countMap.put(c, countMap.getOrDefault(c, 0) + 1);

	PriorityQueue<Character> q = new PriorityQueue<>(new Comparator<Character>() {

	    public int compare(Character c1, Character c2) {
		return countMap.get(c2) - countMap.get(c1);
	    }

	});

	q.addAll(countMap.keySet());

	StringBuffer bf = new StringBuffer();
	while (!q.isEmpty()) {
	    Character c = q.poll();
	    int count = countMap.get(c);
	    while (count > 0) {
		bf.append(c);
		count--;
	    }
	}

	return bf.toString();

    }

}
