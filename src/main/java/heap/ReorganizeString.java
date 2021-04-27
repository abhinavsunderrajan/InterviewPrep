package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same. If possible,
 * output any possible result. If not possible, return the empty string.
 * 
 * @author 746310
 *
 */
public class ReorganizeString {

    public static void main(String[] args) {

	System.out.println(reorganizeString("abbcc"));

    }

    private static String reorganizeString(String s) {
	Map<Character, Integer> countMap = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    Character c = s.charAt(i);
	    countMap.put(c, countMap.getOrDefault(c, 0) + 1);
	}

	System.out.println(countMap);

	PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
	    // Descending order of counts
	    @Override
	    public int compare(Character o1, Character o2) {
		return countMap.get(o2) - countMap.get(o1);
	    }
	});

	pq.addAll(countMap.keySet());

	System.out.println(pq);

	StringBuffer bf = new StringBuffer();
	while (pq.size() > 1) {
	    Character top = pq.poll();
	    Character next = pq.poll();
	    bf.append(top);
	    bf.append(next);
	    countMap.put(top, countMap.get(top) - 1);
	    countMap.put(next, countMap.get(next) - 1);

	    if (countMap.get(top) > 0)
		pq.add(top);
	    if (countMap.get(next) > 0)
		pq.add(next);

	}

	if (!pq.isEmpty()) {
	    if (countMap.get(pq.peek()) > 1)
		return "";
	    else {
		bf.append(pq.poll());
		return bf.toString();
	    }
	}

	return bf.toString();

    }

}
