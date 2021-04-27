package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IcecreamParlour {

    public static void main(String[] args) {
	int arr[] = { 1, 3, 4, 5, 6 };
	int m = 6;
	System.out.println(Arrays.toString(icecreamParlor(m, arr)));

    }

    static int[] icecreamParlor(int m, int[] arr) {

	int ret[] = new int[2];
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < arr.length; i++)
	    map.put(arr[i], i);

	for (int i = 0; i < arr.length; i++) {
	    int ic1 = arr[i];
	    if (map.containsKey((m - ic1))) {
		int j = map.get((m - ic1));
		if (i != j) {
		    ret[0] = i + 1;
		    ret[1] = j + 1;
		    break;
		}

	    }

	}

	return ret;

    }

}
