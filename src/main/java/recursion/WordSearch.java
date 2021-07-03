package recursion;

/**
 * https://leetcode.com/problems/word-search/
 * 
 * @author 746310
 *
 */
public class WordSearch {

    public static void main(String[] args) {
	char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
	String word = "SEE";
	System.out.println(exist(board, word));

    }

    private static boolean exist(char[][] board, String word) {
	int row = board.length;
	int col = board[0].length;

	boolean result = false;
	for (int i = 0; i < row; i++) {
	    for (int j = 0; j < col; j++) {
		// start checking from the 1st character or the 0th index
		if (dfs(board, word, i, j, 0)) {
		    result = true;
		}
	    }
	}

	return result;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int wordIndex) {
	int m = board.length;
	int n = board[0].length;

	if (row < 0 || col < 0 || row >= m || col >= n) {
	    return false;
	}

	if (board[row][col] == word.charAt(wordIndex)) {
	    // cannot reuse the same character again.
	    char temp = board[row][col];
	    board[row][col] = '#';
	    if (wordIndex == word.length() - 1) {
		return true;
	    } else if (dfs(board, word, row - 1, col, wordIndex + 1) || dfs(board, word, row + 1, col, wordIndex + 1)
		    || dfs(board, word, row, col - 1, wordIndex + 1) || dfs(board, word, row, col + 1, wordIndex + 1)) {
		return true;
	    }
	    board[row][col] = temp;
	}

	return false;
    }

}
