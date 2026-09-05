class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left<right){
            int currentSum = numbers[left]+ numbers[right];
            if(currentSum>target){
                right --;
            }
            else if(currentSum<target){
                left++;
            }
            else{
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
        }
        return res;
    }
}
