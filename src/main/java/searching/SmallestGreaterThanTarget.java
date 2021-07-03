package searching;

/**
 * {@link https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/}
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'
 * 
 * @author 746310
 *
 */
public class SmallestGreaterThanTarget {

    public static void main(String[] args) {
	char letters[] = { 'c', 'f', 'j' };
	System.out.println(nextGreatestLetter(letters, 'd'));
	System.out.println(asciiCodes(letters, 'z'));

    }

    private static char asciiCodes(char[] letters, char target) {
	int[] ascii = new int[26];
	for (char c : letters)
	    ascii[c - 'a']++;

	for (int i = (int) (target - 'a') + 1; i < 26; i++) {
	    if (ascii[i] > 0)
		return (char) (i + 'a');
	}

	return letters[0];

    }

    /**
     * Two pointer approach
     * 
     * @param letters
     * @param target
     * @return
     */
    private static char nextGreatestLetter(char[] letters, char target) {

	int left = 0, right = letters.length - 1;
	while (left <= right) {
	    int mid = (left + right) / 2;
	    if (letters[mid] <= target) {
		left++;
	    } else {
		right--;
	    }
	}
	if (left == letters.length) {
	    return letters[0];
	}
	return letters[left];
    }

}
