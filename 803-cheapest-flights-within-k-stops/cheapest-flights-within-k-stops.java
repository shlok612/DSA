class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int f, int s){
            this.first=f;
            this.second=s;

        }
    }
    class Tuple{
        int stop;
        int node;
        int cost;
        public Tuple(int s, int n, int c){
            this.stop=s;
            this.node=n;
            this.cost=c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
           ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
           for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
           }
           int m=flights.length;
           for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
           }
           int []dist=new int[n];
           for(int i=0; i<n;i++){
            dist[i]=Integer.MAX_VALUE;
           }
           Queue<Tuple>q= new LinkedList<>();
           q.add(new Tuple(0,src,0));
           while(!q.isEmpty()){
            Tuple t=q.remove();
            int stop=t.stop;
            int node=t.node;
            int cost=t.cost;
            if(stop>k){
                continue;
            }
            for(Pair it : adj.get(node)){
                int neig=it.first;
                int mon=it.second;
                if(mon+cost<dist[neig] && stop<=k){
                    dist[neig]=mon+cost;
                    q.add(new Tuple(stop+1,neig,cost+mon));
                }
            }

           }
           if(dist[dst]==2147483647){
            return -1;
           }
           return dist[dst];

    }

}