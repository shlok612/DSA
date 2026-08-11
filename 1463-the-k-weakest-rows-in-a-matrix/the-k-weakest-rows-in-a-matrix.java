class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int []> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
        );
        for(int i=0;i<mat.length;i++){
            int c=fun(mat[i]);
            int [] arr={c,i};
            pq.offer(arr);
        }
        int []ans=new int[k];
        int y=0;
        while(k>0){
            int []x=pq.poll();
            ans[y]=x[1];
            y++;
            k--;
        }
        return ans;
        
    }
    public int fun(int[]arr){
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                c++;
            }
        }
        return c;
    }
}