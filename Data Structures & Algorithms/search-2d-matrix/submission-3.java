class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length-1;
        int mid = low + ((high-low) >>> 1);

        while(low<=high){
            if (matrix[mid][0] <= target &&
    matrix[mid][matrix[0].length - 1] >= target){
                int lowinner = 0;
                int highinner = matrix[0].length-1;
                int midinner = lowinner + ((highinner-lowinner) >>> 1);
                while(lowinner<=highinner){
                    if(matrix[mid][midinner]==target){
                        return true;
                    }
                    else if(matrix[mid][midinner]>target){
                        highinner = midinner-1;
                    }
                    else{
                        lowinner = midinner+1;
                    }
                    midinner = lowinner + ((highinner-lowinner) >>> 1);
                }
                break;
            }
            else if(matrix[mid][0]>target){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
            mid = low + ((high-low) >>> 1);
        }
        return false;

    }
}
