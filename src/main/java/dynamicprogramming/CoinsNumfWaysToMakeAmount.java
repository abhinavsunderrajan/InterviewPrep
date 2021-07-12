package dynamicprogramming;

import java.util.Arrays;

/**
 * {@link https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/}
 * Number of ways to make change for an amount.
 * 
 * @author 746310
 *
 */
public class CoinsNumfWaysToMakeAmount {

    private static final int TOTAL_AMOUNT = 11;
    private static final int COINS[] = { 1, 2, 5 };

    public static void main(String[] args) {
	System.out.println(solution1Drr());
	System.out.println("==========================");
	System.out.println(solution2DArr());
    }

    /**
     * Similar to the zero 1 knapsack problem
     * 
     * @return
     */
    private static int solution2DArr() {

	int[][] dpArr = new int[COINS.length][TOTAL_AMOUNT + 1];
	for (int i = 0; i < COINS.length; i++) {
	    for (int amount = 0; amount <= TOTAL_AMOUNT; amount++) {
		if (amount == 0) {
		    // if the amount is zero then don't use the coin hence
		    dpArr[i][amount] = 1;
		    continue;
		}
		if (amount < COINS[0])
		    dpArr[i][amount] = 0;
		else {
		    // withoutCoin number of ways to make the amount without making use of the coin
		    // in consideration

		    // withCoin represents the number of ways to make amount using the coin in
		    // consideration.
		    int withoutCoin = 0;
		    if (i - 1 >= 0)
			withoutCoin = dpArr[i - 1][amount];
		    int withCoin = 0;
		    if (amount >= COINS[i])
			withCoin = dpArr[i][(amount - COINS[i])];
		    dpArr[i][amount] = withoutCoin + withCoin;
		}

	    }
	}

	for (int i = 0; i < dpArr.length; i++)
	    System.out.println(Arrays.toString(dpArr[i]));

	return dpArr[COINS.length - 1][TOTAL_AMOUNT];

    }

    private static int solution1Drr() {
	// The dp array consists of ways to make amounts 0 - n
	// each index of dparr represents the amount
	int dpArr[] = new int[TOTAL_AMOUNT + 1];
	// There is 1 way of making change for 0 dollars i.e. with 0 coins.
	dpArr[0] = 1;

	// Go through all of the coins
	for (int coin : COINS) {
	    // Make a comparison to each index value
	    // of ways with the coin value.
	    for (int amount = 1; amount < dpArr.length; amount++) {
		// if coin is greater than amount you cannot do nothing.
		if (coin <= amount) {
		    // Update the ways array
		    // for example if amount is 6 and coin considered is 5
		    // numWays for 6 = numWays for 5 + numWays for 6
		    dpArr[amount] += dpArr[(amount - coin)];
		}
	    }
	}

	return dpArr[TOTAL_AMOUNT];

    }

}
