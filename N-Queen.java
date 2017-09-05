class Solution {
    public boolean[] cols;
    public boolean[] diag1;
    public boolean[] diag2;
    public int N;
    public int totalNQueens(int n) {
        N = n;
        cols = new boolean[N];
        diag1 = new boolean[2*N];
        diag2 = new boolean[2*N];
        return helper(0, 0);
    }
    
    public int helper(int row, int count) {
        for (int i = 0; i < N; i++) {
            if (cols[i]) continue;
            if (diag1[row - i + N]) continue;
            if (diag2[i + row]) continue;
            if (row == N - 1) {
                count++;
            } else {
                cols[i] = true;
                diag1[row - i + N] = true;
                diag2[row + i] = true;
                count = helper(row + 1, count);
                cols[i] = false;
                diag1[row - i + N] = false;
                diag2[row + i] = false;
            } 
        }
        return count;
    }
}