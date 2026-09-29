class Solution {
    class Pair{
        int row;
        int col;
        int tm;
        public Pair(int r, int c, int tm){
            this.row=r;
            this.col=c;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int time=0;
        int cntfr=0;
        Queue<Pair> q=new LinkedList<>();
        int [][] vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1){
                    vis[i][j]=1;
                    cntfr++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int cnt=0;
            int []dr={-1,0,1,0};
            int []dc={0,1,0,-1};
            while(!q.isEmpty()){
                int r=q.peek().row;
                int c=q.peek().col;
                int t=q.peek().tm;
                time=Math.max(time,t);
                q.poll();
                for(int k=0;k<4;k++){
                    int nr=r+dr[k];
                    int nc=c+dc[k];

                    if(nr>=0 && nr<vis.length && nc>=0 && nc<vis[0].length && vis[nr][nc]==1){
                        vis[nr][nc]=2;
                        cnt++;
                        q.add(new Pair(nr,nc,time+1));
                    }
                }
            }
            
        
        if(cntfr!=cnt){
                return -1;
            }
            return time;
    }
}