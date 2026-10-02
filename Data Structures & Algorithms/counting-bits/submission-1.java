class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i] = numberOfBits(i);
        }
        return res;
    }
    public int numberOfBits(int n){
        int ans=0;
        while(n!=0){
            if(n%2 > 0){
                ans++;
            }
            n=n/2;
        }
        return ans;
    }
}
