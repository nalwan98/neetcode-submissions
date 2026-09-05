class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int kcounter = 0;
        int[] res = new int[nums.length-k + 1];
        int index=0;
        for(int i=0; i<nums.length; i++){
            kcounter++;

            // Remove indices that are out of the bounds of the sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the deque while they are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.offerLast(i);
            if(kcounter==k || i==nums.length-1){
                kcounter--;
                res[index]=nums[deque.peekFirst()];
                index++;
            }
        }
    return res;
    }
}
