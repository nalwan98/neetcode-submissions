class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int lowm =0;
       int highm = matrix.length-1;
       int row = 0;
       while(lowm<=highm){
        int midm = lowm + (highm-lowm)/2;
        if(matrix[midm][matrix[0].length-1]<target){
            lowm = midm+1;
        }
        else if(matrix[midm][0]>target){
            highm = midm-1;
        }
        else{
            row = midm;
            break;
        }
       }
        int low = 0;
        int high = matrix[0].length-1;
       while(low<=high){
        int mid = low + (high-low)/2;
        if(matrix[row][mid]<target){
            low = mid +1;
        }
        else if(matrix[row][mid]>target){
            high = mid -1;
        }
        else{
            System.out.println(matrix[row][mid]);
            return true;
        }
       }
       return false;
    }
}
