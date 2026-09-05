class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int n: piles){
            if(n>max){
                max = n;
            }
        }
        int res = 0;
        int low = 1;
        while(low<=max){
            int mid = low + (max-low)/2;
            int temph=0;
            for(int n: piles){
                temph = temph + (int)Math.ceil((double)n/mid);
            }
            if(temph>h){
                low = mid + 1;
            }
            else if(temph<=h){
                res = mid;
                max = mid - 1;
            }
        }
        return res;
    }
}
