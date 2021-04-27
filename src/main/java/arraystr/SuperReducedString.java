package arraystr;

public class SuperReducedString {

    public static void main(String[] args) {
	System.out.println("super reduced: " + superReducedString("aaabccddd "));

	// Even more succinct
	StringBuffer s = new StringBuffer("aaabccddd");
	for (int i = 1; i < s.length(); i++) {
	    if (s.charAt(i) == s.charAt(i - 1)) {
		s.delete(i - 1, i + 1);
		// this is the most crucial step
		i = 0;
	    }
	}
	if (s.length() == 0)
	    System.out.println("Empty String");
	else
	    System.out.println(s);

    }

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
	while (true) {
	    int i = 0;
	    int j = 1;
	    StringBuffer buffer = new StringBuffer(s);
	    while (j < s.length()) {
		if (s.charAt(i) == s.charAt(j)) {
		    buffer.replace(i, i + 1, "1");
		    buffer.replace(j, j + 1, "1");
		    i = i + 2;
		    j = j + 2;

		} else {
		    i++;
		    j++;
		}

	    }

	    String ret = buffer.toString();
	    ret = ret.replace("1", "");
	    if (ret.length() == s.length()) {
		break;
	    } else {
		s = ret;
	    }
	}
	if (s.length() == 0)
	    s = "Empty String";
	return s;

    }

}
