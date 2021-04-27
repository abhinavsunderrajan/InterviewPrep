package dynamicprogramming;

import java.util.Arrays;

/**
 * Solve subproblems for different max weights and items combinations. what are
 * all the items(1,2,3,4) for max weights 0 - MAX_WEIGHT.
 * 
 * @author 746310
 *
 */
public class KnapSackZeroOne {

    private static final int[] weights = { 5, 3, 4, 2 };
    private static final int[] profits = { 60, 50, 70, 30 };
    private static final int MAX_WEIGHT = 5;

    public static void main(String[] args) {
	int numItems = profits.length;
	int profitArray[][] = new int[numItems][MAX_WEIGHT + 1];
	for (int item = 0; item < numItems; item++) {
	    System.out.println("Include item: " + (item + 1));
	    for (int maxWeight = 0; maxWeight <= MAX_WEIGHT; maxWeight++) {
		// if max weight is 0 then you cannot add any item hence profit is 0
		if (maxWeight == 0)
		    continue;
		// If the weight of the item is greater than the max allowable weight cannot
		// include that item, look for previous solutions exclusing this current weight.
		if (weights[item] > maxWeight) {
		    // If you are considering the first item then you cannot go to a negative index
		    if (item == 0)
			profitArray[item][maxWeight] = 0;
		    else
			profitArray[item][maxWeight] = profitArray[item - 1][maxWeight];

		} else {
		    if (item == 0)
			profitArray[item][maxWeight] = profits[item];
		    else {

			int itemExclude = profitArray[item - 1][maxWeight];
			int weightIndex = maxWeight - weights[item];
			int itemInclude = profits[item];
			if (weightIndex >= 0)
			    itemInclude += profitArray[item - 1][weightIndex];
			profitArray[item][maxWeight] = Math.max(itemExclude, itemInclude);

		    }
		}
	    }

	}
	for (int i = 0; i < profitArray.length; i++)
	    System.out.println(Arrays.toString(profitArray[i]));
	System.out.println("Max profit: " + profitArray[numItems - 1][MAX_WEIGHT]);
    }

}
