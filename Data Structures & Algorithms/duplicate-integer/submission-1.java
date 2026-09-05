class Solution {

  //brute force is double loop O(n^2)
  //could be done with sorting and then looping once O(nlogn)
  //HashSet O(n)
    public boolean hasDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for(int i: nums){
        if(set.contains(i)){
          return true;
        }
        set.add(i);
      }
      return false;
  }
}