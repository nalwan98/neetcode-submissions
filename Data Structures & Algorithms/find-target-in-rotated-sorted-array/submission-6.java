class Solution {
    public int search(int[] nums, int target) {
        int low= 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low + ((high - low) >>> 1);
            if(target == nums[mid]){
                return mid;
            }
            //is Left side sorted
            else if (nums[low] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if (nums[high]>=nums[mid]){
                if(target <= nums[high] && target >= nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }    
             
        }
        return -1;

    }
}

//class Solution {
//     public int search(int[] nums, int target) {
//         int low = 0;
//         int high = nums.length - 1;

//         while (low <= high) {

//             int mid = low + ((high - low) >>> 1);

//             if (nums[mid] == target) {
//                 return mid;
//             }

//             // Left half is sorted
//             if (nums[low] <= nums[mid]) {

//                 // Target is inside the sorted left half
//                 if (nums[low] <= target && target < nums[mid]) {
//                     high = mid - 1;
//                 }
//                 else {
//                     low = mid + 1;
//                 }
//             }

//             // Right half is sorted
//             else {

//                 // Target is inside the sorted right half
//                 if (nums[mid] < target && target <= nums[high]) {
//                     low = mid + 1;
//                 }
//                 else {
//                     high = mid - 1;
//                 }
//             }
//         }

//         return -1;
//     }
// }

//             mid
//              ↓
//        Which half is sorted?
//           /          \
//        LEFT          RIGHT
//         ↓              ↓
// Is target in it?  Is target in it?
//     /    \           /    \
//   yes    no        yes    no
//    ↓      ↓          ↓      ↓
//  left   right      right   left
