class Solution {
    public int maxArea(int[] heights) {
        int left = 0; 
        int right = heights.length -1;
        int max = 0;

        int currMax = 0;

        while(left<right){
            currMax = Math.min(heights[left], heights[right]) * (right-left);
            if(heights[right]> heights[left]){
                left++;
            }
            else{
                right--;
            }
            
          max = Math.max(max, currMax);
        }
        return max;
    }
}
