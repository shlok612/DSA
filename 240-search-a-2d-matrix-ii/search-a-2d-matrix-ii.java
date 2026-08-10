class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=0;
        while(row>=0 && col<matrix[0].length){
            int mid=matrix[row][col];
            if(mid==target){
                return true;
            }
            if(mid<target){
                col++;
            }
            else{
                row--;
            }
        }
        return false;
    }
}