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
    private static final int[] profits = { 60, 50, 90, 30 };
    private static final int MAX_WEIGHT = 5;

    public static void main(String[] args) {
	int numItems = profits.length;
	int profitArray[][] = new int[numItems][MAX_WEIGHT + 1];
	for (int item = 0; item < numItems; item++) {
	    System.out.println("Include item: " + (item + 1));
	    for (int weight = 0; weight <= MAX_WEIGHT; weight++) {
		// if max weight is 0 then you cannot add any item hence profit is 0
		if (weight == 0)
		    continue;
		// If the weight of the item is greater than the max allowable weight cannot
		// include that item, look for previous solutions excluding this current weight.
		if (weights[item] > weight) {
		    // If you are considering the first item then you cannot go to a negative index
		    if (item == 0)
			profitArray[item][weight] = 0;
		    else
			profitArray[item][weight] = profitArray[item - 1][weight];

		} else {
		    if (item == 0)
			profitArray[0][weight] = profits[0];
		    else {

			int excludeProfit = profitArray[item - 1][weight];
			int weightIndex = weight - weights[item];
			// include the item and get the profit for the weight remaining remaining
			// subject to the max weight constraint
			int includeProfit = profits[item];
			if (weightIndex >= 0)
			    includeProfit += profitArray[item - 1][weightIndex];
			profitArray[item][weight] = Math.max(excludeProfit, includeProfit);

		    }
		}
	    }

	}
	for (int i = 0; i < profitArray.length; i++)
	    System.out.println(Arrays.toString(profitArray[i]));
	System.out.println("Max profit: " + profitArray[numItems - 1][MAX_WEIGHT]);
    }

}
