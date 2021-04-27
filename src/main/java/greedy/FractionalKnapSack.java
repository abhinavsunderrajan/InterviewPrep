package greedy;

public class FractionalKnapSack {

    public static void main(String[] args) {

	double[] profits = { 10, 5, 15, 7, 6, 18, 3 };
	int[] weights = { 2, 3, 5, 7, 1, 4, 1 };
	int weightLimit = 15;
	double profitPerUnitWt[] = new double[weights.length];
	for (int i = 0; i < profits.length; i++)
	    profitPerUnitWt[i] = profits[i] / weights[i];

	double profit = 0;
	double weight = 0;
	while (true) {
	    int item = getArgMax(profitPerUnitWt);
	    if (item == -1)
		break;

	    if ((weight + weights[item]) > weightLimit) {
		int itemWeight = weights[item];
		if (itemWeight == 1)
		    break;

		while (weight < weightLimit) {
		    profit += profitPerUnitWt[item];
		    weight += 1;
		}
		break;
	    }
	    profit += weights[item] * profitPerUnitWt[item];
	    weight = weight + weights[item];
	    // no need to look at the item again
	    profitPerUnitWt[item] = Double.MIN_VALUE;

	}

	System.out.println("Max greedy profit: " + profit);

    }

    private static int getArgMax(double arr[]) {
	double max = Double.MIN_VALUE;
	int argMax = -1;
	for (int i = 0; i < arr.length; i++)
	    if (arr[i] > max) {
		max = arr[i];
		argMax = i;
	    }

	return argMax;
    }

}
