class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        int peak=nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[n-1]){
                low=mid+1;
            }
            else{
                peak=mid;
                high=mid-1;
            }
        }
        if(target>=nums[peak] && target<=nums[n-1]){
            low=peak;
            high=n-1;
        }
        else{
            low=0;
            high=peak;
        }
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}