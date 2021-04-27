package backtracking;

public class WordSearch {

    public static void main(String[] args) {
	char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
	System.out.println(exist(board, "ABCCED"));
    }

    private static boolean exist(char[][] board, String word) {
	int m = board.length;
	int n = board[0].length;

	boolean result = false;
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
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
