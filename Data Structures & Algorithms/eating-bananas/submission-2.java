class Solution {
    public int minEatingSpeed(int[] piles, int hour) {
        int max = 0;
        for(int i: piles){
            max = Math.max(max, i);
        }

        int l = 1;
        int h = max;
        int min = Integer.MAX_VALUE;
        while(l<=h){
            int mid = l + ((h-l)/2);
            int curHour = 0;
            for(int i: piles){
                curHour = curHour + (int)(Math.ceil((1.0 *i)/mid));
            }
            if(curHour>hour){
                l = mid+1;
            }
            else if(curHour<=hour){
                h = mid-1;
                min = Math.min(min, mid);
            }
        }
        return min;
    }
}
