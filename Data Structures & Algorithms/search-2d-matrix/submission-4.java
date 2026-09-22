class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //easy way loop to find which raw using binary search once found binary search on that raw to find column
        int low=0;
        int high=matrix.length -1;
        int colLength = matrix[0].length;

        while(low<=high){
            int mid = ((high-low) >>> 1) + low;
            if(target>=matrix[mid][0] && target<=matrix[mid][colLength-1]){
                //do search in this row
                int innerhigh = matrix[mid].length -1;
                int innerlow = 0;
                while(innerlow<=innerhigh){
                    int innermid = ((innerhigh-innerlow) >>> 1) + innerlow;
                    if(target == matrix[mid][innermid]){
                        return true;
                    }
                    else if(target > matrix[mid][innermid]){
                        innerlow = innermid+1;
                    }
                    else{
                        innerhigh = innermid-1;
                    }

                }
                break;
                
            }
            else if (target > matrix[mid][colLength - 1]) {
                // target must be in a later row
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }

        return false;

        //harder way, treat it as a 1d array

    }
}
