package dynamicprogramming;

import java.util.Arrays;

/**
 * Fewest coins to make change
 * 
 * @author 746310
 *
 */
public class CoinsFewestToMakeAmount {
    private static final int TOTAL_AMOUNT = 11;
    private static final int COINS[] = { 9, 6, 5, 1 };

    public static void main(String[] args) {
	// amount is 0 through TOTAL_AMOUNT. The cache will return the total amount of
	// coins for making changes for all amounts from 0 through TOTAL_AMOUNT

	int cache[] = new int[TOTAL_AMOUNT + 1];
	int minCoins = computeMinCoins(TOTAL_AMOUNT, cache);
	System.out.println(Arrays.toString(cache));
	System.out.println(minCoins);

    }

    private static int computeMinCoins(int amount, int cache[]) {
	if (amount == 0)
	    return 0;

	// Initialize result
	int result = Integer.MAX_VALUE;

	for (int coin : COINS) {
	    int numCoins = 0;
	    if (coin <= amount) {
		int balance = amount - coin;
		if (cache[balance] == 0)
		    cache[balance] = computeMinCoins(balance, cache);

		numCoins = 1 + cache[balance];

		if (numCoins < result) {
		    cache[amount] = numCoins;
		    result = numCoins;
		}
	    }
	}

	return result;

    }

}
