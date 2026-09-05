class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int h = matrix.length-1;
        int row = -1;
        while(l<=h){
            int mid = l + ((h-l)/2);
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                row = mid;
                break;
            }
            if(matrix[mid][0]>target){
                h = mid-1;
            }
            if(matrix[mid][0]<target){
                l = mid+1;
            }
        }
        if(row==-1){
            return false;
        }
        l = 0;
        h = matrix[row].length-1;
        while(l<=h){
            int mid = l + ((h-l)/2);
            if(matrix[row][mid]>target){
                h = mid-1;
            }
            else if(matrix[row][mid]<target){
                l = mid+1;
            }
            else if(matrix[row][mid]==target){
                return true;
            }
        }
        return false;
    }
}
