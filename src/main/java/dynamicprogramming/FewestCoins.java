package dynamicprogramming;

import java.util.Arrays;

/**
 * Fewest coins to make change
 * 
 * @author 746310
 *
 */
public class FewestCoins {
    private static final int TOTAL_AMOUNT = 11;
    private static final int COINS[] = { 9, 6, 5, 1 };

    public static void main(String[] args) {
	// amount is 0 through TOTAL_AMOUNT
	int cache[] = new int[TOTAL_AMOUNT + 1];
	int minCoins = computeMinCoins(TOTAL_AMOUNT, cache);
	System.out.println(Arrays.toString(cache));
	System.out.println(minCoins);

    }

    private static int computeMinCoins(int totalAmount, int cache[]) {
	if (totalAmount == 0)
	    return 0;

	// Initialize result
	int res = Integer.MAX_VALUE;

	for (int coin : COINS) {
	    int numCoins = 0;
	    if (coin <= totalAmount) {
		int balance = totalAmount - coin;
		if (cache[balance] > 0)
		    numCoins = 1 + cache[balance];
		else {
		    cache[balance] = computeMinCoins(balance, cache);
		    numCoins = 1 + cache[balance];
		}

		if (numCoins < res) {
		    cache[totalAmount] = numCoins;
		    res = numCoins;
		}
	    }
	}

	return res;

    }

}
