package matrix;

/**
 * Constant memory implementation.
 * 
 * @author 746310
 *
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
	int[][] matrix = { { 1, 2, 0, 1, 5 }, { 2, 3, 2, 3, 2 }, { 0, 4, 1, 8, 7 }, { 3, 3, 0, 1, 2 } };
	int nrow = matrix[0].length;
	int ncol = matrix.length;
	for (int i = 0; i < nrow; i++) {
	    for (int elem : matrix[i])

		for (int j = 0; j < ncol; j++) {

		}
	}

    }

}
