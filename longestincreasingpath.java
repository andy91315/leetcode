class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int result = dfs(matrix, i, j, cache);
        		max = Math.max(max, result);
        	}
        }
        return max;
    }

    public int dfs(int[][] matrix, int x, int y, int[][] cache) {
    	if (cache[x][y] != 0) {
    		return cache[x][y];
    	}
    	int max = 1;
    	for (int i = 0; i < 4; i++) {
    		int newx = x + dirs[i][0];
    		int newy = y + dirs[i][1];
    		if (newx < 0 || newx >= matrix.length || newy < 0 || newy >= matrix[0].length || matrix[newx][newy] >= matrix[x][y]) continue;
    		int temp = 1 + dfs(matrix, newx, newy, cache);
    		max = Math.max(max, temp);
    	}
    	cache[x][y] = max;
    	return max;
    }
}