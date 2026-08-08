class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int l=0;
        int r=1;
        int maxDiff=nums[r]-nums[l];
        while(r<nums.length){
            int diff=nums[r]-nums[l];
            maxDiff=Math.max(maxDiff,diff);
            l++;
            r++;
        }
        return maxDiff;
    }
}