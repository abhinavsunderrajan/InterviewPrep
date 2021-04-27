package arraystr;

import java.util.Arrays;

public class ReverseWodsInString {

    public static void main(String[] args) {
	String name = "Abhinav Sunder Rajan Chingu Piku";
	String[] splits = name.split(" ");
	System.out.println(Arrays.toString(splits));

	int index1 = 0;
	int index2 = splits.length - 1;
	while (index1 < index2) {
	    String temp = splits[index1];
	    splits[index1] = splits[index2];
	    splits[index2] = temp;
	    index1++;
	    index2--;
	}
	System.out.println(Arrays.toString(splits));

    }

}
