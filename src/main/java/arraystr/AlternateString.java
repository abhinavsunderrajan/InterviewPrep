package arraystr;

import java.util.HashSet;
import java.util.Set;

public class AlternateString {

    public static void main(String[] args) {
	System.out.println(alternate("beabeefeab"));

    }

    // Complete the alternate function below.
    static int alternate(String s) {
	Set<Character> set = new HashSet<>();
	for (char c : s.toCharArray())
	    set.add(c);

	char arr[] = new char[set.size()];
	int index = 0;
	for (Character c : set) {
	    arr[index] = c;
	    index++;
	}

	String max = "";
	for (int i = 0; i < arr.length; i++) {
	    for (int j = i + 1; j < arr.length; j++) {

		String trial = s;
		for (int k = 0; k < arr.length; k++) {
		    if (k == i || k == j)
			continue;
		    trial = trial.replace(arr[k] + "", "");
		}
		if (isValid(trial) && trial.length() > max.length()) {
		    max = trial;
		    System.out.println(max);
		}

	    }

	}

	return max.length();

    }

    static boolean isValid(String trial) {
	if (trial.length() > 0) {
	    int a = 0;
	    int b = 2;
	    boolean isValid = true;
	    while (b < trial.length()) {
		if (trial.charAt(a) != trial.charAt(b)) {
		    isValid = false;
		    break;
		}
		a++;
		b++;
	    }
	    return isValid;
	} else {
	    return false;
	}
    }

}
