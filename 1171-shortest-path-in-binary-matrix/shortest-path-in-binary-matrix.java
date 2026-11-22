class Solution {
    class Pair{
        int f, s, t;
        public Pair(int f, int s, int t){
            this.f=f;
            this.s=s;
            this.t=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]dist=new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        dist[0][0]=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(1,0,0));
        int []dr={-1,-1,-1,0,1,1,1,0};
        int []dc={-1,0,1,1,1,0,-1,-1};

        while(!q.isEmpty()){
            Pair x=q.poll();
            int d=x.f;
            int r=x.s;
            int c=x.t;
            if(r == n-1 && c == m-1)
                return d;

            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0 && d+1<dist[nr][nc]){
                    dist[nr][nc]=d+1;
                    if(nr==n-1 && nc==m-1){
                        return 1+d;
                    }
                    q.offer(new Pair(d+1, nr,nc));
                    
                }
            }
            
        }
        return -1;
    }
}