class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0; i<n;i++){
            if(color[i]==-1){
                
                if(check(i, graph, color)==false){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean check(int n, int[][]graph, int []color){
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        color[n]=0;
        while(!q.isEmpty()){
            int x=q.poll();
            for(int it : graph[x]){
                if(color[it]==-1){
                   color[it]=1-color[x];
                   q.add(it); 
                }
                else if(color[it]==color[x]){
                    return false;
                }
            }

        }
        return true;
    }
}