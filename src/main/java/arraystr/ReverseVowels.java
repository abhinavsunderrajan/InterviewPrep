package arraystr;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
	System.out.println(reverseVowels("adksjhefA"));

    }

    private static String reverseVowels(String s) {

	int low = 0;
	int high = s.length() - 1;
	Set<Character> vowSet = new HashSet<>();
	char[] sArr = s.toCharArray();

	vowSet.add('a');
	vowSet.add('e');
	vowSet.add('i');
	vowSet.add('o');
	vowSet.add('u');
	vowSet.add('A');
	vowSet.add('E');
	vowSet.add('I');
	vowSet.add('O');
	vowSet.add('U');

	while (low < high) {
	    while (!vowSet.contains(sArr[low]) && low < high)
		low++;

	    while (!vowSet.contains(sArr[high]) && high > low)
		high--;

	    char temp = sArr[low];
	    sArr[low] = sArr[high];
	    sArr[high] = temp;
	    low++;
	    high--;

	}

	return new String(sArr);

    }

}
