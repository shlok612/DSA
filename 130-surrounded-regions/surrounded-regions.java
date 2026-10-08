class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        int [][]vis=new int[m][n];

        for(int i=0; i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board, vis);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1, board, vis);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0, j, board, vis);
            }
            if(board[m-1][j]=='O'){
                dfs(m-1, j, board, vis);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(vis[i][j]!=1){
                    board[i][j]='X';
                }
            }
        }
        
    }
    public void dfs(int r, int c, char[][]board, int[][]vis){
        vis[r][c]=1;

        int m=board.length;
        int n=board[0].length;

        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};

        for(int i=0; i<4;i++){
            int nr=r+delrow[i];
            int nc=c+ delcol[i];

            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]!=1 && board[nr][nc]=='O'){
                dfs(nr, nc , board, vis);
            }
        }

    }
}