
class Solution {

    int MOD = 1000000007;
    int[][][] dp;

    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, grid, k);
    }

    public int solve(int i, int j, int rem, int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        
        if (i >= m || j >= n) {
            return 0;
        }

        
        rem = (rem + grid[i][j]) % k;

        
        if (i == m - 1 && j == n - 1) {
            return rem == 0 ? 1 : 0;
        }

        if (dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }

        int right = solve(i, j + 1, rem, grid, k);
        int down = solve(i + 1, j, rem, grid, k);

        return dp[i][j][rem] = (right + down) % MOD;
    }
}
