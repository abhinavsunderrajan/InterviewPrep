package dynamicprogramming;

/**
 * {@link https://www.youtube.com/watch?v=hsVUXvqGHeI}
 * 
 * @author 746310
 *
 */
public class MinimumCostToTravel {

    public static void main(String[] args) {
	int[] days = { 1, 4, 6, 7, 8, 20 };
	int cost[] = { 2, 7, 15 };
	int mem[] = new int[days.length];
	int minCost = getMinCost(days, cost, 0, mem);
	System.out.println(minCost);

    }

    private static int getMinCost(int[] days, int[] cost, int dayIndex, int[] mem) {
	if (dayIndex >= days.length)
	    return 0;

	if (mem[dayIndex] > 0)
	    return mem[dayIndex];

	int newDayIndex;
	for (newDayIndex = dayIndex; newDayIndex < days.length; newDayIndex++)
	    if (days[newDayIndex] >= days[dayIndex] + 7)
		break;

	int sevenDayCost = getMinCost(days, cost, newDayIndex, mem) + cost[1];

	int oneDayCost = getMinCost(days, cost, dayIndex + 1, mem) + cost[0];

	for (newDayIndex = dayIndex; newDayIndex < days.length; newDayIndex++)
	    if (days[newDayIndex] >= days[dayIndex] + 30)
		break;

	int thirtyDayCost = getMinCost(days, cost, newDayIndex, mem) + cost[2];

	mem[dayIndex] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
	return mem[dayIndex];
    }

}
