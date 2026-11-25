class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count=0;
        while(target!=1){
            if(target%2!=0){
                count++;
                target--;
            }
            else{
                if(maxDoubles!=0){
                    target=target/2;
                    maxDoubles--;
                    count++;
                    continue;
                }
                else{
                    count+=target-1;
                    break;
                }
                
            }
            
        }
        return count;
    }
}