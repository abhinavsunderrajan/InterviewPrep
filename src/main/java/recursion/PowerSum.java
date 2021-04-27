package recursion;

public class PowerSum {
    static int res = 0;

    private static int power(int x, int n) {
	if (n == 0)
	    return 1;
	if (n % 2 == 0)
	    return power(x, n / 2) * power(x, n / 2);
	else
	    return x * power(x, n / 2) * power(x, n / 2);
    }

    public static void main(String[] args) {
	// System.out.println(power(2, 2));
	check(10, 2);
	System.out.println(res);
    }

    static int checkRecursive(int num, int x, int k, int n, int max) {
	if (x == 0)
	    res++;

	for (int i = k + 1; i <= max; i++) {
	    int remains = x - (int) Math.pow(i, n);
	    if (remains >= 0) {
		int result = checkRecursive(num, remains, i, n, max);
		System.out.println("========= " + result + " =========");
	    }
	}
	System.out.println(x + " " + k);
	return res;
    }

    // Wrapper over checkRecursive()
    static int check(int x, int n) {
	int max = (int) Math.floor(Math.pow(x, 1.0 / n));
	return checkRecursive(x, x, 0, n, max);
    }

}
