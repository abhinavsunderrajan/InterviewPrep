package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * 
 * @author 746310
 *
 */
public class AnagramSubs {

    public static void main(String[] args) {
	int ans = sherlockAndAnagrams("mom");
	System.out.println(ans);

    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

	Map<String, Integer> subCount = new HashMap<>();
	for (int i = 0; i <= s.length(); i++) {
	    for (int j = i + 1; j <= s.length(); j++) {
		String subs = (s.substring(i, j));
		char[] subsArr = subs.toCharArray();
		Arrays.sort(subsArr);
		subs = new String(subsArr);
		subCount.put(subs, subCount.getOrDefault(subs, 0) + 1);
	    }

	}
	int sum = 0;
	for (Integer count : subCount.values()) {
	    if (count >= 2)
		sum += count * (count - 1) / 2;
	}
	return sum;

    }

}
