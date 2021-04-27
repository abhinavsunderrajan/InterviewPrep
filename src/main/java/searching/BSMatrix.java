package searching;

public class BSMatrix {

    public static void main(String[] args) {
	int matrix[][] = { { 1 }, { 3 }, { 5 } };
	System.out.println(searchMatrix(matrix, 1));

    }

    private static boolean searchMatrix(int[][] matrix, int target) {
	int row = -1;
	if (matrix.length == 1)
	    row = 0;
	else if (matrix.length == 2) {
	    row = target >= matrix[1][0] ? 1 : 0;

	} else {
	    row = bsRow(matrix, 0, matrix.length - 1, target);
	}
	return bs(matrix[row], 0, matrix[row].length - 1, target);

    }

    private static boolean bs(int[] arr, int low, int high, int target) {

	if (low > high)
	    return false;

	int mid = (low + high) / 2;

	if (arr[mid] == target)
	    return true;

	if (arr[mid] > target)
	    return bs(arr, low, mid - 1, target);
	else
	    return bs(arr, mid + 1, high, target);
    }

    private static int bsRow(int[][] matrix, int low, int high, int target) {

	int mid = (low + high) / 2;
	if (mid == 0 || mid == matrix.length - 1)
	    return mid;

	if (matrix[mid + 1][0] > target && matrix[mid][0] <= target)
	    return mid;

	if (matrix[mid][0] > target)
	    return bsRow(matrix, low, mid - 1, target);
	else
	    return bsRow(matrix, mid + 1, high, target);

    }

}
