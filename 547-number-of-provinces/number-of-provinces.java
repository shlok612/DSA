class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjlist.get(i).add(j);
                  
                }
            }
        }
        int count=0;
        int [] vis=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                count++;
                dfs(i, adjlist,vis);
            }
        }
        return count;
    }
    public void dfs(int i, ArrayList<ArrayList<Integer>>adjlist, int[]vis){
        vis[i]=1;
        for(int j : adjlist.get(i)){
            if(vis[j]==0){
                dfs(j,adjlist,vis);
            }
        }
    }
}