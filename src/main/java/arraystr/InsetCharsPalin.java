package arraystr;

public class InsetCharsPalin {

    public static void main(String[] args) {
	int count = countMin("helppreanadkada");
	System.out.println(count);

    }

    private static int countMin(String str) {
	int count = str.length() - 1;
	if (isPalin(str))
	    return 0;
	else {

	    for (int i = 2; i <= str.length(); i++) {
		for (int j = 0; j <= str.length() - i; j++) {
		    String subStr = str.substring(j, j + i);
		    System.out.println(subStr);
		    if (isPalin(subStr))
			count = str.length() - subStr.length();
		}

	    }

	}

	return count;
    }

    private static boolean isPalin(String s) {
	if (s.length() == 1)
	    return true;

	boolean isPalin = true;
	int i = 0;
	int j = s.length() - 1;
	while (i < j) {
	    if (s.charAt(i) != s.charAt(j)) {
		isPalin = false;
		break;
	    } else {
		i++;
		j--;
	    }
	}
	return isPalin;

    }

}
