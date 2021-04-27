package recursion;

/**
 * {@link https://www.geeksforgeeks.org/breaking-integer-to-get-maximum-product/#:~:text=Given%20a%20number%20n%2C%20the,18%20is%20maximum%20possible%20product.}
 * 
 * @author 746310
 *
 */
public class GreatestProduct {
    private static int ans;

    public static void main(String[] args) {
	int num = 11;
	System.out.println(maxProduct(num));

    }

    private static int maxProduct(int num) {
	if (num == 2 || num == 3)
	    return (num - 1);
	if (num == 4)
	    return num;

	int a = num;
	int count = 0;
	while (a > 4) {
	    a -= 3;
	    count++;
	}
	return (int) Math.pow(3, count) * a;

    }

}
