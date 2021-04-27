package arraystr;

public class RotateString {

    public static void main(String[] args) {
	System.out.println(rotationalCipher("A0123456789", 39));

    }

    static String rotationalCipher(String input, int rotationFactor) {

	// Write your code here
	StringBuffer buffer = new StringBuffer("");
	for (char c : input.toCharArray()) {
	    int i = (int) c;
	    if (i >= 65 && i <= 90) {
		i = i - 65;
		int r = rotationFactor % 26;
		i = i + r;
		i = i % 26 + 65;
	    } else if (i >= 97 && i <= 122) {
		i = i - 97;
		int r = rotationFactor % 26;
		i = i + r;
		i = i % 26 + 97;
	    } else if (i >= 48 && i <= 57) {
		i = i - 48;
		int r = rotationFactor % 10;
		i = i + r;
		i = i % 10 + 48;

	    } else {
		buffer.append((char) i);
		continue;
	    }

	    buffer.append((char) i);
	}
	return buffer.toString();

    }

}
