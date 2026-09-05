class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            // skip if already processed
            if (!set.contains(num)) continue;

            int curr = num;
            int total = 1;

            // expand left
            int left = curr - 1;
            while (set.contains(left)) {
                set.remove(left);
                total++;
                left--;
            }

            // expand right
            int right = curr + 1;
            while (set.contains(right)) {
                set.remove(right);
                total++;
                right++;
            }

            // remove current number too
            set.remove(num);

            max = Math.max(max, total);
        }

        return max;
    }
}