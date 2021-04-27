package arraystr;

import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
	String str = "quhxgrhqqaccxeprunllfieilbothbbmpsg";
	String ret = removeAdjacentDuplicates(str);
	System.out.println(ret);
	System.out.println(reverseWords("i.like.this.program.very.much"));
    }

    private static String removeAdjacentDuplicates(String str) {
	char[] strArr = str.toCharArray();
	Stack<Character> bf = new Stack<>();
	Character prev = strArr[0];
	bf.add(prev);
	for (int i = 1; i < strArr.length; i++) {
	    Character c = strArr[i];
	    if (c == prev) {
		if (bf.peek() == c)
		    bf.pop();
		prev = c;
		continue;
	    } else {
		bf.add(c);
		prev = c;
	    }

	}
	char[] ret = new char[bf.size()];
	int index = ret.length - 1;
	while (!bf.isEmpty()) {
	    ret[index] = bf.pop();
	    index--;

	}

	return new String(ret);

    }

    private static String reverseWords(String S) {

	String words[] = S.split("\\.");
	int i = 0;
	int j = words.length - 1;
	while (i < j) {
	    String temp = words[i];
	    words[i] = words[j];
	    words[j] = temp;
	    i++;
	    j--;
	}

	StringBuffer bf = new StringBuffer();
	for (String word : words) {
	    bf.append(word);
	    bf.append(".");
	}

	return bf.substring(0, bf.length() - 1).toString();
    }

}
