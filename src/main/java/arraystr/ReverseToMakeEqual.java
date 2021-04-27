package arraystr;

import java.util.Arrays;

/**
 * Deceptively complex. Inductive reasoning explained in
 * {@link https://www.youtube.com/watch?v=7YoDfM4RbZs}
 * 
 * @author 746310
 *
 */
public class ReverseToMakeEqual {

    public static void main(String[] args) {
	int a1[] = { 1, 2, 3, 4 };
	int a2[] = { 1, 4, 3, 2 };
	System.out.println(areTheyEqual(a1, a2));

    }

    private static boolean areArraysEqual(int a1[], int a2[]) {
	for (int i = 0; i < a1.length; i++) {
	    if (a1[i] != a2[i])
		return false;
	}

	return true;

    }

    /**
     * This is of cubic complexity.
     * 
     * @param array_a
     * @param array_b
     * @return
     */
    private static boolean areTheyEqual(int[] array_a, int[] array_b) {
	Arrays.sort(array_a);
	Arrays.sort(array_b);
	return areArraysEqual(array_a, array_b);
    }

}
