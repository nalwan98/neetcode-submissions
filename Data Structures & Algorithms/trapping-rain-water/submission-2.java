class Solution {
    public int trap(int[] height) {
       int left=0;
       int right=height.length-1;
       int leftmax = 0;
       int rightmax = 0;


       int traptotal = 0;

       while(left<right){
        if(height[left]<=height[right]){
            if(height[left]>=leftmax){
                leftmax = height[left];
            }
            else{
                traptotal = traptotal+leftmax - height[left];
            }
            left++;
        }
        else{
            if(height[right]>=rightmax){
                rightmax = height[right];
            }
            else{
                traptotal = traptotal+rightmax - height[right];
            }
            right--;
        }


       }

       return traptotal; 
    }
}
