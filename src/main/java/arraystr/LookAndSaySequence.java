package arraystr;

public class LookAndSaySequence {

    public static void main(String[] args) {
	String first = "1";
	String second = "11";
	System.out.println(first);
	System.out.println(second);
	String start = second;
	int n = 5;
	for (int i = 2; i <= n; i++) {
	    StringBuffer buff = new StringBuffer();
	    Character prev = null;
	    int count = 0;
	    for (Character c : start.toCharArray()) {
		if (prev == null) {
		    prev = c;
		    count++;
		    continue;
		} else if (prev == c)
		    count++;
		else {
		    buff.append(String.valueOf(count) + prev.toString());
		    prev = c;
		    count = 1;
		}
	    }
	    if (count > 0) {
		buff.append(String.valueOf(count) + prev.toString());
	    }
	    start = buff.toString();
	    System.out.println(start);

	}

    }

}
