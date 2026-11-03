class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int count=0;
        for(int j=0;j<nums.length;j++){
            count+=max-nums[j];

        }
        return count;
    }
}