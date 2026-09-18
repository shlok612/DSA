class Solution {
    public int numIslands(char[][] grid) {
        boolean[][]vis=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {

        vis[i][j] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++) {

            int row = i + dr[k];
            int col = j + dc[k];

            if(row >= 0 && row < grid.length &&
               col >= 0 && col < grid[0].length &&
               grid[row][col] == '1' &&
               !vis[row][col]) {

                dfs(row, col, grid, vis);
            }
        }
    }
}