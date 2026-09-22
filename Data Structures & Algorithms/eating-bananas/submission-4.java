class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find max;
        int max =0;
        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int low=1;
        int high=max;
        int res = max;
        while(low<=high){
            int mid = ((high-low) >>> 1) + low;
            int hoursrem = h;
            for(int i=0; i<piles.length; i++){
                hoursrem -= (int) Math.ceil((double) piles[i] / mid);
            }
            if(hoursrem<0){
                low = mid+1;
            }
            else{
                high = mid-1;
                res = Math.min(res, mid);
            }
        }
        return res;
    }
}
