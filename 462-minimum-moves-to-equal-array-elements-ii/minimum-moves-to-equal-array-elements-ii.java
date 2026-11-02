class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums.length/2;
        
        int count=0;
        int midele=nums[mid];
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            if(ele==midele){
                continue;
            }
            if(ele<midele){
                count+=midele-ele;
            }
            if(ele>midele){
                count+=ele-midele;
            }
        }
        return count;
    }
}