package arraystr;

/**
 * Nice string generative approach.
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * 
 * @author 746310
 *
 */
public class SeparateNumbers {

    public static void main(String[] args) {
	separateNumbers("11111111111111111111111111111111");

    }

    static void separateNumbers(String s) {
	// you generate beautiful strings based on the first digit until
	// it is equal to length of s. If 1st digit does not macth then try
	// 2 digits and so on. Continue until s.length()/2;

	int numDigits = 1;
	boolean found = false;
	while (numDigits <= s.length() / 2) {

	    StringBuffer sb = new StringBuffer();
	    sb.append(s.substring(0, numDigits));
	    long start = Long.parseLong(s.substring(0, numDigits));
	    while (true) {
		sb.append(++start);
		if (sb.length() >= s.length())
		    break;
	    }

	    if (sb.toString().equals(s)) {
		System.out.println("YES " + s.substring(0, numDigits));
		found = true;
		break;
	    } else {
		numDigits++;
	    }

	}
	if (!found)
	    System.out.println("NO");
    }

}
