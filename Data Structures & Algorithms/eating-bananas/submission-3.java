class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max= 0;
        for(int i: piles){
            max = Math.max(max, i);
        }
        int low = 1;
        int high = max;
        int min = max+1;
        while(low<=high){
            int mid = low+ ((high-low)/2);
            int cur=0;
            for(int i:piles){
                cur = cur + (int)Math.ceil((i*1.0)/(mid*1.0));
            }
            if(cur<=h){
                min = Math.min(min, mid);
                high = mid-1;
            }
            else if(cur>h){
                low = mid+1;
            }
        }
        return min;
    }
}
