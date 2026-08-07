class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int max=piles[0];
        int i=1;
        while(i<piles.length){
            max=Math.max(max,piles[i]);
            i++;
        }
        int high=max;
        int res=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            long time=condition(piles,mid);
            if(time>h){
                low=mid+1;
            }
            else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
    public long condition(int []piles, int k){
        long time=0;
        for(int i=0;i<piles.length;i++){
            time=time+piles[i]/k;
            if(piles[i]%k!=0){
                time++;
            }
        }
        return time;
    }
}