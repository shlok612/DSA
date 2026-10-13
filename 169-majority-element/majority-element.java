class Solution {
    public int majorityElement(int[] nums) {
        int majele=0;
        int l=nums.length;
        int n=l/2;
        if(l%2!=0){
            n++;
        }
      
        int i=0;
        int j=n-1;
        boolean maj=false;
        while(j<l){
            if(nums[i]==nums[j]){
                maj=true;
                majele=nums[i];
                break;
            }
            i++;
            j++;
        }
        if(maj == false){
            return nums[0];
        }
        return majele;
    }
}