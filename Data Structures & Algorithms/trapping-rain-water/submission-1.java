class Solution {
    public int trap(int[] height) {

        if(height.length<3){
            return 0;
        }
        int[] pre = new int[height.length];
        pre[0]=height[0];
        for(int i=1; i<height.length; i++){
            pre[i] = Math.max(pre[i-1], height[i]);
        }

        int[] post = new int[height.length];
        post[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            post[i] = Math.max(post[i+1], height[i]);
        }

        int total = 0;
        for(int i=0; i<height.length; i++){
            total = total + Math.min(pre[i],post[i]) - height[i];
        }
        return total;
    }
}
