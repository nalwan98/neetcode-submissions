class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length -1;

        int sum = 0;
        while(left<right){
            sum = numbers[left] + numbers[right];
            if (sum > target){
                right--;
            }
            if(sum < target){
                left++;
            }
            if(sum == target){
                break;
            }
        }
        int[] res = {left+1, right+1};
        return res;
    }
}
